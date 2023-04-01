import React from "react"
import Header from "./component/Header/Header.js"
// import Register from "./component/Register";
// import Signin from "./component/SignIn";
// import HomePage from "./component/Home/HomePage"
import { BrowserRouter, NavLink, Route, Routes, Outlet } from "react-router-dom"

//Page import
import Nav from './component/Header/Nav'
import SignIn from "./component/SignIn.js"
import HomePage from "./component/Home/HomePage"
import ErrorPage from "./component/ErrorPage.js"
import WritePage from './component/WritePage'
import CreateCoursePage from './component/CreateCoursePage'
import Register from './component/Register'
import Profile from './component/Profile/Profile'
import MyProfile from './component/Profile/MyProfile'
import BoardPage from './component/BoardPage'
import { display } from '@mui/system'
import VerifyPage from './component/VerifyPage'

export default function App() {

  return (
    <div>
      <Header/>
      {/* <BrowserRouter>
      <Nav />
        <Routes>
          <Route path="/" element={<SignIn />} />
          <Route path="/register" element={<Register />} />
          <Route path="/homepage" element={<HomePage />} />
          <Route path="/write" element={<WritePage />} />
          <Route path="/Profile" element={<Profile />} />
          <Route path="/MyProfile" element={<MyProfile />} />
          <Route path="/createCourse" element={<CreateCoursePage />} />
          <Route path="/BoardPage" element={<BoardPage />} />
          <Route path="/verify" element={<VerifyPage />} />
          <Route path="/*" element={<ErrorPage />} />

        </Routes>

      </BrowserRouter>
 */}




    </div>

  );
}

