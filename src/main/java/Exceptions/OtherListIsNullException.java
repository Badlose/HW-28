package Exceptions;

public class OtherListIsNullException extends RuntimeException {

    public OtherListIsNullException() {

        System.out.println("Переданный список = null.");
    }
}
