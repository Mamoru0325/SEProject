import React, { useEffect, useState } from "react";
import axios from "axios";
import "./LoadingPage.css";
// import HomePage from "./HomePage";
// import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom";
import "../Home/FeedBoardPage.css";
// import { NavLink } from "react-router-dom";
// import Board from "./Board";
function FeedBoardPage() {
  const [data, setData] = useState([]);
  const [id, setId] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    // const localStorageData = localStorage.getItem("user");
    // let user = JSON.parse(localStorageData);
    // console.log("===== " + user.body.userName);
    // if (localStorageData) {
    //   setData(JSON.parse(localStorageData));
    // }
    const fetchData = async () => {
      setTimeout(async () => {
        const response = await axios.get(
          "http://localhost:8080/posts/lastestdate/page/1/value/10"
          // `http://localhost:8080/users/email/${user.body.userName}`
        );
        setData(response.data);
        console.log(data);
        setIsLoading(false);
      }, 2000); // set delay to 2 seconds
    };

    // const fetchDataContentType = async () => {
    //   setTimeout(async () => {
    //     const response = await axios.get(
    //       `http://localhost:8080/posts/${id}/contenttype`
    //       // `http://localhost:8080/users/email/${user.body.userName}`
    //     );
    //     setId(response.data);
    //     console.log(id);
    //     setIsLoading(false);
    //   }, 2000); // set delay to 2 seconds
    // };

    // console.log(data);
    fetchData();
    // fetchDataContentType();
  }, []);

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
    <section className="light">
      {/* <div className="h1 text-center text-dark" id="pageHeaderTitle">
          My Cards Light
        </div> */}
      {/* {data.body.map((item, index) => (
        <div key={index}>{item.postTopic}</div>
      ))} */}
      {data.body.map((item, index) => (
        <div className="container py-2 m-4">
          <div key={index}>
            <article className="postcard light blue">
              <a className="postcard__img_link" href="/BoardPage">
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
                <div className="postcard__preview-txt">{item.postDetail}</div>
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
              </div>
            </article>
          </div>
        </div>
      ))}
    </section>
  );
}

export default FeedBoardPage;
