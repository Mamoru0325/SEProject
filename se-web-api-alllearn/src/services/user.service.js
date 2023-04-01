import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/alllearn/';
const user = JSON.parse(localStorage.getItem('user'));

class UserService {
  
  getPublicContent() {
    return axios.get(API_URL + 'posts');
  }

  getUserBoard() {
    return axios.get(API_URL + 'users', { headers: authHeader() });
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();
