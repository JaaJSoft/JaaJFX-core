package dev.jaaj.fx.control.event;

import dev.jaaj.fx.control.JaaJControl;
import dev.jaaj.fx.event.JaaJEvent;

import java.util.EventObject;

public class ControlEvent extends JaaJEvent<JaaJControl> {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ControlEvent(JaaJControl source) {
        super(source);
    }


}
