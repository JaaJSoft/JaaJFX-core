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

import dev.jaaj.view.exception.ExceptionViewAlrdeadyExists;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ViewManager {

    private final HashSet<View> views = new HashSet<>();
    private View activeView;
    private final Stage primaryStage;
    private ScheduledExecutorService updater = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> scheduledFuture;

    private int updaterPeriod = 5;

    public ViewManager(String defaultTitle) {
        primaryStage = new Stage();
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.setTitle(defaultTitle);
    }

    public ViewManager(String defaulTitle, int updaterPeriod) {
        this(defaulTitle);
        this.updaterPeriod = updaterPeriod;
        startUpdating();
    }

    public ViewManager(String defaultTitle, Image icon) {
        this(defaultTitle);
        primaryStage.getIcons().add(icon);
    }

    public ViewManager(String defaultTitle, Image icon, int updaterPeriod) {
        this(defaultTitle, icon);
        this.updaterPeriod = updaterPeriod;
        startUpdating();
    }


    public void addView(View view) throws ExceptionViewAlrdeadyExists {
        if (views.add(view)) {
            view.onCreate();
        } else {
            throw new ExceptionViewAlrdeadyExists(view);
        }
    }

    public Optional<View> getView(Class<? extends View> klazz) {
        for (View v : views) {
            if (v.getClass().equals(klazz)) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }

    public void setActiveView(Class<? extends View> klazz, int width, int height) {
        if (activeView != null) {
            activeView.stop();
        }
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        getView(klazz).ifPresent(view -> {
            view.start();
            activeView = view;
            primaryStage.setScene(view.getScene());
        });
    }

    public void show() {
        primaryStage.show();
    }

    public int getUpdaterPeriod() {
        return updaterPeriod;
    }

    public void setUpdaterPeriod(int updaterPeriod) {
        stopUpdating();
        this.updaterPeriod = updaterPeriod;
        startUpdating();
    }

    private void startUpdating() {
        scheduledFuture = updater.scheduleAtFixedRate(() -> activeView.update(), updaterPeriod, updaterPeriod, TimeUnit.SECONDS);

    }

    private void stopUpdating() {
        scheduledFuture.cancel(true);
    }
}
