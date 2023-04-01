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
        <dev>
            <dev><Setting />
            <dev >
                <dev className="container">
                    <dev ><h1 className="font">Verification</h1>
                    <a className='b'>การขอเครื่องหมายยืนยัน<IoIosCheckmarkCircle/> เพื่อเป็นการยืนยันสิทธิ์ของคุณ</a><br></br>
                    <a className='b'>โปรดอัปโหลดเอกสารและกรอกรายละเอียดเกี่ยวกับตัวคุณ</a><br></br><br></br>
                    <a className='c'>เอกสารมีรายละเอียดดังนี้ 1. สำเนาบัตรประชาชน 2. รูปถ่ายปัจจุบัน 2 รูป รวมเป็นไฟล์PDF</a><br></br><br></br>
                    <dev >
                        <Button
                            variant="outlined"
                            component="label"
                            color='secondary'
                            size="medium"
                        >
                            UpLoad certificate:  .  
                            <input  accept="pdf/*"  type="file" />
                        </Button>
                    </dev>
                    </dev>
                    
                    
                    <div className='content'>

                        <a className='a'>About Me</a>

                        <TextField
                            id="outlined-basi"
                            label="write about yourself"
                            multiline
                            variant="outlined"

                        />
                        <dev>
                            <button className="buttonsave" onClick={Save}>Sent</button>
                        </dev>
                    </div>




                </dev>
            </dev>
            </dev>


        </dev>
    )


}

export default Verification
