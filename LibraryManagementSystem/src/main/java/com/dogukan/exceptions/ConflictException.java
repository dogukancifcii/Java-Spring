package com.dogukan.exceptions;

import javax.validation.constraints.Email;

public class ConflictException extends RuntimeException {
    public ConflictException(String s) {

        super(s);

    }
}
