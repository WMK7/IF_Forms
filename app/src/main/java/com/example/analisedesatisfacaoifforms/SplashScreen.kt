package com.example.analisedesatisfacaoifforms

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        window.statusBarColor= Color.parseColor("#FFFFFF")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Questionario::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}