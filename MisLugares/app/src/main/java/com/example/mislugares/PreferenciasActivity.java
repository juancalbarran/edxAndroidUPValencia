package com.example.mislugares;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by juan.albarran on 07/22/2016.
 */
public class PreferenciasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenciasFragment())
                .commit();
    }
}
