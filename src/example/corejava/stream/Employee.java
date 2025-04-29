package example.corejava.stream;

import java.time.LocalDate;

class Employee {
    private LocalDate joiningDate;
    private double salary;
    private String name;
    private int age;
    private String gender;

    // Constructor
    public Employee(LocalDate joiningDate, double salary) {
        this.joiningDate = joiningDate;
        this.salary = salary;
    }
    public Employee(LocalDate joiningDate, double salary, String name, String gender, int age) {
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "joiningDate=" + joiningDate +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
