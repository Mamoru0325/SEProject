import React from 'react'
import './Profile.css'
import "./Header.css"
import imgPok from '../pok.jpg'
import proImg from '../proImg.jpg'
import moreImg from '../more.jpg'
import verifImg from '../verifiedIcon.jpg'
import Button from '@material-ui/core/Button';
import Box from '@mui/material/Box';
import Fab from '@mui/material/Fab';
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import NavigationIcon from '@mui/icons-material/Navigation';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import SvgIcon from '@mui/material/SvgIcon';
import EmailIcon from '@mui/icons-material/Email';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';

function Profile() {
  
  return (
    <div className='profile'>
      <div className='container'>
        <div className='profileฺBack-con'>

        </div>
        <div className='content-con'>
          <div className='aboutMe-con'>
            <div className='myImg'>
              <img src={proImg}/>
            </div>
            <div className='followTab'>
              <Button variant="contained">Follow</Button>
              <div className='total'>
                <div className='num'>100k</div>
                <div className='text'>follower</div>
              </div>
            </div>
            <div className='desc-con'>
              <ul className='desc'>
                <li className='desc-text'>
                  <li className='desc-icon'>
                    <SvgIcon component={AccountCircleIcon}inheritViewBox />
                  </li>
                  <li className='text'>
                    สรุปเรื่อง การเงิน การลงทุน เศรษฐกิจ เพื่อนำไปใช้
วางแผนได้อย่างถูกต้องครบถ้วน เพื่อเป้าหมายใน
การดำเนินชีวิตได้อย่างมีความสุขพร้อมกับมีอิสระ
ทางด้านการเงิน
                  </li>
                </li>
                <li className='desc-text'>
                  <li className='desc-icon'>
                    <SvgIcon component={EmailIcon}inheritViewBox />
                  </li>
                  <li className='text'>
                    xxx@gmail.com
                  </li>
                </li>
                <li className='desc-text'>
                  <li className='desc-icon'>
                    <SvgIcon component={CalendarMonthIcon}inheritViewBox />
                  </li>
                  <li className='text'>
                    สร้างเมื่อ 3 มีนาคม 2560
                  </li>
                </li>
              </ul>
            </div>
          </div>
          <div className='nameCourse-con'>
            <ul className='nameTab-con'>
                <li className="name-Big">
                  <li className='fname'>
                    นายก
                  </li>
                  <li className='lname'>
                    นามสมมุติ
                  </li>
                </li>
                 <li className="moreTab">
                  <img src={verifImg}/>

                </li>
                <li className="verified">
                  <Box sx={{ '& > :not(style)': { m: 1 } }}>
                    <Fab size="small" color="primary" aria-label="add">
                      <AddIcon />
                    </Fab>
                  </Box>
                </li>
                <li className="profession">
                  ถนัดด้านเชิงธุรกิจ
                </li>
            </ul>
          <div className='course-con'>
            <div className='course-item'>
              <div className='course-img'>
                <img src={imgPok}/>
              </div>
              <div className='course-owner'>
                <div className='owner-img'>
                  <img src={proImg}/>
                </div>
                <div className='owner-name'>
                  <div className='nameVerified'>
                    <div className='name'>
                      <div className='name-show'>
                        นายก
                      </div>
                      <div className='name-show'>
                        นามสมมุติ
                      </div>
                    </div>
                    <div className='Verifi'>
                      <img src={verifImg}/>
                    </div>
                  </div>
                  <div className='date'>
                      4 day agos
                  </div>
                </div>
              </div>
              <div className='course-detail'>
                <div className='detail-con'>
                  <div className='topic'>
                    “ดาวโจนส์” ดิ่งกว่า 400 จุดผิดหวังผลประกอบการ
บริษัทค้าปลีก
                  </div>
                  <div className='about'>
                    ดาวโจนส์ดิ่งกว่า 400 จุด ผิดหวังผลประกอบการ "โฮม ดีโปท์-วอลมาร์ท" ต่ำกว่าคาด โดย ณ เวลา 22.08 น.ตามเวลาไทย ดัชนีเฉลี่ยอุตสาหกรรมดาวโจนส์อยู่ที่ 33
                  </div>
                </div>
              </div>
              <div className='course-cat'>
                <div className='cat-type'> asd</div>
                <div className='cat-type'>aaa</div>
              </div>
            </div>

            <div className='course-item'>
              <div className='course-img'>

              </div>
              <div className='course-owner'></div>
              <div className='course-detail'></div>
              <div className='course-cat'></div>
            </div>
          </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Profile