package example.corejava.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int age;
    private LocalDate joiningDate;
    private String department;
    private ContactInfo address;

    public Employee(String name, int age, LocalDate joiningDate, String department, ContactInfo address) {
        this.name = name;
        this.age = age;
        this.joiningDate = joiningDate;
        this.department = department;
        this.address = address;
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

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ContactInfo getAddress() {
        return address;
    }

    public void setAddress(ContactInfo address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", joiningDate=" + joiningDate +
                ", department='" + department + '\'' +
                ", address=" + address +
                '}';
    }

    private static class ContactInfo {
        private String contactId;
        private String city;
        private String address;

        public ContactInfo(String contactId, String city, String address) {
            this.contactId = contactId;
            this.city = city;
            this.address = address;
        }

        public String getContactId() {
            return contactId;
        }

        public void setContactId(String contactId) {
            this.contactId = contactId;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "ContactInfo{" +
                    "contactId='" + contactId + '\'' +
                    ", city='" + city + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(
                "Yashwant",
                38,
                LocalDate.of(2011, 12, 31),
                "IT",
                new ContactInfo("100", "Indore", "Satellite Junction")
        ));

        employeeList.add(new Employee(
                "Ankush",
                36,
                LocalDate.of(2012, 12, 31),
                "CS",
                new ContactInfo("101", "Indore", "Pipaniya")
        ));

        employeeList.add(new Employee(
                "Priya",
                29,
                LocalDate.of(2011, 5, 15),
                "HR",
                new ContactInfo("102", "Bhopal", "MP Nagar")
        ));

        employeeList.add(new Employee(
                "Rahul",
                33,
                LocalDate.of(2020, 8, 20),
                "Finance",
                new ContactInfo("103", "Pune", "Hinjewadi")
        ));

        employeeList.add(new Employee(
                "Sneha",
                27,
                LocalDate.of(2018, 3, 10),
                "Marketing",
                new ContactInfo("104", "Mumbai", "Andheri East")
        ));

        employeeList.add(new Employee(
                "Vikram",
                40,
                LocalDate.of(2014, 11, 2),
                "IT",
                new ContactInfo("105", "Bangalore", "Electronic City")
        ));

        // You can now iterate and use this list as needed
        // employeeList.forEach(System.out::println);

        List<String> empNames = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println("====employee name==="+empNames);

        List<Employee> sortedEmpList = employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
        System.out.println("====reverse sortedEmpList===");
        sortedEmpList.forEach(System.out::println);

        Map<Integer, List<Employee>> groupByDate = employeeList.stream().collect(Collectors.groupingBy(emp -> emp.getJoiningDate().getYear()));
        System.out.println("====groupByDate==="+groupByDate);
        groupByDate.forEach((index, emp) -> {
            System.out.println("====emp==="+index + ":" + emp);
        });

        List<ContactInfo> contact = employeeList.stream().map(Employee::getAddress).collect(Collectors.toList());
        System.out.println("=====contact==="+contact);
    }

}
