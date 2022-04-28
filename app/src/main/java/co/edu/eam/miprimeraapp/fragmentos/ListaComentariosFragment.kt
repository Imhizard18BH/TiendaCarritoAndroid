package co.edu.eam.miprimeraapp.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.data.Comentarios
import co.edu.eam.miprimeraapp.databinding.FragmentListaComentariosBinding
import co.edu.eam.miprimeraapp.modelo.Comentario


class ListaComentariosFragment : Fragment() {

    lateinit var binding: FragmentListaComentariosBinding
    var listaComentarios:ArrayList<Comentario> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(arguments!=null){
            val codigoProducto = requireArguments().getString("producto-id")
            listaComentarios = Comentarios.obtener(codigoProducto!!)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaComentariosBinding.inflate(inflater, container, false)

        binding.comentariosP.text = listaComentarios.toString()

        return binding.root
    }

    companion object{

        fun newInstance(codigoProducto:String): ListaComentariosFragment{
            val args = Bundle()
            args.putString("producto-id", codigoProducto)

            val fragment = ListaComentariosFragment()
            fragment.arguments = args

            return fragment
        }

    }

}