package example.corejava.overriding;

class Parent {
    public void show() {
        System.out.println("Parent Class");
    }
}
class Child extends Parent {
    public void show() {
        super.show();
        System.out.println("Child Class");
    }
}
public class MethodOverriding {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show();
        Child c = new Child();
        c.show();
    }
}
