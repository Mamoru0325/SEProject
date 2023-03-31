
import { BorderAll } from '@material-ui/icons'
import React from 'react'

function Banner() {
  return (
    <div style={{
      display :'flex',
      height :'300px',
      width :'auto',
      margin:'50px',
      color: 'white',
      backgroundColor:'blue',
      border: '3px solid black'
      
    }}>
      <img src="./bannerPic.png" alt="bug" height={300} width={'100%'} />
      
    </div>
  )
}



export default Banner