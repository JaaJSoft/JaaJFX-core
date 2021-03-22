/*
 * Copyright 2021 JaaJSoft
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.jaaj.fx.core.form;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;

public abstract class AbstractForm<I> extends Control {
    private final ObjectProperty<I> item = new SimpleObjectProperty<>();
    private final ObjectProperty<FormState> formState = new SimpleObjectProperty<>(FormState.EDITABLE);

    public I getItem() {
        return item.get();
    }

    public ObjectProperty<I> itemProperty() {
        return item;
    }

    public void setItem(I item) {
        this.item.set(item);
    }

    public abstract boolean validate();

    public abstract I apply();

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
