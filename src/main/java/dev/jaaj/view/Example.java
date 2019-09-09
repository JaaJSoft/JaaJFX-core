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

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;
import javafx.application.Application;
import javafx.stage.Stage;

public class Example extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewManager viewManager = new ViewManager("Oui");
        viewManager.addView("default", new DefaultView(), "Bonjour", viewManager);
        viewManager.addView("default2", new DefaultView(), "Bonjour2", viewManager);
        viewManager.setActiveView("default");
        viewManager.show();
    }

    public static void main(String[] args) {
        String key = "Software\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize"; //AppsUseLightTheme
        int appsUseLightTheme = Advapi32Util.registryGetIntValue(WinReg.HKEY_CURRENT_USER, key, "AppsUseLightTheme");
        System.out.println(appsUseLightTheme);
        //launch(args);
    }
}
