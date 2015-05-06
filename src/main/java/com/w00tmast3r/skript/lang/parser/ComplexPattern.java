package com.w00tmast3r.skript.lang.parser;

import java.util.List;

/**
 * A pattern which contains a sequence of subpatterns for parsing.
 */
public class ComplexPattern implements KeyPattern {

    public ComplexPattern(List<KeyPattern> patternSequence) {
    }

    @Override
    public ParseState parse(String group, int position) {
        return null;  // TODO Auto generated method stub
    }

    @Override
    public boolean hasCachedLengths() {
        return false;
    }

    @Override
    public int[] getCachedLengths() {
        return new int[0];
    }

    @Override
    public boolean mustCollapseWhitespace() {
        return false;
    }

    @Override
    public boolean isSuffix() {
        return false;
    }
}
