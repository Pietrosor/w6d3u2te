package it.epicode.w6d3u2te.exception;

import it.epicode.w6d3u2te.model.ApiError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ApiError NotFoundExceptionHandler(NotFoundException e){
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return error;
    }
}
