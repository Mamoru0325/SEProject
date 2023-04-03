import React from "react";
import "./SidebarCourse.css";
import { Link } from "@material-ui/core";
import { IoIosAlbums } from "react-icons/io";
import { IoIosBookmarks } from "react-icons/io";

function CourseMenu() {
  return (
    <div>
      <ul className="sidebar">
        <li>
          <span>AllLearn Course</span>
        </li>
        <li>
          <span>
            <span>
              <Link className="link" href="/MyCourse_AllCreator">
                <IoIosAlbums />
                {"  คอร์สของคุณ "}
              </Link>
            </span>
          </span>
        </li>
        <li>
          <span>
            <span>
              <Link className="link" href="/Course_registrationCreator">
                <IoIosBookmarks />
                {"   คอร์สที่ลงทะเบียน"}
              </Link>
            </span>
          </span>
        </li>
      </ul>
    </div>
  );
}

export default CourseMenu;
