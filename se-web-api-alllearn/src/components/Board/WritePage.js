// ======หน้าเขียนบอร์ดใหม่=========
import React from "react";
import { useState, useEffect } from "react";
import "./WritePage.css";
import TextField from "@material-ui/core/TextField";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputLabel from "@material-ui/core/InputLabel";
import MenuItem from "@material-ui/core/MenuItem";
import FormControl from "@material-ui/core/FormControl";
import Select from "@material-ui/core/Select";
import { useTheme } from "@material-ui/core/styles";
import Chip from "@material-ui/core/Chip";
import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import IconButton from "@material-ui/core/IconButton";
import axios from "axios";
import moment from "moment/moment";
// import PhotoCamera from '@material-ui/core/PhotoCamera';

export default function WritePage() {
  const [personName, setPersonName] = React.useState([]);
  const [images, setImages] = useState([]);
  const [imageURLs, setImageURLs] = useState([]);
  const [selectedFile, setSelectedFile] = useState(null);
  const [items, setItems] = useState([]);
  const [data, setData] = useState([]);
  const [contentType, setContentType] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  // On file select (from the pop up)
  const onFileChange = (event) => {
    // Update the state
    setSelectedFile(event.target.files[0]);
  };

  // On file upload (click the upload button)
  const onFileUpload = () => {
    // Create an object of formData
    const formData = new FormData();

    // Update the formData object
    formData.append("myFile", selectedFile, selectedFile.name);

    // Details of the uploaded file
    console.log(selectedFile);

    // Request made to the backend api
    // Send formData object
    axios.post("http://localhost:8080/users/post", formData);
  };

  // File content to be displayed after
  // file upload is complete
  const fileData = () => {
    if (selectedFile) {
      return (
        <div>
          <h2>File Details:</h2>
          <p>File Name: {selectedFile.name}</p>
          <p>File Type: {selectedFile.type}</p>
          <p>Last Modified: {selectedFile.lastModifiedDate.toDateString()}</p>
        </div>
      );
    } else {
      return (
        <div>
          <br />
          <h4>Choose before Pressing the Upload button</h4>
        </div>
      );
    }
  };

  useEffect(() => {
    fileData();
  }, [selectedFile]);

  const handleChange = (event) => {
    const {
      target: { value },
    } = event;
    setPersonName(
      // On autofill we get a stringified value.
      typeof value === "string" ? value.split(",") : value
    );
  };

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

  useEffect(() => {
    const localStorageData = localStorage.getItem("user");
    let user = JSON.parse(localStorageData);
    console.log("===== " + user.body.userName);
    // if (localStorageData) {
    //   setData(JSON.parse(localStorageData));
    // }
    const fetchData = async () => {
      setTimeout(async () => {
        const response = await axios.get(
          `http://localhost:8080/users/email/${user.body.userName}`
        );
        setData(response.data);
        //console.log(data.body);
        setIsLoading(false);
      }, 2000); // set delay to 2 seconds
    };
    fetchData();

    const fetchContentTypeData = async () => {
      setTimeout(async () => {
        const response = await axios.get(`http://localhost:8080/conntentType/`);
        setContentType(response.data);
        //console.log(contentType);
        setIsLoading(false);
      }, 2000); // set delay to 2 seconds
    };
    fetchContentTypeData();
  }, []);
  console.log(data);
  console.log(contentType);
  if (isLoading) {
    return <div>Loading...</div>;
  }

  const createPo = () => {
    const localStorageData = localStorage.getItem("user");
    let user = JSON.parse(localStorageData);
    const token = user.body.token;
    axios
      .post(
        `http://localhost:8080/users/post`,
        {
          postTopic: "string",
          postDetail: "string",
          createDate: moment().format("YYYY-MM-DD HH:mm a"),
        },
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
          params: {
            contentId: 1,
          },
        }
      )
      .then((response) => {
        console.log(data);
      })
      .catch((error) => {
        console.error(error);
      });
  };
  if (!data) return "No Course";

  return (
    <div>
      <div className="write-page">
        <div className="write-con">
          <div className="write-tag">
            <div>
              <select>
                {contentType.body.map((content, index) => (
                  <option key={index} value={content.contentTypeId}>
                    {content.typeName}
                  </option>
                ))}
              </select>
            </div>
          </div>
          <div className="write-up-img">
            <div className="a">Cover image</div>

            <div>
              <div>
                <input type="file" onChange={onFileChange} />
              </div>
              {fileData()}
            </div>

            {/* <Button
              variant="contained"
              component="label"
              color='tertiary'
              size="small"
            >
              Upload
              <input hidden accept="image/*" type="file" onChange={onImageChange} />
             
            </Button>  */}
          </div>
          <div className="pic">
            {imageURLs.map((imageSrc, idx) => (
              <img key={idx} width="320" height="200" src={imageSrc} />
            ))}
          </div>

          <div className="write-topic">
            <div className="a">Title</div>

            <TextField id="filled-basic" label="Title" variant="filled" />
          </div>

          <div className="write-content">
            <div className="a">Paragrap</div>

            <TextField
              id="filled-textarea"
              placeholder="Type your content"
              multiline
              variant="filled"
            />
            <div className="post-button">
              {/* <Button
                variant="contained"
                color='primary'
                size="large"
              >
                Post
              </Button> */}
              <button onClick={createPo}>Upload!</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
