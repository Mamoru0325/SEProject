import React, { useState, useEffect } from "react";
import axios from "axios";
import {} from "./AdminListPage.css";
import DeleteButton from "../../components/DeleteBotton";
// import { DataGrid } from "@mui/x-data-grid";
// import { IconButton } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import AddAdminPage from "../../components/admin/AddAdminPage";

const AdminList = () => {
  const [data, setData] = useState([]);
  const [dataDelete, setDataDelete] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      setTimeout(async () => {
        const response = await axios.get(
          "http://localhost:8080/users/staff/page/1/value/10"
          // `http://localhost:8080/users/email/${user.body.userName}`
        );
        setData(response.data);
        console.log(data);
        setIsLoading(false);
      }, 500); // set delay to 2 seconds
    };

    // console.log(data);
    fetchData();
    // fetchDataContentType();
  }, []);

  const handleDelete = async (id) => {
    try {
      await axios
        .delete(`http://localhost:8080/users/${id}`)
        .then((response) => {
          setDataDelete(dataDelete.filter((item) => item.id !== id));
          window.location.reload();
        });
    } catch (error) {
      console.error(error);
    }
  };

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
    <table className="table">
      <thead className="thead-dark">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Email</th>
          <th scope="col">Phone Number</th>
          <th scope="col">Delete</th>
        </tr>
      </thead>
      <tbody>
        {data.body.map((item, index) => (
          <tr key={index}>
            <th scope="row">{item.userId}</th>
            <td>{item.email}</td>
            <td>{item.phoneNumber}</td>
            <td>
              <DeleteButton onClick={() => handleDelete(item.userId)} />
            </td>
          </tr>
        ))}
      </tbody>
    </table>

    // <table>
    //   <thead>
    //     <tr>
    //       <th>ID</th>
    //       <th>Name</th>
    //       <th>Description</th>
    //     </tr>
    //   </thead>
    //   <tbody>
    //     {data.body.map((item, index) => (
    //       <tr key={index}>
    //         <td>{item.userId}</td>
    //         <td>{item.email}</td>
    //         <td>{item.phoneNumber}</td>
    //       </tr>
    //     ))}
    //   </tbody>
    // </table>
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
