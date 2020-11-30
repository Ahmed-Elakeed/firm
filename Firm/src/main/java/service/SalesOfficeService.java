package service;

import dataAccess.PropertyDAO;
import dataAccess.SalesOfficeDAO;
import domain.Property;
import domain.SalesOffice;

import java.util.List;

public class SalesOfficeService {
    SalesOfficeDAO salesOfficeDAO=new SalesOfficeDAO();

    public List<SalesOffice> findAllSalesOffices(){
        return salesOfficeDAO.findAllSalesOffices();
    }

    public SalesOffice findSalesOfficeByID(Integer ID){
        return salesOfficeDAO.findSalesOfficeByID(ID);
    }

    public void insertSalesOffice(SalesOffice salesOffice){
        salesOfficeDAO.insertSalesOffice(salesOffice);
    }

    public void deleteSalesOfficeByID(Integer ID){
        salesOfficeDAO.deleteSalesOfficeByID(ID);
    }

    public void deleteSalesOfficeByAnyColumnValue(String columnName,Object columnValue){
        salesOfficeDAO.deleteSalesOfficeByAnyColumnValue(columnName,columnValue);
    }

    public void updateSalesOffice(String columnName,Object newValue,String columnCheckName,Object value){
        salesOfficeDAO.updateSalesOffice(columnName, newValue, columnCheckName, value);
    }
}
