package example.company.photon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Addition {
    public int add(int a, int b);
}

class Student {
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student[" + name + ", " + age + "]";
    }
}

public class Main {

    public static void main(String[] args) {
        Addition addition = (a, b) -> (a + b);
        System.out.println(addition.add(2, 3));

        int[] numbers = {2,3,4,7,8,11, 16,18,17};
        List<Integer> collect = Arrays.stream(numbers).filter(num -> num % 3 != 0).boxed().toList();
        System.out.println("====collect=="+collect);

        StringBuilder sb = new StringBuilder("Test");
        String s1 = sb.toString();
        String s2 = sb.toString();
        if (s1 != s2) {
            System.out.println("True");
        }

        List<Student> students = new ArrayList<>();
        students.add(new Student("James", 25));
        students.add(new Student("James", 27));
        students.add(new Student("James", 25));
        students.add(new Student("James", 25));

        students.remove(new Student("James", 25));

        for (Student stud : students) {
            System.out.println(stud);
        }

        int[] nums = {0,3,5,1,4,11,7};

        for(int i=0; i< nums.length;i++) {
            for(int j=i+1; j< nums.length;j++) {
                if ( nums[i]+ nums[j] == 5) {
                    System.out.println(nums[i] + " " +nums[j]);
                }
            }
        }
    }
}
