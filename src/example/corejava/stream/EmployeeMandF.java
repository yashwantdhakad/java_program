package example.corejava.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeMandF {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(2012, 50000, "Yashwant", "Male", 25),
                new Employee(2013, 45000, "Aman", "Male", 26),
                new Employee(2014, 60000, "Rohit", "Male", 27),
                new Employee(2010, 58000, "Ankush", "Male", 28),
                new Employee(2019, 30000, "Monika", "Female", 28),
                new Employee(2018, 40000, "Anjali", "Female", 27),
                new Employee(2020, 20000, "Pooja", "Female", 26)
        );

        Map<String, Long> employeeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Employee Map: " + employeeMap);

    }
}
