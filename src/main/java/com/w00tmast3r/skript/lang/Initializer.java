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

    public Expression<?>[] expressions() {
        return expressions;
    }

    @SuppressWarnings("unchecked")
    public <T> Expression<T> expression(int index) {
        return (Expression<T>) expressions[index];
    }

    public List<MatchResult> regexResults() {
        return regexResults;
    }

    public int matchedIndex() {
        return matchedIndex;
    }

    public String matchedPattern() {
        return matchedPattern;
    }

    public long mark() {
        return mark;
    }

    public long mark(long flag, boolean xor) {
        if (xor) mark ^= flag;
        else mark = flag;
        return mark;
    }

    public long mark(long flag) {
        return mark(flag, true);
    }
}
