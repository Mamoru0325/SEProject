import React from 'react'
import './Sidebar.css'
import { Link } from '@material-ui/core';
import { IoIosCheckmarkCircle } from "react-icons/io";
import { IoIosPricetag } from "react-icons/io";
import { IoMdPerson } from "react-icons/io";
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';


function Setting() {
    return (
        <div>
            <div >
                <ul className="sidebar">
                    <li><span>AllLearn Setting</span></li>
                    <li ><span ><span>
                        <Link className="link" href="/EProfile">
                            <IoMdPerson />{"   Profile"}
                        </Link>
                    </span></span></li>
                    <li ><span ><span> 
                        <Link className="link" href="./Verification">
                            <IoIosCheckmarkCircle />{"  Verification "}
                        </Link>
                    </span></span></li>
                    <li ><span ><span>
                        <Link className="link" href="/Aptitude">
                            <IoIosPricetag />{"   Aptitude Tags"}
                        </Link>
                    </span></span></li>
                    
                </ul>
            </div>
        </div>
    )
}

export default Setting