package example.corejava.designpatterns;

class SingletonMain {
    private static volatile SingletonMain instance;
    private SingletonMain() {}

    public static SingletonMain getInstance() {
        if (instance == null) {
            synchronized (SingletonMain.class) {
                if (instance == null) {
                    instance = new SingletonMain();
                }
            }
        }
        return instance;
    }
}

public class Singleton {

    public static void main(String[] args) {
        System.out.println("====instance===="+SingletonMain.getInstance());
        System.out.println("====instance===="+SingletonMain.getInstance());
    }
    // Summary of Preventive Measures:
    //Reflection: Modify the constructor to prevent instantiation by reflection.
    //Serialization: Implement readResolve() to ensure the same instance is returned after deserialization.
    //Cloning: Override clone() and throw a CloneNotSupportedException.
    //Multithreading: Use synchronization or double-checked locking to ensure thread safety.
}
