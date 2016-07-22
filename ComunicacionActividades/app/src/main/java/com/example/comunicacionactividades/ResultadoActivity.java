package com.example.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by juan.albarran on 07/21/2016.
 */
public class ResultadoActivity extends Activity {

    private TextView tNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        tNombre = (TextView) findViewById(R.id.nombreTextView);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        tNombre.setText("Hola " + nombre + " ¿Aceptas las condiciones?");
    }

    public void devolver(View view) {
        Intent i = new Intent(this, MainActivity.class);
        String respuesta;
        if (view.getId() == R.id.aceptarButton)
            respuesta = "Aceptado";
        else
            respuesta = "Rechazado";
        i.putExtra("resultado", respuesta);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}
