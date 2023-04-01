import React from "react";
import { NavLink } from "react-router-dom";
import "./HomePage.css";

function FeedCoursePage() {
  return (
    <div className="allContent">
      <NavLink to="/BoardPage">
        <div className="content">Courseeeeeeeeeeeeeeeee</div>
      </NavLink>

      <div className="content">
        <div>Course content 05</div>
      </div>

      <div className="content">
        <div>Course content 05</div>
      </div>

      <div className="content">
        <div>Course content 05</div>
      </div>

      <div className="content">
        <div>content 05</div>
      </div>

      <div className="content">
        <div>content 05</div>
      </div>
    </div>
  );
}

export default FeedCoursePage;
