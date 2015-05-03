package com.w00tmast3r.skript.util;

import com.w00tmast3r.skript.lang.SyntaxUnit;
import com.w00tmast3r.skript.lang.parser.SyntaxMetadata;

import java.util.function.Supplier;

public final class Syntax {

    public static <T extends SyntaxUnit> SyntaxMetadata<T> data(String pattern, Supplier<T> constructor) {

    }
}
