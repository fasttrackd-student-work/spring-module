package com.cooksys.lemonadestand.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cooksys.lemonadestand.exceptions.BadRequestException;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
import com.cooksys.lemonadestand.model.ErrorDto;

@ControllerAdvice(basePackages = { "com.cooksys.lemonadestand.controllers" })
@ResponseBody
public class LemonadeStandControllerAdvice {

    // In the videos I add a second parameter to these methods - an
    // HttpServletRequest object
    // Spring will pass that object in if I add it as a parameter.
    // However, we are not using that object, so it's not necessary here to set up
    // the methods to expect it.

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorDto handleBadRequestException(BadRequestException badRequestException) {
        return new ErrorDto(badRequestException.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDto handleNotFoundException(NotFoundException notFoundException) {
        return new ErrorDto(notFoundException.getMessage());
    }

}
