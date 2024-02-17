package com.jordicuevas.tarearegistro

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvApellido = findViewById<TextView>(R.id.tvApellido)
        val tvCorreo = findViewById<TextView>(R.id.tvCorreo)
        val tvGenero = findViewById<TextView>(R.id.tvGenero)
        val tvPassword = findViewById<TextView>(R.id.tvPassword)


        val usuario = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("DATOS_ENVIADOS", Usuario::class.java)
        }else {
            intent.getSerializableExtra("DATOS_ENVIADOS") as Usuario
        }

        if (usuario != null) {
            tvNombre.text = "Nombre:   ${usuario.nombre}"
            tvApellido.text = "Apellido:   ${usuario.apellido}"
            tvCorreo.text = "Correo:   ${usuario.correo}"
            tvGenero.text = "Genero:   ${usuario.genero}"
            tvPassword.text = "Contraseña:   ${usuario.password}"
        }
        else {
            tvNombre.text = "Error al enviar los datos"
            tvNombre.text = "Error al enviar los datos"
            tvNombre.text = "Error al enviar los datos"
            tvNombre.text = "Error al enviar los datos"
            tvNombre.text = "Error al enviar los datos"
        }



    }
}