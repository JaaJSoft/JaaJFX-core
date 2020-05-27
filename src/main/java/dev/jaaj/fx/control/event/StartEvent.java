package dev.jaaj.fx.control.event;

import dev.jaaj.event.JaaJEvent;
import dev.jaaj.fx.control.JaaJControl;

public class StartEvent extends ControlEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public StartEvent(JaaJControl source) {
        super(source);
    }
}
