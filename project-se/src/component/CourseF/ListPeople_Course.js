import CourseMenu from "./CourseMenu"
import './AllPeople_Course.css'
import * as React from "react";
import Paper from "@mui/material/Paper";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TablePagination from "@mui/material/TablePagination";
import TableRow from "@mui/material/TableRow";
import Button from '@material-ui/core/Button';
import AcceptPeople_Course from "./AcceptPeople_Course"
import { IoIosEasel } from "react-icons/io";
import { NavLink } from 'react-router-dom';

const columns = [
    { id: "Name", label: "รายชื่อในคอร์สของคุณ", minWidth: 180 },
];

function createData(Name) {
    return { Name };
}

const rows = [
    createData("India"),

];




function ListPeople_Course() {
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(10);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    return (
        <dev>
            <dev>
                <Paper sx={{ ml: "300px", width: "700px", overflow: "hidden" }}>
                    <TableContainer sx={{ maxHeight: 650 }}>
                        <Table stickyHeader aria-label="sticky table">
                            <TableHead >
                                <TableRow>
                                    {columns.map((column) => (
                                        <TableCell
                                            key={column.id}
                                            align={"center"}
                                            style={{ minWidth: column.minWidth, fontSize: 18, backgroundColor: "#003566", color: "#fff", borderColor: "#FFC300" }}
                                        >
                                            {column.label}
                                        </TableCell>
                                    ))}
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {rows.map((row) => (
                                    <TableRow key={row.id}>
                                        <TableCell align={"center"} style={{ color: "#003566" }} >{row.Name}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                    <TablePagination
                        rowsPerPageOptions={[10, 25, 100]}
                        component="div"
                        count={rows.length}
                        rowsPerPage={rowsPerPage}
                        page={page}
                        onPageChange={handleChangePage}
                        onRowsPerPageChange={handleChangeRowsPerPage}
                    />
                </Paper>
            </dev>
        </dev>
    );

}

export default ListPeople_Course