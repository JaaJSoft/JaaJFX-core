package dev.jaaj.fx.event;

import java.util.EventObject;

public class JaaJEvent<S> extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public JaaJEvent(S source) {
        super(source);
    }

    @Override
    @SuppressWarnings("unchecked")
    public S getSource() {
        return (S) super.getSource();
    }
}
