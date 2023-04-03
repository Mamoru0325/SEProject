import React, { useState, useEffect } from "react";
import axios from "axios";
import {} from "./AdminListPage.css";
import { DataGrid } from "@mui/x-data-grid";
import { IconButton } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import AddAdminPage from "../../components/admin/AddAdminPage";

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
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      setTimeout(async () => {
        const response = await axios.get(
          "http://localhost:8080/posts/lastestdate/page/1/value/10"
        );
        setData(response.data);
        console.log(data);
        setIsLoading(false);
      }, 2000); // set delay to 2 seconds
    };

    fetchData();
  }, []);

  if (isLoading) {
    return (
      <section className="light">
        {/* <div className="h1 text-center text-dark" id="pageHeaderTitle">
          My Cards Light
        </div> */}
        {/* {data.body.map((item, index) => (
        <div key={index}>{item.postTopic}</div>
      ))} */}
        <div className="container py-2 m-4">
          <div className="lds-spinner">
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
            <div />
          </div>
          Loading
        </div>
      </section>
    );
  }
  return (
    <div className="AdminManagementPage-Con">
      <div className="AdminManagement-Con">
        {/* <h1>หน้า{NowPage}</h1> */}
        <div className="AdminManagementHeadButt-con">
          <div className="AdminManagementButt-con">
            <button
              type="button"
              className="SwapPageButt"
              onClick={() => setNowPage((NowPage) => "AdminList")}
            >
              Staff List
            </button>
            <button
              type="button"
              className="SwapPageButt"
              onClick={() => setNowPage((NowPage) => "AddAdmin")}
            >
              Add Staff
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
