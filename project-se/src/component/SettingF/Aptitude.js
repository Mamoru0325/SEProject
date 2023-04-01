import Setting from './Setting'
import './Aptitude.css'
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import { IoIosPricetag } from "react-icons/io";

function Save() {
    alert('You have successfully submitted your verification Aptitude Tags confirmation.');
}


function Aptitude() {
    return (
        <div>

            <div style={{ display: 'flex'}}>

                <div >
                    <Setting />
                </div>
                
                <div className="Ap-container">
                    <div className='Ap-content'>

                        <div >
                            <h1 className="Ap-font">Aptitude Tags</h1>
                            <div className='Ap-b'>การขอเครื่องหมายยืนยันความถนัด<IoIosPricetag /> เพื่อบ่งบอกว่าคุณเป็นกูรูด้านอะไร</div>
                            <div className='Ap-b'>โปรดอัปโหลดเอกสารและกรอกรายละเอียดเกี่ยวกับตัวคุณ</div>
                            <div className='Ap-c'>เอกสารมีรายละเอียดดังนี้ 1.ใบประกาศยืนยันความสามารถความถนัด 2.หลักฐานยืนยันด้านความถนัด รวมเป็นไฟล์PDF</div>
                           
                            <div style={{marginBlockStart:'10px' , marginBlockEnd:'20px'}}>
                                <Button
                                    variant="outlined"
                                    component="label"
                                    color='secondary'
                                    size="medium"
                                >
                                    UpLoad certificate:  .
                                    <input accept="pdf/*" multiple type="file" />
                                </Button>
                            </div>
                        </div>


                        <a className='Ap-a'>Tag ความถนัดของคุณ</a>

                        <TextField
                            id="outlined-basi"
                            label="คำนิยามความถนัดสั้นๆ"
                            variant="outlined"
                        />

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

export default Aptitude




