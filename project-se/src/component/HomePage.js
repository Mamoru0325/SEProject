// ======หน้าแรก=========
import React, { useState } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Banner from './Banner'
import FeedCoursePage from './FeedCoursePage';
import FeedBoardPage from './FeedBoardPage'
import "./HomePage.css"
import ToggleButton from '@mui/material/ToggleButton';
import ToggleButtonGroup from '@mui/material/ToggleButtonGroup';
import SearchIcon from '@mui/icons-material/Search';
import Paper from '@mui/material/Paper';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';



export default function HomePage() {
  const [alignment, setAlignment] = React.useState('blog');
  const [active, setActive] = useState("blog");

  const handleChange = (event, newAlignment) => {
    setAlignment(newAlignment);
  };

  return (
    <div>
      <Banner />

      <div className='toggleBut'>
        <ToggleButtonGroup
          color="primary"
          value={alignment}
          exclusive
          onChange={handleChange}
          aria-label="Platform"
          fullWidth
        >

          <ToggleButton value={"blog"} onClick={() => setActive("blog")}>Blogs</ToggleButton>
          <ToggleButton value={"course"} onClick={() => setActive("course")}>Course</ToggleButton>

        </ToggleButtonGroup>
      </div>

      <div className='HomePage'>
        <div className='search-box'>
          
          <Paper
            component="form"
            sx={{display: 'flex',alignItems: 'center', width: 150 }}
          >
            <IconButton type="button" sx={{ p: '10px' }} aria-label="search">
              <SearchIcon />
            </IconButton>

            <InputBase
              sx={{ ml: 1, flex: 1 }}
              placeholder="Search"
              inputProps={{ 'aria-label': 'search' }}
            />

          </Paper>

          <button>ยอดนิยม</button>
          <button>ล่าสุด</button>
          <button>สำรวจ</button>

          <div className='line'></div>
        </div>

        <div>
          {active === "blog" && <FeedBoardPage title="1" />}
          {active === "course" && <FeedCoursePage title="2" />}

        </div>
      </div>





    </div>

  )
}

