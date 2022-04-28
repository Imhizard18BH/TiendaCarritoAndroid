package co.edu.eam.miprimeraapp.fragmentos

import android.graphics.Canvas
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.adapter.ProductoAdapter
import co.edu.eam.miprimeraapp.data.Productos
import co.edu.eam.miprimeraapp.databinding.FragmentListaProductosBinding
import co.edu.eam.miprimeraapp.modelo.Producto
import com.google.android.material.snackbar.Snackbar
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

class ListaProductosFragment : Fragment() {

    lateinit var binding:FragmentListaProductosBinding
    lateinit var adapterProductos:ProductoAdapter
    lateinit var listaProductos:ArrayList<Producto>
    var codigoCategoria: Int = -1
    var esOferta:Boolean = false
    var textoBusqueda:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(arguments!=null){
            codigoCategoria = requireArguments().getInt("categoria-id")
            esOferta = requireArguments().getBoolean("oferta")
            textoBusqueda = requireArguments().getString("busqueda", "")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaProductosBinding.inflate(inflater, container, false)

        /*listaProductos = if(codigoCategoria!=-1){
            Productos.listar(codigoCategoria)
        }else{
            if(esOferta){
                Productos.listarOfertas()
            }else{
                Productos.buscar(textoBusqueda)
            }
        }*/

        adapterProductos = ProductoAdapter(listaProductos)
        binding.listaProductos.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.listaProductos.adapter = adapterProductos

        val simpleCallback: ItemTouchHelper.SimpleCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT /*or ItemTouchHelper.RIGHT*/){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition
                val producto = listaProductos[pos]

                when(direction){
                    ItemTouchHelper.LEFT -> {

                        listaProductos.removeAt(pos)
                        adapterProductos.notifyItemRemoved(pos)

                        Snackbar.make(binding.listaProductos, "${producto.nombre} se ha eliminado!", Snackbar.LENGTH_LONG)
                            .setAction("Deshacer", View.OnClickListener {
                                listaProductos.add(pos, producto)
                                adapterProductos.notifyItemInserted(pos)
                            }).show()

                    }
                    /*ItemTouchHelper.RIGHT -> {
                        Log.e("ListaProductosActivity", "Swipe derecha")
                    }*/
                }
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {

                RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor( ContextCompat.getColor( context!!, R.color.red ) )
                    .addSwipeLeftLabel("Eliminar")
                    .setSwipeLeftLabelColor( ContextCompat.getColor(context!!, R.color.white ) )
                    .setSwipeLeftLabelTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
                    .create()
                    .decorate()

                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }

        }

        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.listaProductos)

        return binding.root
    }

    companion object{

        fun newInstance(codigoCategoria:Int = -1, esOferta:Boolean = false, busqueda:String = ""):ListaProductosFragment{
            var bundle = Bundle()
            bundle.putInt("categoria-id", codigoCategoria)
            bundle.putBoolean("oferta", esOferta)
            bundle.putString("busqueda", busqueda)

            var fragment = ListaProductosFragment()
            fragment.arguments = bundle

            return fragment
        }

    }

}