package co.edu.eam.miprimeraapp.modelo

import java.util.*

class Comentario (var comentario:String, var fecha: Date, var ProductoID:String,var idUsuario:String,var id:Int){
    override fun toString(): String {
        return "Comentario(co='$comentario', fecha='$fecha', proID='$ProductoID', idUser='$idUsuario', id='$id')"
    }
}