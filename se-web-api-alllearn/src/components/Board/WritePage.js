// ======หน้าเขียนบอร์ดใหม่=========
import React from 'react'
import { useState, useEffect } from "react";
import "./WritePage.css"
import TextField from '@material-ui/core/TextField';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import { useTheme } from '@material-ui/core/styles';
import Chip from '@material-ui/core/Chip';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import axios from 'axios';
// import PhotoCamera from '@material-ui/core/PhotoCamera';


const ITEM_HEIGHT = 48;
const ITEM_PADDING_TOP = 8;
const MenuProps = {
  PaperProps: {
    style: {
      maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
      width: 250,
    },
  },
};

const names = [
  'กีฬา',
  'เศรฐกิจ',
  'คอมพิวเตอร์',
  'ศิลปะ',
  'ความงาม',
  'กีฬา',
  'อสังหาทรัพย์',
];

function getStyles(name, personName, theme) {
  return {
    fontWeight:
      personName.indexOf(name) === -1
        ? theme.typography.fontWeightRegular
        : theme.typography.fontWeightMedium,
  };
}

export default function WritePage() {
  const theme = useTheme();
  const [personName, setPersonName] = React.useState([]);
  const [images, setImages] = useState([]);
  const [imageURLs, setImageURLs] = useState([]);
  const [selectedFile, setSelectedFile] = useState(null);

  // On file select (from the pop up)
  const onFileChange = event => {
    // Update the state
    setSelectedFile(event.target.files[0]);
  };

  // On file upload (click the upload button)
  const onFileUpload = () => {
    // Create an object of formData
    const formData = new FormData();

    // Update the formData object
    formData.append('myFile', selectedFile, selectedFile.name);

    // Details of the uploaded file
    console.log(selectedFile);

    // Request made to the backend api
    // Send formData object
    axios.post('http://localhost:8080/users/post', formData);
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
      typeof value === 'string' ? value.split(',') : value,
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

  return (
    <div>

      <div className='write-page'>

        <div className='write-con'>

          <div className='write-tag'>

            {/* <FormControl sx={{ m: 1, width: 300 }}>

              <InputLabel id="demo-multiple-chip-label">Tag</InputLabel>

              <Select
                labelId="demo-multiple-chip-label"
                id="demo-multiple-chip"
                multiple
                value={personName}
                onChange={handleChange}
                input={<OutlinedInput id="select-multiple-chip" label="Chip" />}
                renderValue={(selected) => (
                  <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5 }}>
                    {selected.map((value) => (
                      <Chip key={value} label={value} />
                    ))}
                  </Box>
                )}
                MenuProps={MenuProps}
              >
                {names.map((name) => (
                  <MenuItem
                    key={name}
                    value={name}
                    style={getStyles(name, personName, theme)}
                  >
                    {name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl> */}

          </div>
          <div className='write-up-img'>

            <div className='a'>Cover image</div>


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
          <div className="pic">{imageURLs.map((imageSrc, idx) => (
            <img key={idx} width="320" height="200" src={imageSrc} />
          ))}
          </div>

          <div className='write-topic'>

            <div className='a'>Title</div>

            <TextField
              id="filled-basic"
              label="Title"
              variant="filled"
            />

          </div>

          <div className='write-content'>

            <div className='a'>Paragrap</div>

            <TextField
              id="filled-textarea"
              placeholder="Type your content"
              multiline
              variant="filled"

            />
            <div className='post-button'>
              {/* <Button
                variant="contained"
                color='primary'
                size="large"
              >
                Post
              </Button> */}
<button onClick={onFileUpload}>Upload!</button>

            </div>
          </div>



        </div>

      </div>
    </div>

  );
}
