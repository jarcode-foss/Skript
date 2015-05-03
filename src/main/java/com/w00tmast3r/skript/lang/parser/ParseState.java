package com.w00tmast3r.skript.lang.parser;

public enum ParseState {
    /**
     * The current pattern was matched successfully and the parser may move on to the next pattern.
     */
    SUCCESS,
    /**
     * The current pattern could not be matched, indicating that the parse branch has failed.
     */
    FAILURE,
    /**
     * The current pattern has not reached a {@link #FAILURE} condition, but has still not met a {@link #SUCCESS}
     * condition.
     */
    PROGRESS,
    /**
     * The current pattern has reached a potential {@link #SUCCESS} condition, but more characters
     */
    DIVERGE
}
