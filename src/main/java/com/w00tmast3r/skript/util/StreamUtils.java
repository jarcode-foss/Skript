package com.w00tmast3r.skript.util;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamUtils {

    @SuppressWarnings("unchecked")
    public static <T> Stream<Class<? extends T>> superClasses(Class target, Class<T> limit) {
        ArrayList<Class<? extends T>> list = new ArrayList<>();
        while (target != null && limit.isAssignableFrom(target)) {
            list.add(target);
            target = target.getSuperclass();
        }
        return list.stream();
    }
}
