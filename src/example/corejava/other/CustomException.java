package example.corejava.other;

public class CustomException {
    public static class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
    }
    public static class MyRuntimeException extends RuntimeException {
        public MyRuntimeException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws MyCustomException {

        throw new MyRuntimeException("This is my runtime exception");
        // throw new MyCustomException("This is my custom exception");
    }
}

