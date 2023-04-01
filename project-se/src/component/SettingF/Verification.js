import Setting from './Setting'
import './Aptitude.css'
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import { IoIosCheckmarkCircle } from "react-icons/io";

function Save() {
    alert('You have successfully submitted your verification confirmation.');
}



function Verification() {
    return (
        <div>


            <div style={{ display: 'flex' }}>

                <Setting />

                <div className="Ap-container">
                    <div className='Ap-content'>
                        <div>
                            <h1 className="Ap-font">Verification</h1>
                            <div className='Ap-b'>การขอเครื่องหมายยืนยัน<IoIosCheckmarkCircle /> เพื่อเป็นการยืนยันสิทธิ์ของคุณ</div>
                            <div className='Ap-b'>โปรดอัปโหลดเอกสารและกรอกรายละเอียดเกี่ยวกับตัวคุณ</div>
                            <div className='Ap-c'>เอกสารมีรายละเอียดดังนี้ 1. สำเนาบัตรประชาชน 2. รูปถ่ายปัจจุบัน 2 รูป รวมเป็นไฟล์PDF</div>
                            
                            <div style={{marginBlockStart:'10px' , marginBlockEnd:'20px'}}>
                                <Button
                                    variant="outlined"
                                    component="label"
                                    color='secondary'
                                    size="medium"
                                >
                                    UpLoad certificate:  .
                                    <input accept="pdf/*" type="file" />
                                </Button>
                            </div>
                        </div>




                        <a className='Ap-a'>About Me</a>

                        <TextField
                            id="outlined-basi"
                            label="write about yourself"
                            multiline
                            variant="outlined"

                        />
                        
                            <button className="buttonsave" onClick={Save}>Sent</button>
                        
                    </div>




                </div>

            </div>


        </div>
    )


}

export default Verification
