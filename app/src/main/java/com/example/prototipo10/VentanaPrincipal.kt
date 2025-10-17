package com.example.prototipo10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment // <-- ¡No olvides importar Fragment!
import com.example.prototipo10.databinding.ActivityVentanaPrincipalBinding

class VentanaPrincipal : AppCompatActivity() {
    private lateinit var binding: ActivityVentanaPrincipalBinding // Es mejor práctica hacerlo privado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentanaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar un fragmento por defecto al iniciar
        fragmentos(Subastas())

        binding.menuNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.subastas -> {
                    fragmentos(Subastas())
                    true // Devuelve true si se maneja el evento
                }
                R.id.perfil -> {
                    fragmentos(Perfil())
                    true // Devuelve true si se maneja el evento
                }
                R.id.misSubastas -> {
                    fragmentos(MisSubastas())
                    true // Devuelve true si se maneja el evento
                }
                else -> false // Para cualquier otro caso, devuelve false
            }
        }
    }

    // Asegúrate de que el tipo de Fragment sea de androidx.fragment.app.Fragment
    private fun fragmentos(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}