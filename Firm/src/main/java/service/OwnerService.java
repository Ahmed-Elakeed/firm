package service;

import dataAccess.OwnerDAO;
import domain.Employee;
import domain.Owner;

import java.util.List;

public class OwnerService {
    OwnerDAO ownerDAO=new OwnerDAO();

    public List<Owner> findAllOwners(){
        return ownerDAO.findAllOwners();
    }

    public Owner findOwnerByID(int ID){
        return ownerDAO.findOwnerByID(ID);
    }

    public void insertOwner(Owner owner){
        ownerDAO.insertOwner(owner);
    }

    public void deleteOwnerByID(Integer ID){
        ownerDAO.deleteOwnerByID(ID);
    }
    public void deleteOwnerByAnyColumnValue(String columnName,Object columnValue){
        ownerDAO.deleteOwnerByAnyColumnValue(columnName,columnValue);
    }
    public void updateOwner(String columnName,Object newValue,String columnCheckName,Object Value){
        ownerDAO.updateOwner(columnName, newValue, columnCheckName, Value);
    }
}
