package br.com.cresol.desafio.exception;

import java.nio.file.AccessDeniedException;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionsHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AccessDeniedException.class)
    public ExceptionInfo handler(AccessDeniedException e) {
    	Logger.getLogger(this.getClass()).log(Level.ERROR, e.getMessage(), e);
        return new ExceptionInfo(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionInfo handler(IllegalArgumentException e) {
    	Logger.getLogger(this.getClass()).log(Level.ERROR, e.getMessage(), e);
        return new ExceptionInfo(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public ExceptionInfo handler(IllegalStateException e) {
    	Logger.getLogger(this.getClass()).log(Level.ERROR, e.getMessage(), e);
        return new ExceptionInfo(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ExceptionInfo handlers(Throwable e) {
    	Logger.getLogger(this.getClass()).log(Level.ERROR, e.getMessage(), e);
        return new ExceptionInfo(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DesafioCresolException.class)
    public ExceptionInfo handler(DesafioCresolException e) {
       Logger.getLogger(this.getClass()).log(Level.ERROR, e.getMessage(), e);
        return new ExceptionInfo(e.getMessage());
    }

}