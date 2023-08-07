package case_study.models;

public class Villa extends  Facility{
    private String roomStandard;
    private double theAreaOfThePool;
    private int numberOfFloors;


    public Villa(String idFacility, String serviceName, double area, double rentalCost, int maxNum, String rentalType, String roomStandard, double theAreaOfThePool, int numberOfFloors) {
        super(idFacility, serviceName, area, rentalCost, maxNum, rentalType);
        this.roomStandard = roomStandard;
        this.theAreaOfThePool = theAreaOfThePool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getTheAreaOfThePool() {
        return theAreaOfThePool;
    }

    public void setTheAreaOfThePool(double theAreaOfThePool) {
        this.theAreaOfThePool = theAreaOfThePool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return
                "Villa{" +super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", theAreaOfThePool=" + theAreaOfThePool +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
