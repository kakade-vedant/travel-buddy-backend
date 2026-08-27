package com.kakade.vedant.TravelBuddy.exception;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException() {
        super("Item Not Found.");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
