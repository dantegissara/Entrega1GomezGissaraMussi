package com.example.tp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    private lateinit var etUsuario: EditText
    private lateinit var etPassword: EditText
    private  lateinit var cbRecordar: CheckBox
    private lateinit var btnRegistrar: Button
    private lateinit var btnIniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        saludarUsuario()

        etUsuario= findViewById(R.id.etUsuario)
        etPassword=findViewById(R.id.etPass)
        cbRecordar=findViewById(R.id.cbRecordar)
        btnIniciar=findViewById(R.id.botonIniciar)
        btnRegistrar=findViewById(R.id.botonRegistrar)

        btnRegistrar.setOnClickListener{
            val crear = Intent(this, crearUsuario::class.java)
            //intentMain.putExtra("nombre", nombreUsuario)
            startActivity(crear)
            finish()
        }

        btnIniciar.setOnClickListener{
            var mensaje = "Iniciar Sesion"
            var nombreUsuario= etUsuario.text.toString()

            if(nombreUsuario.isEmpty() || etPassword.text.toString().isEmpty()){
                mensaje+= "- Faltan Datos"


            }else{
                mensaje+= " - Datos OK"
                if(cbRecordar.isChecked)
                    mensaje+= "- Recordar Usuario"

                val intentMain = Intent(this, MainActivity::class.java)
                intentMain.putExtra("nombre", nombreUsuario)
                startActivity(intentMain)
                finish()
            }

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
        }

    }

    private fun saludarUsuario() {
        var bundle: Bundle? = intent.extras
        if(bundle != null){
            var usuario = bundle?.getString("nombre")
            Toast.makeText(this, "Bienvenido/a $usuario", Toast.LENGTH_LONG).show()
        }
    }
}
