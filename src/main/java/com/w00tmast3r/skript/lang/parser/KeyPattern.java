package com.w00tmast3r.skript.lang.parser;

import java.util.function.Function;

/**
 * A pattern which handles
 */
public interface KeyPattern extends Function<String, ParseState> {

    /**
     * Parses a character and returns the next pattern that should receive a character.
     *
     * @param group the character to parse
     * @return the result of the parse
     */
    ParseState apply(String group);

    /**
     * Get whether or not this pattern has a predefined length.
     * <p>
     * Even if this method returns {@code true}, the pattern is not guaranteed to be optimized.
     *
     * @return true if this pattern has a predictable length
     * @see #getCachedLength
     */
    boolean hasCachedLength();

    /**
     * Gets the length of this pattern for parser optimization.
     * <p>
     * Even if this method is called, the pattern is not guaranteed to be optimized. An optimized parser does not call
     * {@link #apply(String)} until the token is this length.
     *
     * @return the expected length of this pattern
     */
    int getCachedLength();

    /**
     * Gets whether or not the pattern may accept two whitespace characters in a row.
     *
     * @return true if this pattern is whitespace insensitive
     */
    boolean mustCollapseWhitespace();
}
