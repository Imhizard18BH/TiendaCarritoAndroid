package co.edu.eam.miprimeraapp.data

import co.edu.eam.miprimeraapp.modelo.Usuario

object Usuarios {

    private var usuarios:ArrayList<Usuario> = ArrayList()

    init{
        usuarios.add(Usuario("1","Juan","juan@hotmail.com","123"))
    }

    fun getLista():ArrayList<Usuario>{
        return usuarios
    }
    fun agregar(usuario: Usuario){
     usuarios.add(usuario)
    }
}