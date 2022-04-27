package co.edu.eam.miprimeraapp.actividades

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.edu.eam.miprimeraapp.data.Usuarios
import co.edu.eam.miprimeraapp.databinding.ActivityLoginBinding
import co.edu.eam.miprimeraapp.databinding.ActivityOlvidasteContrasenaBinding
import co.edu.eam.miprimeraapp.modelo.Usuario

class OlvidasteContrasena: AppCompatActivity() {
    lateinit var binding: ActivityOlvidasteContrasenaBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOlvidasteContrasenaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener {
            val correo=binding.txtCorreo.text
            if (correo.toString().isNotEmpty()){
                Toast.makeText(this,"Se ha enviado contraseña de recuperación", Toast.LENGTH_LONG).show()
            }
        }

    }
}