package myException;

public class MyException extends Exception{
    private static final String message = "Something went wrong. Please enter correct data.";

    public MyException(String exception) {
        super(message + exception);
    }

}
