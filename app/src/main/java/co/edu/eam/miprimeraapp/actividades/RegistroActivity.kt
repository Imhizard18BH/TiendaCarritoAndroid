package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.databinding.ActivityRegistroBinding
import co.edu.eam.miprimeraapp.modelo.Usuario
import co.edu.eam.miprimeraapp.util.Utilidades

class RegistroActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtLayoutCedula.isErrorEnabled = true
        binding.txtLayoutNombre.isErrorEnabled = true
        binding.txtLayoutCorreo.isErrorEnabled = true
        binding.txtLayoutPassword.isErrorEnabled = true

        binding.btnRegistro.setOnClickListener {

            val cedula = binding.txtCedula.text.toString()
            val nombre = binding.txtNombre.text.toString()
            val correo = binding.txtCorreo.text.toString()
            val password = binding.txtPassword.text.toString()
            var valido = true

            if(cedula.isEmpty()){
                valido = false
                binding.txtLayoutCedula.error = "Es un campo obligatorio"
            }else{
                binding.txtLayoutCedula.error = null
            }

            if(nombre.isEmpty()){
                valido = false
                binding.txtLayoutNombre.error = "Es un campo obligatorio"
            }else{
                binding.txtLayoutNombre.error = null
            }

            if(correo.isEmpty()){
                valido = false
                binding.txtLayoutCorreo.error = "Es un campo obligatorio"
            }else{
                binding.txtLayoutCorreo.error = null
            }

            if(password.isEmpty()){
                valido = false
                binding.txtLayoutPassword.error = "Es un campo obligatorio"
            }else{
                binding.txtLayoutPassword.error = null
            }

            if(valido){
                val usario = Usuario(cedula, nombre, correo, password)
                //Guarda en un bd o se envía a un servicio de negocio
                Utilidades.mostrarMensaje(this, "Se creó el usuario")
            }
        }

    }
}