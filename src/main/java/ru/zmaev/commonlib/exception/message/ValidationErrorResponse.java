package ru.zmaev.commonlib.exception.message;

import ru.zmaev.commonlib.model.dto.Violation;

import java.util.List;

public class ValidationErrorResponse {

    private final List<Violation> violations;

    public ValidationErrorResponse(List<Violation> violations) {
        this.violations = violations;
    }

    public List<Violation> getViolations() {
        return violations;
    }
}