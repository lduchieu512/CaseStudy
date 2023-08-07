package case_study.controllers;

import case_study.models.Employee;
import case_study.services.Impl.CustomerSeviceImpl;
import case_study.services.Impl.EmployeeSeviceImpl;
import case_study.services.Impl.FacilityServiceImpl;

import java.util.Scanner;

import static java.lang.System.exit;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();

    }

    public static void displayMainMenu() {

        do {
            System.out.println("======MENU======");
            System.out.println("1.\tEmployee Management");
            System.out.println("2.\tCustomer Management");
            System.out.println("3.\tFacility Management ");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit\n");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    employeeManagement();
                    break;

                case 2:
                    customerManagement();
                    break;

                case 3:
                    facilityManagement();
                    break;


                case 4:
                    bookingManagement();
                    break;


                case 5:
                    promotionManagement();
                    break;

                case 6:
                    exit(0);

            }

        } while (true);
    }


    private static void employeeManagement() {
        EmployeeSeviceImpl employeeSevice = new EmployeeSeviceImpl();
        boolean check = true;
        do {
            System.out.println("1\tDisplay list employees");
            System.out.println("2\tAdd new employee");
            System.out.println("3\tEdit employee");
            System.out.println("4\tReturn main menu");
            int choose1 = sc.nextInt();
            switch (choose1) {
                case 1:
                    employeeSevice.display();
                    break;
                case 2:
                    employeeSevice.addNew();
                    break;
                case 3:
                    //Edit employee
                    break;
                case 4:
                    //Return main menu
                     displayMainMenu();
                     break;
                default:
                    displayMainMenu();
                    break;

            }
        } while (check);
    }

    private static void customerManagement() {
        CustomerSeviceImpl customerSevice = new CustomerSeviceImpl();
        boolean check = true;
        do {
            System.out.println("1.\tDisplay list customers");
            System.out.println("2.\tAdd new customer");
            System.out.println("3.\tEdit customer");
            System.out.println("4.\tReturn main menu");
            int choose2 = sc.nextInt();
            switch (choose2) {
                case 1:
                    customerSevice.display();
                    break;
                case 2:
                    customerSevice.addNew();
                    break;
                case 3:
                    //3.	Edit customer
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default: displayMainMenu();
                break;

            }
        } while (check);
    }

    private static void facilityManagement() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl() ;
        boolean check = true;

        do {
            System.out.println("1\tDisplay list facility");
            System.out.println("2\tAdd new facility");
            System.out.println("3\tDisplay list facility maintenance");
            System.out.println("4\tReturn main menu");
            int choose3 = sc.nextInt();
            switch (choose3) {
                case 1:
                    facilityService.displayAll();
                    break;
                case 2:
                    addNewFacilityManagement();
                    break;
                case 3:
                    //3.	Display list facility maintenance
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    displayMainMenu();
                    break;

            }
        } while (check);
    }
    private static void addNewFacilityManagement() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        boolean check = true;

        do {
            System.out.println("1\t Add new Villa");
            System.out.println("2\tAdd new House");
            System.out.println("3\tAdd new Room");
            System.out.println("4\tReturn main menu");
            int choose3 = sc.nextInt();
            switch (choose3) {
                case 1:
                    facilityService.addNewVilla();
                    facilityManagement();
                    break;
                case 2:
                    facilityService.addNewHouse();
                    facilityManagement();
                    break;
                case 3:
                    facilityService.addNewRoom();
                    facilityManagement();
                    break;
                case 4:
                    facilityManagement();
                    break;
                default:  facilityManagement();
                break;

            }
        } while (check);
    }


    private static void bookingManagement(){
        do {
            System.out.println("1.\tAdd new booking");
            System.out.println("2.\tDisplay list booking");
            System.out.println("3.\tCreate new constracts");
            System.out.println("4.\tDisplay list contracts");
            System.out.println("5.\tEdit contracts");
            System.out.println("6.\tReturn main menu");
            int choose4 = sc.nextInt();
            switch (choose4) {
                case 1:
                    //1.	Display list customers
                    break;
                case 2:
                    //	2.	Add new customer
                    break;
                case 3:
                    //3.	Edit customer
                    break;
                case 4:
                    //4.	Return main menu
                    break;
                case 5:
                    break;
                case 6:
                    return ;

            }
        } while (true);
    }

    private static void promotionManagement(){
        do {
            System.out.println("1.\tDisplay list customers use service");
            System.out.println("2.\tDisplay list customers get voucher");
            System.out.println("3.\tReturn main menu");
            int choose5 = sc.nextInt();
            switch (choose5) {
                case 1:
                    //1.	Display list facility
                    break;
                case 2:
                    //	2.	Add new facility
                    break;
                case 3:
                    //3.	Display list facility maintenance
                    return;


            }
        } while (true);
    }



}
