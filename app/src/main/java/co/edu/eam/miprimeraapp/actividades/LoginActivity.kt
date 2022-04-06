package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.edu.eam.miprimeraapp.R

import co.edu.eam.miprimeraapp.data.Usuarios
import co.edu.eam.miprimeraapp.databinding.ActivityLoginBinding
import co.edu.eam.miprimeraapp.modelo.Usuario

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var usuarios:ArrayList<Usuario>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarios = Usuarios.getLista()
        binding.btnIngresar.setOnClickListener {
            val correo=binding.txtCorreo.text
            val password=binding.txtPassword.text
            if (correo.toString().isNotEmpty()||password.toString().isNotEmpty()){
                validarDatos(correo.toString(),password.toString(),usuarios)
            }
        }
    }

    fun validarDatos(correo:String,password:String,usuarios:ArrayList<Usuario>):Boolean{

        for (cat in usuarios){
            if(cat.correo.equals(correo)&&cat.password.equals(password)){
                Log.v("LoginActivity", "Se inicio sesion correctamente")
                return true
            }
        }
        Log.e("LoginActivity", "No Se pudo iniciar sesion correctamente")
        return false
    }
}