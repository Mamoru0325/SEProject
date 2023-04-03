import React, { useState } from 'react';
import './ReportButton.css'
import { FiAlertCircle, FiHeart, FiThumbsUp } from "react-icons/fi";
import TextField from '@material-ui/core/TextField';


function ReportButton(props) {
    const [isDialogOpen, setIsDialogOpen] = useState(false);


    return (
        <div>
            <button onClick={() => setIsDialogOpen(true)}>
                <span className="fcheck" style={{ backgroundColor: "#fff", border: '0', color: "#DC143C", padding: "15px", fontSize: "20px" }}><FiAlertCircle /></span></button>
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
                            <button className="dialog-buttonV2" >Report</button>
                        </dev>
                    </div>
                    <div className="overlayV" onClick={() => setIsDialogOpen(false)}></div>
                </div>
            )}
        </div>
    );
}

export default ReportButton
