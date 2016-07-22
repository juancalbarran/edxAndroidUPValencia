package com.example.comunicacionactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button bVerificar;
    private EditText eNombre;
    private TextView tResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = (EditText) findViewById(R.id.editText);
        tResultado = (TextView) findViewById(R.id.resultadoTextView);

        bVerificar = (Button) findViewById(R.id.verificarButton);
        bVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificar(null);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            String res = data.getExtras().getString("resultado");
            tResultado.setText("Resultado: " + res);
        }
    }

    public void verificar(View view) {
        Intent i = new Intent(this, ResultadoActivity.class);
        i.putExtra("nombre", eNombre.getText().toString());
        startActivityForResult(i, 1234);
    }
}
