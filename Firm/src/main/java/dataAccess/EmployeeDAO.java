package dataAccess;

import dataAccess.dataBase.ConnectionDB;
import domain.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {

        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        PreparedStatement preparedStatement;
        public List<Employee> findAllEmployees(){
            List<Employee> list=null;
            Employee employee;
            try {
                preparedStatement=ConnectionDB.getConnection().prepareStatement("select * from employee");
                ResultSet res = preparedStatement.executeQuery();
                list=new ArrayList<Employee>();
                while (res.next()) {
                    int ID=res.getInt("emp_id");
                    String name= res.getString("emp_name");
                    int officeNum=res.getInt("office_num");
                    employee=new Employee(ID,name,officeNum);
                    list.add(employee);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            return list;
        }
    public ResultSet findAllEmployees_ResultSet(){
        try {
            preparedStatement=ConnectionDB.getConnection().prepareStatement("select * from employee");
            ResultSet res  = preparedStatement.executeQuery();
            return res;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
        public Employee findEmployeeByID(Integer ID) {
            Employee employee = null;
            try {
                preparedStatement = ConnectionDB.getConnection().prepareStatement("select * from employee where emp_id=?");
                preparedStatement.setObject(1,ID);
                ResultSet res = preparedStatement.executeQuery();
                while (res.next()) {
                    int empID=res.getInt("emp_id");
                    String name= res.getString("emp_name");
                    int officeNum=res.getInt("office_num");
                    employee=new Employee(empID,name,officeNum);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            return employee;
        }

        public void insertEmployee(Employee employee) {
            try {
                preparedStatement = ConnectionDB.getConnection().prepareStatement("insert into employee values (?,?,?)");
                preparedStatement.setObject(1,employee.getID());
                preparedStatement.setObject(2,employee.getName());
                preparedStatement.setObject(3,employee.getOfficeNum());
                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                logger.log(Level.SEVERE,"Employee ID or office Number has invalid value");
            }
        }

        public void deleteEmployeeByID(Integer ID){
            try {
                preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from employee where emp_id=?");
                preparedStatement.setObject(1,ID);
                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

        public void deleteEmployeeByAnyColumnValue(String columnName,Object columnValue){
            try {
                preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from employee where "+columnName+"=?");
                preparedStatement.setObject(1,columnValue);
                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                logger.log(Level.SEVERE,"one or more parameters has invalid value");
            }
        }
        public void updateEmployee(String columnName,Object newValue,String columnCheckName,Object value){
            try {
                preparedStatement = ConnectionDB.getConnection().prepareStatement("update employee set "+columnName+"=? where "+columnCheckName+"=?");
                preparedStatement.setObject(1,newValue);
                preparedStatement.setObject(2,value);
                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                logger.log(Level.SEVERE,"one or more parameters has invalid value");
            }
        }

}
