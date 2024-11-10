package com.itsmenicky.imc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itsmenicky.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_calc = binding.btnCalcular
        val resultado = binding.textViewResultado

        btn_calc.setOnClickListener{
            val peso = binding.editTxtPeso.text.toString()
            val altura = binding.editTxtAltura.text.toString()

            if(peso.isEmpty()){
                resultado.setText("Informe seu peso!")
            }else if(altura.isEmpty()){
                resultado.setText("Informe sua altura!")
            }else{
                calculaIMC(peso, altura)
            }
        }
    }
    private fun calculaIMC(peso:String, altura:String){
        val peso = Integer.parseInt(peso)
        val altura = Integer.parseInt(altura)
        val resultado = binding.textViewResultado
        val imc = peso / (altura * altura)

        val mensagem = when{
            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade (Grau I)"
            imc <= 39.9 -> "Obesidade (Grau II)"
            else -> "Obesidade Mórbida"
        }

        imc.toString()
        resultado.setText("$imc \n $mensagem")
    }
}