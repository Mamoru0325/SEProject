// ======แถบ nav ด้านบน=========
import React from 'react'
import "./Header.css"
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom"

//Page import
import Nav from './Nav'
import SignIn from "../SignIn"
import HomePage from "../Home/HomePage"
import ErrorPage from '../ErrorPage'
import WritePage from '../WritePage'
import CreateCoursePage from '../CreateCoursePage'
import Register from '../Register'
import Profile from '../Profile/Profile'
import MyProfile from '../Profile/MyProfile'
import BoardPage from '../BoardPage'
// import DropdownMenu from './DropMenu'
import { display } from '@mui/system'
import VerifyPage from '../VerifyPage'
import Setting from '../SettingF/Setting'
import Aptitude from '../SettingF/Aptitude'
import Verification from '../SettingF/Verification'
import EProfile from '../SettingF/EProfile'
import CoursePage from '../CoursePage'
import AdminListPage from '../admin/AdminListPage'
import AdminManagementPage from '../admin/AdminManagementPage'
import StaffRequestPage from '../admin/StaffRequestPage'
import StaffRequestDetailPage from '../admin/StaffRequestDetailPage'

import CourseMenu from '../CourseF/CourseMenu'
import MyCourse_All from '../CourseF/MyCourse_All'
import Course_Registration from '../CourseF/Course_Registration'
import AllPeople_Course from '../CourseF/AllPeople_Course'

export default function Header() {
    return (
        <BrowserRouter >

            <Nav />

   

            <Routes>
                
             
                {/* <Route path="/" element={<SignIn />} /> */}
                <Route path="/singIn" element={<SignIn />} />

                <Route path="/homepage" element={<HomePage />} />
                <Route path="/write" element={<WritePage />} />
                <Route path="/Profile" element={<Profile />} />
                <Route path="/MyProfile" element={<MyProfile />} />
                <Route path="/createCourse" element={<CreateCoursePage />} />
                <Route path="/BoardPage" element={<BoardPage />} />
                <Route path="/coursePage" element={<CoursePage/>}/>
                <Route path="/register" element={<Register />} />
                <Route path="/verify" element={<VerifyPage />} />
                <Route path="/register" element={<Register />} />
                <Route path="/*" element={<ErrorPage />} />

                <Route path="/Setting" element={<Setting />} />
                <Route path="/Aptitude" element={<Aptitude />} />
                <Route path="/Verification" element={<Verification />} />
                <Route path="/EProfile" element={<EProfile />} />

                <Route path="/AdminManage" element={<AdminManagementPage />} />
                <Route path="/StaffRequest" element={<StaffRequestPage />} />
                <Route path="/AdminListPage" element={<AdminListPage />} />
                <Route path="/StaffRequestDetail" element={<StaffRequestDetailPage />} />

                <Route path="/MyCourse" element={<CourseMenu />} />
                <Route path="/MyCourse_All" element={<MyCourse_All />} />
                <Route path="/Course_Registration" element={<Course_Registration />} />
                <Route path="/AllPeople_Course" element={<AllPeople_Course />} />

                ///////////////////////

                {/* <Route path="/staffManage" element={<Ad />} /> */}
            </Routes>
        </BrowserRouter>
    )
}

