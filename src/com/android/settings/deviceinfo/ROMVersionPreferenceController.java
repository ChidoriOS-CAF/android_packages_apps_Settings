/*
 * Copyright (C) 2018 The ChidoriOS Project
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
package com.android.settings.deviceinfo;
import android.content.Context;
import android.os.SystemProperties;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.text.TextUtils;
import com.android.settings.R;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;
public class ROMVersionPreferenceController extends AbstractPreferenceController implements
    PreferenceControllerMixin {
    private static final String PROPERTY_CHIDORI_VERSION = "ro.modversion";
    private static final String KEY_CHIDORI_VERSION = "modversion";
     public ROMVersionPreferenceController(Context context) {
        super(context);
    }
     @Override
    public boolean isAvailable() {
        return !TextUtils.isEmpty(SystemProperties.get(PROPERTY_CHIDORI_VERSION));
    }
     @Override
    public String getPreferenceKey() {
        return KEY_CHIDORI_VERSION;
    }
     @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final Preference pref = screen.findPreference(KEY_CHIDORI_VERSION);
        if (pref == null) return;
        String version = SystemProperties.get(PROPERTY_CHIDORI_VERSION);
        pref.setSummary(version);
    }
}
