package case_study.models;

public class Customer extends  Person{
    private String typeDeClient;
    public Customer(){}

    public Customer(String typeDeClient) {
        this.typeDeClient = typeDeClient;
    }

    public Customer(int id, String name, int age, String sex, String numCmnd, int numPhone, String email, String address, String typeDeClient) {
        super(id, name, age, sex, numCmnd, numPhone, email, address);
        this.typeDeClient = typeDeClient;
    }

    public String getTypeDeClient() {
        return typeDeClient;
    }

    public void setTypeDeClient(String typeDeClient) {
        this.typeDeClient = typeDeClient;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString()+
                "typeDeClient='" + typeDeClient + '\'' +
                '}';
    }
}
