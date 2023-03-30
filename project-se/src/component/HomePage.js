// ======หน้าแรก=========
import React from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Banner from './Banner'
import FeedBoardPage from './FeedBoardPage'
import "./HomePage.css"

function searchBox() {
  return (
    <div className='HomePage'>
      <div className='search-box'>
        <p>searchBoxf</p>
      </div>
    </div>
  )

}

function HomePage() {
  return (
    <div>
      HomePage
      <Banner />
      <FeedBoardPage />
      <searchBox />

    </div>

  )
}

export default HomePage