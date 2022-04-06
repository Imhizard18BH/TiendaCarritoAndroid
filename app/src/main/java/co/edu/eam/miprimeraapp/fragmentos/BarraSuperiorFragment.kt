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
import co.edu.eam.miprimeraapp.actividades.CarritoActivity
import co.edu.eam.miprimeraapp.actividades.LoginActivity
import co.edu.eam.miprimeraapp.actividades.MainActivity
import co.edu.eam.miprimeraapp.actividades.ResultadoBusquedaActivity
import co.edu.eam.miprimeraapp.databinding.FragmentBarraSuperiorBinding


class BarraSuperiorFragment : Fragment() {

    lateinit var binding: FragmentBarraSuperiorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("BarraSuperiorFragment", "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBarraSuperiorBinding.inflate(inflater, container, false)

        Log.v("BarraSuperiorFragment", "onCreateView()")

        /*binding.textoBusqueda.setOnEditorActionListener { textView, i, keyEvent ->
            if( i == EditorInfo.IME_ACTION_SEARCH ){
                irABusqueda()
            }
            true
        }*/

        binding.btnHome.setOnClickListener {
            startActivity( Intent(context, MainActivity::class.java) )
        }
        binding.btnLogin.setOnClickListener{
            startActivity(Intent(context,LoginActivity::class.java))
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
        Log.v("BarraSuperiorFragment", "onAttach()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("BarraSuperiorFragment", "onDetach()")
    }

}