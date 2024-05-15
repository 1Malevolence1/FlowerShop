package com.example.businesslogic.exeption;

import java.util.List;

public class ValidationErrorResponse  extends Throwable {
    private final List<Violation> violation;

    public ValidationErrorResponse(List<Violation> violation) {
        this.violation = violation;
    }
}
