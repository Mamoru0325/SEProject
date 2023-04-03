import React, { useState } from "react";
import {} from "./AdminManagementPage.css";
import { DataGrid } from "@mui/x-data-grid";

import { IconButton } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import WarningAmberIcon from "@mui/icons-material/WarningAmber";

const CourseColumns = [
  { field: "id", headerName: "ID", width: 70 },
  { field: "TitleName", headerName: "Title Name", width: 600 },
  { field: "OwnerName", headerName: "Owner name", width: 180 },
  {
    field: "remove",
    description: "This column has a value getter and is not sortable.",
    sortable: false,
    width: 160,
    renderCell: (cellValues) => {
      return (
        <IconButton aria-label="delete" size="small">
          <DeleteIcon fontSize="inherit" />
        </IconButton>
      );
    },
    // valueGetter: (params) =>
    //   `${params.row.firstName || ''} ${params.row.lastName || ''}`,
  },
  {
    field: "warn",
    description: "This column has a value getter and is not sortable.",
    sortable: false,
    width: 160,
    renderCell: (cellValues) => {
      return (
        <IconButton aria-label="delete" size="small">
          <WarningAmberIcon fontSize="inherit" />
        </IconButton>
      );
    },
  },
];
const PostColumns = [
  { field: "id", headerName: "ID", width: 70 },
  { field: "TitleName", headerName: "Title Name", width: 600 },
  { field: "OwnerName", headerName: "Owner name", width: 180 },
  {
    field: "remove",
    description: "This column has a value getter and is not sortable.",
    sortable: false,
    width: 160,
    renderCell: (cellValues) => {
      return (
        <IconButton aria-label="delete" size="small">
          <DeleteIcon fontSize="inherit" />
        </IconButton>
      );
    },
  },
  {
    field: "warn",
    description: "This column has a value getter and is not sortable.",
    sortable: false,
    width: 160,
    renderCell: (cellValues) => {
      return (
        <IconButton aria-label="delete" size="small">
          <WarningAmberIcon fontSize="inherit" />
        </IconButton>
      );
    },
  },
];
const ReportColumns = [
  { field: "id", headerName: "ID", width: 70 },
  { field: "TitleName", headerName: "Title Name", width: 600 },
  { field: "OwnerName", headerName: "Owner name", width: 180 },
  {
    field: "remove",
    description: "This column has a value getter and is not sortable.",
    sortable: false,
    width: 160,
    renderCell: (cellValues) => {
      return (
        <IconButton aria-label="delete" size="small">
          <DeleteIcon fontSize="inherit" />
        </IconButton>
      );
    },
  },
  {
    field: "warn",
    description: "This column has a value getter and is not sortable.",
    sortable: false,
    width: 160,
    renderCell: (cellValues) => {
      return (
        <IconButton aria-label="delete" size="small">
          <WarningAmberIcon fontSize="inherit" />
        </IconButton>
      );
    },
  },
];

const CourseRows = [{ id: 1, OwnerName: "CourseSnow", TitleName: "Jon" }];
const PostRows = [
  { id: 1, OwnerName: "PostSnow", TitleName: "Jon" },
  { id: 2, OwnerName: "Lannister", TitleName: "Cersei" },
];
const ReportRows = [
  { id: 1, OwnerName: "ReportSnow", TitleName: "Jon" },
  { id: 2, OwnerName: "Lannister", TitleName: "Cersei" },
  { id: 3, OwnerName: "Lannister", TitleName: "Jaime" },
];

const CourseTable = () => {
  return (
    <div style={{ height: 550, width: "100%" }}>
      <DataGrid
        rows={CourseRows}
        columns={CourseColumns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
  );
};

const PostTable = () => {
  return (
    <div style={{ height: 550, width: "100%" }}>
      <DataGrid
        rows={PostRows}
        columns={PostColumns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
  );
};
const ReportTable = () => {
  return (
    <div style={{ height: 550, width: "100%" }}>
      <DataGrid
        rows={ReportRows}
        columns={ReportColumns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
  );
};

const CheckShowPage = (props) => {
  if (props.props === "Post") {
    return <PostTable />;
  } else if (props.props === "Report") {
    return <ReportTable />;
  } else if (props.props === "Course") {
    return <CourseTable />;
  }
  return null;
};

const AdminManagementPage = () => {
  const [NowPage, setNowPage] = useState("Report");
  return (
    <div className="AdminManagementPage-Con">
      <div className="AdminManagement-Con">
        <h1>{NowPage}Page</h1>
        <div className="AdminManagementHeadButt-con">
          <div className="AdminManagementButt-con">
            {/* <button
              type="button"
              className="SwapPageButt"
              onClick={() => setNowPage((NowPage) => "Course")}
            >
              Course
            </button>
            <button
              type="button"
              className="SwapPageButt"
              onClick={() => setNowPage((NowPage) => "Post")}
            >
              Post
            </button> */}
            <button
              type="button"
              className="SwapPageButt"
              onClick={() => setNowPage((NowPage) => "Report")}
            >
              Report
            </button>
          </div>
        </div>
        <div className="AdminManagementTable-con">
          <div className="AdminManagementTableHead-con">
            <CheckShowPage props={NowPage} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminManagementPage;
