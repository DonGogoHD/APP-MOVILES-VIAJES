package com.example.viajes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_third extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewApellido;
    private TextView textViewRUT;
    private TextView textViewCiudadEmbarqueIda;
    private TextView textViewValorPasajeIda;
    private TextView textViewCiudadEmbarqueVuelta;
    private TextView textViewValorPasajeVuelta;
    private TextView textViewTotalNeto;
    private TextView textViewIVA;
    private TextView textViewTotalPagar;
    private Button buttonInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textViewNombre = findViewById(R.id.textViewNombre);
        textViewApellido = findViewById(R.id.textViewApellido);
        textViewRUT = findViewById(R.id.textViewRUT);
        textViewCiudadEmbarqueIda = findViewById(R.id.textViewCiudadEmbarqueIda);
        textViewValorPasajeIda = findViewById(R.id.textViewValorPasajeIda);
        textViewCiudadEmbarqueVuelta = findViewById(R.id.textViewCiudadEmbarqueVuelta);
        textViewValorPasajeVuelta = findViewById(R.id.textViewValorPasajeVuelta);
        textViewTotalNeto = findViewById(R.id.textViewTotalNeto);
        textViewIVA = findViewById(R.id.textViewIVA);
        textViewTotalPagar = findViewById(R.id.textViewTotalPagar);
        buttonInicio = findViewById(R.id.buttonInicio);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("NOMBRE");
        String apellido = intent.getStringExtra("APELLIDO");
        String rut = intent.getStringExtra("RUT");
        String ciudadEmbarqueIda = intent.getStringExtra("CIUDAD_EMBARQUE");
        String valorPasajeIda = intent.getStringExtra("VALOR_PASAJE");
        String ciudadEmbarqueVuelta = intent.getStringExtra("CIUDAD_EMBARQUE2");
        String valorPasajeVuelta = intent.getStringExtra("VALOR_PASAJE2");

        textViewNombre.setText("Nombre: " + nombre);
        textViewApellido.setText("Apellido: " + apellido);
        textViewRUT.setText("RUT: " + rut);
        textViewCiudadEmbarqueIda.setText("Ciudad de embarque (ida): " + ciudadEmbarqueIda);
        textViewValorPasajeIda.setText("Valor pasaje (ida): " + valorPasajeIda);
        textViewCiudadEmbarqueVuelta.setText("Ciudad de embarque (vuelta): " + ciudadEmbarqueVuelta);
        textViewValorPasajeVuelta.setText("Valor pasaje (vuelta): " + valorPasajeVuelta);

        calcularCostos(valorPasajeIda, valorPasajeVuelta);

        buttonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_third.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void calcularCostos(String valorIda, String valorVuelta) {
        try {
            double valorPasajeIda = Double.parseDouble(valorIda);
            double valorPasajeVuelta = Double.parseDouble(valorVuelta);

            double totalNeto = valorPasajeIda + valorPasajeVuelta;
            double iva = totalNeto * 0.19;
            double totalPagar = totalNeto + iva;

            textViewTotalNeto.setText("Total neto: " + (int)totalNeto);
            textViewIVA.setText("IVA (19%): " + (int)iva);
            textViewTotalPagar.setText("Total a pagar (neto + IVA): " + (int)totalPagar);

        } catch (NumberFormatException e) {
            Log.e("activity_third", "Error al parsear los valores de los pasajes", e);
            textViewTotalNeto.setText("Total neto: 0");
            textViewIVA.setText("IVA (19%): 0");
            textViewTotalPagar.setText("Total a pagar (neto + IVA): 0");
        }
    }
}
