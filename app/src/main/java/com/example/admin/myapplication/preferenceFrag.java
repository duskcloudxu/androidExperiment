package com.example.admin.myapplication;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.widget.Toast;

/**
 * Created by admin on 2017/12/19.
 */

public class preferenceFrag extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preference);
        Preference.OnPreferenceChangeListener checkListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString() == "true")
                    Toast.makeText(getActivity(), preference.getTitle() + ":on", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(getActivity(), preference.getTitle() + ":off", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        };
        Preference.OnPreferenceChangeListener listChangeListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Toast.makeText(getActivity(), preference.getTitle() + "has been set as:"+newValue.toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        };
        CheckBoxPreference c1 = (CheckBoxPreference) findPreference("isFlying");
        CheckBoxPreference c2 = (CheckBoxPreference) findPreference("noMute");
        SwitchPreference c3 = (SwitchPreference) findPreference("openChineseInput");
        c1.setOnPreferenceChangeListener(checkListener);
        c2.setOnPreferenceChangeListener(checkListener);
        c3.setOnPreferenceChangeListener(checkListener);
        ListPreference l1=(ListPreference)findPreference("language");
        ListPreference l2=(ListPreference) findPreference("netAgent");
        l1.setOnPreferenceChangeListener(listChangeListener);
        l2.setOnPreferenceChangeListener(listChangeListener);

    }
}
