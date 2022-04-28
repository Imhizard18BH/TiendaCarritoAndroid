package co.edu.eam.miprimeraapp.fragmentos

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import co.edu.eam.miprimeraapp.data.Productos
import co.edu.eam.miprimeraapp.databinding.FragmentDetalleProductoBinding
import co.edu.eam.miprimeraapp.modelo.Producto
import co.edu.eam.miprimeraapp.util.Utilidades
import java.util.*

class DetalleProductoFragment : Fragment() {

    var producto:Producto? = null
    lateinit var binding:FragmentDetalleProductoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(arguments != null){
            val codigoProducto = requireArguments().getString("producto-id", "")
           // producto = Productos.obtener(codigoProducto)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleProductoBinding.inflate(inflater, container, false)

        /*if(producto!=null){
            binding.nombreProducto.text = producto!!.nombre
            binding.precioProducto.text = Utilidades.formatearDinero(producto!!.precio)

            if(producto!!.descuento > 0){
                binding.precioProducto.paintFlags = binding.precioProducto.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

                binding.descuentoProducto.text = ""+producto!!.descuento*100
                binding.descuentoProducto.isVisible = true

                val nuevoPrecio = producto!!.calcularNuevoPrecio()
                binding.nuevoPrecioProducto.text = Utilidades.formatearDinero(nuevoPrecio)
                binding.nuevoPrecioProducto.isVisible = true
            }

            binding.descProducto.text = producto!!.descripcion
        }*/

        return binding.root
    }

    companion object{

        fun newInstance(codigoProducto:String):DetalleProductoFragment{
            var args = Bundle()
            args.putString("producto-id", codigoProducto)
            val fragment = DetalleProductoFragment()
            fragment.arguments = args

            return fragment
        }

    }

}