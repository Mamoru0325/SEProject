// ======แถบ nav ด้านบน=========
import React from 'react'
import "./Header.css"
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom"

//Page import
import SignIn from "./SignIn"
import HomePage from "./HomePage"
import ErrorPage from './ErrorPage'
import WritePage from './WritePage'
import CreateCoursePage from './CreateCoursePage'
import Register from './Register'

const DropdownMenu = () => {

    const DropdownItem = (props) => {
        return (
            <a href='#' className='menu-item'>
                <span className='icon-button'>{props.leftIcon}</span>
                {props.children}

                <span className='icon-right'>{props.rightIcon}</span>

            </a>
        );

    }

    return (
        <div className='dropdown'>
            <DropdownItem>My Profile</DropdownItem>
        </div>
    )
}

function Header() {
    return (
        <BrowserRouter >
            <div className="header">

                <div className="container">

                    <nav className="header-con">

                        <div className='logo'>

                            <NavLink to="/homepage">
                                <img src="./LogoV1.png" alt="bug" height={50} />
                            </NavLink>

                        </div>


                        <li className='menu'>

                            <NavLink className="menu-link" to="/homepage">
                                HomePage
                            </NavLink>

                            <NavLink className="menu-link" to="/write">
                                Write
                            </NavLink>

                            <NavLink className="menu-link" to="/createCourse">
                                Create Course
                            </NavLink>

                            <NavLink className="menu-link" to="/">
                                Login
                            </NavLink>

                        </li>
                    </nav>
                </div>
            </div>

            <Routes>
                <Route path="/" element={<SignIn />} />
                <Route path="/homepage" element={<HomePage />} />
                <Route path="/write" element={<WritePage />} />
                <Route path="/createCourse" element={<CreateCoursePage />} />
                <Route path="/register" element={<Register/>}/>
                <Route path="/*" element={<ErrorPage />} />
            </Routes>
        </BrowserRouter>
    )
}

export default Header