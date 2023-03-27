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
import Profile from './Profile'
import MyProfile from './MyProfile'
import BoardPage from './BoardPage'
import DropdownMenu from './DropMenu'


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

                    
                            <NavLink className="menu-link" to="/write">
                                Write
                            </NavLink>

                            <NavLink className="menu-link" to="/createCourse">
                                Create Course
                            </NavLink>

                            <NavLink className="menu-link" to="/">
                                Login
                            </NavLink>

                            <DropdownMenu/>

                        </li>
                    </nav>
                </div>
            </div>

            <Routes>
                <Route path="/" element={<SignIn />} />
                <Route path="/homepage" element={<HomePage />} />
                <Route path="/write" element={<WritePage />} />
                <Route path="/Profile" element={<Profile />} />
                <Route path="/MyProfile" element={<MyProfile />} />
                <Route path="/createCourse" element={<CreateCoursePage />} />
                <Route path="/BoardPage" element={<BoardPage />} />
                <Route path="/register" element={<Register/>}/>
                <Route path="/*" element={<ErrorPage />} />
            </Routes>
        </BrowserRouter>
    )
}

export default Header