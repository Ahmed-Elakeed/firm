package domain;

public class Property {
    int ID;
    String address;
    String city;
    String state;
    String zipCode;
    int officeNum;

    public Property(int ID, String address, String city, String state, String zipCode, int officeNum) {
        this.ID = ID;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.officeNum = officeNum;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }
    public void print(){
        System.out.println(this.getID()+"\t"+this.getAddress()+"\t"+this.getCity()+"\t"+this.getState()+"\t"+this.getZipCode()+"\t"+this.getOfficeNum());
    }
}
