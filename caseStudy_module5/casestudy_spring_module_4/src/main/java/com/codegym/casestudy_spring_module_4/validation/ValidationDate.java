package com.codegym.casestudy_spring_module_4.validation;

import com.codegym.casestudy_spring_module_4.model.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class ValidationDate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;

        if (!(contract.getContractStartDate() == null) && !(contract.getContractEndDate() == null)) {
            LocalDate startTime = contract.getContractStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endTime = contract.getContractEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(startTime, endTime).getDays() < 0) {
                errors.rejectValue("contractEndDate", "dateComparison");
            }
        }
    }
}
