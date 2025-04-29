package example.corejava.overloading;

class Sum {
    public int add(int a, int b) {
        return a+b;
    }
    public int add(int a, int b, int c) {
        return a+b+c;
    }
}
public class MethodOverloading {
    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println("Sum of 2 and 3 is:" + sum.add(2, 3));
        System.out.println("Sum of 1, 2 and 3 is:" + sum.add(1, 2, 3));
    }
}
