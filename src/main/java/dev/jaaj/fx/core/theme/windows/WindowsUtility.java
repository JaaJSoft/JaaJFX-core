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

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

public class WindowsUtility {

    public static boolean isWindows10() {
        String os = System.getProperty("os.name");
        return os.equalsIgnoreCase("windows 10");
    }

    public static WindowsTheme getWindowsTheme() {
        String key = "Software\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize";
        int appsUseLightTheme = Advapi32Util.registryGetIntValue(WinReg.HKEY_CURRENT_USER, key, "AppsUseLightTheme");
        if (appsUseLightTheme == 0) {
            return WindowsTheme.DARK;
        } else {
            return WindowsTheme.LIGHT;
        }
    }
}
