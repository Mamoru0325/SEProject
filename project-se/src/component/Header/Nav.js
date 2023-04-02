import React from 'react'
import "./Header.css"
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom"
import DropdownMenu from './DropMenu'

export default function Nav() {
    return (
    
            <div className="header">

                <div className="w-100">

                    <nav className="header-con">

                        <div className='logo'>

                            <NavLink to="/homepage">
                                <img src="./LogoV1.png" alt="bug" height={50} />
                            </NavLink>

                        </div>


                        <li className='menu'>


                            <NavLink className="menu-link" to="/write">
                                Write
                            </NavLink>

                            <NavLink className="menu-link" to="/createCourse">
                                Create Course
                            </NavLink>

                            <NavLink className="menu-link" to="/">
                                Login
                            </NavLink>

                            <DropdownMenu />

                        </li>
                    </nav>
                </div>
            </div>

     
    )
}

