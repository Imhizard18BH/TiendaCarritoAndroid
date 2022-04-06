package co.edu.eam.miprimeraapp.util

import android.content.Context
import android.widget.Toast

object Utilidades {

    fun mostrarMensaje(context:Context, texto:String){
        Toast.makeText(context, texto, Toast.LENGTH_LONG).show()
    }

}