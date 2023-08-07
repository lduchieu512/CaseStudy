package case_study.services.Impl;

import case_study.models.Employee;
import case_study.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSeviceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        for (Employee employee: employeeList
             ) {
            System.out.println(employee.toString());
            
        }
    }

    @Override
    public void addNew() {
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap Ten: ");
        String name = sc.nextLine();
        System.out.println("Nhap nam sinh: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap gioi tinh: ");
        String sex = sc.nextLine();
        System.out.println("Nhap so CMND");
        String numCmnd = sc.nextLine();
        System.out.println("Nhap so dien thoai ");
        int numPhone = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap Email");
        String email = sc.nextLine();
        System.out.println("Nhap dia chi");
        String address = sc.nextLine();
        System.out.println("Nhap trinh do");
        String level = sc.nextLine();
        System.out.println("Nhap vi tri ung tuyen");
        String position = sc.nextLine();
        System.out.println("Nhap luong");
        int salaey = Integer.parseInt(sc.nextLine()) ;
        Employee employee = new Employee(id,name,age,sex,numCmnd,numPhone,email,address,level,position,salaey);
        employeeList.add(employee);

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
