package co.edu.eam.miprimeraapp.modelo

class Categoria(var nombre:String, var icono: Char, var color:String) {

    override fun toString(): String {
        return "Categoria(nombre='$nombre', icono='$icono', color='$color')"
    }
}