package com.w00tmast3r.skript.lang.parser.standard;

public interface KeyPattern {

    /**
     * Parses a group of tokens and returns the results of the parse.
     *
     * @param group the token group to parse
     * @return the result of the parse
     */
    byte parse(String group);

    /**
     * Get whether or not this pattern has a predefined length.
     *
     * @return whether the pattern has a static length
     */
    boolean hasCachedLength();

    /**
     * Gets the length of this pattern for parser optimization.
     *
     * @return
     */
    int getCachedLength();

    /**
     * Returns how whitespace should be handled DURING the parsing of the token.
     *
     * @return this pattern's whitespace setting
     */
    WhitespaceMode getWhitespaceMode();
}
