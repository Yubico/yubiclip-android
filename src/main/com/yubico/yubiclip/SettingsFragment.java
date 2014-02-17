package com.yubico.yubiclip;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import com.yubico.yubiclip.scancode.KeyboardLayout;

import java.util.Set;

/**
 * Created by dain on 2/17/14.
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);

        ListPreference prefLayout = (ListPreference) findPreference("prefLayout");
        Set<String> availableLayouts = KeyboardLayout.availableLayouts();
        CharSequence[] availableLayoutsArr = new CharSequence[availableLayouts.size()];
        int i = 0;
        for(String layout : availableLayouts) {
            availableLayoutsArr[i++] = layout;
        }
        prefLayout.setEntries(availableLayoutsArr);
        prefLayout.setEntryValues(availableLayoutsArr);
    }
}
