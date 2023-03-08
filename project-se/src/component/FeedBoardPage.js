import React from 'react'
import HomePage from './HomePage'
import "./HomePage.css"
function FeedBoardPage() {
  return (

    <div className='HomePage'>
       <div className='search-box'>
        <p>searchBox</p>
      </div>
      <div className='allContent'>
        <div className='content'>
          <div>content 01</div>
        </div>
        <div className='content'>
          <div>content 02</div>
        </div>

        <div className='content'>
          <div>content 03</div>
        </div>
      </div>

    </div>

  )
}

export default FeedBoardPage