package org.example.permisosenmarshmallow;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private View vista;
    private static final int SOLICITUD_PERMISO_WRITE_CALL_LOG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vista = findViewById(R.id.content_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrarLlamada();
            }
        });
    }

    private void borrarLlamada() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {

            getContentResolver().delete(CallLog.Calls.CONTENT_URI,
                    "number='555555555'", null);
            Snackbar.make(vista, "Llamadas borradas del registro.",
                    Snackbar.LENGTH_SHORT).show();
        }else {solicitarPermisoBorrarLlamada();}
    }

    void solicitarPermisoBorrarLlamada() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_CALL_LOG)) {
            Snackbar.make(vista, "Sin el permiso administrar llamadas no puedo"
                    +" borrar llamadas del registro.", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{ Manifest.permission. WRITE_CALL_LOG},
                                    SOLICITUD_PERMISO_WRITE_CALL_LOG);
                        }
                    })
                    .show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_CALL_LOG},
                    SOLICITUD_PERMISO_WRITE_CALL_LOG);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        if (requestCode == SOLICITUD_PERMISO_WRITE_CALL_LOG) {
            if (grantResults.length== 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                borrarLlamada();
            } else {
                Snackbar.make(vista, "Sin el permiso, no puedo realizar la" +
                        "acción", Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}
