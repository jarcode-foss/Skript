package com.w00tmast3r.skript.lang;

import java.util.List;

public interface Scope extends Traversable {

    /**
     * Returns all the children traversables of this scope.
     *
     * @return a list of child traversables
     */
    List<Traversable> getChildren();

    /**
     * Sets the list of children in this scope.
     */
    void setChildren(List<Traversable> children);

    /**
     * Returns the next traversable run outside of this scope.
     *
     * @return the next traversable
     */
    List<Traversable> getNextOutside();

    /**
     * Sets the next traversable run outside of this scope.
     */
    void setNextOutside(Traversable children);

    /**
     * Called when the last child of the scope is reached or when a child's {@link Traversable#walk} returns null.
     * Returns the next traversable to execute, which may not be the next
     *
     * @return the next traversable
     */
    Traversable walkOutside(Context context);

}
