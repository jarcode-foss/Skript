package com.w00tmast3r.skript.lang;

import com.w00tmast3r.skript.lang.scope.EnclosingScope;
import com.w00tmast3r.skript.lang.scope.Scope;

public interface Traversable {

    /**
     * Gets the containing scope of this item.
     *
     * @return the parent scope
     */
    Scope getParent();

    /**
     * Sets the containing scope of this item.
     *
     * @param scope the parent scope
     */
    void setParent(Scope scope);

    /**
     * Gets the enclosing scope of this item.
     *
     * @return the enclosing scope
     */
    default EnclosingScope getEnclosingParent() {
        Scope current = getParent();
        while (!(current instanceof EnclosingScope) && current != null) {
            current = current.getParent();
        }
        return (EnclosingScope) current;
    }

    /**
     * Sets the enclosing scope of this item.
     *
     * @param scope the enclosing scope
     */
    void setEnclosingParent(Scope scope);


    /**
     * Executes this traversable and gets the next traversable to run.
     *
     * @param context the context this traversable was executed in
     * @return the next traversable to execute
     */
    default Traversable walk(Context context) {
        run(context);
        return getNext();
    }

    /**
     * Executes this traversable. This method only exists for the purpose of neat structuring.
     *
     * @param context the context this traversable was executed in
     */
    default void run(Context context) {}

    /**
     * Gets the next traversable object that would be returned logically. Not guaranteed to have the same output as
     * {@link #walk}
     *
     * @return the next traversable object to be executed
     */
    Traversable getNext();

    /**
     * Sets the next traversable object that would be returned logically. This method is guaranteed to change the output
     * of {@link #getNext}.
     *
     * @param traversable the next traversable object to be executed
     */
    void setNext(Traversable traversable);
}
