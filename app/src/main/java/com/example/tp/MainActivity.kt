package com.example.tp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var etNota1: EditText
    lateinit var etNota2: EditText
    lateinit var btnPromedio: Button
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNota1=findViewById(R.id.editNota1)
        btnPromedio=findViewById(R.id.botonPromedio)
        btnPromedio.setOnClickListener {
            var numero1 = etNota1.text.toString()
            var numero2 = etNota2.text.toString()

            var promedio = (numero1.toInt() + numero2.toInt()) / 2

            resultado.text=promedio.toString()
            // Toast.makeText(this, "EL Promedio $numero1 y $numero2 es $promedio", Toast.LENGTH_LONG).show()
        }



    }
}