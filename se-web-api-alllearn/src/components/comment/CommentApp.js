import React, { useState, useEffect } from "react";
import "./Comment.css";
import { FiAlertCircle, FiHeart, FiThumbsUp } from "react-icons/fi";
import LikeButton_Comment from "./LinkButton_Comment";
import ReportButton from "../ReportButton";

function CommentApp() {
  const [comments, setComments] = useState([]);
  const [inputValue, setInputValue] = useState("");

  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();
    if (inputValue.trim() !== "") {
      setComments([...comments, inputValue]);
      setInputValue("");
    }
  };

  return (
    <div className="comment-container">
      <div className="comments">
        {comments.map((comment, index) => (
          <div key={index} className="comment">
            <div className="comment-icon">
              <ReportButton />
              <LikeButton_Comment />
            </div>
            <li className="boardPageOwnerImg">
              <img src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            </li>
            <div className="comment-con">
              <div>
                <div style={{ fontSize: "20px", fontWeight: "bold" }}>Name</div>
                {comment}
              </div>
            </div>
          </div>
        ))}
      </div>

      <form onSubmit={handleFormSubmit}>
        <label htmlFor="commentInput">Comment</label>
        <br />
        <textarea
          id="commentInput"
          value={inputValue}
          onChange={handleInputChange}
        />
        <br />
        <button className="com-button" type="submit">
          Comment
        </button>
      </form>

      <hr />
    </div>
  );
}

export default CommentApp;
