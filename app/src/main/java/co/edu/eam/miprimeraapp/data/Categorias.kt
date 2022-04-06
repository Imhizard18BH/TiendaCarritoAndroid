package co.edu.eam.miprimeraapp.data

import co.edu.eam.miprimeraapp.modelo.Categoria

object Categorias {

    private var categorias:ArrayList<Categoria> = ArrayList()

    init {
        categorias.add( Categoria("Tecnología", '\uf390', "") )
        categorias.add( Categoria("Hogar", '\uf236', "") )
        categorias.add( Categoria("Ropa", '\uf553', "") )
        categorias.add( Categoria("Electrodomésticos", '\uf1e6', "") )
        categorias.add( Categoria("Herremientas", '\uf6e3', "") )
        categorias.add( Categoria("Otros", '\uf1b9', "") )
    }

    fun getLista():ArrayList<Categoria>{
        return categorias
    }

    fun agregar(categoria: Categoria){
        categorias.add(categoria)
    }

}