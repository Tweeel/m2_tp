package com.example.tp.architectures_logicielles.tp_2.exo3.validators;

public class IntegerValidator implements IValidator {
    @Override
    public boolean validate(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
