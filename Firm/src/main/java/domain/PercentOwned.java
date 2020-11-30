package domain;

public class PercentOwned {
    int ownerID;
    int propertyID;
    int percentOwned;

    public PercentOwned(int ownerID, int propertyID, int percentOwned) {
        this.ownerID = ownerID;
        this.propertyID = propertyID;
        this.percentOwned = percentOwned;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getPercentOwned() {
        return percentOwned;
    }

    public void setPercentOwned(int percentOwned) {
        this.percentOwned = percentOwned;
    }
    public void print(){
        System.out.println(this.getOwnerID() + "\t" + this.getPropertyID() + "\t" + this.getPercentOwned());
    }
}
