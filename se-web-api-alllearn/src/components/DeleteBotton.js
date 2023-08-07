import React, { useState } from 'react';
import './ReportButton.css'
import { FiTrash, FiHeart, FiThumbsUp } from "react-icons/fi";
import TextField from '@material-ui/core/TextField';
import { Button } from '@mui/material'
import { FiCheck } from "react-icons/fi";


function DeleteButton(props) {
    const [isSuccessDialogOpen, setIsSuccessDialogOpen] = useState(false);
    const [isDialogOpen, setIsDialogOpen] = useState(false);

    const handleDelete = () => {
        // ต้องการลบข้อมูล ทำตามขั้นตอนที่ต้องการ และปิด dialog
        // setIsSuccessDialogOpen(true);
        setIsDialogOpen(false);
        setIsSuccessDialogOpen(true); 
        
    };

    const handleCancel = () => {
        // ไม่ต้องการลบ ปิด dialog
        setIsDialogOpen(false);
    };

  



    return (
        <div>
            <button onClick={() => setIsDialogOpen(true)} style={{ border: 'none', backgroundColor: 'white',color: 'red' }}>
                <span className="fcheck"><FiTrash /></span>
            </button>

            {isDialogOpen && (
                <div>

                    <div className="dialog-containerV">
                        <h2>คุณต้องการจะลบใช่หรือไม่</h2>



                        <br></br><br></br>

                        <dev className="dialog-footerV">

                            <button className="dialog-buttonV" onClick={handleCancel}>ยกเลิก</button>
                            <button className="dialog-buttonV2" onClick={handleDelete}>ลบ</button>
                        </dev>
                       
                    </div>

                   
                   
                </div>
            )} {isSuccessDialogOpen && (
                        <div>
                            <div className="overlay" onClick={() => setIsSuccessDialogOpen(false)}></div>
                            <div className="dialog-container">
                                <h1>ลบสำเร็จ</h1>
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

export default DeleteButton