package example.corejava.other;

public class CustomException {
    public static void main(String[] args) throws MyCustomException {
        throw new MyCustomException("This is my custom exception");
    }
}

class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}