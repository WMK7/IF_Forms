package com.example.analisedesatisfacaoifforms

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.analisedesatisfacaoifforms.databinding.ActivityTelaSalaCoferenciaBinding

class TelaSalaCoferencia : AppCompatActivity() {
    lateinit var binding: ActivityTelaSalaCoferenciaBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTelaSalaCoferenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sala1A = binding.txt1A
        val sala1B = binding.txt1B
        val sala2A = binding.txt2A
        val sala2B = binding.txt2B
        val sala3 = binding.txt3
        val voltar = binding.imageViewVoltarSala

        voltar.setOnClickListener {
            val intent = Intent(this, TelaLogin::class.java)
            startActivity(intent)
        }

        sala1A.setOnClickListener {
            val intent = Intent(this, Questionario::class.java)
            startActivity(intent)
        }

        sala1B.setOnClickListener {
            val intent = Intent(this, Questionario::class.java)
            startActivity(intent)
        }

        sala2A.setOnClickListener {
            val intent = Intent(this, Questionario::class.java)
            startActivity(intent)
        }

        sala2B.setOnClickListener {
            val intent = Intent(this, Questionario::class.java)
            startActivity(intent)
        }

        sala3.setOnClickListener {
            val intent = Intent(this, Questionario::class.java)
            startActivity(intent)
        }



    }
}