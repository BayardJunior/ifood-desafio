package com.github.bayardjunior.ifood.domain.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtils {

    public ResponseEntityUtils() {
    }

    public static <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static <T> ResponseEntity<T> notFound() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    public static <T> ResponseEntity<T> badRequest(T body) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);
    }

    public static <T> ResponseEntity<T> created(T body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}
