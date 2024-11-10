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
        val pesoVal = Integer.parseInt(peso)
        val alturaVal = java.lang.Float.parseFloat(altura)
        val resultado = binding.textViewResultado
        val imc = pesoVal / ((alturaVal * alturaVal)/10000)

        val mensagem = when {
            imc < 18.5 -> "Peso Baixo"
            imc in 18.5..24.9 -> "Peso Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc in 30.0..34.9 -> "Obesidade (Grau I)"
            imc in 35.0..39.9 -> "Obesidade (Grau II)"
            else -> "Obesidade Mórbida"
        }

        imc.toString()
        resultado.setText("$imc \n $mensagem")
    }
}