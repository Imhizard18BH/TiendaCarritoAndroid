package co.edu.eam.miprimeraapp.data

import co.edu.eam.miprimeraapp.modelo.Categoria
import co.edu.eam.miprimeraapp.modelo.Producto

object Productos {

    private var listaProductos:ArrayList<Producto> = ArrayList()

    init{
        listaProductos.add( Producto("123", 40000f, "Memoria USB 8 GB", "Une espectacular memoria usb marca gato", ArrayList()))
        listaProductos.add( Producto("126", 90000f, "Camiseta Levis", "Camiseta colección 2022", ArrayList()))
        listaProductos.add( Producto("125", 160000f, "Nintendo Switch", "Nintendo 2021", ArrayList()))
        listaProductos.add( Producto("124", 90000f, "Computador ASUS", "Computador con xyz características", ArrayList()))
        listaProductos.add( Producto("127", 160000f, "Nintendo Switch OLED", "Nintendo 2022", ArrayList()))
    }

    fun getLista():ArrayList<Producto>{
        return listaProductos
    }

    fun agregar(producto: Producto){
        listaProductos.add(producto)
    }

    fun eliminar(codigo:String){
        listaProductos.removeIf{ it.codigo == codigo }
    }

    fun buscar(nombre:String):ArrayList<Producto>{

        val lista:ArrayList<Producto> = ArrayList()

        for( prod in listaProductos){
            if( prod.nombre!!.lowercase().contains(nombre.lowercase()) ){
                lista.add(prod)
            }
        }

        return lista
    }

    fun listar(categoria: Categoria){

    }

    fun editar(producto: Producto){

    }
}