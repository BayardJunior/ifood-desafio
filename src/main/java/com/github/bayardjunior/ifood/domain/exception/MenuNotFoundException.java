package com.github.bayardjunior.ifood.domain.exception;

public class MenuNotFoundException extends RuntimeException {

    public MenuNotFoundException(String message) {
        super(message);
    }
}
