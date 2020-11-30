package domain;

public class SalesOffice {
    int officeNum;
    String location;
    int managerID;

    public SalesOffice(int officeNum, String location, int managerID) {
        this.officeNum = officeNum;
        this.location = location;
        this.managerID = managerID;
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
    public void print(){
        System.out.println(this.getOfficeNum()+"\t"+this.getLocation()+"\t"+this.getManagerID());
    }
}
