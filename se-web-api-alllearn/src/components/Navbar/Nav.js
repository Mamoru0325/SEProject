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
import MyCourse_All from "../CourseF/MyCourse_All";
import Course_Registration from "../CourseF/Course_Registration";
import AllPeople_Course from "../CourseF/AllPeople_Course";

class Navbar extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user.body.roles,
        // showModeratorBoard: user.roles.includes("ROLE_MODERATOR"),
        // showAdminBoard: user.roles.includes("ROLE_ADMIN"),
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
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    });
  }

  render() {
    const { currentUser, showModeratorBoard, showAdminBoard } = this.state;

    return (
      <div>
        <nav className="navbar navbar-expand navbar-light bg-light">
          <Link to={"/"} className="navbar-brand">
            <img src={Logo} alt="" height={40} width={45} />
          </Link>
          <div className="navbar-nav mr-auto">
            {/* <li className="nav-item">
              <Link to={"/homepage"} className="nav-link">
                Home
              </Link>
            </li> */}

            {showModeratorBoard && (
              <li className="nav-item">
                <Link to={"/mod"} className="nav-link">
                  Moderator Board
                </Link>
              </li>
            )}

            {currentUser == "ROLE_SystemAdmin" && (
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
            )}

            {/* {currentUser && (
              <li className="nav-item">
                <Link to={"/user"} className="nav-link">
                  User
                </Link>
              </li>
            )} */}
          </div>

          {currentUser != "ROLE_SystemAdmin" && currentUser ? (
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
                <DropdownMenu />
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

            {/* <Route path="/homepage" element={<HomePage />} /> */}
            {/* <Route path="/write" element={<WritePage />} /> */}
            <Route path="/Profile" element={<Profile />} />
            {/* <Route path="/MyProfile" element={<MyProfile />} /> */}
            <Route path="/createCourse" element={<CreateCoursePage />} />
            <Route path="/BoardPage" element={<BoardPage />} />
            <Route path="/coursePage" element={<CoursePage />} />
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
            <Route path="/MyCourse_All" element={<MyCourse_All />} />
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
