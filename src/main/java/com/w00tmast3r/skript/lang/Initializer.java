package com.w00tmast3r.skript.lang;

/**
 * The "constructor" of a {@link com.w00tmast3r.skript.lang.SyntaxUnit}. The initializer is created and passed to the
 * syntax unit once a line of code has been parsed without errors.
 */
public class Initializer {

    private final Expression<?>[] expressions;
    private final int matchedIndex;
    private final String matchedPattern;

    public Initializer(Expression<?>[] expressions, int matchedIndex, String matchedPattern) {
        this.expressions = expressions;
        this.matchedIndex = matchedIndex;
        this.matchedPattern = matchedPattern;
    }

    /**
     * Returns all the expressions parsed in this pattern, in order.
     *
     * @return an array of expressions
     */
    public Expression<?>[] expressions() {
        return expressions;
    }

    /**
     * A convenience method for {@code expressions()[index]} with inferred type casting.
     *
     * @param index the index of the requested expression
     * @param <T> the inferred type of the expression
     * @return the expression at the index
     */
    @SuppressWarnings("unchecked")
    public <T> Expression<T> expression(int index) {
        return (Expression<T>) expressions[index];
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
