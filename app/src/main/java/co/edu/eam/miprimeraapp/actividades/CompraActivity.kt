package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.eam.miprimeraapp.databinding.ActivityCompraBinding

class CompraActivity : AppCompatActivity() {

    lateinit var binding:ActivityCompraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}