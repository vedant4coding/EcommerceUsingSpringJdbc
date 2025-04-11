import axios from 'axios';

const reg = 'http://localhost:8080/auth/registration';
const log = 'http://localhost:8080/auth/login';
const cate= 'http://localhost:8080/seller/addCategory';
const Aproduct='http://localhost:8080/seller/addProduct';

// Register API
export const register = async (data) => {
  return await axios.post(reg, data);
};

// Login API
export const logins = async (data) => {
  return await axios.post(log, data);
};

// Category API
export const addCategory = async (data) =>{
  return await axios.post(cate,data);
}

// Add Product API
export const addProduct  = async (data) =>{
  return await axios.post(Aproduct,data);
}