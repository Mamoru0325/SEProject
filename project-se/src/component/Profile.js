import React from 'react'
import './Profile.css'
import "./Header.css"
import imgPok from '../pok.jpg'
import Button from '@material-ui/core/Button';

function Profile() {
  return (
    <div className='profile'>
      <div className='container'>
        <div className='profileฺBack-con'>

        </div>
        <div className='content-con'>
          <div className='aboutMe-con'>
            <div className='myImg'>

            </div>
            <div className='followTab'>
              <Button variant="contained">Follow</Button>
              <div className='total'>
                <div className='num'>100k</div>
                <div className='text'>follower</div>
              </div>
            </div>
            <div className='desc'>

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
                  aaaaa
                </li>
                <li className="verified">
                  asdasd
                </li>
                <li className="profession">
                  asdasd
                </li>
            </ul>
          <div className='course-con'>
            <div className='course-item'>
              <div className='course-img'>
                <img src={imgPok}/>
              </div>
              <div className='course-owner'>
                <div className='owner-img'>

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
                      aaa
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