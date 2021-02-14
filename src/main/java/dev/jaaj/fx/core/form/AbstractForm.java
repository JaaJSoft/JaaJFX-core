package dev.jaaj.fx.core.form;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;

public abstract class AbstractForm<R> extends Control {

    private final ObjectProperty<FormState> formState = new SimpleObjectProperty<>(FormState.EDITABLE);

    public AbstractForm() {
    }


    public abstract boolean validate();

    public abstract R apply();

    public FormState getFormState() {
        return formState.get();
    }

    public ObjectProperty<FormState> formStateProperty() {
        return formState;
    }

    public void setFormState(FormState formState) {
        this.formState.set(formState);
    }
}
