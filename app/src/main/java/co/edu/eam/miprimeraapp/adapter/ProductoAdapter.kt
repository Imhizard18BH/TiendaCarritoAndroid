package co.edu.eam.miprimeraapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.actividades.DetalleProductoActivity
import co.edu.eam.miprimeraapp.databinding.ItemProductoBinding
import co.edu.eam.miprimeraapp.modelo.Producto

class ProductoAdapter(var lista:ArrayList<Producto>): RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductoBinding.inflate( LayoutInflater.from(parent.context), parent, false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProducto(lista[position])
    }

    override fun getItemCount(): Int =  lista.size

    inner class ViewHolder(private var view:ItemProductoBinding):RecyclerView.ViewHolder(view.root), View.OnClickListener{

        init{
            view.root.setOnClickListener(this)
        }

        fun bindProducto(producto:Producto){
            view.tituloProducto.text = producto.nombre
            view.precioProducto.text = producto.precio.toString()
        }

        override fun onClick(p0: View?) {
            itemView.context.startActivity( Intent( itemView.context, DetalleProductoActivity::class.java ) )
        }

    }
}