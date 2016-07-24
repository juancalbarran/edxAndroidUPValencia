package com.example.mislugares;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by juan.albarran on 07/22/2016.
 */
public class PreferenciasFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
