package dev.jaaj.fx.control;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

public abstract class SkinFXML<T extends Control> extends SkinBase<T> {
    protected SkinFXML(T control, Path pathFXML) {
        super(control);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController(this);
        Node load;
        try {
            fxmlLoader.setLocation(pathFXML.toUri().toURL());
            load = fxmlLoader.load();
        } catch (IOException e) {
            load = new TextArea(e.getMessage());
            e.printStackTrace();
        }
        getChildren().add(load);
    }


}
