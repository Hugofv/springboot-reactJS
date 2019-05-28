package com.star.wars.exception;


import com.star.wars.rest.util.MessageCode;
import com.star.wars.rest.util.exception.StarwarsRestResponseExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author FALKOR-LTDA "Hugo Fernandes"
 *
 */
@ControllerAdvice
public class ResponseExceptionHandler extends StarwarsRestResponseExceptionHandler {


    @Override
    protected MessageCode getCodeInternalServerError() {
        return StarwarsMessageCode.ERRO_INESPERADO;
    }
}
