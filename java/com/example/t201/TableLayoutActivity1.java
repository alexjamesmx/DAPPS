package com.example.t201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TableLayoutActivity1 extends AppCompatActivity {
    private ActionBar actionBar;
    private TextView calculadoraDisplay;
    private Button btnAC;
    private Button btnDot;
    private Button btnxmenos1;
    private Button btnIgual, btnMenos, btnSuma;
    private double num1, num2;
    private boolean enOperacion = false, seBorroenOperacion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        calculadoraDisplay = findViewById(R.id.calculadora_display);
        btnAC = findViewById(R.id.btn_AC);
        btnDot = findViewById(R.id.btn_Dot);
        btnxmenos1 = findViewById(R.id.btn_xmenos1);
        btnIgual = findViewById(R.id.btn_igual);
        btnMenos = findViewById(R.id.btn_Menos);
        btnSuma = findViewById(R.id.btn_Suma);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = 0;
                StringBuilder textoPantalla = new StringBuilder(calculadoraDisplay.getText().toString());
                for (int i = 0; i < textoPantalla.length(); i++) {
                    if (textoPantalla.charAt(i) == '.') {
                        x = 1;
                    }
                }
                if (x != 1) {
                    textoPantalla.append('.');
                    calculadoraDisplay.setText(textoPantalla);
                }
            }
        });

        //BOTTON AC
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = calculadoraDisplay.getText().toString();
                if(!enOperacion) {
                    calculadoraDisplay.setText("0");
                    num1 = 0;
                    num2 = 0;
                }
                else{
                    seBorroenOperacion = true;
                    calculadoraDisplay.setText("0");
                }
            }
        });

        btnxmenos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = calculadoraDisplay.getText().toString();
                double numeroDisplay = Double.parseDouble(textoPantalla);

                if (num1 == 0) {
                    num1 = numeroDisplay;
                } else {
                    num2 = numeroDisplay;
                }

                numeroDisplay = numeroDisplay * -1;
                calculadoraDisplay.setText(String.valueOf(numeroDisplay));


            }
        });

//BOTON OPERACION MENOS
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  TOMAMOS VALOR DE LO ESCRITO
                if(!enOperacion) {
                    String textoPantalla = calculadoraDisplay.getText().toString();
                    //CONVERTIMOS EL VALOR A NUMERO
                    double numeroDisplay = Double.parseDouble(textoPantalla);
                    if (num1 == 0) {
                        num1 = numeroDisplay;
                    } else {
                        num2 = numeroDisplay;
                    }
                    double resultado = num1 + num2;
                    calculadoraDisplay.setText(String.valueOf(resultado));
                    enOperacion = true;
                }
                else{
                    if(!seBorroenOperacion){
                        String textoPantalla = calculadoraDisplay.getText().toString();
                        //CONVERTIMOS EL VALOR A NUMERO

                        num2 = Double.parseDouble(textoPantalla);
                        double resultado = num1 + num2;
                        calculadoraDisplay.setText(String.valueOf(resultado));
                        enOperacion = true;
                    }
                    else{
                        double resultado = num1 + num2;
                        calculadoraDisplay.setText(String.valueOf(resultado));
                        enOperacion = true;
                    }

                }
            }
        });


        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //METODO FINISH REGERESA A PANTALLA ANTERIOR
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickBoton(View boton) {
        Button botonSeleccionado = (Button) boton;
        String textoBoton = botonSeleccionado.getText().toString();
        String textoPantalla = calculadoraDisplay.getText().toString();

        if (!enOperacion) {
            if (textoPantalla.startsWith("0")) {
                calculadoraDisplay.setText("");
                textoPantalla = calculadoraDisplay.getText().toString();
                textoPantalla += textoBoton;
                calculadoraDisplay.setText(textoPantalla);
            } else {
                textoPantalla += textoBoton;
                calculadoraDisplay.setText(textoPantalla);
            }
        }

        if (enOperacion) {
                calculadoraDisplay.setText("");
                num1 = Double.parseDouble(textoPantalla);
                textoPantalla = calculadoraDisplay.getText().toString();
                textoPantalla += textoBoton;
                calculadoraDisplay.setText(textoPantalla);
                enOperacion = false;

        }
    }

//CLICK BOTTON AC

//CLICK BOTTON MAS


}