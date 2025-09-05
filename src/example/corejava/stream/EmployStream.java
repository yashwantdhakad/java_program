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

        Map<String, Optional<Employee>> maxSalaryEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("=====maxSalaryEmployees==="+maxSalaryEmployees);

        List<Employee> sortByGenderAndThenAge = employees.stream().sorted(Comparator.comparing(Employee::getGender).thenComparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("====sortByGenderAndThenAge==="+sortByGenderAndThenAge);

        Employee secondHighest = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("===secondHighest==="+secondHighest);

        // Grouping by age and then collect employee name list
        Map<Integer, List<String>> namesByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("====namesByAge===="+namesByAge);

        Map<Boolean, List<Employee>> partitionedByAge = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 26));
        System.out.println("===partitionedByAge==="+partitionedByAge);

        Employee seniorMost = employees.stream()
                .min(Comparator.comparing(Employee::getJoiningDate))
                .orElse(null);
        System.out.println("=====seniorMost==="+seniorMost);

        Map<Integer, Double> employeeWithAverageSalrByYear = employees.stream().collect(Collectors.groupingBy(employee -> employee.getJoiningDate().getYear(), Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("=====employeeWithAverageSalrByYear==="+employeeWithAverageSalrByYear);

        Map<Integer, Double> totalSalaryByYear = employees.stream().collect(Collectors.groupingBy(emp->emp.getJoiningDate().getYear(), Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Total salary by year: " + totalSalaryByYear);

        Map<Integer, Double> sortedMap = totalSalaryByYear.entrySet().stream().sorted(Map.Entry.<Integer, Double>comparingByKey().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap:: new));
        System.out.println("Sorted Map by year: " + sortedMap);

        Optional<Employee> highestPaidEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();
        System.out.println("Highest paid employee: " + highestPaidEmployee.get());

        List<String> empNameSortedBySalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).map(Employee::getName).collect(Collectors.toList());
        System.out.println("====empNameSortedBySalary==="+empNameSortedBySalary);

        // Filter employee after 31-01-2015 joining date
        List<Employee> filterEmployees = employees.stream().filter(employee -> employee.getJoiningDate().isAfter(LocalDate.of(2015, 1, 31))).collect(Collectors.toList());
        System.out.println("====filterEmployees===="+filterEmployees);
    }
}
