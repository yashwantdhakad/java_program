package example.corejava.stream;

class Employee {
    private int year;
    private double salary;
    private String name;
    private int age;
    private String gender;

    // Constructor
    public Employee(int year, double salary) {
        this.year = year;
        this.salary = salary;
    }
    public Employee(int year, double salary, String name, String gender, int age) {
        this.year = year;
        this.salary = salary;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
                "year=" + year +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
