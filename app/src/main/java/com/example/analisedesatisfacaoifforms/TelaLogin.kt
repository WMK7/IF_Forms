package com.example.analisedesatisfacaoifforms

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.analisedesatisfacaoifforms.databinding.ActivityTelaLoginBinding

class TelaLogin : AppCompatActivity() {
    lateinit var binding: ActivityTelaLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val email =findViewById<EditText>(R.id.editTextEmailLogin)
        val senha =findViewById<EditText>(R.id.editTextSenhaLogin)
        val especEmail = "mk@gmail.com"
        val especSenha = "123456"


        super.onCreate(savedInstanceState)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.voltarLogin.setOnClickListener {
            val intent = Intent(this, TelaCriarContaMainActivity::class.java)
            startActivity(intent)
        }
        binding.textViewSemConta.setOnClickListener {
            val intent = Intent(this, TelaCriarContaMainActivity::class.java)
            startActivity(intent)
        }
        binding.btEntrarLogin.setOnClickListener {

            if(email.text.toString() == especEmail && senha.text.toString() == especSenha){
                val intent = Intent(this, Questionario::class.java)
                startActivity(intent)
            }
        }


    }
}