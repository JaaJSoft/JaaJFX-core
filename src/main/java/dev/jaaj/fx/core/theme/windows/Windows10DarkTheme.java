/*
 * Copyright 2021 JaaJSoft
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

package dev.jaaj.fx.core.theme.windows;

import dev.jaaj.fx.core.theme.Theme;
import javafx.scene.Scene;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import static dev.jaaj.fx.core.theme.windows.WindowsUtility.isWindows10;

public class Windows10DarkTheme implements Theme {
    @Override
    public boolean canApply() {
        if (isWindows10()) {
            return WindowsUtility.getWindowsTheme().equals(WindowsTheme.DARK);
        }
        return false;
    }

    @Override
    public void applyTheme(Scene scene) {
        new JMetro(scene, Style.DARK);
    }

    @Override
    public String getPrettyName() {
        return "Windows 10 Dark";
    }
}
