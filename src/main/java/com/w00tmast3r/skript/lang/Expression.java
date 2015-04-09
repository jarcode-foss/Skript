package com.w00tmast3r.skript.lang;

import java.util.Optional;
import java.util.function.BiFunction;

public interface Expression<R> extends SyntaxUnit, BiFunction<Initializer, Context, Optional<R>> {



    /**
     * Returns the object associated with this expression
     * <p>
     *
     * @param context the context in which this expression is executed
     * @return the object associated with this expression
     */
    Optional<R> get(Context context);


    /**
     * Returns the expected return type of this expression.
     *
     * @return the return type of this expression
     */
    Class<? extends R> returnType();

    @Override
    default Optional<R> apply(Initializer initializer, Context context) {
        init(initializer);
        return get(context);
    }
}
