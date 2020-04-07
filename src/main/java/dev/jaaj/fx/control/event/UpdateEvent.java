package dev.jaaj.fx.control.event;

import dev.jaaj.fx.control.JaaJControl;

public class UpdateEvent extends ControlEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public UpdateEvent(JaaJControl source) {
        super(source);
    }
}
