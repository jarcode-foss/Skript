package com.w00tmast3r.skript.lang.parser;

import com.google.common.collect.ImmutableList;
import com.sun.istack.internal.NotNull;

/**
 * A pattern which handles
 */
public interface KeyPattern {

    /**
     * Parses a character and returns the next pattern that should receive a character.
     *
     * @param group the character to parse
     * @return the result of the parse
     */
    @NotNull
    ParseState parse(String group, int position);

    /**
     * Get whether or not this pattern has predefined lengths.
     * <p>
     * Even if this method returns {@code true}, the pattern is not guaranteed to be optimized.
     *
     * @return true if this pattern has predictable lengths
     * @see #getCachedLengths
     */
    boolean hasCachedLengths();

    /**
     * Gets the possible lengths of this pattern for parser optimization.
     * <p>
     * Even if this method is called, the pattern is not guaranteed to be optimized. An optimized parser does not call
     * {@link #parse(String, int)} until the token is this length.
     *
     * @return the possible lengths of this expression
     */
    ImmutableList<Integer> getCachedLengths();

    /**
     * Gets whether or not the pattern may accept two whitespace characters in a row.
     *
     * @return true if this pattern is whitespace insensitive
     */
    boolean mustCollapseWhitespace();

    /**
     * Gets whether or not the first position of this pattern parses expressions.
     * <p>
     * Some parsers will use this value to reorder parse order for optimisation.
     *
     * @return
     */
    boolean isExpression();
}
