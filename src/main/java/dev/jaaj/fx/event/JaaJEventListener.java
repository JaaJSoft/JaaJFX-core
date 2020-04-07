package dev.jaaj.fx.event;

import dev.jaaj.fx.control.JaaJControl;

import java.util.EventListener;
import java.util.EventObject;

@FunctionalInterface
public interface JaaJEventListener<E extends JaaJEvent<?>> extends EventListener {

    void handle(E event);

}
