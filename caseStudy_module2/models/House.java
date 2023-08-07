package case_study.models;

public class House extends Facility{
    private String roomStandard;
    private int numberOfFloors;




    public House(String idFacility, String serviceName, double area, double rentalCost, int maxNum, String rentalType, String roomStandard, int numberOfFloors) {
        super(idFacility, serviceName, area, rentalCost, maxNum, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" + super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
