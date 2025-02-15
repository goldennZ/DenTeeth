package br.edu.puccampinas.denteeth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import br.edu.puccampinas.denteeth.databinding.ActivityTelaPrincipalBinding
import br.edu.puccampinas.denteeth.emergencia.EmergenciaFragment

class TelaPrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(ListaEmergenciasFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_emergencia -> {
                    replaceFragment(ListaEmergenciasFragment())
                    true
                }
                R.id.item_perfil -> {
                    replaceFragment(Second2Fragment())
                    true
                }
                R.id.item_reputacao -> {
                    replaceFragment(ThirdFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun replaceFragment (fragment: Fragment) {
        val fragmentSupportManager = supportFragmentManager
        val fragmentTransaction = fragmentSupportManager.beginTransaction()
        fragmentTransaction.replace(R.id.flFragment, fragment)
        fragmentTransaction.commit()
    }
}