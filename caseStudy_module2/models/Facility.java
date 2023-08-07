package case_study.models;

public abstract class Facility {
    private String idFacility;
    private String serviceName;
    private double area;
    private double rentalCost;
    private int maxNum;
    private String rentalType;

    public Facility(String idFacility,String serviceName, double area, double rentalCost, int maxNum, String rentalType) {
        this.idFacility = idFacility;
        this.serviceName = serviceName;
        this.area = area;
        this.rentalCost = rentalCost;
        this.maxNum = maxNum;
        this.rentalType = rentalType;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idFacility='" + idFacility + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", rentalCost=" + rentalCost +
                ", maxNum=" + maxNum +
                ", rentalType=" + rentalType +
                '}';
    }
}
