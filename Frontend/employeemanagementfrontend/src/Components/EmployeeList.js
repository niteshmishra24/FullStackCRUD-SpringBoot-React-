import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { getEmployees, deleteEmployee } from './api';

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    getEmployees()
      .then(response => {
        setEmployees(response.data);
      })
      .catch(error => {
        console.error('Error fetching employees:', error);
      });
  }, []);

  const handleDelete = (id) => {
    deleteEmployee(id)
      .then(response => {
        console.log('Employee deleted successfully:', response.data);
        // Fetch the updated list of employees after deletion
        getEmployees()
          .then(response => {
            setEmployees(response.data);
          })
          .catch(error => {
            console.error('Error fetching employees:', error);
          });
      })
      .catch(error => {
        console.error('Error deleting employee:', error);
      });
  };

  return (
    <div>
      <h2>Employee List</h2>
      <ul>
        {employees.map(employee => (
          <li key={employee.id}>
            {employee.firstname} {employee.lastname} - {employee.email}
            <button onClick={() => handleDelete(employee.id)}>Delete</button>
            <Link to={`/edit/${employee.id}`}>Edit</Link>
          </li>
        ))}
      </ul>
      <Link to="/add">Add Employee</Link>
    </div>
  );
};

export default EmployeeList;
