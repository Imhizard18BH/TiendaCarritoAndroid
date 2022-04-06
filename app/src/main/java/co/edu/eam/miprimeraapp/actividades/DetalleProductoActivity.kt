package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.modelo.Producto

class DetalleProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)

        val codigoP = intent.extras?.getParcelable<Producto>("PRODUCTO")
        Log.e("DetalleProductoActivity", codigoP.toString())
    }
}