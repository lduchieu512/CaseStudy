package case_study.models;

public class Room extends Facility{
   private String prestationGratuite;


    public Room(String idFacility, String serviceName, double area, double rentalCost, int maxNum, String rentalType, String prestationGratuite) {
        super(idFacility, serviceName, area, rentalCost, maxNum, rentalType);
        this.prestationGratuite = prestationGratuite;
    }

    public String getPrestationGratuite() {
        return prestationGratuite;
    }

    public void setPrestationGratuite(String prestationGratuite) {
        this.prestationGratuite = prestationGratuite;
    }

    @Override
    public String toString() {
        return "Room{" + super.toString()+
                "prestationGratuite='" + prestationGratuite + '\'' +
                '}';
    }
}
