package example.corejava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PersonStreamExample {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        List<Person> personList = Arrays.asList(
                new Person("Yashwant", "Neemuch"),
                new Person("Aman", "Indore"),
                new Person("Rohit", "Indore"),
                new Person("Ankush", "Khargon")
        );
        System.out.println(personList);
        List<Person> filteredList = personList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .peek(person -> person.setRollNum(atomicInteger.incrementAndGet()))
                .collect(Collectors.toList());
        System.out.println(filteredList);

//        List<Person> filteredList1 = personList.stream()
//                .sorted(Comparator.comparing(Person::getName))
//                .map(person -> { person.setRollNum(atomicInteger.incrementAndGet()); return  person;})
//                .collect(Collectors.toList());
//        System.out.println(filteredList1);
    }
}

