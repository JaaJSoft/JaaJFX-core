package dev.jaaj.fx.example;

import javafx.scene.control.Button;
import javafx.scene.control.SkinBase;

public class ExampleControlSkin extends SkinBase<ExampleControl> {

    protected ExampleControlSkin(ExampleControl control) {
        super(control);
        getChildren().add(new Button("AAA"));
    }
}
