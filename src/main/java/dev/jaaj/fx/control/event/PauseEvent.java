package dev.jaaj.fx.control.event;

import dev.jaaj.fx.control.JaaJControl;
import dev.jaaj.fx.event.JaaJEvent;

public class PauseEvent extends JaaJEvent<JaaJControl> {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public PauseEvent(JaaJControl source) {
        super(source);
    }
}
