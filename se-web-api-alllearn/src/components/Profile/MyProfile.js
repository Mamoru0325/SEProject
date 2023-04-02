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
    // <div className="profile">
    //   <div className="container">
    //     <div className="profileฺBack-con"></div>
    //     <div className="content-con">
    //       <div className="aboutMe-con">
    //         <div className="myImg">
    //           <img src="" alt="profileImg" />
    //         </div>
    //         <div className="MyProfile-totalTab">
    //           <ul className="MyProfile-totalText">
    //             <li>จำนวนผู้ติดตาม </li>
    //             <li>จำนวนโพสต์</li>
    //             <li>จำนวนคอร์ส</li>
    //           </ul>
    //           <div className="MyProfile-totalNum">
    //             <div>10.6k </div>
    //             <div>230</div>
    //             <div>3</div>
    //           </div>
    //         </div>
    //         <div className="desc-con">
    //           <ul className="desc">
    //             <li className="desc-text">
    //               <li className="desc-icon">
    //                 <SvgIcon component={AccountCircleIcon} inheritViewBox />
    //               </li>
    //               <li className="text">
    //                 สรุปเรื่อง การเงิน การลงทุน เศรษฐกิจ เพื่อนำไปใช้
    //                 วางแผนได้อย่างถูกต้องครบถ้วน เพื่อเป้าหมายใน
    //                 การดำเนินชีวิตได้อย่างมีความสุขพร้อมกับมีอิสระ
    //                 ทางด้านการเงิน
    //               </li>
    //             </li>
    //             <li className="desc-text">
    //               <li className="desc-icon">
    //                 <SvgIcon component={EmailIcon} inheritViewBox />
    //               </li>
    //               <li className="text">{data.body.userName}</li>
    //             </li>
    //             <li className="desc-text">
    //               <li className="desc-icon">
    //                 <SvgIcon component={CalendarMonthIcon} inheritViewBox />
    //               </li>
    //               <li className="text">สร้างเมื่อ 3 มีนาคม 2560</li>
    //             </li>
    //           </ul>
    //         </div>
    //         <div className="Myprofile-descEditButt-con">
    //           <Button variant="contained">
    //             <SvgIcon component={EditIcon} inheritViewBox />
    //             แก้ไขข้อมูล
    //           </Button>
    //         </div>
    //       </div>
    //       <div className="nameCourse-con">
    //         <ul className="nameTab-con">
    //           <li className="name-Big">
    //             <li className="fname">{data.body.firstName}</li>
    //             <li className="lname">{data.body.lastName}</li>
    //           </li>
    //           <li className="moreTab">
    //             <SvgIcon component={VerifiedIcon} inheritViewBox />
    //           </li>
    //           <li className="profession">ถนัดด้านเชิงธุรกิจ</li>
    //         </ul>
    //         <div className="course-con">
    //           <div className="course-item">
    //             <div className="course-img">
    //               <img src="" alt="courseImg" />
    //             </div>
    //             <div className="course-owner">
    //               <div className="owner-img">
    //                 <img src="" alt="profileImg" />
    //               </div>
    //               <div className="owner-name">
    //                 <div className="nameVerified">
    //                   <div className="name">
    //                     <div className="name-show">นายก</div>
    //                     <div className="name-show">นามสมมุติ</div>
    //                   </div>
    //                   <div className="Verifi">
    //                     <SvgIcon component={VerifiedIcon} inheritViewBox />
    //                   </div>
    //                 </div>
    //                 <div className="date">4 day agos</div>
    //               </div>
    //             </div>
    //             <div className="course-detail">
    //               <div className="detail-con">
    //                 <div className="topic">
    //                   “ดาวโจนส์” ดิ่งกว่า 400 จุดผิดหวังผลประกอบการ
    //                   บริษัทค้าปลีก
    //                 </div>
    //                 <div className="about">
    //                   ดาวโจนส์ดิ่งกว่า 400 จุด ผิดหวังผลประกอบการ "โฮม
    //                   ดีโปท์-วอลมาร์ท" ต่ำกว่าคาด โดย ณ เวลา 22.08 น.ตามเวลาไทย
    //                   ดัชนีเฉลี่ยอุตสาหกรรมดาวโจนส์อยู่ที่ 33
    //                 </div>
    //               </div>
    //             </div>
    //             <div className="course-cat">
    //               <div className="cat-type"> asd</div>
    //               <div className="cat-type">aaa</div>
    //             </div>
    //           </div>

    //           <div className="course-item">
    //             <div className="course-img"></div>
    //             <div className="course-owner"></div>
    //             <div className="course-detail"></div>
    //             <div className="course-cat"></div>
    //           </div>
    //         </div>
    //       </div>
    //     </div>
    //   </div>
    // </div>
    <div className="container">
      <div className="main-body">
        {/* Breadcrumb */}
        {/* <nav aria-label="breadcrumb" className="main-breadcrumb">
          <ol className="breadcrumb">
            <li className="breadcrumb-item">
              <a href="index.html">Home</a>
            </li>
            <li className="breadcrumb-item">
              <a href="javascript:void(0)">User</a>
            </li>
            <li className="breadcrumb-item active" aria-current="page">
              User Profile
            </li>
          </ol>
        </nav> */}
        {/* /Breadcrumb */}
        <div className="row gutters-sm">
          <div className="col-md-4 mb-3">
            <div className="card">
              <div className="card-body">
                <div className="d-flex flex-column align-items-center text-center">
                  <img
                    src="https://bootdey.com/img/Content/avatar/avatar7.png"
                    alt="Admin"
                    className="rounded-circle"
                    width={150}
                  />
                  <div className="mt-3">
                    <h4>John Doe</h4>
                    <p className="text-secondary mb-1">Full Stack Developer</p>
                    <p className="text-muted font-size-sm">
                      Bay Area, San Francisco, CA
                    </p>
                    <button className="btn btn-primary">Follow</button>
                    <button className="btn btn-outline-primary">Message</button>
                  </div>
                </div>
              </div>
            </div>
            <div className="card mt-3">
              <ul className="list-group list-group-flush">
                <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                  <h6 className="mb-0">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width={24}
                      height={24}
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth={2}
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="feather feather-globe mr-2 icon-inline"
                    >
                      <circle cx={12} cy={12} r={10} />
                      <line x1={2} y1={12} x2={22} y2={12} />
                      <path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z" />
                    </svg>
                    Website
                  </h6>
                  <span className="text-secondary">https://bootdey.com</span>
                </li>
                <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                  <h6 className="mb-0">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width={24}
                      height={24}
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth={2}
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="feather feather-github mr-2 icon-inline"
                    >
                      <path d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22" />
                    </svg>
                    Github
                  </h6>
                  <span className="text-secondary">bootdey</span>
                </li>
                <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                  <h6 className="mb-0">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width={24}
                      height={24}
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth={2}
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="feather feather-twitter mr-2 icon-inline text-info"
                    >
                      <path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z" />
                    </svg>
                    Twitter
                  </h6>
                  <span className="text-secondary">@bootdey</span>
                </li>
                <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                  <h6 className="mb-0">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width={24}
                      height={24}
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth={2}
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="feather feather-instagram mr-2 icon-inline text-danger"
                    >
                      <rect x={2} y={2} width={20} height={20} rx={5} ry={5} />
                      <path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z" />
                      <line x1="17.5" y1="6.5" x2="17.51" y2="6.5" />
                    </svg>
                    Instagram
                  </h6>
                  <span className="text-secondary">bootdey</span>
                </li>
                <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                  <h6 className="mb-0">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width={24}
                      height={24}
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth={2}
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="feather feather-facebook mr-2 icon-inline text-primary"
                    >
                      <path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z" />
                    </svg>
                    Facebook
                  </h6>
                  <span className="text-secondary">bootdey</span>
                </li>
              </ul>
            </div>
          </div>
          <div className="col-md-8">
            <div className="card mb-3">
              <div className="card-body">
                <div className="row">
                  <div className="col-sm-3">
                    <h6 className="mb-0">Full Name</h6>
                  </div>
                  <div className="col-sm-9 text-secondary">Kenneth Valdez</div>
                </div>
                <hr />
                <div className="row">
                  <div className="col-sm-3">
                    <h6 className="mb-0">Email</h6>
                  </div>
                  <div className="col-sm-9 text-secondary">fip@jukmuh.al</div>
                </div>
                <hr />
                <div className="row">
                  <div className="col-sm-3">
                    <h6 className="mb-0">Phone</h6>
                  </div>
                  <div className="col-sm-9 text-secondary">(239) 816-9029</div>
                </div>
                <hr />
                <div className="row">
                  <div className="col-sm-3">
                    <h6 className="mb-0">Mobile</h6>
                  </div>
                  <div className="col-sm-9 text-secondary">(320) 380-4539</div>
                </div>
                <hr />
                <div className="row">
                  <div className="col-sm-3">
                    <h6 className="mb-0">Address</h6>
                  </div>
                  <div className="col-sm-9 text-secondary">
                    Bay Area, San Francisco, CA
                  </div>
                </div>
                <hr />
                {/* <div className="row">
                  <div className="col-sm-12">
                    <a
                      className="btn btn-info "
                      target="__blank"
                      href="https://www.bootdey.com/snippets/view/profile-edit-data-and-skills"
                    >
                      Edit
                    </a>
                  </div>
                </div> */}
              </div>
            </div>
            <div className="row gutters-sm">
              <div className="col-sm-6 mb-3">
                <div className="card h-100">
                  <div className="card-body">
                    <h6 className="d-flex align-items-center mb-3">
                      <i className="material-icons text-info mr-2">
                        assignment
                      </i>
                      Project Status
                    </h6>
                    <small>Web Design</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "80%" }}
                        aria-valuenow={80}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                    <small>Website Markup</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "72%" }}
                        aria-valuenow={72}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                    <small>One Page</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "89%" }}
                        aria-valuenow={89}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                    <small>Mobile Template</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "55%" }}
                        aria-valuenow={55}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                    <small>Backend API</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "66%" }}
                        aria-valuenow={66}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div className="col-sm-6 mb-3">
                <div className="card h-100">
                  <div className="card-body">
                    <h6 className="d-flex align-items-center mb-3">
                      <i className="material-icons text-info mr-2">
                        assignment
                      </i>
                      Project Status
                    </h6>
                    <small>Web Design</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "80%" }}
                        aria-valuenow={80}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                    <small>Website Markup</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "72%" }}
                        aria-valuenow={72}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                    <small>One Page</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "89%" }}
                        aria-valuenow={89}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                    <small>Mobile Template</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "55%" }}
                        aria-valuenow={55}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                    <small>Backend API</small>
                    <div className="progress mb-3" style={{ height: 5 }}>
                      <div
                        className="progress-bar bg-primary"
                        role="progressbar"
                        style={{ width: "66%" }}
                        aria-valuenow={66}
                        aria-valuemin={0}
                        aria-valuemax={100}
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Profile;
