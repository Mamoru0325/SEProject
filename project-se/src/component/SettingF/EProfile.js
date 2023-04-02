import Setting from './Setting'
import './Aptitude.css'
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import { useState, useEffect } from "react";

function Save() {
    alert('You have successfully Edit your Profile.');
}


function EProfile() {
    const [images, setImages] = useState([]);
    const [imageURLs, setImageURLs] = useState([]);

    useEffect(() => {
        if (images.length < 1) return;
        const newImageUrls = [];
        images.forEach((image) => newImageUrls.push(URL.createObjectURL(image)));
        setImageURLs(newImageUrls);
    }, [images]);

    function onImageChange(e) {
        setImages([...e.target.files]);
    }

    console.log("Images : ", images);
    console.log("imageURLs : ", imageURLs);


    return (
        <div>

            <div style={{ display: 'flex' }}>

                <Setting />
                <div className="Ap-container">
                    <div className='Ap-content'>
                        <div ><h1 className="Ap-font">Edit your Profile</h1>
                            <div >

                                <Button
                                    variant="outlined"
                                    component="label"
                                    color='secondary'
                                    size="medium"
                                >
                                    Upload Profile:  .

                                    <input hidden accept="image/*" type="file" onChange={onImageChange} />

                                </Button><br></br><br></br>

                            </div>
                            <div className="pic">{imageURLs.map((imageSrc, idx) => (
                                <img key={idx} width="320" height="320" src={imageSrc} />
                            ))}
                            </div>
                        </div>



                        <a className='a'>About Me</a>

                        <TextField
                            id="outlined-basi"
                            label="แก้ไขคำแนะนำตัว"
                            multiline
                            variant="outlined"

                        />

                        <button className="buttonsave" onClick={Save}>Save</button>

                    </div>




                </div>

            </div>


        </div>
    )


}

export default EProfile




