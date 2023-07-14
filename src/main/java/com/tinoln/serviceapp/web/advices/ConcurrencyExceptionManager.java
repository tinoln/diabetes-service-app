package com.tinoln.serviceapp.web.advices;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class ConcurrencyExceptionManager {

    @ExceptionHandler(ConcurrencyException.class)
    public ModelAndView concurrencyException(final ConcurrencyException ex) {
        return ex.populateAndGetFormView();
    }

}
