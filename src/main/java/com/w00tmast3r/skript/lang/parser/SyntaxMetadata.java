package com.w00tmast3r.skript.lang.parser;

import com.w00tmast3r.skript.lang.SyntaxUnit;

import java.util.function.Supplier;

/**
 * Links
 *
 * @param <T>
 */
public final class SyntaxMetadata<T extends SyntaxUnit> {

    private final Supplier<KeyPattern> patternSupplier;
    private final Supplier<T> unitConstructor;

    public SyntaxMetadata(Supplier<KeyPattern> patternSupplier, Supplier<T> unitConstructor) {
        this.patternSupplier = patternSupplier;
        this.unitConstructor = unitConstructor;
    }

    public Supplier<KeyPattern> getPatternSupplier() {
        return patternSupplier;
    }

    public Supplier<T> getUnitConstructor() {
        return unitConstructor;
    }

    public KeyPattern createPattern() {
        return patternSupplier.get();
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
