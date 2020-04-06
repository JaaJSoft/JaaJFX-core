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

package dev.jaaj.fx.theme;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;
import javafx.stage.Stage;

public class Windows10DarkTheme implements Theme {
    @Override
    public boolean canApply(Stage stage) {
        String os = System.getProperty("os.name");
        if (!os.toLowerCase().equals("windows 10")) {
            return false;
        }
        String key = "Software\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize";
        int appsUseLightTheme = Advapi32Util.registryGetIntValue(WinReg.HKEY_CURRENT_USER, key, "AppsUseLightTheme");
        return appsUseLightTheme == 0;
    }

    @Override
    public void applyTheme(Stage scene) {

    }
}
