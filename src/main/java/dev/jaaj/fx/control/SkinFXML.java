/*
 * Copyright 2020 JaaJSoft
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
