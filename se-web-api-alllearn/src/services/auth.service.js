import axios from "axios";

const API_URL = "http://localhost:8080/auth/";

class AuthService {
  async login(email, password) {
    const response = await axios.post(API_URL + "signin", {
      email,
      password,
    });
    // alert("signin success!!");
    if (response.data) {
      localStorage.setItem("user", JSON.stringify(response.data));
      // alert("signin success!!");
    }
    return response.data;
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(
    email,
    username,
    title,
    password,
    firstName,
    lastName,
    phoneNumber,
    imgPath,
    backgroundPath,
    verifyStatus,
    matchingPassword
  ) {
    return axios.post(API_URL + "signup", {
      email,
      username,
      title,
      password,
      firstName,
      lastName,
      phoneNumber,
      imgPath,
      backgroundPath,
      verifyStatus,
      matchingPassword,
    });
  }

  registerStaff(
    email,
    username,
    title,
    password,
    firstName,
    lastName,
    phoneNumber,
    imgPath,
    backgroundPath,
    verifyStatus,
    matchingPassword
  ) {
    return axios.post(API_URL + "signup/staff", {
      email,
      username,
      title,
      password,
      firstName,
      lastName,
      phoneNumber,
      imgPath,
      backgroundPath,
      verifyStatus,
      matchingPassword,
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem("user"));
  }
}

export default new AuthService();
