package dev.jaaj.fx.event;

import java.util.ArrayList;
import java.util.List;

public class EventInvoker<E extends JaaJEvent<?>> {
    private final List<JaaJEventListener<E>> eventListenerList = new ArrayList<>();

    public void addListener(JaaJEventListener<E> eventHandler) {
        eventListenerList.add(eventHandler);
    }

    public boolean removeListener(JaaJEventListener<E> eventHandler) {
        return eventListenerList.remove(eventHandler);
    }

    public void invoke(E event) {
        eventListenerList.forEach(eEventHandler -> eEventHandler.handle(event));
    }
}
