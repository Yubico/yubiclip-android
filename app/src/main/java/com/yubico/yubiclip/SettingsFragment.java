package com.yubico.yubiclip;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import com.yubico.yubiclip.scancode.KeyboardLayout;

import java.util.Set;

/**
 * Created by dain on 2/17/14.
 */
public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(this);

        ListPreference prefLayout = (ListPreference) findPreference(getString(R.string.pref_layout));
        Set<String> availableLayouts = KeyboardLayout.availableLayouts();
        CharSequence[] availableLayoutsArr = new CharSequence[availableLayouts.size()];
        int i = 0;
        for(String layout : availableLayouts) {
            availableLayoutsArr[i++] = layout;
        }
        prefLayout.setEntries(availableLayoutsArr);
        prefLayout.setEntryValues(availableLayoutsArr);

        updateClearSummary();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updateClearSummary();
    }

    private void updateClearSummary() {
        ListPreference pref = (ListPreference) findPreference(getString(R.string.pref_timeout));
        pref.setSummary(pref.getEntry() + ".");
    }
}
