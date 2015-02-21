package com.w00tmast3r.skript.util.event;

import com.w00tmast3r.skript.util.StreamUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public class EventDelegator {
    private static EventDelegator ourInstance = new EventDelegator();
    private HashMap<Class<? extends CallableEvent>, ArrayList<Consumer<?>>> targets = new HashMap<>();

    public static EventDelegator getInstance() {
        return ourInstance;
    }

    private EventDelegator() {
    }

    @SuppressWarnings("unchecked")
    public void invoke(CallableEvent event) {
        StreamUtils.superClasses(event.getClass(), CallableEvent.class)
                .forEach(s -> targets.get(s).forEach(c -> ((Consumer<CallableEvent>) c).accept(event)));
    }

    public <T extends CallableEvent> void register(Consumer<T> consumer, Class<T> type) {
        targets.putIfAbsent(type, new ArrayList<>());
        targets.get(type).add(consumer);
    }
}
