package com.kakade.vedant.TravelBuddy.exception;

public class IdModificationException extends Exception {
    public IdModificationException() {
        super("Entity ID is already set and cannot be modified.");
    }
}
