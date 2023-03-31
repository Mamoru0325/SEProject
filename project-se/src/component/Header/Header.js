// ======แถบ nav ด้านบน=========
import React from 'react'
import "./Header.css"
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom"

//Page import
import Nav from './Nav'
import SignIn from "../SignIn"
import HomePage from "../HomePage"
import ErrorPage from '../ErrorPage'
import WritePage from '../WritePage'
import CreateCoursePage from '../CreateCoursePage'
import Register from '../Register'
import Profile from '../Profile'
import MyProfile from '../MyProfile'
import BoardPage from '../BoardPage'
// import DropdownMenu from './DropMenu'
import { display } from '@mui/system'
import VerifyPage from '../VerifyPage'


function Header() {
    return (
        <BrowserRouter >

            <Nav />

   

            <Routes>
                
             
                <Route path="/" element={<SignIn />} />
                <Route path="/homepage" element={<HomePage />} />
                <Route path="/write" element={<WritePage />} />
                <Route path="/Profile" element={<Profile />} />
                <Route path="/MyProfile" element={<MyProfile />} />
                <Route path="/createCourse" element={<CreateCoursePage />} />
                <Route path="/BoardPage" element={<BoardPage />} />
                <Route path="/register" element={<Register />} />
                <Route path="/verify" element={<VerifyPage />} />
                <Route path="/register" element={<Register />} />
                <Route path="/*" element={<ErrorPage />} />


                ///////////////////////

                {/* <Route path="/staffManage" element={<Ad />} /> */}
            </Routes>
        </BrowserRouter>
    )
}

export default Header