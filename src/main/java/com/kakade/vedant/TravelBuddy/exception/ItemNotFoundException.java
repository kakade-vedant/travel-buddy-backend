package com.kakade.vedant.TravelBuddy.exception;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException() {
        super("Item not Found.");
    }

    public ItemNotFoundException(String itemName) {
        super(itemName + " not Found.");
    }
}
