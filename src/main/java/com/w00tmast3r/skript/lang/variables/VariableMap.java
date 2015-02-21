package com.w00tmast3r.skript.lang.variables;

import com.w00tmast3r.skript.lang.Context;

import java.util.WeakHashMap;

public class VariableMap {

    private final WeakHashMap<Context, Variable<?>> variables = new WeakHashMap<>();
}
