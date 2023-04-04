import React, { useState } from 'react';
import './ReportButton.css'
import { FiAlertCircle, FiHeart, FiThumbsUp } from "react-icons/fi";
import TextField from '@material-ui/core/TextField';
import { Button } from '@mui/material'
import { FiCheck } from "react-icons/fi";


function ReportButton(props) {
    const [isDialogOpen, setIsDialogOpen] = useState(false);
    const [isSuccessDialogOpen, setIsSuccessDialogOpen] = useState(false);

    const handleReport= () => {
        // ต้องการลบข้อมูล ทำตามขั้นตอนที่ต้องการ และปิด dialog
        // setIsSuccessDialogOpen(true);
        setIsDialogOpen(false);
        setIsSuccessDialogOpen(true); 
        
    };


    return (
        <div>
            <button onClick={() => setIsDialogOpen(true)} style={{border:'none' ,backgroundColor:'white',marginRight: "10px" , color: 'red'}}>
                <span className="fcheck"><FiAlertCircle /></span>
            </button>
            {isDialogOpen && (
                <div>

                    <div className="dialog-containerV">
                        <h2>รายงานการละเมิด</h2>
                        <div className="selectdesign">
                            <select className="selectdesign" id="mySelect" disabled={!isDialogOpen}>
                                <option value="option1">อนาจาร,คุกคามทางเพศ</option>
                                <option value="option2">คำหยาบคาย</option>
                                <option value="option3">เนื้อหาไม่เหมาะสม</option>
                            </select>
                        </div><br></br>
                        <div >รายละเอียดเพิ่มเติม</div><br></br>

                        <TextField className="areadetai"
                            id="outlined-basic"
                            label="Detail"
                            multiline
                            variant="outlined"
                        /><br></br><br></br>

                        <dev className="dialog-footerV">
                            <button className="dialog-buttonV" onClick={() => setIsDialogOpen(false)}>Close</button>
                            <button className="dialog-buttonV2" onClick={handleReport} >Report</button>
                        </dev>
                    </div>
                    <div className="overlayV" onClick={() => setIsDialogOpen(false)}></div>
                </div>
            )} {isSuccessDialogOpen && (
                <div>
                    <div className="overlay" onClick={() => setIsSuccessDialogOpen(false)}></div>
                    <div className="dialog-container">
                        <h1>กดรายงานสำเร็จ</h1>
                        <FiCheck size={70} />
                        <div className='dialog-footer'>
                            <button className='dialog-button' onClick={() => setIsSuccessDialogOpen(false)}>Close</button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

export default ReportButton
