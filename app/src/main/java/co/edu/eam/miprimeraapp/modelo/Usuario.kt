package co.edu.eam.miprimeraapp.modelo

class Usuario(var cedula:String, var nombre:String, var correo:String, var password:String) {

    override fun toString(): String {
        return "Usuario(cedula='$cedula', nombre='$nombre', correo='$correo', password='$password')"
    }
}