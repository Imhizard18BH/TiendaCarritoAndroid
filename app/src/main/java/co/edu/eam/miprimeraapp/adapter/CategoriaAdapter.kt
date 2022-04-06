package co.edu.eam.miprimeraapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.miprimeraapp.actividades.ListaProductosActivity
import co.edu.eam.miprimeraapp.databinding.ItemCategoriaBinding
import co.edu.eam.miprimeraapp.modelo.Categoria

class CategoriaAdapter(var lista:ArrayList<Categoria>): RecyclerView.Adapter<CategoriaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemCategoriaBinding.inflate( LayoutInflater.from(parent.context), parent, false )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCategoria( lista.get(position) )
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder(var view:ItemCategoriaBinding):RecyclerView.ViewHolder(view.root){

        fun bindCategoria(categoria: Categoria){
            view.txtCat.text = categoria.nombre
            view.btnCat.text = ""+categoria.icono
            view.btnCat.setOnClickListener {
                view.btnCat.context.startActivity( Intent(view.btnCat.context, ListaProductosActivity::class.java ) )
            }
        }
    }
}