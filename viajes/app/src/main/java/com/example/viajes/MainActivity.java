package com.example.viajes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextLastname;
    private EditText editTextRUT;
    private EditText editTextDestino;
    private Button buttonEnviar;
    private Button buttonBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextLastname = findViewById(R.id.editTextLastname);
        editTextRUT = findViewById(R.id.editTextRUT);
        editTextDestino = findViewById(R.id.editTextdestino);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonBorrar = findViewById(R.id.buttonBorrar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos();
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarCampos();
            }
        });
    }

    private void enviarDatos() {
        String nombre = editTextUsername.getText().toString().trim();
        String apellido = editTextLastname.getText().toString().trim();
        String rut = editTextRUT.getText().toString().trim();
        String destino = editTextDestino.getText().toString().trim();

        if (TextUtils.isEmpty(nombre)) {
            editTextUsername.setError("Ingresar Nombre.");
            return;
        }

        if (TextUtils.isEmpty(apellido)) {
            editTextLastname.setError("Ingresar Apellido");
            return;
        }

        if (TextUtils.isEmpty(rut)) {
            editTextRUT.setError("Ingresa el RUT");
            return;
        }

        if (TextUtils.isEmpty(destino)) {
            editTextDestino.setError("Ingresa tu destino");
            return;
        }

        Intent intent = new Intent(MainActivity.this, activity_second.class);
        intent.putExtra("NOMBRE", nombre);
        intent.putExtra("APELLIDO", apellido);
        intent.putExtra("RUT", rut);
        intent.putExtra("DESTINO", destino);
        startActivity(intent);
    }

    private void borrarCampos() {
        editTextUsername.setText("");
        editTextLastname.setText("");
        editTextRUT.setText("");
        editTextDestino.setText("");
    }
}
