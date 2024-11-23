package com.example.analisedesatisfacaoifforms

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.analisedesatisfacaoifforms.databinding.ActivityGerenciarSalasBinding

class GerenciarSalas : AppCompatActivity() {
    lateinit var binding: ActivityGerenciarSalasBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGerenciarSalasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewVoltarGerarSala.setOnClickListener {
            val intent = Intent(this, TelaLogin::class.java)
            startActivity(intent)
        }

        binding.btCriarSala.setOnClickListener {


        }
    }
}
