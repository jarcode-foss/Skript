package com.w00tmast3r.skript.lang;

import java.util.List;

public interface Scope extends Traversable {

    /**
     * Returns all the children traversables of this scope.
     *
     * @return
     */
    List<Traversable> getChildren();

    /**
     * Gets the next traversable object outside of this scope.
     *
     * @return the next traversable
     */
    Traversable getNextOuter();

    /**
     * Called when the last child
     *
     * @return
     */
    Traversable walkOutside(Context context);

}
