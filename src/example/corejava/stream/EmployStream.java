package example.corejava.stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployStream {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(LocalDate.of(2012, 12,20), 50000, "Yashwant", "Male", 25),
                new Employee(LocalDate.of(2013,8, 15), 45000, "Aman", "Male", 26),
                new Employee(LocalDate.of(2014, 5, 24), 60000, "Rohit", "Male", 27),
                new Employee(LocalDate.of(2010, 12,31), 58000, "Ankush", "Male", 28),
                new Employee(LocalDate.of(2019,1,1), 30000, "Monika", "Female", 28),
                new Employee(LocalDate.of(2018, 6, 15), 40000, "Anjali", "Female", 27),
                new Employee(LocalDate.of(2020,2, 15), 20000, "Pooja", "Female", 26)
        );
        Map<Integer, Double> totalSalaryByYear = employees.stream().collect(Collectors.groupingBy(emp->emp.getJoiningDate().getYear(), Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Total salary by year: " + totalSalaryByYear);

        Map<Integer, Double> sortedMap = totalSalaryByYear.entrySet().stream().sorted(Map.Entry.<Integer, Double>comparingByKey().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap:: new));
        System.out.println("Sorted Map by year: " + sortedMap);

        Optional<Employee> highestPaidEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();
        System.out.println("Highest paid employee: " + highestPaidEmployee.get());

        List<String> empNameSortedBySalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).map(Employee::getName).collect(Collectors.toList());
        System.out.println("====empNameSortedBySalary==="+empNameSortedBySalary);

        List<Employee> filterEmployees = employees.stream().filter(employee -> employee.getJoiningDate().isAfter(LocalDate.of(2015, 1, 31))).collect(Collectors.toList());
        System.out.println("====filterEmployees===="+filterEmployees);
    }
}
