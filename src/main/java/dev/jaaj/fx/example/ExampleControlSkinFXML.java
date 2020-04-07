package dev.jaaj.fx.example;

import dev.jaaj.fx.control.SkinFXML;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.nio.file.Path;

public class ExampleControlSkinFXML extends SkinFXML<ExampleControl> {

    @FXML
    Button button;

    protected ExampleControlSkinFXML(ExampleControl control) {
        super(control, Path.of("src/main/java/dev/jaaj/fx/example/ExampleControlSkinFXML.fxml"));//TODO add a helper function ? or @
    }
}
