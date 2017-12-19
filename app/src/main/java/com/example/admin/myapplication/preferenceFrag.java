package com.example.admin.myapplication;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by admin on 2017/12/19.
 */

public class preferenceFrag extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preference);
    }
}
