package Exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
        System.out.println("Такая строка не найдена.");
    }
}
