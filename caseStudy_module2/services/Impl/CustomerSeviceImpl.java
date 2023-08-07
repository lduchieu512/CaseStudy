package case_study.services.Impl;

import case_study.models.Customer;
import case_study.services.CustomerService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerSeviceImpl implements CustomerService {
    static List<Customer>  customerList = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);


    @Override
    public void display() {
        for (Customer customer: customerList
             ) {
            System.out.println(customer.toString());

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
        System.out.println("Loai khach");
        String typeDeClient = sc.nextLine();
        Customer customer = new Customer(id,name,age,sex,numCmnd,numPhone,email,address,typeDeClient);
        customerList.add(customer);
        System.out.println("Da them moi khach hang thanh cong");

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
