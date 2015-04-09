package com.w00tmast3r.skript.lang.parser.standard;

import com.w00tmast3r.skript.lang.SyntaxUnit;

import java.util.List;
import java.util.function.Supplier;

/**
 * Links
 *
 * @param <T>
 */
public final class SyntaxMetadata<T extends SyntaxUnit> {

    private final List<KeyPattern> keyPatterns;
    private final Supplier<T> unitConstructor;

    public SyntaxMetadata(List<KeyPattern> keyPatterns, Supplier<T> unitConstructor) {
        this.keyPatterns = keyPatterns;
        this.unitConstructor = unitConstructor;
    }

    public List<KeyPattern> getKeyPatterns() {
        return keyPatterns;
    }

    public Supplier<T> getUnitConstructor() {
        return unitConstructor;
    }

    public T create() {
        try {
            return unitConstructor.get();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
