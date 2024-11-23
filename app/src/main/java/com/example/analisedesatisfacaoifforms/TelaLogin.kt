package com.example.analisedesatisfacaoifforms

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.analisedesatisfacaoifforms.databinding.ActivityTelaLoginBinding

class TelaLogin : AppCompatActivity() {
    lateinit var binding: ActivityTelaLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = findViewById<EditText>(R.id.editTextEmailLogin)
        val senha = findViewById<EditText>(R.id.editTextSenhaLogin)


        // texto não tenho conta retorna para tela de criar conta
        binding.voltarLogin.setOnClickListener {
            val intent = Intent(this, TelaCriarContaMainActivity::class.java)
            startActivity(intent)
        }

        //textView retorna para tela de criar conta
        binding.textViewSemConta.setOnClickListener {
            val intent = Intent(this, TelaCriarContaMainActivity::class.java)
            startActivity(intent)
        }

        //botao entrar direciona para proxima tela
        binding.btEntrarLogin.setOnClickListener {

            val email = binding.editTextEmailLogin.text.toString()
            val senha = binding.editTextSenhaLogin.text.toString()

            when {
                email == "mk@gmail.com" && senha == "123456" -> {
                    val intent = Intent(this, TelaSalaCoferencia::class.java)
                    startActivity(intent)
                }
                email == "admin" && senha == "123456" -> {
                    val intent = Intent(this, GerenciarSalas::class.java)
                    startActivity(intent)
                }
                else -> {
                    Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }//onCreat
}//class