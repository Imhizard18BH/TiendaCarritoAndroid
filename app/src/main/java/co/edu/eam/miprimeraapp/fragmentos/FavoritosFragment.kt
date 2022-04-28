package co.edu.eam.miprimeraapp.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.edu.eam.miprimeraapp.databinding.FragmentFavoritosBinding

class FavoritosFragment: Fragment() {

    lateinit var binding:FragmentFavoritosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritosBinding.inflate(inflater, container, false)

        return binding.root
    }


}