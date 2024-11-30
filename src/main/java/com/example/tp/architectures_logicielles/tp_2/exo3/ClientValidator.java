package com.example.tp.architectures_logicielles.tp_2.exo3;

import com.example.tp.architectures_logicielles.tp_2.exo3.validators.IValidator;

public class ClientValidator {
    IValidator validator;

    public ClientValidator(IValidator validator) {
        this.validator = validator;
    }

    public void setValidator(IValidator validator) {
        this.validator = validator;
    }

    public boolean validate(String value) {
        return validator.validate(value);
    }
}
