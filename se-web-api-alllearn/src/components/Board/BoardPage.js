import React, { useState } from 'react'
import './BoardPage.css'
import { Button } from '@mui/material'
import BookmarksIcon from '@mui/icons-material/Bookmarks';
import SvgIcon from '@mui/material/SvgIcon';
import { Link } from '@material-ui/core';

import ThumbUpIcon from '@mui/icons-material/ThumbUp';
import ChatBubbleOutlinedIcon from '@mui/icons-material/ChatBubbleOutlined';

import CommentApp from '../comment/CommentApp';
import LikeButton from '../LikeButton';
import ReportButton from '../ReportButton';
import DeleteButton from '../DeleteButton';
import { FiAlertCircle, FiHeart, FiThumbsUp } from "react-icons/fi";


function BoardPage() {
  const [comments, setComments] = useState([]);
  function addComment(comment) {
    setComments([...comments, comment]);
  }

  const handleCommentSubmit = (comment) => {
    setComments([...comments, comment]);
  };

  return (
    <div className='boardPage-con'>
      <div className='boardPageAllPost-con'>
        <div className='boardPagePost-con'>
          <div className='boardPagePostHead-con'>
            <ul className='boardPageOwner-con'>
              <li className='boardPageOwnerImg'>
                <img src="./proImg.jpg" />
              </li>

              <li className='boardPageOwnerDetail'>
                <li className='boardPageOwnerName'>
                  นายก นามสมมุติ
                </li>
                <li className='boardPageOwnerDate'>
                  Feb 18 · 4 min read
                </li>
              </li>
              <li className='boardPageOwnerFollower'>
                <li className='boardPageNumFollower'>
                  67M Followers
                </li>
                <li className='boardPageButtonFollower'>
                  <Button variant="contained" size='small'>Follow</Button>
                </li>
              </li>
              <li className='boardPageFavButton'>
                <ReportButton />

              </li>
              <li className='boardPageFavButton'>

                <DeleteButton />

              </li>
            </ul>
          </div>
          <div className='boardPagePostBody-con'>
            <div className='boardPagePostBodyImg'>
              <img src="./pok.jpg"></img>

            </div>


            <div className='boardPagePostBodyDesc-con'>
              <ul className='boardPagePostBodyDesc'>
                <li className='boardPagePostBodyDescTopic'>
                  What We’re Reading: Love is great, but have you tried friendship?
                </li>
                <li className='boardPagePostDescMaybe'>
                  A few Medium stories you may have missed this week
                </li>
                <li className='boardPagePostDesc'>
                  The big holiday this week was all about love. (Please see our list of Staff Picks for Valentine’s Day for some sharp thoughts on romance from Medium writers). Yet an equally powerful, though far less heralded, force in all our lives is friendship. Simple friendship — a thing we learn early but never really master — can have as much impact on our overall happiness as love.
                  The big holiday this week was all about love. (Please see our list of Staff Picks for Valentine’s Day for some sharp thoughts on romance from Medium writers). Yet an equally powerful, though far less heralded, force in all our lives is friendship. Simple friendship — a thing we learn early but never really master — can have as much impact on our overall happiness as love.
                  The big holiday this week was all about love. (Please see our list of Staff Picks for Valentine’s Day for some sharp thoughts on romance from Medium writers). Yet an equally powerful, though far less heralded, force in all our lives is friendship. Simple friendship — a thing we learn early but never really master — can have as much impact on our overall happiness as love.
                </li>
              </ul>
            </div>
          </div>

          <div className='boardPagePostTail-con'>
            <a href='#' className='boardPagePostTag'>เศรษฐกิจ</a>
            {/* <span className='boardPagePostBodyLikeNum'>
                <SvgIcon component={ThumbUpIcon} inheritViewBox />1k
              </span>
              <span className='boardPagePostBodyCommentNum'>
                <SvgIcon component={ChatBubbleOutlinedIcon} inheritViewBox />67
              </span> */}

          </div>
          <LikeButton />





          <div>
            <CommentApp />
          </div>



        </div>
        <div className='boardPageRecPost-con'>
          <div className='boardPageRecPosHead'>
            <p>Recommend post</p>
          </div>
          <div className='boardPageRecPosBody'>
            <div className='boardPageRecPosGrid-con'>
              <div className='boardPageRecPos'>
                <div className='boardPageRecPosText'>
                  <div className='boardPageRecPosTextOwner'>
                    <ul className='boardPageOwner-con'>
                      <li className='boardPageOwnerImg'>
                        <img src="./proImg.jpg" />
                      </li>
                      <li className='boardPageOwnerDetail'>
                        <li className='boardPageOwnerName'>
                          นายก นามสมมุติ
                        </li>
                        <li className='boardPageOwnerDate'>
                          Feb 18 · 4 min read
                        </li>
                      </li>
                    </ul>
                  </div>
                  <div className='boardPageRecPosTextDesc'>
                    <p className='boardPageRecPosTextDescTopic'>What We’re Reading: Love is great, but have you tried friendship?</p>
                    <p className='boardPageRecPosTextDescAbout'>What We’re Reading: Love is great, but have you tried friendship?</p>
                  </div>
                </div>
                <div className='boardPageRecPosImg'>
                  <img src="./pok,jpg" />
                  <SvgIcon component={BookmarksIcon} inheritViewBox />
                </div>
              </div>
              <div className='boardPageRecPos'>
                asdasdasd
              </div>
              <div className='boardPageRecPos'>
                asdasdasd
              </div>
            </div>

          </div>
          <div className='boardPageRecPosTail'>
            <Button variant="contained" color='inherit' href='#'>Load more</Button>
          </div>
        </div>
      </div>
    </div>
  )
}

export default BoardPage
