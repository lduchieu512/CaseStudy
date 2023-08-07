package case_study.models;

public class Employee extends Person{
    private String level;
    private String position;
    private int salaey;

    public Employee(){}

    public Employee(String level, String position, int salaey) {
        this.level = level;
        this.position = position;
        this.salaey = salaey;
    }

    public Employee(int id, String name, int age, String sex, String numCmnd, int numPhone, String email, String address, String level, String position, int salaey) {
        super(id, name, age, sex, numCmnd, numPhone, email, address);
        this.level = level;
        this.position = position;
        this.salaey = salaey;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalaey() {
        return salaey;
    }

    public void setSalaey(int salaey) {
        this.salaey = salaey;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString()+
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salaey=" + salaey +
                '}';
    }
}
