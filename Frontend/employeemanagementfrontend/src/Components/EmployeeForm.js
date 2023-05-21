import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { addEmployee, updateEmployee, getEmployeeById } from './api';

const EmployeeForm = () => {
  const { id } = useParams();
  const [firstname, setFirstname] = useState('');
  const [lastname, setLastname] = useState('');
  const [email, setEmail] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      getEmployeeById(id)
        .then(response => {
          const employee = response.data;
          setFirstname(employee.firstname);
          setLastname(employee.lastname);
          setEmail(employee.email);
        })
        .catch(error => {
          console.error('Error fetching employee:', error);
        });
    }
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();

    const employeeData = { firstname, lastname, email };

    if (id) {
      // Update existing employee
      updateEmployee(id, employeeData)
        .then(response => {
          console.log('Employee updated successfully:', response.data);
          // Reset form fields
          setFirstname('');
          setLastname('');
          setEmail('');
          // Navigate back to the employee list
          navigate('/');
        })
        .catch(error => {
          console.error('Error updating employee:', error);
        });
    } else {
      // Create new employee
      addEmployee(employeeData)
        .then(response => {
          console.log('Employee added successfully:', response.data);
          // Reset form fields
          setFirstname('');
          setLastname('');
          setEmail('');
          // Navigate back to the employee list
          navigate('/');
        })
        .catch(error => {
          console.error('Error adding employee:', error);
        });
    }
  };

  return (
    <div>
      <h2>{id ? 'Update Employee' : 'Add Employee'}</h2>
      <form onSubmit={handleSubmit}>
        <label>
          First Name:
          <input type="text" value={firstname} onChange={(e) => setFirstname(e.target.value)} required />
        </label>
        <label>
          Last Name:
          <input type="text" value={lastname} onChange={(e) => setLastname(e.target.value)} required />
        </label>
        <label>
          Email:
          <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
        </label>
        <button type="submit">{id ? 'Update' : 'Add'}</button>
      </form>
      <button onClick={() => navigate('/')}>Cancel</button>
    </div>
  );
};

export default EmployeeForm;
