package co.edu.eam.miprimeraapp.actividades

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.adapter.ProductoAdapter
import co.edu.eam.miprimeraapp.data.Productos
import co.edu.eam.miprimeraapp.databinding.ActivityListaProductosBinding
import co.edu.eam.miprimeraapp.modelo.Producto
import com.google.android.material.snackbar.Snackbar
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

class ListaProductosActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaProductosBinding
    lateinit var listaProductos:ArrayList<Producto>
    lateinit var adapterProductos:ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListaProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val codigoCategoria = intent.extras?.getInt("categoria")
        Toast.makeText(this, "La categoría seleccionada es: $codigoCategoria", Toast.LENGTH_LONG).show()

        listaProductos = Productos.getLista()

        adapterProductos = ProductoAdapter(listaProductos)
        binding.listaProductos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.listaProductos.adapter = adapterProductos

        val simpleCallback:ItemTouchHelper.SimpleCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT /*or ItemTouchHelper.RIGHT*/){
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
                    .addSwipeLeftBackgroundColor( ContextCompat.getColor( baseContext, R.color.red ) )
                    .addSwipeLeftLabel("Eliminar")
                    .setSwipeLeftLabelColor( ContextCompat.getColor(baseContext, R.color.white ) )
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


    }
}