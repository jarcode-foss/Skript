package com.w00tmast3r.skript.lang.parser;

import com.google.common.collect.ImmutableList;
import com.sun.istack.internal.NotNull;

/**
 * A pattern which handles the parsing of individual strings.
 */
public interface KeyPattern {

    /**
     * Parses a string at a position in the pattern and returns the next result of that parsed character.
     * <p>
     * If the position returned is different than the position passed to the method, consequent parses will only contain
     * strings found after the position was modified.
     * <p>
     * Position 0 should always be the start of the pattern. There is no specification for what the position should be
     * at any given time, since it is just used for keeping track of position in a parse.
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
     * @return whether or not the first position is an expression.
     */
    boolean isExpression();
}
