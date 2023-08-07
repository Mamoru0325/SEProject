import React, { useState } from 'react';
import './ConfirmCourse.css'
import { FiCheck } from "react-icons/fi";
import {useEffect } from "react";
import axios from "axios";

import { Link, useParams } from "react-router-dom";

function ConfirmCourse(props) {
    const [isDialogOpen, setIsDialogOpen] = useState(false);
    const [file, setFile] = useState(null); // เก็บไฟล์ที่เลือกจาก input
    const [isSuccess, setIsSuccess] = useState(false); // เพิ่มตัวแปร isSuccess
    const [user, setUser] = useState([]);
    const { id } = useParams();
    const [data, setData] = useState([]);
  
    const [content, setContent] = useState([]);
    const [recommend, setRecommend] = useState([]);
  const [dataDelete, setDataDelete] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [QR, setQR] = useState();

    const handleFileChange = (event) => {
        const selectedFile = event.target.files[0];
        setFile(selectedFile);
    };

    const handleNextClick = () => {
        if (file) {
          setIsDialogOpen(false);
          // props.onNext();
          setIsSuccessDialogOpen(true); // เปิด dialog แสดงว่าสำเร็จ
        } else {
          alert('Please upload a file before proceeding.');
        }
      };
      
      const [isSuccessDialogOpen, setIsSuccessDialogOpen] = useState(false);

      useEffect(() => {
        createQR();
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

        const fetchQRData = async () => {
          setTimeout(async () => {
            const response = await axios.get(`http://localhost:8080/courses/1/payment`);
            setQR(response.data);
            console.log(QR);
            setIsLoading(false);
          }, 2001); // set delay to 2 seconds
        };
        fetchQRData();
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

      return (
        <div>
          <button className='Regis-but' onClick={() => setIsDialogOpen(true)}>Register</button>
          {isDialogOpen && (
            <div>
              <div className="overlay" onClick={() => setIsDialogOpen(false)}></div>
              <div className="dialog-container">
                <h1>ตรวจสอบข้อมูลและชำระเงิน</h1>
                <div style={{ display: 'flex', gap: '30px' }}>
                  <div className='dialog-font'>
                    <h3>
                      วันที่เปิดสอน
                    </h3>
                    <div>{data.body.startDate} ถึง<br/> {data.body.endDate}</div>
                    <h3>
                      จำนวนเปิดรับ<br/>
                    </h3>
                    <div>{data.body.minimum} ถึง {data.body.maximum}</div>
                    <h3>
                      ราคา
                    </h3>
                    <div>{data.body.price}</div>
                  </div>
                  <div>
                    <div className='QrCode'> </div>
                    <h5>แนบหลักฐานการชำระเงิน</h5>
                    <div>
                      <input type="file" id="file-upload" onChange={handleFileChange} />
                    </div>
                  </div>
                </div>
                <div className='dialog-footer'>
                  <button className='dialog-button' onClick={handleNextClick}>ยืนยัน</button>
                </div>
              </div>
            </div>
          )}
          {isSuccessDialogOpen && (
            <div>
              <div className="overlay" onClick={() => setIsSuccessDialogOpen(false)}></div>
              <div className="dialog-container">
                <h1>ลงทะเบียนสำเร็จ</h1>
                <FiCheck size={70}/>
                <div className='dialog-footer'>
                  <button className='dialog-button' onClick={() => setIsSuccessDialogOpen(false)}>Close</button>
                </div>
              </div>
            </div>
          )}
        </div>
      );
}

export default ConfirmCourse;