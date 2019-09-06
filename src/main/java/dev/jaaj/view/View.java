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

package dev.jaaj.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class View {

    protected Scene scene;
    protected Node root;
    protected URL urlFXML;
    protected List<View> subView;
    protected View parent = null;

    public View(URL urlFXML) throws IOException {
        this.urlFXML = urlFXML;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(urlFXML);
        fxmlLoader.setController(this);
        root = fxmlLoader.load();
        subView = new ArrayList<>();
    }

    public View(URL urlFXML, View parent) throws IOException {
        this(urlFXML);
        this.parent = parent;
    }

    public View(Node root) {
        this.root = root;
    }

    public View(Node root, View parent) {
        this.root = root;
        this.parent = parent;
    }

    /**
     * Called when the scene is add in the scene manager or in another view
     * @param args
     */
    public abstract void onCreate(Object... args);


    /**
     * Start the view
     */
    protected abstract void onStart(Object... args);

    /**
     * Called at every SceneManager::setScene()
     * Update all sub view before
     */
    public void start(Object... args) {
        onStart(args);
        for (View v : subView) {
            v.start(args);
        }
    }

    public void update() {
        onUpdate();
        for (View v : subView) {
            v.update();
        }
    }

    /**
     * Called every n (5 default) seconds to update the view
     */
    protected abstract void onUpdate();

    public void stop() {
        for (View v : subView) {
            v.stop();
        }
        onStop();
    }

    protected abstract void onStop();

    public Scene getScene() {
        if (scene == null) {
            scene = new Scene((Parent) root);
        }
        return scene;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public URL getUrlFXML() {
        return urlFXML;
    }

    public View getParent() {
        return parent;
    }

    public void addSubView(View v) {
        subView.add(v);
    }
}
