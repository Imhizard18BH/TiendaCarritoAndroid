package co.edu.eam.miprimeraapp.data

import co.edu.eam.miprimeraapp.modelo.Compra

object Compras {

    private var compras:ArrayList<Compra> = ArrayList()

    init{

    }

    fun getLista():ArrayList<Compra>{
        return compras
    }



}