import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

export const getEmployees = () => {
  return axios.get(`${API_BASE_URL}/employees`);
};

export const getEmployeeById = (id) => {
  return axios.get(`${API_BASE_URL}/employees/${id}`);
};

export const addEmployee = (employeeData) => {
  return axios.post(`${API_BASE_URL}/add-employee`, employeeData);
};

export const updateEmployee = (id, employeeData) => {
  return axios.put(`${API_BASE_URL}/update-employee/${id}`, employeeData);
};

export const deleteEmployee = (id) => {
  return axios.delete(`${API_BASE_URL}/delete-employee/${id}`);
};
