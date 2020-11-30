package dataAccess;

import dataAccess.dataBase.ConnectionDB;
import domain.PercentOwned;
import domain.SalesOffice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PercentOwnedDAO {
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    PreparedStatement preparedStatement;
    public List<PercentOwned> findAllPercentOwned(){
        List<PercentOwned> list=null;
        PercentOwned percentOwned;
        try {
            preparedStatement= ConnectionDB.getConnection().prepareStatement("select * from property_owned");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<PercentOwned>();
            while (res.next()) {
                int ownerID=res.getInt("owner_id");
                int propertyID= res.getInt("prop_id");
                int percent_owned=res.getInt("percent_owned");
                percentOwned=new PercentOwned(ownerID,propertyID,percent_owned);
                list.add(percentOwned);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public PercentOwned findPercentOwnedByID(Integer owner_id,Integer prop_id) {
        PercentOwned percentOwned=null;
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("select * from property_owned where owner_id=? and prop_id=?");
            preparedStatement.setObject(1,owner_id);
            preparedStatement.setObject(2,prop_id);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int ownerID=res.getInt("owner_id");
                int propertyID= res.getInt("prop_id");
                int percent_owned=res.getInt("percent_owned")   ;
                percentOwned=new PercentOwned(ownerID,propertyID,percent_owned);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return percentOwned;
    }

    public void insertPercentOwned(PercentOwned percentOwned) {
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("insert into property_owned values (?,?,?)");
            preparedStatement.setObject(1,percentOwned.getOwnerID());
            preparedStatement.setObject(2,percentOwned.getPropertyID());
            preparedStatement.setObject(3,percentOwned.getPercentOwned());
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"Owner ID or property ID has invalid value (OR) Both");
        }
    }

    public void deletePercentOwnedByID(Integer owner_id,Integer prop_id){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from property_owned where owner_id=? and prop_id=?");
            preparedStatement.setObject(1,owner_id);
            preparedStatement.setObject(2,prop_id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"Can't delete because there is a foreign key");
        }
    }

    public void deletePercentOwnedByAnyColumnValue(String columnName,Object columnValue){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("delete from property_owned where "+columnName+"=?");
            preparedStatement.setObject(1,columnValue);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"one or more parameters has invalid value (OR) Can't delete because there is a foreign key");
        }
    }
    public void updatePercentOwned(String columnName,Object newValue,String columnCheckName,Object value){
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement("update property_owned set "+columnName+"=? where "+columnCheckName+"=?");
            preparedStatement.setObject(1,newValue);
            preparedStatement.setObject(2,value);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"one or more parameters has invalid value");
        }
    }
}
