package com.example.jogorandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText entrada1;
    TextView saida;
    int numgerado = 0;
    int tentativas = 0;
    Random gerador = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        entrada1 = findViewById(R.id.entrada);
        saida = findViewById(R.id.saida);
    }

    public void gerar(View v) {
        tentativas = 0;
        numgerado = gerador.nextInt(100) + 1;
    }

    public void confirmar(View v) {
        if (tentativas > 5) {
            saida.setText("Suas chances se esgotaram :(, O numero misterioso era " + numgerado);

        } else {
            tentativas++;


            int digito = Integer.parseInt(entrada1.getText().toString());
            if (digito > numgerado) {
                saida.setText("O número digitado é maior que o numero misterioso! " + tentativas + " tentativas usadas!");
            } else if (digito < numgerado) {
                saida.setText("O número digitado é menor que o numero misterioso! " + tentativas + " tentativas usadas!");
            } else {

                saida.setText("Parabéns! Você adivinhou o número secreto com " + tentativas + "! ");

            }

        }
    }
}