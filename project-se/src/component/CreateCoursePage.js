// ======หน้าสำหรับไว้สร้างคอร์ส=========

import React from 'react'
import "./CreateCoursePage.css"
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

  const handleChange = (event) => {
    const {
      target: { value },
    } = event;
    setPersonName(
      // On autofill we get a stringified value.
      typeof value === 'string' ? value.split(',') : value,
    );
  };

  return (
    <div>

      <div className='create-course-page'>

        <div className='create-course-info'>

          <div className='r1'>

            <div className='create-course-topic'>
              <a className='a'>กำหนดวันปิดรับสมัคร</a>

              {/* <DateField
                label="Controlled field"
                value={value}
                onChange={(newValue) => setValue(newValue)}
              /> */}

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
              />
            </div>
            <div className='create-course-topic'>

              <a className='a'>กำหนดระยะเวลากิจกรรม</a>

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
              />

            </div>

          </div>

          <div className='r2'>
            <div className='create-course-topic'>
              <a className='a'>กำหนดราคา</a>



              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
              />
            </div>
            <div className='create-course-topic'>

              <a className='a'>กำหนดจำนวนคน</a>

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
              />

            </div>

            <div className='create-course-topic'>

              <a className='a'>กำหนดช่วงเวลา</a>

              <TextField
                id="filled-basic"
                label="Title"
                variant="filled"
              />

            </div>

          </div>



        </div>

        <div className='create-course-con'>

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
          <div className='line'></div>
          <div className='create-course-up-img'>

            <a className='a'>Cover image</a>

            <Button
              variant="contained"
              component="label"
              color='tertiary'
              size="small"
            >
              Upload
              <input hidden accept="image/*" multiple type="file" />
            </Button>

          </div>
          <div className='create-course-topic'>

            <a className='a'>Title</a>

            <TextField
              id="filled-basic"
              label="Title"
              variant="filled"
            />

          </div>

          <div className='create-course-content'>

            <a className='a'>Paragrap</a>

            <TextField
              id="filled-textarea"
              placeholder="Type your content"
              multiline
              variant="filled"

            />
            
            <div className='create-button'>
              <Button
                variant="contained"
                color='primary'
                size="large"
              >
                Create coruse
              </Button>
            </div>
          </div>



        </div>

      </div>
    </div>

  );
}







