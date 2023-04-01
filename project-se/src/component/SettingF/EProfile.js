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
        <dev>
            <dev><Setting />
                <dev >
                    <dev className="container">
                        <dev ><h1 className="font">Edit your Profile</h1>
                            <dev >
                                
                                <Button
                                    variant="outlined"
                                    component="label"
                                    color='secondary'
                                    size="medium"
                                >
                                    UpLoad Profile:  .

                                    <input hidden accept="image/*" type="file" onChange={onImageChange} />

                                </Button><br></br><br></br>

                            </dev>
                            <dev className="pic">{imageURLs.map((imageSrc, idx) => (
                                <img key={idx} width="320" height="320" src={imageSrc} />
                            ))}</dev>
                        </dev>

                        <div className='content'>

                            <a className='a'>About Me</a>

                            <TextField
                                id="outlined-basi"
                                label="แก้ไขคำแนะนำตัว"
                                multiline
                                variant="outlined"

                            />
                            <dev>
                                <button className="buttonsave" onClick={Save}>Save</button>
                            </dev>
                        </div>




                    </dev>
                </dev>
            </dev>


        </dev>
    )


}

export default EProfile




