package com.w00tmast3r.skript.lang.util;

public class SkriptAPIException extends RuntimeException {

    public SkriptAPIException(String pattern, String message) {
        this(pattern, message, null);
    }

    public SkriptAPIException(String pattern, String message, Throwable cause) {
        super(message + " [pattern: " + pattern + "]", cause);
    }
}
