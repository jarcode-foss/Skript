package com.w00tmast3r.skript.lang.parser;

import com.sun.istack.internal.NotNull;

public class ParseState {

    public static final ParseState FAILURE = new ParseState(State.FAILURE, 0);

    private final State state;
    private final int nextPosition;

    public ParseState(@NotNull State state, int nextPosition) {
        this.state = state;
        this.nextPosition = nextPosition;
    }

    public State getState() {
        return state;
    }

    /**
     * Gets the next position to parse from in {@link KeyPattern#parse(String, int)}. In the case of a
     * {@link State#FAILURE}, this returns the current position. In the case of a {@link State#SUCCESS}, this returns 0.
     * <p>
     *
     *
     * @return the next position to parse from
     */
    public int getNextPosition() {
        return nextPosition;
    }

    public boolean hasOutputData() {
        return false; // TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParseState that = (ParseState) o;

        if (nextPosition != that.nextPosition) return false;
        if (state != that.state) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + nextPosition;
        return result;
    }

    public static enum State {
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
         * The current pattern has reached a potential {@link #SUCCESS} condition, but more {@link #SUCCESS} conditions may
         * still be reachable.
         */
        DIVERGE
    }
}
