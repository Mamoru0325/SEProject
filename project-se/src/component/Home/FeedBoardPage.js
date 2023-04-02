import React from 'react'
import HomePage from './HomePage'
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom"
import "./HomePage.css"
import Board from './Board'
function FeedBoardPage() {
  return (



    <div className='allContent'>
      <NavLink to="/BoardPage">
        <div className='content'>
          <Board/>
        </div>
      </NavLink>

      <div className='content'>
      <Board/>
      </div>

      <div className='content'>
      <Board/>
      </div>

      <div className='content'>
      <Board/>
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