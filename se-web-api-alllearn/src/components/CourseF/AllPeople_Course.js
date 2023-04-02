import CourseMenu from "./CourseMenu"
import './AllPeople_Course.css'
import AcceptPeople_Course from "./AcceptPeople_Course"
import ListPeople_Course from "./ListPeople_Course"
import { IoIosArrowBack } from "react-icons/io";
import { NavLink } from 'react-router-dom';
import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

function createData(CountListName, CountAcceptName) {
    return { CountListName, CountAcceptName };
}

const rows = [
    createData(25, 15),
];


function AllPeople_Course() {
    return (
        <dev >
            <CourseMenu />
            <dev>
                <h1 className="textnameCourse"
                >
                    <NavLink className={"buttonbackC"} to="/MyCourse_All" ><IoIosArrowBack />Back</NavLink>
                    Name Course
                </h1>
            </dev>
            <dev className="boxPeople">
                <dev><ListPeople_Course /></dev>
                <dev><AcceptPeople_Course /></dev>
            </dev>

            <TableContainer component={Paper} sx={{ ml: "300px", width: "700px", overflow: "hidden" }}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow style={{ fontSize: 18, backgroundColor: "#003566", color: "#fff", borderColor: "#FFC300" }}>
                            <TableCell style={{ fontSize: 18, color: "#fff", }} align="center">จำนวนรายชื่อผู้เข้าร่วม</TableCell>
                            <TableCell style={{ fontSize: 18, color: "#fff", }} align="center">จำนวนรายชื่อรอการยืนยันเข้าร่วม</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows.map((row) => (
                            <TableRow
                                key={row.name}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell align="center">{row.CountListName}</TableCell>
                                <TableCell align="center">{row.CountAcceptName}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

        </dev>

    )

}

export default AllPeople_Course