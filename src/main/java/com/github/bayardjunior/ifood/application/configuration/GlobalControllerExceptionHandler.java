package com.github.bayardjunior.ifood.application.configuration;

import com.github.bayardjunior.ifood.domain.exception.MenuNotFoundException;
import com.github.bayardjunior.ifood.domain.exception.RestaurantAlreadyExistsException;
import com.github.bayardjunior.ifood.domain.utils.ResponseEntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(MenuNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException() {
        return ResponseEntityUtils.notFound();
    }

    @ExceptionHandler(RestaurantAlreadyExistsException.class)
    public ResponseEntity<Object> handleBadReqestException(String msg) {
        return ResponseEntityUtils.badRequest(msg);
    }

}
