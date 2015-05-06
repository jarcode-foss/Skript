package com.w00tmast3r.skript.lang;

import com.google.common.collect.ImmutableList;

/**
 * The "constructor" of a {@link SyntaxUnit}. The initializer is created and passed to the
 * syntax unit once a line of code has been parsed without errors.
 */
public class Initializer {

    private final ImmutableList<Expression<?>> expressions;
    private final int matchedIndex;
    private final String matchedPattern;

    public Initializer(ImmutableList<Expression<?>> expressions, int matchedIndex, String matchedPattern) {
        this.expressions = expressions;
        this.matchedIndex = matchedIndex;
        this.matchedPattern = matchedPattern;
    }

    /**
     * Returns all the expressions parsed in this pattern, in order.
     *
     * @return an array of expressions
     */
    public ImmutableList<Expression<?>> expressions() {
        return expressions;
    }

    /**
     * A convenience method for {@code expressions().get(index)} with inferred type casting.
     *
     * @param index the index of the requested expression
     * @param <T> the inferred type of the expression
     * @return the expression at the index
     */
    @SuppressWarnings("unchecked")
    public <T> Expression<T> expression(int index) {
        return (Expression<T>) expressions.get(index);
    }

    /**
     * Returns the index of the pattern the syntax unit matched.
     *
     * @return the index of the matched pattern
     */
    public int matchedIndex() {
        return matchedIndex;
    }

    /**
     * Returns the unparsed matched pattern the syntax unit matched.
     *
     * @return the unparsed matched pattern
     */
    public String matchedPattern() {
        return matchedPattern;
    }
}
