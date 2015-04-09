package com.w00tmast3r.skript.lang;

import java.util.Optional;

public interface Context {

    boolean setTime();

    int getTime();

    default <T> Optional<T> singleOf(Expression<T> expression) {
        return expression.getSingle(this);
    }

    default <T> Optional<T[]> multipleOf(Expression<T> expression) {
        return expression.getMultiple(this);
    }
}
