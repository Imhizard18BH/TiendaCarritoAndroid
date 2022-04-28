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
import co.edu.eam.miprimeraapp.databinding.FragmentBarraSuperiorLoginBinding


class BarraSuperiorFragmentLogin : Fragment() {

    lateinit var binding: FragmentBarraSuperiorLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("BarraSuperiorFragment", "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBarraSuperiorLoginBinding.inflate(inflater, container, false)

        Log.v("BarraSuperiorLoginFragment", "onCreateView()")

        return binding.root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v("BarraSuperiorFragment", "onAttach()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("BarraSuperiorFragment", "onDetach()")
    }

}