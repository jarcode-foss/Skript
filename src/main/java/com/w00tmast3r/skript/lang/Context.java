package com.w00tmast3r.skript.lang;

public interface Context {

    boolean setTime();

    int getTime();

    /**
     * Verifies the given expressions, returning true if any expression is null.
     *
     * @param expressions
     * @return
     */
    default boolean checkNulls(Expression<?>... expressions) {
        for (Expression<?> expression : expressions) {
            if (expression.isNull(this)) return true;
        }
        return false;
    }

    default <T> T singleOf(Expression<T> expression) {
        return expression.getSingle(this);
    }

    default <T> T[] multipleOf(Expression<T> expression) {
        return expression.getMultiple(this);
    }
}
