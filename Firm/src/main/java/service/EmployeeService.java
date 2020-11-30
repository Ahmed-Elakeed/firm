package service;

import dataAccess.EmployeeDAO;
import domain.Employee;

import java.sql.ResultSet;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class EmployeeService {
    EmployeeDAO employeeDAO=new EmployeeDAO();

    public List<Employee> findAllEmployees(){
        return employeeDAO.findAllEmployees();
    }
    public ResultSet findAllEmployees_ResultSet(){
        return employeeDAO.findAllEmployees_ResultSet();
    }

    public Employee findEmployeeByID(Integer ID){
        return employeeDAO.findEmployeeByID(ID);
    }

    public void insertEmployee(Employee employee){
        employeeDAO.insertEmployee(employee);
    }

    public void deleteEmployeeByID(Integer ID){
        employeeDAO.deleteEmployeeByID(ID);
    }

    public void deleteEmployeeByAnyColumnValue(String columnName,Object columnValue){
        employeeDAO.deleteEmployeeByAnyColumnValue(columnName,columnValue);
    }

    public void updateEmployee(String columnName,Object newValue,String columnCheckName,Object value){
        employeeDAO.updateEmployee(columnName, newValue, columnCheckName, value);
    }
}
