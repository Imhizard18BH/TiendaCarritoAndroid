package co.edu.eam.miprimeraapp.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.databinding.FragmentComprasBinding

class ComprasFragment : Fragment() {

    lateinit var binding:FragmentComprasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComprasBinding.inflate(inflater, container, false)


        return binding.root
    }

}