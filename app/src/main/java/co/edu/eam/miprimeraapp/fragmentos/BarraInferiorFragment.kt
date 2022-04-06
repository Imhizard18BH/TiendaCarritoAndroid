package co.edu.eam.miprimeraapp.fragmentos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.actividades.*
import co.edu.eam.miprimeraapp.databinding.FragmentBarraInferiorBinding
import co.edu.eam.miprimeraapp.databinding.FragmentBarraSuperiorBinding


class BarraInferiorFragment : Fragment() {

    lateinit var binding: FragmentBarraInferiorBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("BarraSuperiorFragment", "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBarraInferiorBinding.inflate(inflater, container, false)

        Log.v("BarraInfeiorFragment", "onCreateView()")

        /*binding.textoBusqueda.setOnEditorActionListener { textView, i, keyEvent ->
            if( i == EditorInfo.IME_ACTION_SEARCH ){
                irABusqueda()
            }
            true
        }*/

        binding.btnHome.setOnClickListener {
            startActivity( Intent(context, MainActivity::class.java) )
        }
        binding.btnNuevoProducto.setOnClickListener{
            startActivity(Intent(context,CrearProductoActivity::class.java))
        }
        binding.btnLikes.setOnClickListener{
            startActivity(Intent(context,ListaProductosActivity::class.java))
        }
        binding.btnCarrito.setOnClickListener{
            startActivity(Intent(context,CarritoActivity::class.java))
        }

        return binding.root
    }
/*
    fun irABusqueda(){
        val criterio = binding.textoBusqueda.text.toString()

        if(criterio.isNotEmpty()){
            val intent = Intent(context, ResultadoBusquedaActivity::class.java)
            intent.putExtra("criterio", criterio)
            startActivity(intent)
        }

    }*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v("BarraInferiorFragment", "onAttach()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("BarraInferiorFragment", "onDetach()")
    }

}