package com.example.prototipo10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botonRegistro = findViewById<Button>(R.id.botonRegistrate)

        botonRegistro.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }

        val botonIniciarSesion = findViewById<Button>(R.id.botonIniciarSesion)
        botonIniciarSesion.setOnClickListener {
            val intent = Intent(this, VentanaPrincipal::class.java)
            startActivity(intent)
        }
    }
}
