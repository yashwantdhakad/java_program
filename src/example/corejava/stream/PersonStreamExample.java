package example.corejava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonStreamExample {

    private static int count = 1;
    private static int getCountAndIncrement() {
        return count++;
    }

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Yashwant", "Neemuch"),
                new Person("Aman", "Indore"),
                new Person("Rohit", "Indore"),
                new Person("Ankush", "Khargon")
        );
        System.out.println(personList);
        List<Person> filteredList = personList.stream()
//                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .peek(person -> person.setRollNum(getCountAndIncrement()))
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }
}

