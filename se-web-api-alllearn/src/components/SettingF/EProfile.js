import Setting from './Setting'
import './Aptitude.css'
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import { useState, useEffect } from "react";
import axios from "axios";

function Save() {
    alert('You have successfully Edit your Profile.');
}


function EProfile() {

    const [images, setImages] = useState([]);
    const [imageURLs, setImageURLs] = useState([]);
    const [detail, setDetail] = useState([]);



    // useEffect(() => {
    //     const localStorageData = localStorage.getItem("user");
    //     let user = JSON.parse(localStorageData);
    //     console.log("===== " + user.body.userName);

    //     const fetchData = async () => {
    //         setTimeout(async () => {
    //             const response = await axios.get(
    //                 `http://localhost:8080/users/email/${user.body.userName}`
    //             );
    //             setData(response.data);
    //             //console.log(data.body);
    //             setIsLoading(false);
    //         }, 2000); // set delay to 2 seconds
    //     };
    //     fetchData();

    // }, []);


    const createPo = () => {

        const localStorageData = localStorage.getItem('user');
        let user = JSON.parse(localStorageData);
        const token = user.body.token;

        // console.log(contentTypeNow);
        // console.log(postTopic);
        // console.log(postDetail);

        axios.put(`http://localhost:8080/users/${user.id}`, {
            detail: `${detail}`,
            // postDetail: `${postDetail}`,
            // reportStatus: "Done",
            // createDate: moment().format('YYYY-MM-DD HH:mm a'),
        }, {
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`,
            },
        }).then((response) => {
            console.log(response.data);
        }).catch((error) => {
            console.error(error);
        });
    };

    // axios.post("'http://localhost:8080/users/email/", formData);


    // function onImageChange(e) {
    //     setImages([...e.target.files]);
    // }

    // console.log("Images : ", images);
    // console.log("imageURLs : ", imageURLs);


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

                                    <input hidden accept="image/*" type="file" />

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

                        <button className="buttonsave" onClick={createPo}>Save</button>

                    </div>




                </div>

            </div>


        </div>
    )


}


export default EProfile




