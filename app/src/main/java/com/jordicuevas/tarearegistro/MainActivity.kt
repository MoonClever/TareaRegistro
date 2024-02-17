package com.jordicuevas.tarearegistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvError = findViewById<TextView>(R.id.tvError)
        var tvWarning = findViewById<TextView>(R.id.tvWarning)
        var etNombre = findViewById<EditText>(R.id.etNombre)
        var etApellido = findViewById<EditText>(R.id.etApellido)
        var etCorreo = findViewById<EditText>(R.id.etcorreo)
        var etPassword = findViewById<EditText>(R.id.etPassword)
        var rgGenero = findViewById<RadioGroup>(R.id.rgGenero)
        var btSend = findViewById<Button>(R.id.btSend)

        btSend.setOnClickListener {
            tvError.text = ""
            tvWarning.text = ""

            var strNombre = etNombre.text
            var strApellido = etApellido.text
            var strCorreo = etCorreo.text
            var strPassword = etPassword.text
            var strGenero = when(rgGenero.checkedRadioButtonId){
                R.id.rbHombre -> "Hombre"
                R.id.rbMujer -> "Mujer"
                else -> "No seleccionado"
            }

            if (TextUtils.isEmpty(strNombre) ||
                TextUtils.isEmpty(strApellido) ||
                TextUtils.isEmpty(strCorreo) ||
                TextUtils.isEmpty(strPassword)){
                tvError.text="Por favor rellene los campos de texto"
            }
            else if(strGenero == "No seleccionado"){
                tvWarning.text = "Por favor seleccione su genero"
            }
            else{
                val sendIntent = Intent(this, ResultActivity::class.java).apply{
                    var user = Usuario(strNombre.toString(), strApellido.toString(), strCorreo.toString(), strGenero, strPassword.toString())
                    putExtra("DATOS_ENVIADOS", user)
                }
                startActivity(sendIntent)
            }
        }

    }
}