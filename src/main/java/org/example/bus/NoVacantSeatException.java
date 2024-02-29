package org.example.bus;

public class NoVacantSeatException extends Exception {

    public NoVacantSeatException(String message) {
        super(message);
    }

}
