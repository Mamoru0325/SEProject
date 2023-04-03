import React, { useState } from 'react';
import './ConfirmCourse.css'

function ConfirmCourse(props) {
    const [isDialogOpen, setIsDialogOpen] = useState(false);
    const [file, setFile] = useState(null); // เก็บไฟล์ที่เลือกจาก input

    const handleFileChange = (event) => {
        const selectedFile = event.target.files[0];
        setFile(selectedFile);
    };

    const handleNextClick = () => {
        if (file) {
            setIsDialogOpen(false);
            // props.onNext();
            alert('Register Successful');
        } else {
            alert('Please upload a file before proceeding.');
        }
    };
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
                                <div>xxx</div>
                                <h3>
                                    จำนวนเปิดรับ<br/>
                                  
                                </h3>
                                <div>xxxx</div>
                                <h3>
                                    ราคา
                                </h3>
                                <div>xxxx</div>
                            </div>
                            <div>
                                <div className='QrCode'></div>

                                <h5>แนบหลักฐานการชำระเงิน</h5>
                                <div >
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
        </div>
    );
}

export default ConfirmCourse;
