package co.edu.eam.miprimeraapp.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import co.edu.eam.miprimeraapp.adapter.CategoriaAdapter
import co.edu.eam.miprimeraapp.data.Categorias
import co.edu.eam.miprimeraapp.databinding.FragmentInicioBinding
import co.edu.eam.miprimeraapp.modelo.Categoria

class InicioFragment: Fragment() {

    lateinit var binding: FragmentInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)

        val categorias:ArrayList<Categoria> = Categorias.getLista()

        val adapter = CategoriaAdapter(categorias)
        binding.categorias.layoutManager = GridLayoutManager(context, 3)
        binding.categorias.adapter = adapter

        return binding.root
    }

}