import React from "react";
import "./CoursePage.css";
import { useState, useEffect } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import ConfirmCourse from "./ConfirmCourse";
import ConfirmCourse2 from "./ConfirmCourse";

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
          <img className="small-profile" src="./proImg.jpg" alt="avatar" />

          <span> ชื่อ นามสกุล</span>
        </div>

        <div className="cp-img">
          <img src="./bannerPic.png" alt="img" height={400} width={900} />
        </div>

        <div className="cp-info">
          <h1>หัวข้อ</h1>
          <p>
            รู้หรือไม่ว่า Engoo เป็นแพลตฟอร์ม เรียนภาษาอังกฤษออนไลน์ สอนสด
            ตัวต่อตัว กับครูต่างชาติ และครูเจ้าของภาษา เรียนได้ตลอด 24 ชม.
            โดยแพลตฟอร์มนี้ ถูกออกแบบขึ้นโดยประเทศญี่ปุ่น
            ด้วยหลักสูตรที่ยืดหยุ่นและได้ผลจริง
            ในราคาที่ผู้เรียนทุกระดับสามารถเข้าถึงได้ จึงทำให้ Engoo
            เติบโตและเป็นที่นิยมเป็นอย่างมากทั้งในประเทศไทยและทั่วโลก
          </p>
        </div>

        <div className="cp-detail">
          <div className="cp-font">
            <div>register 10/10</div>

            <div>ระยะเวลาเปิดรับสมัคร</div>

            <div>วันที่เปิดสอน</div>
            <div>จำนวนที่เปิดรับ min max</div>

            <div>ราครา</div>
          </div>
        </div>
        <div style={{ display: "flex", justifyContent: "center" }}>
          <ConfirmCourse />
        </div>
      </div>
    </div>
  );
}
