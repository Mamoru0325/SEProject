import CourseMenu from "./CourseMenu";
import "./Course_Registration.css";

import * as React from "react";
import Paper from "@mui/material/Paper";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TablePagination from "@mui/material/TablePagination";
import TableRow from "@mui/material/TableRow";

import { IoIosEasel } from "react-icons/io";
import { NavLink } from "react-router-dom";

import CourseMenuCreator from "../../components/CourseF/CourseMenuCreator";

const columns = [
  { id: "Course", label: "คอร์สที่ลงทะเบียน", minWidth: 180 },
  { id: "Date", label: "วันสอน", minWidth: 70 },
  { id: "TimeS", label: "เวลาเริ่มสอน", minWidth: 70 },
  { id: "TimeF", label: "เวลาจบคอร์ส", minWidth: 70 },
  { id: "Price", label: "ราคา", minWidth: 50 },
  { id: "Status", label: "สถานะคอร์ส", minWidth: 50 },
  { id: "Deteil", label: "ดูรายละเอียด", minWidth: 50 },
];

function createData(Course, Date, TimeS, TimeF, Price, Status, Deteil) {
  return { Course, Date, TimeS, TimeF, Price, Status, Deteil };
}

const rows = [
  createData(
    "India",
    "20-3-2023",
    "13:00:00",
    "16:00:00",
    5000,
    "เสร็จสิ้น",
    "55"
  ),
];

function Course_Registration() {
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
        <CourseMenuCreator />
      </dev>
      <dev>
        <Paper sx={{ ml: "260px", width: "fix", overflow: "hidden" }}>
          <TableContainer sx={{ maxHeight: 440 }}>
            <Table stickyHeader aria-label="sticky table">
              <TableHead>
                <TableRow>
                  {columns.map((column) => (
                    <TableCell
                      key={column.id}
                      align={"center"}
                      style={{
                        minWidth: column.minWidth,
                        fontSize: 18,
                        backgroundColor: "#003566",
                        color: "#fff",
                        borderColor: "#FFC300",
                      }}
                    >
                      {column.label}
                    </TableCell>
                  ))}
                </TableRow>
              </TableHead>
              <TableBody>
                {rows.map((row) => (
                  <TableRow key={row.id}>
                    <TableCell align={"center"} style={{ color: "#003566" }}>
                      {row.Course}
                    </TableCell>
                    <TableCell align={"center"} style={{ color: "#003566" }}>
                      {row.Date}
                    </TableCell>
                    <TableCell align={"center"} style={{ color: "#003566" }}>
                      {row.TimeS}
                    </TableCell>
                    <TableCell align={"center"} style={{ color: "#003566" }}>
                      {row.TimeF}
                    </TableCell>
                    <TableCell align={"center"} style={{ color: "#003566" }}>
                      {row.Price}
                    </TableCell>
                    <TableCell align={"center"} style={{ color: "#003566" }}>
                      {row.Status}
                    </TableCell>
                    <TableCell align={"center"} style={{ color: "#003566" }}>
                      <NavLink to="/CoursePage/1" className={"buttonDetail"}>
                        <IoIosEasel />
                      </NavLink>
                    </TableCell>
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

export default Course_Registration;
