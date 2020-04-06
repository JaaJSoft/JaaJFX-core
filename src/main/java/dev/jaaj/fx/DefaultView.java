/*
 * Copyright (c) 2019. JaaJ-dev
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
 *
 */

package dev.jaaj.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DefaultView extends View {
    @FXML
    private
    BorderPane rootBorderPane;

    public DefaultView() throws IOException {
        super(DefaultView.class.getResource("default.fxml"));
    }

    @Override
    public void onCreate(Object... args) {
        Button value = new Button((String) args[0]);
        value.setOnAction(event -> {
            System.out.println("Click " + args[0]);
            ViewManager viewManager = (ViewManager) args[1];
            viewManager.setActiveView("default2");
        });
        rootBorderPane.setCenter(value);
    }

    @Override
    protected void onStart(Object... args) {
        System.out.println("start");
    }


    @Override
    protected void onUpdate() {
        System.out.println("update");
    }

    @Override
    protected void onStop() {
        System.out.println("stop");
    }
}
