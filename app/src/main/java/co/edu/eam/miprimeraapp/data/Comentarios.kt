package co.edu.eam.miprimeraapp.data

import co.edu.eam.miprimeraapp.modelo.Comentario
import java.util.*
import kotlin.collections.ArrayList

object Comentarios {

    private var lista:ArrayList<Comentario> = ArrayList()

    init {

        lista.add( Comentario("Buen producto", Date(), "126", "112", 4) )
        lista.add( Comentario("Mal producto", Date(), "126", "112", 1) )
        lista.add( Comentario("Regular producto", Date(), "126", "234", 2) )
        lista.add( Comentario("Buen producto xd", Date(), "126", "565", 4) )
        lista.add( Comentario("Buen producto xd", Date(), "125", "565", 4) )

    }

    fun crear(comentario: Comentario){
        lista.add(comentario)
    }

    fun obtener(productoID: String):ArrayList<Comentario>{
        return lista.filter { c -> c.ProductoID == productoID }.toCollection(ArrayList())
    }
}