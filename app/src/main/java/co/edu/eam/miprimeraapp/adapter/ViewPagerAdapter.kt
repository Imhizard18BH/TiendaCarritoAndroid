package co.edu.eam.miprimeraapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.edu.eam.miprimeraapp.fragmentos.CrearProductoFragment
import co.edu.eam.miprimeraapp.fragmentos.MainFragment

class ViewPagerAdapter(var fragment:FragmentActivity):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int=4

    override fun createFragment(position: Int): Fragment {
        return if(position==0){
             MainFragment();
        }else{
            return CrearProductoFragment()
        }
    }
}