package domain;

public class Employee {
    private int ID;
    private String name;
    private int officeNum;

    public Employee(int ID, String name, int officeNum) {
        this.ID = ID;
        this.name = name;
        this.officeNum = officeNum;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }
    public void print(){
        System.out.println(this.ID+"\t"+this.name+"\t"+this.officeNum);
    }

}
