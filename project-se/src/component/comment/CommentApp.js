import React, { useState, useEffect } from 'react';
import './Comment.css'
import { FiAlertCircle, FiHeart } from "react-icons/fi";



function CommentApp() {
    const [comments, setComments] = useState([]);
    const [inputValue, setInputValue] = useState('');

    const handleInputChange = (event) => {
        setInputValue(event.target.value);
    };

    const handleFormSubmit = (event) => {
        event.preventDefault();
        if (inputValue.trim() !== '') {
            setComments([...comments, inputValue]);
            setInputValue('');
        }
    };

    return (
        <div className="com-container">

            <form onSubmit={handleFormSubmit}>
                <label htmlFor="commentInput">Comment</label>
                <br />
                <textarea
                    id="commentInput"
                    value={inputValue}
                    onChange={handleInputChange}
                />
                <br />
                <button className='com-button' type="submit">Submit</button>
            </form>

            <hr />

            <div className="comments">

                {comments.map((comment, index) => (
                    <div key={index} className="comment">
                        <li className='boardPageOwnerImg'>
                            <img src="./proImg.jpg" />
                        </li>
                        <div className='comment-con'>
                            <div>
                                <div style={{ fontSize: '20px', fontWeight: 'bold' }}>Name</div>
                                {comment}
                            </div>
                            <div>
                                <FiAlertCircle />
                                <FiHeart />
                            </div>

                        </div>

                    </div>
                ))}
            </div>
        </div>
    );
}

export default CommentApp;
