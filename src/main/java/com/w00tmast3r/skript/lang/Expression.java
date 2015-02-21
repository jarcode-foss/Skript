package com.w00tmast3r.skript.lang;

public interface Expression<T> extends SyntaxUnit {

    T getSingle(Context c);

    T[] getMultiple(Context c);

    boolean isSingle();

    boolean isNull(Context c);
}
