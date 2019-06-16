package ru.lubich.friendservice.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public final class ResourceForbiddenException extends RuntimeException {
    //  class definition
}