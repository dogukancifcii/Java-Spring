package com.dogukan.exceptions;

public class isBookAlreadyExist extends RuntimeException {
    public isBookAlreadyExist(String s) {
        super(s);
    }
}
