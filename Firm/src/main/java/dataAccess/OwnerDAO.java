package dataAccess;

import dataAccess.dataBase.ConnectionDB;
import domain.Employee;
import domain.Owner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OwnerDAO {
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    PreparedStatement preparedStatement;
    public List<Owner> findAllOwners(){
        List<Owner> list=null;
        Owner owner;
        try {
            preparedStatement= ConnectionDB.getConnection().prepareStatement("select * from owner");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<Owner>();
            while (res.next()) {
                int ID=res.getInt("owner_id");
                String name= res.getString("owner_name");
                owner=new Owner(ID,name);
                list.add(owner);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public Owner findOwnerByID(Integer ID) {
        Owner owner = null;
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("select * from owner where owner_id=?");
            preparedStatement.setObject(1,ID);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int ownerID=res.getInt("owner_id");
                String name= res.getString("owner_name");
                owner=new Owner(ownerID,name);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return owner;
    }

    public void insertOwner(Owner owner) {
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("insert into owner values (?,?)");
            preparedStatement.setObject(1,owner.getID());
            preparedStatement.setObject(2,owner.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"Owner ID has invalid value");
        }
    }

    public void deleteOwnerByID(Integer ID){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from owner where owner_id=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void deleteOwnerByAnyColumnValue(String columnName,Object columnValue){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from owner where "+columnName+"=?");
            preparedStatement.setObject(1,columnValue);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"one or more parameters has invalid value");
        }
    }
    public void updateOwner(String columnName,Object newValue,String columnCheckName,Object value){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("update owner set "+columnName+"=? where "+columnCheckName+"=?");
            preparedStatement.setObject(1,newValue);
            preparedStatement.setObject(2,value);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"one or more parameters has invalid value");
        }
    }
}
