import React, { useState } from "react";
import {} from "./AdminListPage.css";
import { DataGrid } from "@mui/x-data-grid";
import { IconButton } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import { AddAdminPage } from "./AddAdminPage";

const AdminListColumns = [
  { field: "id", headerName: "ID", width: 70 },
  {
    field: "fullName",
    headerName: "Name",
    width: 300,
    valueGetter: (params) =>
      `${params.row.FirstName || ""} ${params.row.SurName || ""}`,
  },
  { field: "userName", headerName: "User Name", width: 180 },
  { field: "password", headerName: "Password", width: 180 },
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
];

const AdminListRows = [
  {
    id: 1,
    FirstName: "AdminSnow",
    SurName: "Jon",
    userName: "xxx1",
    password: "admin",
  },
];

const AdminList = () => {
  return (
    <div style={{ height: 550, width: "100%" }}>
      <DataGrid
        rows={AdminListRows}
        columns={AdminListColumns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
  );
};

const CheckShowPage = (props) => {
  if (props.props === "AdminList") {
    return <AdminList />;
  } else if (props.props === "AddAdmin") {
    return <AddAdminPage />;
  }
  return null;
};

const AdminManagementPage = () => {
  const [NowPage, setNowPage] = useState("AdminList");
  return (
    <div className="AdminManagementPage-Con">
      <div className="AdminManagement-Con">
        <h1>หน้า{NowPage}</h1>
        <div className="AdminManagementHeadButt-con">
          <div className="AdminManagementButt-con">
            <button
              type="button"
              className="SwapPageButt"
              onClick={() => setNowPage((NowPage) => "AdminList")}
            >
              Admin List
            </button>
            <button
              type="button"
              className="SwapPageButt"
              onClick={() => setNowPage((NowPage) => "AddAdmin")}
            >
              Add Admin
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
