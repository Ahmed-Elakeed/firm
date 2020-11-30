package service;

import dataAccess.PercentOwnedDAO;
import dataAccess.SalesOfficeDAO;
import domain.PercentOwned;
import domain.SalesOffice;

import java.util.List;

public class PercentOwnedService {
    PercentOwnedDAO percentOwnedDAO=new PercentOwnedDAO();

    public List<PercentOwned> findAllPercentOwned(){
        return percentOwnedDAO.findAllPercentOwned();
    }

    public PercentOwned findPercentOwnedByID(Integer owner_id,Integer prop_id){
        return percentOwnedDAO.findPercentOwnedByID(owner_id,prop_id);
    }

    public void insertPercentOwned(PercentOwned percentOwned){
        percentOwnedDAO.insertPercentOwned(percentOwned);
    }

    public void deletePercentOwnedByID(Integer owner_id,Integer prop_id){
        percentOwnedDAO.deletePercentOwnedByID(owner_id,prop_id);
    }

    public void deletePercentOwnedByAnyColumnValue(String columnName,Object columnValue){
        percentOwnedDAO.deletePercentOwnedByAnyColumnValue(columnName,columnValue);
    }

    public void updatePercentOwned(String columnName,Object newValue,String columnCheckName,Object value){
        percentOwnedDAO.updatePercentOwned(columnName, newValue, columnCheckName, value);
    }
}
