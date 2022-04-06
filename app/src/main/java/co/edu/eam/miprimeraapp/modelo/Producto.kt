package co.edu.eam.miprimeraapp.modelo

import android.os.Parcel
import android.os.Parcelable

class Producto (var codigo:String?, var precio:Float, var nombre:String?, var descripcion:String?, var imagenes:ArrayList<String>?): Parcelable{

    var descuento:Float = 0f
    var categorias:List<Categoria> = ArrayList()

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()
    ) {
        descuento = parcel.readFloat()
    }

    override fun toString(): String {
        return "Producto(codigo='$codigo', precio=$precio, nombre='$nombre', descripcion='$descripcion', imagenes=$imagenes, descuento=$descuento)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(codigo)
        parcel.writeFloat(precio)
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeStringList(imagenes)
        parcel.writeFloat(descuento)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }


}