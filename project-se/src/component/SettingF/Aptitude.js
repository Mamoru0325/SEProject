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
        <dev>
            <dev><Setting />
                <dev >
                    <dev className="container">
                        <dev ><h1 className="font">Aptitude Tags</h1>
                            <a className='b'>การขอเครื่องหมายยืนยันความถนัด<IoIosPricetag /> เพื่อบ่งบอกว่าคุณเป็นกูรูด้านอะไร</a><br></br>
                            <a className='b'>โปรดอัปโหลดเอกสารและกรอกรายละเอียดเกี่ยวกับตัวคุณ</a><br></br><br></br>
                            <a className='c'>เอกสารมีรายละเอียดดังนี้ 1.ใบประกาศยืนยันความสามารถความถนัด 2.หลักฐานยืนยันด้านความถนัด รวมเป็นไฟล์PDF</a><br></br><br></br>
                            <dev >
                                <Button
                                    variant="outlined"
                                    component="label"
                                    color='secondary'
                                    size="medium"
                                >
                                    UpLoad certificate:  .
                                    <input accept="pdf/*" multiple type="file" />
                                </Button>
                            </dev>
                        </dev>

                        <div className='topic'>

                            <a className='a'>Tag ความถนัดของคุณ</a>

                            <TextField
                                id="outlined-basi"
                                label="คำนิยามความถนัดสั้นๆ"
                                variant="outlined"
                            />

                        </div>
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

export default Aptitude




