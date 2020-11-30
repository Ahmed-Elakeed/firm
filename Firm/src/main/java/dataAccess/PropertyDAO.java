package dataAccess;

import dataAccess.dataBase.ConnectionDB;
import domain.Employee;
import domain.Property;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyDAO {
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    PreparedStatement preparedStatement;
    public List<Property> findAllProperties(){
        List<Property> list=null;
        Property property;
        try {
            preparedStatement= ConnectionDB.getConnection().prepareStatement("select * from property");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<Property>();
            while (res.next()) {
                int ID=res.getInt("prop_id");
                String address= res.getString("address");
                String city=res.getString("city");
                String state=res.getString("state");
                String zip_code=res.getString("zip_code");
                int officeNum=res.getInt("office_num");
                property=new Property(ID,address,city,state,zip_code,officeNum);
                list.add(property);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public Property findPropertyByID(Integer ID) {
        Property property = null;
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("select * from property where prop_id=?");
            preparedStatement.setObject(1,ID);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int prop_ID=res.getInt("prop_id");
                String address= res.getString("address");
                String city=res.getString("city");
                String state=res.getString("state");
                String zip_code=res.getString("zip_code");
                int officeNum=res.getInt("office_num");
                property=new Property(prop_ID,address,city,state,zip_code,officeNum);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return property;
    }

    public void insertProperty(Property property) {
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("insert into property values (?,?,?,?,?,?)");
            preparedStatement.setObject(1,property.getID());
            preparedStatement.setObject(2,property.getAddress());
            preparedStatement.setObject(3,property.getCity());
            preparedStatement.setObject(4,property.getState());
            preparedStatement.setObject(5,property.getZipCode());
            preparedStatement.setObject(6,property.getOfficeNum());
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"Property ID or office Number has invalid value");
        }
    }

    public void deletePropertyByID(Integer ID){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from property where prop_id=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void deletePropertyByAnyColumnValue(String columnName,Object columnValue){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from property where "+columnName+"=?");
            preparedStatement.setObject(1,columnValue);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"One or more parameters has invalid value");
        }
    }
    public void updateProperty(String columnName,Object newValue,String columnCheckName,Object value){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("update property set "+columnName+"=? where "+columnCheckName+"=?");
            preparedStatement.setObject(1,newValue);
            preparedStatement.setObject(2,value);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"One or more parameters has invalid value");
        }
    }
}
