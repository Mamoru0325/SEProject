import React from "react";
import "./CoursePage.css";
import { useState, useEffect } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import ConfirmCourse from "./ConfirmCourse";
import ConfirmCourse2 from "./ConfirmCourse";
import { FiUsers ,FiClock} from "react-icons/fi";

import { HiTicket } from "react-icons/hi2";

export default function CoursePage() {
  const searchParams = new URLSearchParams(window.location.search);
  const selectedValue = searchParams.get("id");
  console.log(selectedValue);
  const { id } = useParams();
  console.log(id + "id");

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
          `http://localhost:8080/courses/${id}`
        );
        const response1 = await axios.get(
          // "http://localhost:8080/users/staff/page/1/value/10"
          `http://localhost:8080/courses/${id}/contenttype`
        );
        const response2 = await axios.get(
          "http://localhost:8080/courses/page/1/value/5"
          // `http://localhost:8080/users/email/${user.body.userName}`
        );
        const response3 = await axios.get(
          `http://localhost:8080/courses/${id}/user`
        );
        setUser(response3.data);
        setData(response.data);
        setRecommend(response2.data);
        setContent(response1.data);
        console.log(data);
        setIsLoading(false);
      }, 501);
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

  const createQR = () => {

    const localStorageData = localStorage.getItem('user');
    let user = JSON.parse(localStorageData);
    const token = user.body.token;
    // console.log(contentTypeNow);
    // console.log(postTopic);
    // console.log(postDetail);
    axios.post(`http://localhost:8080/courses/1/payment`, {
      payby: 1,
      joinCourseId: 5,
      status: "Wating",
      qrCodePath: "D:/SE_65_GROUP_1/se-web-api-alllearn/public/image",
    }, {
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
    }).then((response) => {
      console.log(response.data);
    }).catch((error) => {
      console.error(error);
    });

    
      };
      if (!data) return "No Course";

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
    <div className="cp-container">
      <div className="cp-content">
        <div className="cp-profile">
          <img
            className="small-profile"
            src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
            alt="avatar"
          />

          <span>
            {" "}
            {user.body.firstName} {user.body.lastName}
          </span>
        </div>

        <div className="cp-img">
          <img
            src="https://picsum.photos/1000/1000"
            alt="img"
            height={400}
            width={900}
          />
        </div>

        <div className="cp-info">
          <h1>{data.body.courseTopic}</h1>
          <p>{data.body.courseDetail}</p>
        </div>

        <div className="cp-detail">
          <div className="cp-font">
            <div style={{fontSize: "18px", color: "#003566"}}>
              <FiUsers style={{margin: "10px",fontSize:"22px"}}/> {data.body.minimum}/{data.body.maximum}
            </div><br></br>

            <div style={{fontSize: "18px"}}>
              <span style={{fontSize: "20px", color: "#003566"}}><FiClock />  วันสมัคร </span>  <div>เริ่ม   {data.body.firstEnrollDate} ถึง{" "}
              {data.body.lastEnrollDate}</div> 
            </div>

            <div ><span style={{fontSize: "20px", color: "#003566"}}><FiClock />  วันสอน</span></div>
            <div style={{fontSize: "18px"}}>
                    เริ่ม   {data.body.startDate} ถึง {data.body.endDate}
              </div><br></br>
            
            <div style={{fontSize: "18px"}}>
            <FiUsers style={{fontSize: "20px", color: "#003566"}}/> เปิดรับ ขั้นต่ำ: {data.body.minimum} คน มากสุด: {data.body.maximum} คน
            </div>

            <div style={{fontSize: "18px"}}><HiTicket style={{fontSize: "20px", color: "#003566"}}/> {data.body.price}</div>
          </div>
        </div>
        <div style={{ display: "flex", justifyContent: "center" }}>
          <ConfirmCourse props={data}/>
        </div>
      </div>
    </div>
  );
}