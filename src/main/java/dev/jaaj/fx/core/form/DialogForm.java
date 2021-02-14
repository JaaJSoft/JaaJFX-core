package dev.jaaj.fx.core.form;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public abstract class DialogForm<R> extends Dialog<R> {

    protected DialogForm(AbstractForm<R> form, String dialogTitle, String dialogHeader) {
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
