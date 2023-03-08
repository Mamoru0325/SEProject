// ======หน้าแรก=========
import React from 'react'
import Banner from './Banner'
import FeedBoardPage from './FeedBoardPage'
import "./HomePage.css"

function searchBox() {
  return (
    <div className='HomePage'>
      <div className='search-box'>
        <p>searchBox</p>
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