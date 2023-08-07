package case_study.services.Impl;

import case_study.models.Facility;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;
import case_study.services.FacilityService;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    static Map<Facility,Integer> facilityIntegerMap = new LinkedHashMap<>();
    static Scanner sc= new Scanner(System.in);



    @Override
    public void display() {
        
    }

    @Override
    public void addNew() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayAll() {
        for (Map.Entry<Facility,Integer> element: facilityIntegerMap.entrySet()
             ) {
            System.out.println("Service "+ element.getKey() +" So lan thue: "+element.getValue());
        }
    }

    @Override
    public void displayAllMaintain() {

    }

    @Override
    public void addNewHouse() {
        /// String idFacility,
        // String serviceName,
        // double area,
        // double rentalCost,
        // int maxNum,
        // String rentalType,
        // String roomStandard,
        // int numberOfFloors

        System.out.println("Nhap id: ");
        String id = sc.nextLine();
        System.out.println("Nhap Ten dich vu: ");
        String name = sc.nextLine();
        System.out.println("Nhap dien tich House: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap chi phi thue: ");
        double rentalCost = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so luong toi da ");
        int maxNum = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap kieu thue ");
        String rentalType = sc.nextLine();
        System.out.println("Nhap tieu chuan phong");
        String roomStandard = sc.nextLine();
        System.out.println("Nhap so tang");
        int numberOfFloors = Integer.parseInt(sc.nextLine());

        House  house = new House(id,name,area,rentalCost,maxNum,rentalType,roomStandard,numberOfFloors);
        facilityIntegerMap.put(house,0);
        System.out.println("Da them moi House thanh cong");

    }

    @Override
    public void addNewVilla() {
        //   String id
        //   String serviceName,
        //    double area,
        //    double rentalCost,
        //    int maxNum,
        //    String rentalType,
        //    String roomStandard,
        //    double theAreaOfThePool,
        //    int numberOfFloors) {
        System.out.println("Nhap id: ");
        String id = sc.nextLine();
        System.out.println("Nhap Ten dich vu: ");
        String name = sc.nextLine();
        System.out.println("Nhap dien tich villa: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap chi phi thue: ");
        double rentalCost = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so luong toi da ");
        int maxNum = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap kieu thue ");
        String rentalType = sc.nextLine();
        System.out.println("Nhap tieu chuan phong");
        String roomStandard = sc.nextLine();
        System.out.println("Nhap dien tich ho boi");
        double theAreaOfThePool = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so tang");
        int numberOfFloors = Integer.parseInt(sc.nextLine());

        Villa villa = new Villa(id,name,area,rentalCost,maxNum,rentalType,roomStandard,theAreaOfThePool,numberOfFloors);
        facilityIntegerMap.put(villa,0);
        System.out.println("Da them moi villa thanh cong");

    }

    @Override
    public void addNewRoom() {
      //String idFacility,
        // String serviceName,
        // double area,
        // double rentalCost,
        // int maxNum,
        // String rentalType
        // String prestationGratuite
        System.out.println("Nhap id: ");
        String id = sc.nextLine();
        System.out.println("Nhap Ten dich vu: ");
        String name = sc.nextLine();
        System.out.println("Nhap dien tich villa: ");
        double area = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap chi phi thue: ");
        double rentalCost = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so luong toi da ");
        int maxNum = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap kieu thue ");
        String rentalType = sc.nextLine();
        System.out.println("Nhap dich vu mien phi di kem");
        String prestationGratuite = sc.nextLine();

        Room room = new Room(id,name,area,rentalCost,maxNum,rentalType,prestationGratuite);
        facilityIntegerMap.put(room,0);
    }
}
