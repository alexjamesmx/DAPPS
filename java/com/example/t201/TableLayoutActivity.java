package com.example.t201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TableLayoutActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private TextView calculadoraDisplay;
    private Button btnAC, btnDot, btnxmenos1, btnIgual, btnMenos, btnSuma, btnPorcentaje, btnMultiplicar, btnDivision;
    private double num1, num2;
    private boolean enOperacion = false, enOperacionMultiplicar = false, enOperacionx1 = false;

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
        btnPorcentaje = findViewById(R.id.btn_porcentaje);
        btnMultiplicar = findViewById(R.id.btn_Multiplicar);
        btnDivision = findViewById(R.id.btn_Division);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //BOTON DE PORCENTAJE
        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPantalla = calculadoraDisplay.getText().toString();
                double numeroDisplay = Double.parseDouble(textoPantalla);
                double resultado = numeroDisplay / 100;
                calculadoraDisplay.setText(String.valueOf(resultado));
            }
        });

        //BOTON PUNTO DECIMAL
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

        //BOTTON AC BORRAR TODO
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculadoraDisplay.setText("0");
                num1 = 0;
                num2 = 0;
            }
        });

        //BOTON POR -1
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
                enOperacion = true;
            }
        });

//BOTON OPERACION MENOS
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!enOperacion) {
                    //TOMAMOS EL TEXTO DE LA PANTALLA
                    String textoPantalla = calculadoraDisplay.getText().toString();
                    //CONVERTIMOS EL TEXTO A NUMERO
                    double numeroDisplay = Double.parseDouble(textoPantalla);
                    if (num1 == 0) {
                        if(num2 != 0){
                            num1 = 0;
                            num2 = numeroDisplay;
                        }
                       else{
                            num1 = numeroDisplay;
                        } // 10  10 - 0 = 10  10 - 4 = 6    10-2= 8
                    } else {
                        num2 = numeroDisplay; // 4           4
                    }
                    double resultado = num1 - num2;
                    num1 = resultado;
                    calculadoraDisplay.setText(String.valueOf(resultado));
                    enOperacion = true;
                }
            }
        });

//BOTON OPERACION SUMA
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!enOperacion) {
                    //TOMAMOS EL TEXTO DE LA PANTALLA
                    String textoPantalla = calculadoraDisplay.getText().toString();
                    //CONVERTIMOS EL TEXTO A NUMERO
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
            }
        });

        //BOTON OPERACION MULTIPLICAR
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!enOperacion) {
                    //TOMAMOS EL TEXTO DE LA PANTALLA
                    String textoPantalla = calculadoraDisplay.getText().toString();
                    //CONVERTIMOS EL TEXTO A NUMERO
                    double numeroDisplay = Double.parseDouble(textoPantalla);
                    if (num1 == 0) {
                        num1 = numeroDisplay;
                        num2 = 1;
                    } else if (num1 != 0) {
                        num2 = numeroDisplay;
                    }
                    double resultado = num1 * num2;
                    calculadoraDisplay.setText(String.valueOf(resultado));
                    enOperacion = true;
                }
            }
        });

        //BOTON OPERACION DIVISION
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!enOperacion) {
                    //TOMAMOS EL TEXTO DE LA PANTALLA
                    String textoPantalla = calculadoraDisplay.getText().toString();
                    //CONVERTIMOS EL TEXTO A NUMERO
                    double numeroDisplay = Double.parseDouble(textoPantalla);
                    if (num1 == 0) {
                        num1 = numeroDisplay;
                        num2 = 1;
                    } else if (num1 != 0) {
                        num2 = numeroDisplay;
                    }
                    double resultado = num1 / num2;
                    calculadoraDisplay.setText(String.valueOf(resultado));
                    enOperacion = true;
                }
            }
        });


        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public void clickBoton(View boton) {
        Button botonSeleccionado = (Button) boton;
        String textoBoton = botonSeleccionado.getText().toString();
        String textoPantalla = calculadoraDisplay.getText().toString();
        //SI NO ESTA EN OPERACION BORRAMOS EL CERO INICIAL Y CONCATENAMOS VALORES
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
//SI SE ENCUENTRA EN OPERACION BORRAMOS EL VALOR UNA VEZ Y DESPUES CONCATENAMOS VALORES SI SE DESEA
        if (enOperacion) {
            calculadoraDisplay.setText("");
            num1 = Double.parseDouble(textoPantalla);
            textoPantalla = calculadoraDisplay.getText().toString();
            textoPantalla += textoBoton;
            calculadoraDisplay.setText(textoPantalla);
            enOperacion = false;
        }

        if (enOperacionMultiplicar) {
            num1 = Double.parseDouble(textoPantalla);
            textoPantalla = calculadoraDisplay.getText().toString();
            textoPantalla += textoBoton;
            calculadoraDisplay.setText(textoPantalla);
            enOperacionMultiplicar = false;
        }


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //METODO FINISH REGERESA A PANTALLA ANTERIOR
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}