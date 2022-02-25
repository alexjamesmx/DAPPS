package com.example.t201;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btnPrimerEjercicio;
    private Button btnSegundoEjercicio;
    private Button btnTercerEjercicio;
    private Button btnCuartoEjercicio;
    private Button btnQuintoEjercicio;
    private Button btnSextoEjercicio;
    private Button btnSeptimoEjercicio;
    private Button btnOctavoEjercicio;
    private Button btnPractica_2;
    private Button btnPractica_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
              btnPrimerEjercicio = findViewById(R.id.btn_PrimerEjercicio);
              btnSegundoEjercicio = findViewById(R.id.btn_SegundoEjercicio);
              btnTercerEjercicio = findViewById(R.id.btn_TercerEjercicio);
              btnCuartoEjercicio = findViewById(R.id.btn_CuartoEjercicio);
              btnQuintoEjercicio = findViewById(R.id.btn_QuintoEjercicio);
              btnSextoEjercicio = findViewById(R.id.btn_SextoEjercicio);
              btnSeptimoEjercicio = findViewById(R.id.btn_SeptimoEjercicio);
              btnOctavoEjercicio = findViewById(R.id.btn_OctavoEjercicio);
              btnPractica_2 = findViewById(R.id.btn_Practica_2);
              btnPractica_3 = findViewById(R.id.btn_Practica_3);
              btnPrimerEjercicio.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      //Cambiamos el texto
                      btnPrimerEjercicio.setText("Me apachurarron");
                      //Abrir nueva ventana
                      Intent navPrimerEjercicio = new Intent(
                          MenuActivity.this,
                          MainActivity.class
                      );
                      startActivity(navPrimerEjercicio);
                  }
              });
        btnSegundoEjercicio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Abrir nueva ventana
            Intent navSegundoEjercicio = new Intent(
                    MenuActivity.this,
                    LinearLayoutActivity.class
            );
            startActivity(navSegundoEjercicio);
        }
        });
           btnTercerEjercicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Abrir nueva ventana
                    Intent navTercerEjercicio = new Intent(
                            MenuActivity.this,
                           ScrollLayoutActivity.class
                    );
                    startActivity(navTercerEjercicio);
                }
    });
        btnCuartoEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrir nueva ventana
                Intent navCuartoEjercicio = new Intent(
                        MenuActivity.this,
                        Tarjeta_presentacion.class
                );
                startActivity(navCuartoEjercicio);
            }
        });
        btnQuintoEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrir nueva ventana
                Intent navQuintoEjercicio = new Intent(
                        MenuActivity.this,
                       ConstraintLayoutActivity.class
                );
                startActivity(navQuintoEjercicio);
            }
        });
        btnSextoEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrir nueva ventana
                Intent navSextoEjercicio = new Intent(
                        MenuActivity.this,
                       ControlesEntradaActivity.class
                );
                startActivity(navSextoEjercicio);
            }
        });

        btnSeptimoEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(
                                MenuActivity.this,
                                ControlesSeleccionActivity.class
                        )

                );
            }
        });

        btnOctavoEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(
                                MenuActivity.this,
                                TableLayoutActivity.class
                        )

                );
            }
        });

        btnPractica_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(
                                MenuActivity.this,
                                Practica_2_Activity.class
                        )
                );
            }
        });
        btnPractica_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(
                                MenuActivity.this,
                                Practica_3_Activity.class
                        )
                );
            }
        });


    }
}