package com.example.tp.architectures_logicielles.tp_2.exo3.validators;

public class EmailValidator implements IValidator {
    @Override
    public boolean validate(String value) {
        return value.matches("^(.+)@(.+)$");
    }
}
