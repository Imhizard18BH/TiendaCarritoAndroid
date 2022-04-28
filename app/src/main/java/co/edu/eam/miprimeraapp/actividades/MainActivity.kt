package co.edu.eam.miprimeraapp.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.adapter.CategoriaAdapter
import co.edu.eam.miprimeraapp.adapter.ViewPagerAdapter
import co.edu.eam.miprimeraapp.data.Categorias
import co.edu.eam.miprimeraapp.databinding.ActivityMainBinding
import co.edu.eam.miprimeraapp.fragmentos.BarraSuperiorFragment
import co.edu.eam.miprimeraapp.modelo.Categoria
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var resultLauncher:ActivityResultLauncher<Intent>
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categorias:ArrayList<Categoria> = Categorias.getLista()

        val adapter = CategoriaAdapter(categorias)
        binding.categorias.layoutManager = GridLayoutManager(this, 3)
        binding.categorias.adapter = adapter

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            Log.v("MainActivity", "Llegó información")
            if(it.data!=null){
                Log.v("MainActivity", "${it.data?.extras?.getString("FOTO")}")
            }
        }

        val fragmento=BarraSuperiorFragment()
        val transaccion=supportFragmentManager.beginTransaction()
        transaccion.replace(binding.barraSuperior.id,fragmento)
        transaccion.commit()

      /*  binding.viewPagerMain.adapter = ViewPagerAdapter()
        TabLayoutMediator(binding.tabs,binding.viewPagerMain){tab,pos->
            when(pos){
                0->tab.text="Main"
                1->tab.text="Crear producto"
                2->tab.text="Likes"
                3->tab.text="Carrito"
            }
        }*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_productos, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_agregar -> irACrearProducto()
            R.id.menu_login -> irALogin()
            R.id.menu_registro -> irARegistro()
        }

        return super.onOptionsItemSelected(item)
    }

    fun irARegistro(){
        startActivity( Intent(this, RegistroActivity::class.java) )
    }

    fun irALogin(){
        startActivity( Intent(this, LoginActivity::class.java) )
    }

    fun irACrearProducto(){
        startActivity( Intent(this, CrearProductoActivity::class.java) )
    }

}