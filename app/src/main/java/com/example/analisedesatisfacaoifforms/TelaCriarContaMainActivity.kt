package com.example.analisedesatisfacaoifforms

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.analisedesatisfacaoifforms.databinding.TelaCriarContaMainBinding

class TelaCriarContaMainActivity : AppCompatActivity() {
    private lateinit var  binding: TelaCriarContaMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaCriarContaMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtJaPossuoConta.setOnClickListener {
            val intent = Intent(this, TelaLogin::class.java)
            startActivity(intent)
        }
    }
}