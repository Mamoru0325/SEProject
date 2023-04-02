import React from "react";
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBIcon,
} from "mdb-react-ui-kit";
import "mdb-react-ui-kit/dist/css/mdb.min.css";
import "@fortawesome/fontawesome-free/css/all.min.css";
// import { lightBlue } from "@material-ui/core/colors";

export const AddAdminPage = () => {
  return (
    <div className="Addmin-con">
      <MDBContainer fluid>
        <MDBCard
          className="text-black m-5 align-items-center"
          style={{ borderRadius: "25px" }}
        >
          <MDBCardBody>
            <MDBRow>
              <MDBCol
                md="6"
                lg="6"
                className="order-2 order-lg-1 d-flex flex-column align-items-center"
                style={{
                  background: "lightgray",
                  width: "100%",
                  borderRadius: 40,
                  boxShadow: "5px 5px 5px #888888",
                }}
              >
                <h3 classNAme="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                  AddAdmin
                </h3>

                <div className="d-flex flex-row mb-4">
                  <MDBInput
                    size="lg"
                    label={
                      <div>
                        <MDBIcon icon="user" className="me-2" />
                        Username
                      </div>
                    }
                    id="form2"
                    type="text"
                    className="me-9"
                    style={{ background: "lightblue" }}
                  />
                </div>

                <div className="d-flex flex-row align-items-center mb-4">
                  <MDBInput
                    size="lg"
                    label={
                      <div>
                        <MDBIcon icon="lock" className="me-2" />
                        Password
                      </div>
                    }
                    id="form3"
                    type="password"
                    style={{ background: "lightblue" }}
                  />
                </div>

                <div className="d-flex flex-row align-items-center mb-4">
                  <MDBInput
                    size="lg"
                    label={
                      <div>
                        <MDBIcon icon="key" className="me-2" />
                        Repeat Password
                      </div>
                    }
                    id="form4"
                    type="password"
                    style={{ background: "lightblue" }}
                  />
                </div>

                <div className="d-flex flex-row align-items-center ">
                  <MDBRow>
                    <MDBCol md="6">
                      <MDBInput
                        wrapperClass="mb-4"
                        label="ชื่อ"
                        size="lg"
                        id="form1"
                        type="text"
                        style={{ background: "lightblue" }}
                      />
                    </MDBCol>
                    <MDBCol md="6">
                      <MDBInput
                        wrapperClass="mb-4"
                        label="นามสกุล"
                        size="lg"
                        id="form2"
                        type="text"
                        style={{ background: "lightblue" }}
                      />
                    </MDBCol>
                  </MDBRow>
                </div>

                <MDBBtn className="mb-4 " size="lg">
                  Register
                </MDBBtn>
              </MDBCol>
            </MDBRow>
          </MDBCardBody>
        </MDBCard>
      </MDBContainer>
    </div>
  );
};

export default AddAdminPage;
