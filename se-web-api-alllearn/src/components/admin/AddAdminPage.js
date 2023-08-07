// import React from "react";
import { MDBContainer, MDBCard } from "mdb-react-ui-kit";
import "mdb-react-ui-kit/dist/css/mdb.min.css";
import "@fortawesome/fontawesome-free/css/all.min.css";
// import { lightBlue } from "@material-ui/core/colors";

import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";

import AuthService from "../../services/auth.service";

const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const email = (value) => {
  if (!isEmail(value)) {
    return (
      <div className="alert alert-danger" role="alert">
        This is not a valid email.
      </div>
    );
  }
};

const vusername = (value) => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The username must be between 3 and 20 characters.
      </div>
    );
  }
};

const vpassword = (value) => {
  if (value.length < 6 || value.length > 40) {
    return (
      <div className="alert alert-danger" role="alert">
        The password must be between 6 and 40 characters.
      </div>
    );
  }
};

const mpassword = (value, valueCheck) => {
  if (value === valueCheck) {
    return (
      <div className="alert alert-danger" role="alert">
        Try Again...
      </div>
    );
  }
  // if (value.length < 6 || value.length > 40) {
  //   return (
  //     <div className="alert alert-danger" role="alert">
  //       The password must be between 6 and 40 characters.
  //     </div>
  //   );
  //}
};

export default class AddAdminPage extends Component {
  constructor(props) {
    super(props);
    this.handleRegister = this.handleRegister.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);

    this.onChangeTitle = this.onChangeTitle.bind(this);
    this.onChangeFirstName = this.onChangeFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangePhoneNumber = this.onChangePhoneNumber.bind(this);
    this.onChangeImgPath = this.onChangeImgPath.bind(this);
    this.onChangeBackgroundPath = this.onChangeBackgroundPath.bind(this);
    this.onChangeVerifyStatus = this.onChangeVerifyStatus.bind(this);
    this.onChangeMatchingPassword = this.onChangeMatchingPassword.bind(this);

    this.state = {
      email: "",
      username: "",
      title: "",
      password: "",
      firstName: "",
      lastName: "",
      phoneNumber: "",
      imgPath: "//ssl.gstatic.com/accounts/ui/avatar_2x.png",
      backgroundPath: "//ssl.gstatic.com/accounts/ui/avatar_2x.png",
      verifyStatus: "N",
      matchingPassword: "",
      successful: false,
      message: "",
    };
  }

  onChangeEmail = (e) => {
    this.setState({
      email: e.target.value,
    });
  };

  onChangeUsername = (e) => {
    this.setState({
      username: e.target.value,
    });
  };

  onChangeTitle = (e) => {
    this.setState({
      title: e.target.value,
    });
  };

  onChangePassword = (e) => {
    this.setState({
      password: e.target.value,
    });
  };

  onChangeFirstName = (e) => {
    this.setState({
      firstName: e.target.value,
    });
  };

  onChangeLastName = (e) => {
    this.setState({
      lastName: e.target.value,
    });
  };

  onChangePhoneNumber = (e) => {
    this.setState({
      phoneNumber: e.target.value,
    });
  };

  onChangeImgPath = (e) => {
    this.setState({
      imgPath: e.target.value,
    });
  };

  onChangeBackgroundPath = (e) => {
    this.setState({
      backgroundPath: e.target.value,
    });
  };

  onChangeVerifyStatus = (e) => {
    this.setState({
      verifyStatus: e.target.value,
    });
  };

  onChangeMatchingPassword = (e) => {
    this.setState({
      matchingPassword: e.target.value,
    });
  };

  handleRegister = (e) => {
    e.preventDefault();

    this.setState({
      message: "",
      successful: false,
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      AuthService.registerStaff(
        this.state.email,
        this.state.username,
        this.state.title,
        this.state.password,
        this.state.firstName,
        this.state.lastName,
        this.state.phoneNumber,
        this.state.imgPath,
        this.state.backgroundPath,
        this.state.verifyStatus,
        this.state.matchingPassword
      ).then(
        (response) => {
          this.setState({
            message: response.data.message,
            successful: true,
          });
        },
        (error) => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          this.setState({
            successful: false,
            message: resMessage,
          });
        }
      );
    }
  };
  render() {
    return (
      <div className="Addmin-con">
        <MDBContainer fluid>
          <MDBCard
            className="text-black m-5 align-items-center"
            style={{ borderRadius: "25px" }}
          >
            <div className="col-md-12">
              <div className="card card-container">
                <img
                  src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                  alt="profile-img"
                  className="profile-img-card"
                />

                <Form
                  onSubmit={this.handleRegister}
                  ref={(c) => {
                    this.form = c;
                  }}
                >
                  {!this.state.successful && (
                    <div>
                      <div className="form-group">
                        <label htmlFor="title">Title Mr/Ms/Miss/Other</label>
                        <Input
                          type="text"
                          className="form-control"
                          name="title"
                          value={this.state.title}
                          onChange={this.onChangeTitle}
                          validations={[required]}
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="firstname">First Name</label>
                        <Input
                          type="text"
                          className="form-control"
                          name="firstname"
                          value={this.state.firstName}
                          onChange={this.onChangeFirstName}
                          validations={[required]}
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="lastname">Last Name</label>
                        <Input
                          type="text"
                          className="form-control"
                          name="lastname"
                          value={this.state.lastName}
                          onChange={this.onChangeLastName}
                          validations={[required]}
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="phonenumber">Phone Number</label>
                        <Input
                          type="text"
                          className="form-control"
                          name="phonenumber"
                          value={this.state.phoneNumber}
                          onChange={this.onChangePhoneNumber}
                          validations={[required]}
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="username">Username</label>
                        <Input
                          type="text"
                          className="form-control"
                          name="username"
                          value={this.state.username}
                          onChange={this.onChangeUsername}
                          validations={[required, vusername]}
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <Input
                          type="text"
                          className="form-control"
                          name="email"
                          value={this.state.email}
                          onChange={this.onChangeEmail}
                          validations={[required, email]}
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <Input
                          type="password"
                          className="form-control"
                          name="password"
                          value={this.state.password}
                          onChange={this.onChangePassword}
                          validations={[required, vpassword]}
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="matchingPassword">
                          Confirm Password
                        </label>
                        <Input
                          type="password"
                          className="form-control"
                          name="matchingPassword"
                          value={this.state.matchingPassword}
                          valueCheck={this.password}
                          // valueCheck={this.state.password}
                          onChange={this.onChangeMatchingPassword}
                          validations={[required, mpassword]}
                        />
                      </div>

                      <div className="form-group">
                        <button className="btn btn-primary btn-block">
                          Add Staff
                        </button>
                      </div>
                    </div>
                  )}

                  {this.state.message && (
                    <div className="form-group">
                      <div
                        className={
                          this.state.successful
                            ? "alert alert-success"
                            : "alert alert-danger"
                        }
                        role="alert"
                      >
                        {this.state.message}
                      </div>
                    </div>
                  )}
                  <CheckButton
                    style={{ display: "none" }}
                    ref={(c) => {
                      this.checkBtn = c;
                    }}
                  />
                </Form>
              </div>
            </div>
          </MDBCard>
        </MDBContainer>
        {}
      </div>
    );
  }
}
