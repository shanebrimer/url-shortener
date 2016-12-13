package com.craft.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityIdConflictException extends RuntimeException {

    private static final long serialVersionUID = -564148341541373723L;

    public EntityIdConflictException() {
        super();
    }

    public EntityIdConflictException(String message) {
        super(message);
    }

}
