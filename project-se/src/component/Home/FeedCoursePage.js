import React from 'react'
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom"
import "./HomePage.css"
import Course from './Course'

function FeedCoursePage() {
  return (



    <div className='allContent'>
      <NavLink to="/coursePage">
        <div className='content'>
          <Course/>
        </div>
      </NavLink>

      <div className='content'>
      <Course/>
      </div>

      <div className='content'>
      <Course/>
      </div>

      <div className='content'>
      <Course/>
      </div>

      <div className='content'>
      <Course/>
      </div>

      <div className='content'>
        <div>content 05</div>
      </div>

      <div className='content'>
        <div>content 05</div>
      </div>
      
      <div className='content'>
        <div>content 05</div>
      </div>
    </div>



  )

}

export default FeedCoursePage