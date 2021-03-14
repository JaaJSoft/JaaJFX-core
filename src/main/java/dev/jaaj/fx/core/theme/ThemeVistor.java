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

package dev.jaaj.fx.core.theme;

import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

public class ThemeVistor {
    private final List<Theme> themes = new ArrayList<>();

    public ThemeVistor addTheme(Theme theme) {
        themes.add(theme);
        return this;
    }

    public Theme visit(Scene scene) {
        for (Theme theme : themes) {
            if (theme.canApply(scene)) {
                return theme;
            }
        }
        return new DefaultTheme();
    }
}