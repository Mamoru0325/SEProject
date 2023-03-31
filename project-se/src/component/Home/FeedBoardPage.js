import React from 'react'
import HomePage from './HomePage'
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom"
import "./HomePage.css"
function FeedBoardPage() {
  return (



      <div className='allContent'>
        <NavLink to="/BoardPage">
          <div className='content'>
           test
          </div>
        </NavLink>

        <div className='content'>
          <div>Blog content 02</div>
        </div>

        <div className='content'>
          <div>Blog content 03</div>
        </div>

        <div className='content'>
          <div>Blog content 03</div>
        </div>

        <div className='content'>
          <div>content 03</div>
        </div>

        <div className='content'>
          <div>content 03</div>
        </div>
      </div>



  )
}

export default FeedBoardPage