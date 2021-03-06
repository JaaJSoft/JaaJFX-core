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

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public abstract class DialogForm<R> extends Dialog<R> {

    public DialogForm(AbstractForm<R> form, String dialogTitle, String dialogHeader) {
        this.setTitle(dialogTitle);
        this.setHeaderText(dialogHeader);
        this.getDialogPane().setContent(form);
        this.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        final Button btOk = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
        btOk.addEventFilter(ActionEvent.ACTION, event -> {
            if (!form.validate()) {
                // The conditions are not fulfilled so we consume the event to prevent the dialog to close
                event.consume();
            }
        });

        this.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                return form.apply();
            } else {
                return null;
            }
        });
    }
}
