package dataAccess;

import dataAccess.dataBase.ConnectionDB;
import domain.Property;
import domain.SalesOffice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesOfficeDAO {
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    PreparedStatement preparedStatement;
    public List<SalesOffice> findAllSalesOffices(){
        List<SalesOffice> list=null;
        SalesOffice salesOffice;
        try {
            preparedStatement= ConnectionDB.getConnection().prepareStatement("select * from sales_office");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<SalesOffice>();
            while (res.next()) {
                int officeNum=res.getInt("office_num");
                String location= res.getString("office_location");
                int managerID=res.getInt("manager_id");
                salesOffice=new SalesOffice(officeNum,location,managerID);
                list.add(salesOffice);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public SalesOffice findSalesOfficeByID(Integer ID) {
        SalesOffice salesOffice = null;
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("select * from sales_office where office_num=?");
            preparedStatement.setObject(1,ID);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int officeNum=res.getInt("office_num");
                String location= res.getString("office_location");
                int managerID=res.getInt("manager_id");
                salesOffice=new SalesOffice(officeNum,location,managerID);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return salesOffice;
    }

    public void insertSalesOffice(SalesOffice salesOffice) {
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("insert into sales_office values (?,?,?)");
            preparedStatement.setObject(1,salesOffice.getOfficeNum());
            preparedStatement.setObject(2,salesOffice.getLocation());
            preparedStatement.setObject(3,salesOffice.getManagerID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"Manager ID or office Number has invalid value");
        }
    }

    public void deleteSalesOfficeByID(Integer ID){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from sales_office where office_num=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
           logger.log(Level.SEVERE,"Can't delete because there is a foreign key");
        }
    }

    public void deleteSalesOfficeByAnyColumnValue(String columnName,Object columnValue){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from sales_office where "+columnName+"=?");
            preparedStatement.setObject(1,columnValue);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"One or more parameters has invalid value (OR) Can't delete because there is a foreign key");
        }
    }
    public void updateSalesOffice(String columnName,Object newValue,String columnCheckName,Object value){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("update sales_office set "+columnName+"=? where "+columnCheckName+"=?");
            preparedStatement.setObject(1,newValue);
            preparedStatement.setObject(2,value);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"One or more parameters has invalid value");
        }
    }
}
