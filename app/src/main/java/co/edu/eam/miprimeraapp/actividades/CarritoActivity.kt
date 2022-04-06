package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.eam.miprimeraapp.databinding.ActivityCarritoBinding

class CarritoActivity : AppCompatActivity() {

    lateinit var binding:ActivityCarritoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}