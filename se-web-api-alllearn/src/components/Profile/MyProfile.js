import React, { useEffect, useState } from "react";
import "./Profile.css";
import "../Profile/MyProfile.css";
import "../Header/Header.css";
import Button from "@material-ui/core/Button";
import VerifiedIcon from "@mui/icons-material/Verified";
import EditIcon from "@mui/icons-material/Edit";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import SvgIcon from "@mui/material/SvgIcon";
import EmailIcon from "@mui/icons-material/Email";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import axios from "axios";

function Profile() {
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const localStorageData = localStorage.getItem("user");
    let user = JSON.parse(localStorageData);
    // console.log("===== " + user.body.userName);
    // if (localStorageData) {
    //   setData(JSON.parse(localStorageData));
    // }
    const fetchData = async () => {
      setTimeout(async () => {
        const response = await axios.get(
          `http://localhost:8080/users/email/${user.body.userName}`
        );
        setData(response.data);
        // console.log(data);
        setIsLoading(false);
      }, 2000); // set delay to 2 seconds
    };
    console.log(data);
    fetchData();
  }, []);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="profile">
      <div className="container">
        <div className="profileฺBack-con"></div>
        <div className="content-con">
          <div className="aboutMe-con">
            <div className="myImg">
              <img src="" alt="profileImg" />
            </div>
            <div className="MyProfile-totalTab">
              <ul className="MyProfile-totalText">
                <li>จำนวนผู้ติดตาม </li>
                <li>จำนวนโพสต์</li>
                <li>จำนวนคอร์ส</li>
              </ul>
              <div className="MyProfile-totalNum">
                <div>10.6k </div>
                <div>230</div>
                <div>3</div>
              </div>
            </div>
            <div className="desc-con">
              <ul className="desc">
                <li className="desc-text">
                  <li className="desc-icon">
                    <SvgIcon component={AccountCircleIcon} inheritViewBox />
                  </li>
                  <li className="text">
                    สรุปเรื่อง การเงิน การลงทุน เศรษฐกิจ เพื่อนำไปใช้
                    วางแผนได้อย่างถูกต้องครบถ้วน เพื่อเป้าหมายใน
                    การดำเนินชีวิตได้อย่างมีความสุขพร้อมกับมีอิสระ
                    ทางด้านการเงิน
                  </li>
                </li>
                <li className="desc-text">
                  <li className="desc-icon">
                    <SvgIcon component={EmailIcon} inheritViewBox />
                  </li>
                  <li className="text">{data.body.userName}</li>
                </li>
                <li className="desc-text">
                  <li className="desc-icon">
                    <SvgIcon component={CalendarMonthIcon} inheritViewBox />
                  </li>
                  <li className="text">สร้างเมื่อ 3 มีนาคม 2560</li>
                </li>
              </ul>
            </div>
            <div className="Myprofile-descEditButt-con">
              <Button variant="contained">
                <SvgIcon component={EditIcon} inheritViewBox />
                แก้ไขข้อมูล
              </Button>
            </div>
          </div>
          <div className="nameCourse-con">
            <ul className="nameTab-con">
              <li className="name-Big">
                <li className="fname">{data.body.firstName}</li>
                <li className="lname">{data.body.lastName}</li>
              </li>
              <li className="moreTab">
                <SvgIcon component={VerifiedIcon} inheritViewBox />
              </li>
              <li className="profession">ถนัดด้านเชิงธุรกิจ</li>
            </ul>
            <div className="course-con">
              <div className="course-item">
                <div className="course-img">
                  <img src="" alt="courseImg" />
                </div>
                <div className="course-owner">
                  <div className="owner-img">
                    <img src="" alt="profileImg" />
                  </div>
                  <div className="owner-name">
                    <div className="nameVerified">
                      <div className="name">
                        <div className="name-show">นายก</div>
                        <div className="name-show">นามสมมุติ</div>
                      </div>
                      <div className="Verifi">
                        <SvgIcon component={VerifiedIcon} inheritViewBox />
                      </div>
                    </div>
                    <div className="date">4 day agos</div>
                  </div>
                </div>
                <div className="course-detail">
                  <div className="detail-con">
                    <div className="topic">
                      “ดาวโจนส์” ดิ่งกว่า 400 จุดผิดหวังผลประกอบการ
                      บริษัทค้าปลีก
                    </div>
                    <div className="about">
                      ดาวโจนส์ดิ่งกว่า 400 จุด ผิดหวังผลประกอบการ "โฮม
                      ดีโปท์-วอลมาร์ท" ต่ำกว่าคาด โดย ณ เวลา 22.08 น.ตามเวลาไทย
                      ดัชนีเฉลี่ยอุตสาหกรรมดาวโจนส์อยู่ที่ 33
                    </div>
                  </div>
                </div>
                <div className="course-cat">
                  <div className="cat-type"> asd</div>
                  <div className="cat-type">aaa</div>
                </div>
              </div>

              <div className="course-item">
                <div className="course-img"></div>
                <div className="course-owner"></div>
                <div className="course-detail"></div>
                <div className="course-cat"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Profile;
