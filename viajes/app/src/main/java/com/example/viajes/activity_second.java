package com.example.viajes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_second extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewApellido;
    private TextView textViewRUT;
    private TextView textViewDestino;
    private EditText editTextNombreLineaAerea;
    private EditText editTextCiudadEmbarque;
    private EditText editTextValorPasaje;
    private EditText editTextCiudadEmbarque2;
    private EditText editTextValorPasaje2;
    private Button buttonBack;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewNombre = findViewById(R.id.textViewNombre);
        textViewApellido = findViewById(R.id.textViewApellido);
        textViewRUT = findViewById(R.id.textViewRUT);
        textViewDestino = findViewById(R.id.textViewdestino);
        editTextNombreLineaAerea = findViewById(R.id.editTextNombrelineaerea);
        editTextCiudadEmbarque = findViewById(R.id.editTextCiudadembarque);
        editTextValorPasaje = findViewById(R.id.editTextValorpasaje);
        editTextCiudadEmbarque2 = findViewById(R.id.editTextCiudadembarque2);
        editTextValorPasaje2 = findViewById(R.id.editTextValorpasaje2);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNext = findViewById(R.id.buttonNext);

        //DATOS PANTALLA 1
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("NOMBRE");
        String apellido = intent.getStringExtra("APELLIDO");
        String rut = intent.getStringExtra("RUT");
        String destino = intent.getStringExtra("DESTINO");

        //MOSTRANDO DATOS 1
        textViewNombre.setText("Nombre: " + nombre);
        textViewApellido.setText("Apellido: " + apellido);
        textViewRUT.setText("RUT: " + rut);
        textViewDestino.setText("Destino de viaje: " + destino);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreLineaAerea = editTextNombreLineaAerea.getText().toString().trim();
                String ciudadEmbarque = editTextCiudadEmbarque.getText().toString().trim();
                String valorPasaje = editTextValorPasaje.getText().toString().trim();
                String ciudadEmbarque2 = editTextCiudadEmbarque2.getText().toString().trim();
                String valorPasaje2 = editTextValorPasaje2.getText().toString().trim();

                boolean isValid = true;
                if (nombreLineaAerea.isEmpty()) {
                    editTextNombreLineaAerea.setError("Ingresa el nombre de la linea aerea");
                    isValid = false;
                }
                if (ciudadEmbarque.isEmpty()) {
                    editTextCiudadEmbarque.setError("Ingresa ciudad de embarque (ida)");
                    isValid = false;
                }
                if (valorPasaje.isEmpty()) {
                    editTextValorPasaje.setError("Ingresa el valor del pasaje (ida)");
                    isValid = false;
                }
                if (ciudadEmbarque2.isEmpty()) {
                    editTextCiudadEmbarque2.setError("Ingresa ciudad de embarque (vuelta)");
                    isValid = false;
                }
                if (valorPasaje2.isEmpty()) {
                    editTextValorPasaje2.setError("Ingresa el valor del pasaje (vuelta)");
                    isValid = false;
                }

                if (isValid) {

                    Intent intent = new Intent(activity_second.this, activity_third.class);
                    intent.putExtra("NOMBRE", nombre);
                    intent.putExtra("APELLIDO", apellido);
                    intent.putExtra("RUT", rut);
                    intent.putExtra("NOMBRE_LINEA_AEREA", nombreLineaAerea);
                    intent.putExtra("CIUDAD_EMBARQUE", ciudadEmbarque);
                    intent.putExtra("VALOR_PASAJE", valorPasaje);
                    intent.putExtra("CIUDAD_EMBARQUE2", ciudadEmbarque2);
                    intent.putExtra("VALOR_PASAJE2", valorPasaje2);
                    startActivity(intent);
                }
            }
        });
    }
}
