package co.edu.eam.miprimeraapp.data

import co.edu.eam.miprimeraapp.modelo.Producto

object Carrito {

    private var lista:ArrayList<Producto> = ArrayList()

    fun obtener():ArrayList<Producto>{
        return lista
    }

    fun agregar(producto: Producto){
        lista.add(producto)
    }

    fun limpiar(){
        lista.clear()
    }

}