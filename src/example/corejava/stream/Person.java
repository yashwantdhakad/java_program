package example.corejava.stream;

public class Person {
    private String name;
    private Integer rollNum;
    private String city;

    public Person(String name, String city) {
        this.city = city;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNum() {
        return rollNum;
    }

    public void setRollNum(Integer rollNum) {
        this.rollNum = rollNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", rollNum=" + rollNum +
                ", city='" + city + '\'' +
                '}';
    }
}
