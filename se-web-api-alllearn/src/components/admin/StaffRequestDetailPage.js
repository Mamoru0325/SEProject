import React from 'react'
import {} from './StaffRequestDetailPage.css'
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import FilePresentIcon from '@mui/icons-material/FilePresent';
import { Input, Link, SvgIcon, TextField } from '@mui/material';

const StaffRequestDetailPage = () => {
  return (
    <div className='RequestDetailPage-con'>
        <div className='container'>
            <div className='RequestDetailHead-con'>
                <div className='RequestDetailBackButt-con'>
                    <a href='/StaffRequest'><ArrowBackIcon/></a>
                </div>
            </div>
            <div className='RequestDetail-con'>
                <div className='RequestDetailData-con'>
                    <div className='RequestDetailDataName-con'>
                        <div className='RequestDetailName-con'>
                            <div className='RequestDetailNameFrame'>
                                <p>Username</p>
                            </div>
                            <div className='RequestDetailNameFrame' style={{background:'lightgray',borderRadius:'10%',width:'97%'}}>
                                <p>....</p>
                            </div>
                        </div>
                        <div className='RequestDetailName-con'>
                            <div className='RequestDetailNameFrame'>
                                <p>Name</p>
                            </div>
                            <div className='RequestDetailNameFrame' style={{background:'lightgray',borderRadius:'10%',width:'97%'}}>
                                <p>สมคิด ติดไม่ซื่อ</p>
                            </div>
                        </div>
                    </div>
                    <div className='RequestDetailDataName-con'>
                        <div className='RequestDetailNameFrame'>
                            <p style={{width:70}}>Name</p>
                        </div>
                        <div className='RequestDetailNameFrame' style={{background:'lightgray',borderRadius:'10%'}}>
                            <Link href='#' target = "_blank"><FilePresentIcon/></Link>
                        </div>
                    </div>
                    <div className='RequestDetailDataName-con'>
                        <div className='RequestDetailNameFrame'>
                            <p style={{width:70}}>Detail</p>
                        </div>
                        <div className='RequestDetailNameFrame' style={{background:'lightgray',height:'100%', width:'100%'}}>
                            <TextField id="standard-multiline-flexible" multiline minRows={10} maxRows={10} variant="standard" style={{width:'100%'}} inputProps={{ maxLength: 300 }}/>
                        </div>
                    </div>
                </div>
                <div className='RequestDetailButt-con'>
                        <div className='RequestDetailButt'>
                            <button type="button" className='ApproveButt' style={{background:'#ace1af'}}>Approve</button>
                        </div>
                        <div className='RequestDetailButt'>
                            <button type="button" className='ApproveButt' style={{background:'#e67877 '}}>Reject</button>
                        </div>
                </div>
            </div>
        </div>
    </div>
    
  )
}

export default StaffRequestDetailPage