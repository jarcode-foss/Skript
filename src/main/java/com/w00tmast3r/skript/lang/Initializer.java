package com.w00tmast3r.skript.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;

public class Initializer {

    private final Expression<?>[] expressions;
    private final List<MatchResult> regexResults = new ArrayList<>(1);
    private final int matchedIndex;
    private final String matchedPattern;
    private long mark = 0;

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
     * Returns a list of regex results from the matched pattern, if any manual regex was present in the pattern.
     *
     * @return
     */
    public List<MatchResult> regexResults() {
        return regexResults;
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

    /**
     * Returns the flags of this initializer as a a long.
     * <p>
     * This value defaults to {@code 0} if the mark has never been set.
     *
     * @return this initializer's custom flags as a long
     */
    public long mark() {
        return mark;
    }

    /**
     * Sets the flags of this initializer and returns the new long.
     *
     * @param flag the base long
     * @param xor whether or not to XOR the existing flags with the base long
     * @return the final results of the flag modification
     */
    public long mark(long flag, boolean xor) {
        if (xor) mark ^= flag;
        else mark = flag;
        return mark;
    }

    /**
     *
     *
     * @param flag the base long
     * @return the final results of the flag modification
     */
    public long mark(long flag) {
        return mark(flag, true);
    }
}
