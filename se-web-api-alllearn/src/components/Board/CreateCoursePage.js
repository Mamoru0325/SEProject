// ======หน้าสำหรับไว้สร้างคอร์ส=========

import React from "react";
import { useState, useEffect } from "react";
import "./CreateCoursePage.css";
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
import moment, { max } from "moment/moment";
import { Link } from "react-router-dom";

// import Slider from '@mui/material/Slider';

// const ITEM_HEIGHT = 48;
// const ITEM_PADDING_TOP = 8;
// const MenuProps = {
//   PaperProps: {
//     style: {
//       maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
//       width: 250,
//     },
//   },
// };

// const names = [
//   'กีฬา',
//   'เศรฐกิจ',
//   'คอมพิวเตอร์',
//   'ศิลปะ',
//   'ความงาม',
//   'กีฬา',
//   'อสังหาทรัพย์',
// ];

// function getStyles(name, personName, theme) {
//   return {
//     fontWeight:
//       personName.indexOf(name) === -1
//         ? theme.typography.fontWeightRegular
//         : theme.typography.fontWeightMedium,
//   };
// }

export default function CreateCoursePage() {
  const theme = useTheme();
  const [personName, setPersonName] = React.useState([]);
  const [images, setImages] = useState([]);
  const [imageURLs, setImageURLs] = useState([]);
  const [data, setData] = useState([]);
  const [contentTypeNow, setContentTypeNow] = useState(1);
  const [isLoading, setIsLoading] = useState(true);
  const [contentType, setContentType] = useState();
  const [courseTopic, setcourseTopic] = useState();
  const [courseDetail, setcourseDetail] = useState();
  const [minimum, setMinimum] = useState();
  const [maximum, setMaximum] = useState();
  const [lastEnroll, setLastEnroll] = useState();
  const [price, setPrice] = useState();
  const [eventDate, setEventDate] = useState();
  const [startDate, setStartDate] = useState();
  const [endDate, setEndDate] = useState();

  const TextTopicChange = (event) => {
    setcourseTopic(event.target.value);
  };

  const TextDetailChange = (event) => {
    setcourseDetail(event.target.value);
  };

  const TextlastEnrollChange = (event) => {
    setLastEnroll(event.target.value);
  };

  const priceChange = (event) => {
    setPrice(event.target.value);
  };

  const minimumChange = (event) => {
    setMinimum(event.target.value);
  };

  const maximumChange = (event) => {
    setMaximum(event.target.value);
  };

  const TextEventDateChange = (event) => {
    setEventDate(event.target.value);
  };

  const TextStartDateChange = (event) => {
    setStartDate(event.target.value);
  };

  const TextEndDateChange = (event) => {
    setEndDate(event.target.value);
  };

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
        const response = await axios.get(`http://localhost:8080/contenttypes/`);
        setContentType(response.data);
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
  const createCo = () => {
    const localStorageData = localStorage.getItem("user");
    let user = JSON.parse(localStorageData);
    const token = user.body.token;
    console.log(contentTypeNow);
    console.log(courseTopic);
    console.log(courseDetail);
    console.log(Date());
    console.log(lastEnroll);
    console.log(maximum);
    console.log(startDate);
    console.log(endDate);
    console.log(eventDate);
    axios
      .post(
        `http://localhost:8080/users/course?contentId=${contentTypeNow}`,
        {
          courseTopic: `${courseTopic}`,
          courseDetail: `${courseDetail}`,
          minimum: 1,
          maximum: `${maximum}`,
          price: `${price}`,
          status: "Available",
          reportStatus: "Done",
          firstEnrollDate: moment(Date()).format("YYYY-MM-DD"),
          lastEnrollDate: `${lastEnroll}`,
          eventDate: `${eventDate}`,
          startDate: moment(`${startDate}`).format("YYYY-MM-DD HH:mm a"),
          endDate: moment(`${endDate}`).format("YYYY-MM-DD HH:mm a"),
        },
        {
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
        }
      )
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };
  if (!data) return "No Course";

  return (
    <div>
      <div className="create-course-page">
        <div className="create-course-info">
          <div className="write-tag">
            <div>
              <select
                onChange={(event) => setContentTypeNow(event.target.value)}
              >
                {contentType.body.map((content, index) => (
                  <option key={index} value={content.contentTypeId}>
                    {content.typeName}
                  </option>
                ))}
              </select>
            </div>
          </div>
          <div className="r1">
            <div className="create-course-topic">
              <a className="a">กำหนดวันปิดรับสมัคร</a>

              {/* <DateField
                label="Controlled field"
                value={value}
                onChange={(newValue) => setValue(newValue)}
              /> */}

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
                type="date"
                onChange={TextlastEnrollChange}
              />
            </div>
            <div className="create-course-topic">
              <a className="a">กำหนดระยะเวลากิจกรรมเริ่ม</a>

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
                type="date"
                onChange={TextStartDateChange}
              />
            </div>
            <div className="create-course-topic">
              <a className="a">กำหนดระยะเวลากิจกรรมจบ</a>

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
                type="date"
                onChange={TextEndDateChange}
              />
            </div>
          </div>

          <div className="r2">
            <div className="create-course-topic">
              <a className="a">กำหนดราคา</a>
              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
                onChange={priceChange}
              />
            </div>
            <div className="create-course-topic">
              <a className="a">กำหนดจำนวนคน</a>

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
                onChange={maximumChange}
              />
            </div>

            <div className="create-course-topic">
              <a className="a">กำหนดช่วงเวลา</a>

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
                type="date"
                onChange={TextEventDateChange}
              />
            </div>
          </div>
        </div>

        <div className="create-course-con">
          {/* <div className='write-tag'>

            <FormControl sx={{ m: 1, width: 300 }}>

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
            </FormControl>

          </div> */}
          <div className="line"></div>
          {/* <div className="create-course-up-img">
            <a className="a">Cover image</a>

            <Button
              variant="contained"
              component="label"
              color="tertiary"
              size="small"
            >
              Upload
              <input
                hidden
                accept="image/*"
                type="file"
                onChange={onImageChange}
              />
            </Button>
          </div> */}
          <div className="pic">
            {imageURLs.map((imageSrc, idx) => (
              <img key={idx} width="320" height="200" src={imageSrc} />
            ))}
          </div>

          <div className="create-course-topic">
            <a className="a">Title</a>

            <TextField
              id="filled-basic"
              label="Title"
              variant="filled"
              onChange={TextTopicChange}
            />
          </div>

          <div className="create-course-content">
            <a className="a">Paragrap</a>

            <TextField
              id="filled-textarea"
              placeholder="Type your content"
              multiline
              variant="filled"
              onChange={TextDetailChange}
            />

            <div className="create-button">
              <Button
                variant="contained"
                color="primary"
                size="large"
                onClick={createCo}
              >
                <Link to={`/`}>Create coruse</Link>
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
