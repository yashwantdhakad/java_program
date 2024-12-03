package example.corejava.stream;

import java.util.*;
import java.util.stream.Collectors;

public class EmployStream {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(2012, 50000, "Yashwant", "Male", 25),
                new Employee(2013, 45000, "Aman", "Male", 26),
                new Employee(2014, 60000, "Rohit", "Male", 27),
                new Employee(2010, 58000, "Ankush", "Male", 28),
                new Employee(2019, 30000, "Monika", "Female", 28),
                new Employee(2018, 40000, "Anjali", "Female", 27),
                new Employee(2020, 20000, "Pooja", "Female", 26)
        );
        Map<Integer, Double> totalSalaryByYear = employees.stream().collect(Collectors.groupingBy(Employee::getYear, Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Total salary by year: " + totalSalaryByYear);

        Map<Integer, Double> sortedMap = totalSalaryByYear.entrySet().stream().sorted(Map.Entry.<Integer, Double>comparingByKey().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap:: new));
        System.out.println("Sorted Map by year: " + sortedMap);

        Optional<Employee> highestPaidEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();
        System.out.println("Highest paid employee: " + highestPaidEmployee.get());

    }
}
