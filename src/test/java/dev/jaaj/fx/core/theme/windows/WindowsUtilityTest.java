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

import org.junit.Test;

import static org.junit.Assert.*;

public class WindowsUtilityTest {

    @Test
    public void getWindowsTheme() {
        if (WindowsUtility.isWindows10()) {
            assertEquals(WindowsTheme.DARK, WindowsUtility.getWindowsTheme());
            assertNotEquals(WindowsTheme.LIGHT, WindowsUtility.getWindowsTheme());
        }
    }

    @Test
    public void isWindows10() {
        if (WindowsUtility.isWindows10()) {
            assertTrue(WindowsUtility.isWindows10());
        }
    }
}
