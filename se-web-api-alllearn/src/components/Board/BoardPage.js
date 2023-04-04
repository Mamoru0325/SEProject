import React, { useState, useEffect } from "react";
import "./BoardPage.css";
import { Button } from "@mui/material";
import BookmarksIcon from "@mui/icons-material/Bookmarks";
import SvgIcon from "@mui/material/SvgIcon";
// import { Link } from "@material-ui/core";

// import ThumbUpIcon from "@mui/icons-material/ThumbUp";
// import ChatBubbleOutlinedIcon from "@mui/icons-material/ChatBubbleOutlined";
import DeleteButton from "../DeleteBotton";

import CommentApp from "../comment/CommentApp";
import LikeButton from "../LikeButton";
import ReportButton from "../ReportButton";
// import { FiAlertCircle, FiHeart, FiThumbsUp } from "react-icons/fi";

import axios from "axios";
import { Link, useParams } from "react-router-dom";

function BoardPage() {
  const searchParams = new URLSearchParams(window.location.search);
  const selectedValue = searchParams.get("id");
  console.log(selectedValue);
  const { id } = useParams();
  console.log(id + "id");

  const [comments, setComments] = useState([]);
  function addComment(comment) {
    setComments([...comments, comment]);
  }

  const handleCommentSubmit = (comment) => {
    setComments([...comments, comment]);
  };

  const [data, setData] = useState([]);
  const [content, setContent] = useState([]);
  const [recommend, setRecommend] = useState([]);
  const [user, setUser] = useState([]);
  const [dataDelete, setDataDelete] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      setTimeout(async () => {
        const response = await axios.get(
          // "http://localhost:8080/users/staff/page/1/value/10"
          `http://localhost:8080/posts/${id}`
        );
        const response1 = await axios.get(
          // "http://localhost:8080/users/staff/page/1/value/10"
          `http://localhost:8080/posts/${id}/contenttype`
        );
        const response2 = await axios.get(
          "http://localhost:8080/posts/lastestdate/page/1/value/5"
          // `http://localhost:8080/users/email/${user.body.userName}`
        );
        const response3 = await axios.get(
          `http://localhost:8080/posts/${id}/user`
        );
        setUser(response3.data);
        setData(response.data);
        setRecommend(response2.data);
        setContent(response1.data);
        console.log(data);
        setIsLoading(false);
      }, 500);
    };

    // const fetchContent = async () => {
    //   setTimeout(async () => {
    //     const response = await axios.get(
    //       // "http://localhost:8080/users/staff/page/1/value/10"
    //       `http://localhost:8080/posts/${id}/contenttype`
    //     );
    //     setContent(response.data);
    //     console.log(content);
    //     // setIsLoading(false);
    //   }, 500); // set delay to 2 seconds
    // };

    // // console.log(data);
    // fetchContent();
    fetchData();
    // fetchDataContentType();
  }, []);

  const handleReload = () => {
    window.location.reload();
  };

  if (isLoading) {
    return (
      <section className="light">
        {/* <div className="h1 text-center text-dark" id="pageHeaderTitle">
          My Cards Light
        </div> */}
        {/* {data.body.map((item, index) => (
        <div key={index}>{item.postTopic}</div>
      ))} */}
        <div className="container py-2 m-4">
          <div className="lds-spinner">
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
          </div>
          Loading
        </div>
      </section>
    );
  }

  return (
    <div className="boardPage-con">
      <div className="boardPageAllPost-con">
        <div className="boardPagePost-con">
          <div className="boardPagePostHead-con">
            <ul className="boardPageOwner-con">
              {/* {data.body.map((item, index) => (

            ))} */}
              <li className="boardPageOwnerImg">
                <img src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
              </li>

              <li className="boardPageOwnerDetail">
                <li className="boardPageOwnerName">
                  {user.body.firstName} {user.body.lastName}
                </li>
                <li className="boardPageOwnerDate">{data.body.createDate}</li>
              </li>
              <li className="boardPageOwnerFollower">
                <li className="boardPageNumFollower">0 Followers</li>
                <li className="boardPageButtonFollower">
                  <Button variant="contained" size="small">
                    Follow
                  </Button>
                </li>
              </li>
              <li className="boardPageFavButton">
                <ReportButton />
              </li>
              <li className="boardPageFavButton">
                <DeleteButton />
              </li>
            </ul>
          </div>
          <div className="boardPagePostBody-con">
            <div className="boardPagePostBodyImg">
              <img src="https://picsum.photos/1000/1000"></img>
            </div>

            <div className="boardPagePostBodyDesc-con">
              <ul className="boardPagePostBodyDesc">
                <li className="boardPagePostBodyDescTopic">
                  {data.body.postTopic}
                </li>
                {/* <li className="boardPagePostDescMaybe">
                  A few Medium stories you may have missed this week
                </li> */}
                <li className="boardPagePostDesc">{data.body.postDetail}</li>
              </ul>
            </div>
          </div>

          <div className="boardPagePostTail-con">
            <a href="#" className="boardPagePostTag">
              {content.body.typeName}
            </a>
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

        <div className="boardPageRecPost-con">
          <div className="boardPageRecPosHead">
            <p>Recommend post</p>
          </div>
          {recommend.body.map((item, index) => (
            <div className="boardPageRecPostBody" key={index}>
              <div className="container m-1">
                <div key={index}>
                  <article className="postcard light blue">
                    <a className="postcard__img_link">
                      <img
                        className="postcard__img"
                        src="https://picsum.photos/1000/1000"
                        alt="Image Title"
                      />
                    </a>
                    <div className="postcard__text t-dark">
                      <h1 className="postcard__title blue">
                        <a href="#">{item.postTopic}</a>
                      </h1>
                      <div className="postcard__subtitle small">
                        <time dateTime="2020-05-25 12:00:00">
                          <i className="fas fa-calendar-alt mr-2" />
                          {item.createDate}
                        </time>
                      </div>
                      <div className="postcard__bar" />
                      <div className="postcard__preview-txt">
                        {item.postDetail}
                      </div>
                      <ul className="postcard__tagbox">
                        <li className="tag__item">
                          <i className="fas fa-tag mr-2" />
                          {/* {id.body.typeName} */}
                        </li>
                        {/* <li className="tag__item">
                    <i className="fas fa-clock mr-2" />
                    55 mins.
                  </li> */}
                        {/* <li className="tag__item play blue">
                    <a href="#">
                      <i className="fas fa-play mr-2" />
                      Play Episode
                    </a>
                  </li> */}
                      </ul>
                      <div className="mt-3">
                        <button
                          type="button"
                          class="btn btn-primary"
                          onClick={handleReload}
                        >
                          <Link to={`/BoardPage/${item.postId}`}>
                            Read More
                          </Link>
                        </button>
                      </div>
                    </div>
                  </article>
                </div>
              </div>
            </div>
          ))}
          {/* <div className="boardPageRecPosTail">
            <Button variant="contained" color="inherit" href="#">
              Load more
            </Button>
          </div> */}
        </div>
      </div>
    </div>
  );
}

export default BoardPage;
