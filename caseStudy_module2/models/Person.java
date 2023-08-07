package case_study.models;

public abstract class Person {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String numCmnd;
    private int numPhone;
    private String email;
    private String address;

    public Person() {
    }

    public Person(int id, String name, int age, String sex, String numCmnd, int numPhone, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.numCmnd = numCmnd;
        this.numPhone = numPhone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String set) {
        this.sex = sex;
    }

    public String getNumCmnd() {
        return numCmnd;
    }

    public void setNumCmnd(String numCmnd) {
        this.numCmnd = numCmnd;
    }

    public int getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(int numPhone) {
        this.numPhone = numPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", set=" + sex +
                ", numCmnd=" + numCmnd +
                ", numPhone=" + numPhone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}