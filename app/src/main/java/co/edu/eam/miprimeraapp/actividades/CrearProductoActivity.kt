package co.edu.eam.miprimeraapp.actividades

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.children
import co.edu.eam.miprimeraapp.data.Categorias
import co.edu.eam.miprimeraapp.data.Productos
import co.edu.eam.miprimeraapp.databinding.ActivityCrearProductoBinding
import co.edu.eam.miprimeraapp.modelo.Categoria
import co.edu.eam.miprimeraapp.modelo.Producto
import com.google.android.material.chip.Chip

class CrearProductoActivity : AppCompatActivity() {

    lateinit var binding:ActivityCrearProductoBinding
    lateinit var categorias:ArrayList<Categoria>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCrearProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categorias = Categorias.getLista()

        for( cat in categorias ){
            var chip = Chip(this)
            chip.text = cat.nombre
            chip.isCheckable = true
            binding.categoriasProducto.addView( chip )
        }


        val opciones = arrayListOf("Sin descuento", "Con descuento")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.seleccionDescuento.adapter = adapter

        binding.seleccionDescuento.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                binding.txtDescuento.isEnabled = pos == 1
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }
        }

        binding.btnCrearProducto.setOnClickListener {
            val nombre = binding.txtNombre.text
            val precio = binding.txtPrecio.text
            val descuento = binding.txtDescuento.text
            val descripcion = binding.txtDescripcion.text

            val lista = binding.categoriasProducto.checkedChipIds

            if( nombre.toString().isNotEmpty() && precio.toString().isNotEmpty() && descripcion.toString().isNotEmpty() && lista.size > 0 ) {

                val producto = Producto(
                    "C1",
                    precio.toString().toFloat(),
                    nombre.toString(),
                    descripcion.toString(),
                    ArrayList()
                )

                producto.descuento = descuento.toString().toFloat()
                producto.categorias = lista.map { e -> categorias.get(e-1) }

                Productos.agregar(producto)
            }

        }

    }

    fun crearListaCategorias( enteros:List<Int> ):ArrayList<Categoria>{
        val lista:ArrayList<Categoria> = ArrayList()

        for( en in enteros){
            lista.add( categorias.get(en-1) )
        }

        return lista
    }

}