import React, { useEffect, useState } from "react";
import axios from "axios";
import "./HomePage.css";
import "./LoadingPage.css";
import { Link } from "react-router-dom";
// import Course from "./Course";

function FeedCoursePage() {
  const [data, setData] = useState([]);
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
          "http://localhost:8080/courses/page/1/value/10"
          // `http://localhost:8080/users/email/${user.body.userName}`
        );
        setData(response.data);
        console.log(data);
        setIsLoading(false);
      }, 2000); // set delay to 2 seconds
    };
    console.log(data);
    fetchData();
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
        <div className="container py-0 m-4">
          <div key={index}>
            <article className="postcard light blue">
              <a className="postcard__img_link" href="/CoursePage">
                <img
                  className="postcard__img"
                  src="https://picsum.photos/1000/1000"
                  alt="Image Title"
                />
              </a>
              <div className="postcard__text t-dark">
                <h1 className="postcard__title blue">
                  <a href="#">{item.courseTopic}</a>
                </h1>
                <div className="postcard__subtitle small">
                  <time dateTime="2020-05-25 12:00:00">
                    <i className="fas fa-calendar-alt mr-2" />
                    Event Date: {item.eventDate}
                  </time>
                  <br />
                  <div className="mt-1">Minimum {item.minimum}</div>
                  <div className="mt-0">Maximum {item.maximum}</div>
                  <div className="mt-0">
                    Price: {item.price}{" "}
                    {
                      "(The course fee is divided by the total number of people)"
                    }
                  </div>
                  <br />
                  <time dateTime="2020-05-25 12:00:00">
                    <i className="fas fa-calendar-alt mr-2" />
                    First Enroll Date :{item.firstEnrollDate}
                  </time>
                  <br />
                  <time dateTime="2020-05-25 12:00:00">
                    <i className="fas fa-calendar-alt mr-2" />
                    Last Enroll Date :{item.lastEnrollDate}
                  </time>
                  <br />
                  <time dateTime="2020-05-25 12:00:00">
                    <i className="fas fa-calendar-alt mr-2" />
                    End Date :{item.endDate}
                  </time>
                </div>
                <div className="postcard__bar" />
                <div className="postcard__preview-txt">{item.courseDetail}</div>
                <ul className="postcard__tagbox">
                  <li className="tag__item">
                    <i className="fas fa-tag mr-2" />
                    AllLearn Course
                  </li>
                  {/* <li className="tag__item">
                    <i className="fas fa-clock mr-2" />
                    55 mins.
                  </li>
                  <li className="tag__item play blue">
                    <a href="#">
                      <i className="fas fa-play mr-2" />
                      Play Episode
                    </a>
                  </li> */}
                </ul>
                <div className="mt-3">
                  <button type="button" class="btn btn-primary">
                    <Link to={`/CoursePage/${item.courseId}`}>Read More</Link>
                  </button>
                </div>
              </div>
            </article>
          </div>
        </div>
      ))}
    </section>
  );
}

export default FeedCoursePage;
