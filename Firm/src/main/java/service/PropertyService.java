package service;

import dataAccess.EmployeeDAO;
import dataAccess.PropertyDAO;
import domain.Employee;
import domain.Property;

import java.util.List;

public class PropertyService {

    PropertyDAO propertyDAO=new PropertyDAO();

    public List<Property> findAllProperties(){
        return propertyDAO.findAllProperties();
    }

    public Property findPropertyByID(Integer ID){
        return propertyDAO.findPropertyByID(ID);
    }

    public void insertProperty(Property property){
        propertyDAO.insertProperty(property);
    }

    public void deletePropertyByID(Integer ID){
        propertyDAO.deletePropertyByID(ID);
    }

    public void deletePropertyByAnyColumnValue(String columnName,Object columnValue){
        propertyDAO.deletePropertyByAnyColumnValue(columnName,columnValue);
    }

    public void updateProperty(String columnName,Object newValue,String columnCheckName,Object value){
        propertyDAO.updateProperty(columnName, newValue, columnCheckName, value);
    }
}
