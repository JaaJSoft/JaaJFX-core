package dev.jaaj.fx.example;

import dev.jaaj.fx.control.JaaJControl;
import javafx.scene.control.Skin;

public class ExampleControl extends JaaJControl {
    public ExampleControl() {

    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new ExampleControlSkinFXML(this);
    }
}
