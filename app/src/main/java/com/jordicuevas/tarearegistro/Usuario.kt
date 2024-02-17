package com.jordicuevas.tarearegistro

import android.text.Editable
import java.io.Serializable

data class Usuario(
    var nombre : String,
    var apellido : String,
    var correo : String,
    var genero : String,
    var password : String
): Serializable
