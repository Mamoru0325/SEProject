import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "../../App.css";

import AuthService from "../../services/auth.service";

import Login from "../../components/login.component";
import Register from "../../components/register.component";

import { Route, Routes, Link } from "react-router-dom";

// import AuthVerify from "./common/auth-verify";
import EventBus from "../../common/EventBus";

import Logo from "../../assets/LogoV1.png";
import HomePage from "../Home/HomePage";
import Profile from "../Profile/MyProfile";
// import WritePage from "../Write/WritePage";

import DropdownMenu from "../Header/DropMenu";
import DropdownMenuCreator from "../Header/DropMenuCreator";
import DropdownMenuAdmin from "../Header/DropMenuAdmin";

//Add
//Page import
// import Nav from "./Nav";
// import SignIn from "../../components/Board/SignIn";
// import HomePage from "../Home/HomePage";
import ErrorPage from "../../components/Board/ErrorPage";
import WritePage from "../../components/Board/WritePage";
import CreateCoursePage from "../../components/Board/CreateCoursePage";
// import Register from "../../components/Board/Register";
// import Profile from "../Profile/Profile";
// import MyProfile from "../Profile/MyProfile";
import BoardPage from "../../components/Board/BoardPage";
// import DropdownMenu from './DropMenu'
// import { display } from "@mui/system";
import VerifyPage from "../../components/Board/VerifyPage";
import Setting from "../SettingF/Setting";
import Aptitude from "../SettingF/Aptitude";
import Verification from "../SettingF/Verification";
import EProfile from "../SettingF/EProfile";
import CoursePage from "../../components/Board/CoursePage";
import AdminListPage from "../admin/AdminListPage";
import AdminManagementPage from "../admin/AdminManagementPage";
import StaffRequestPage from "../admin/StaffRequestPage";
import StaffRequestDetailPage from "../admin/StaffRequestDetailPage";

import CourseMenu from "../CourseF/CourseMenu";
import CourseMenuCreator from "../CourseF/CourseMenuCreator";
import MyCourse_AllCreator from "../CourseF/MyCourse_AllCreator";
import MyCourse_All from "../CourseF/MyCourse_All";
import Course_Registration from "../CourseF/Course_Registration";
import AllPeople_Course from "../CourseF/AllPeople_Course";

import Course_RegistrationCreator from "../../components/CourseF/Course_RegistrationCreator";

class Navbar extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      staffUser: false,
      adminSystem: false,
      creatorUser: false,
      currentUser: false,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user.body.roles.includes("ROLE_User"),
        creatorUser: user.body.roles.includes("ROLE_CourseCreator"),
        adminSystem: user.body.roles.includes("ROLE_SystemAdmin"),
        staffUser: user.body.roles.includes("ROLE_Staff"),
      });
    }

    EventBus.on("logout", () => {
      this.logOut();
    });
  }

  componentWillUnmount() {
    EventBus.remove("logout");
  }

  logOut() {
    AuthService.logout();
    this.setState({
      staffUser: false,
      adminSystem: false,
      creatorUser: false,
      currentUser: false,
    });
  }

  render() {
    const { currentUser, creatorUser, adminSystem, staffUser } = this.state;

    return (
      <div>
        <nav className="navbar navbar-expand navbar-light bg-light">
          <Link to={"/"} className="navbar-brand">
            <img src={Logo} alt="" height={40} width={45} />
          </Link>
          <div className="navbar-nav ml-auto">
            {/* <li className="nav-item">
              <Link to={"/homepage"} className="nav-link">
                Home
              </Link>
            </li> */}

            {/* {currentUser == "ROLE_SystemAdmin" && (
              <div className="navbar-nav ml-auto">
                <li className="nav-item">
                  <a href="/AdminManage" className="nav-link">
                    Management
                  </a>
                </li>
                <li className="nav-item">
                  <a href="/login" className="nav-link" onClick={this.logOut}>
                    LogOut
                  </a>
                </li>
              </div>
            )} */}

            {/* {currentUser && (
              <li className="nav-item">
                <Link to={"/user"} className="nav-link">
                  User
                </Link>
              </li>
            )} */}
          </div>

          {/* <h1>User</h1> */}
          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/" className="nav-link">
                  Home
                </a>
              </li>
              {/* <li className="nav-item">
                <a href="/myprofile" className="nav-link">
                  MyProfile
                </a>
              </li> */}
              <li className="nav-item">
                <a href="/write" className="nav-link">
                  Write
                </a>
              </li>
              {/* <li className="nav-item">
                <a href="/createCourse" className="nav-link">
                  Create Course
                </a>
              </li> */}
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  LogOut
                </a>
              </li>
              <li>
                <DropdownMenu />
              </li>
            </div>
          ) : creatorUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/" className="nav-link">
                  Home
                </a>
              </li>
              {/* <li className="nav-item">
                <a href="/myprofile" className="nav-link">
                  MyProfile
                </a>
              </li> */}
              <li className="nav-item">
                <a href="/write" className="nav-link">
                  Write
                </a>
              </li>
              <li className="nav-item">
                <a href="/createCourse" className="nav-link">
                  Create Course
                </a>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  LogOut
                </a>
              </li>
              <li>
                <DropdownMenuCreator />
              </li>
            </div>
          ) : adminSystem ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/AdminListPage" className="nav-link">
                  Management Staff
                </a>
              </li>
              {/* <li className="nav-item">
                <a href="/" className="nav-link">
                  Home
                </a>
              </li> */}
              {/* <li className="nav-item">
                <a href="/myprofile" className="nav-link">
                  MyProfile
                </a>
              </li> */}
              {/* <li className="nav-item">
                <a href="/write" className="nav-link">
                  Write
                </a>
              </li>
              <li className="nav-item">
                <a href="/createCourse" className="nav-link">
                  Create Course
                </a>
              </li> */}
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  LogOut
                </a>
              </li>
              <li>
                <DropdownMenuAdmin />
              </li>
            </div>
          ) : staffUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/AdminManage" className="nav-link">
                  Management
                </a>
              </li>
              {/* <li className="nav-item">
                <a href="/" className="nav-link">
                  Home
                </a>
              </li> */}
              {/* <li className="nav-item">
                <a href="/myprofile" className="nav-link">
                  MyProfile
                </a>
              </li> */}
              {/* <li className="nav-item">
                <a href="/write" className="nav-link">
                  Write
                </a>
              </li>
              <li className="nav-item">
                <a href="/createCourse" className="nav-link">
                  Create Course
                </a>
              </li> */}
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  LogOut
                </a>
              </li>
              <li>
                <DropdownMenuAdmin />
              </li>
            </div>
          ) : (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                  Login
                </Link>
              </li>

              <li className="nav-item">
                <Link to={"/register"} className="nav-link">
                  Sign Up
                </Link>
              </li>
            </div>
          )}
        </nav>

        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/write" element={<WritePage />} />
            <Route path="/myprofile" element={<Profile />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />

            <Route path="/BoardPage/:id" element={<BoardPage />} />
            <Route path="/coursePage/:id" element={<CoursePage />} />

            {/* <Route path="/homepage" element={<HomePage />} /> */}
            {/* <Route path="/write" element={<WritePage />} /> */}
            <Route path="/Profile" element={<Profile />} />
            {/* <Route path="/MyProfile" element={<MyProfile />} /> */}
            <Route path="/createCourse" element={<CreateCoursePage />} />
            {/* <Route path="/BoardPage" element={<BoardPage />} /> */}
            {/* <Route path="/coursePage" element={<CoursePage />} /> */}
            {/* <Route path="/register" element={<Register />} /> */}
            <Route path="/verify" element={<VerifyPage />} />
            {/* <Route path="/register" element={<Register />} /> */}
            <Route path="/*" element={<ErrorPage />} />

            <Route path="/Setting" element={<Setting />} />
            <Route path="/Aptitude" element={<Aptitude />} />
            <Route path="/Verification" element={<Verification />} />
            <Route path="/EProfile" element={<EProfile />} />

            <Route path="/AdminManage" element={<AdminManagementPage />} />
            <Route path="/StaffRequest" element={<StaffRequestPage />} />
            <Route path="/AdminListPage" element={<AdminListPage />} />
            <Route
              path="/StaffRequestDetail"
              element={<StaffRequestDetailPage />}
            />

            <Route path="/MyCourse" element={<CourseMenu />} />
            <Route path="/myCourseCreator" element={<CourseMenuCreator />} />
            <Route path="/MyCourse_All" element={<MyCourse_All />} />
            <Route
              path="/MyCourse_AllCreator"
              element={<MyCourse_AllCreator />}
            />
            <Route
              path="/Course_RegistrationCreator"
              element={<Course_RegistrationCreator />}
            />

            <Route
              path="/Course_Registration"
              element={<Course_Registration />}
            />
            <Route path="/AllPeople_Course" element={<AllPeople_Course />} />
          </Routes>
        </div>

        {/* <AuthVerify logOut={this.logOut}/> */}
      </div>
    );
  }
}

export default Navbar;
