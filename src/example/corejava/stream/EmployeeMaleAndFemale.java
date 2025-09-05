package example.corejava.stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

// Find the male and female employees
public class EmployeeMaleAndFemale {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(LocalDate.of(2012, 12,20), 50000, "Yashwant", "Male", 25),
                new Employee(LocalDate.of(2013,8, 15), 45000, "Aman", "Male", 26),
                new Employee(LocalDate.of(2014, 5, 24), 60000, "Rohit", "Male", 27),
                new Employee(LocalDate.of(2010, 12,31), 58000, "Ankush", "Male", 28),
                new Employee(LocalDate.of(2019,1,1), 30000, "Monika", "Female", 28),
                new Employee(LocalDate.of(2018, 6, 15), 40000, "Anjali", "Female", 27),
                new Employee(LocalDate.of(2020,2, 15), 20000, "Pooja", "Female", 26)
        );

        Map<String, Long> employeeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Employee Map: " + employeeMap);
        Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender));
        System.out.println("====collect==="+collect);
        collect.forEach((key, value) -> {
                System.out.println(key);
                value.forEach(System.out::println);
            }
        );
        Employee employee = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println("===max salary of employee===:" +employee);

        Employee minSalEmployee = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).get();
        System.out.println("===minSal Emp===:" + minSalEmployee);
        List<Employee> sortedEmployeeList = employeeList.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
        sortedEmployeeList.forEach(System.out::println);

        List<String> collect1 = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("=====Sort the emp with salary and get names=="+collect1);

        double average = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("======average====="+average);
    }
}
