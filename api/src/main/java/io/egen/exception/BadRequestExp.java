package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestExp extends RuntimeException {
    public BadRequestExp(String msg) {
        super(msg);
    }
}
