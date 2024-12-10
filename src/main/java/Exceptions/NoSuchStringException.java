package Exceptions;

public class NoSuchStringException extends RuntimeException {

    public NoSuchStringException() {
        System.out.println("Такая строка не найдена.");
    }
}
