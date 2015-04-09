package com.w00tmast3r.skript.lang;

import java.util.Optional;

public interface Effect extends Expression<Effect>, Traversable {

    @Override
    default Optional<Effect> get(Context context) {
        return Optional.of(this);
    }

    @Override
    default Class<? extends Effect> returnType() {
        return Effect.class;
    }
}
