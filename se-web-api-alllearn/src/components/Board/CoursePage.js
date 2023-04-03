import React from 'react'
import './CoursePage.css'
import { useState } from 'react';

import ConfirmCourse from './ConfirmCourse'
import ConfirmCourse2 from './ConfirmCourse';

export default function CoursePage() {

  return (
    <div className='cp-container'>
      <div className='cp-content'>

        <div className='cp-profile'>

          <img className='small-profile' src='./proImg.jpg' alt='avatar' />

          <span> ชื่อ นามสกุล</span>
        </div>

        <div className='cp-img'>
          <img src="./bannerPic.png" alt="img" height={400} width={900} />
        </div>

        <div className='cp-info'>
          <h1>หัวข้อ</h1>
          <p>
            รู้หรือไม่ว่า Engoo เป็นแพลตฟอร์ม เรียนภาษาอังกฤษออนไลน์
            สอนสด ตัวต่อตัว กับครูต่างชาติ และครูเจ้าของภาษา เรียนได้ตลอด 24 ชม.
            โดยแพลตฟอร์มนี้ ถูกออกแบบขึ้นโดยประเทศญี่ปุ่น ด้วยหลักสูตรที่ยืดหยุ่นและได้ผลจริง
            ในราคาที่ผู้เรียนทุกระดับสามารถเข้าถึงได้ จึงทำให้ Engoo เติบโตและเป็นที่นิยมเป็นอย่างมากทั้งในประเทศไทยและทั่วโลก
          </p>

        </div>

        <div className='cp-detail'>
          <div className='cp-font'>
            <div>
              register 10/10
            </div>

            <div>
              ระยะเวลาเปิดรับสมัคร
            </div>

            <div>
              วันที่เปิดสอน
            </div>
            <div>
              จำนวนที่เปิดรับ
              min
              max
            </div>

            <div>
              ราครา
            </div>


          </div>

         

        </div>
        <div style={{display:'flex' , justifyContent:'center'}}>
           <ConfirmCourse />
        </div>



      </div>

    </div>

  )
}


