package com.example.introduce

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var textViewUsername: TextView
    private lateinit var buttonExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)

        textViewUsername = findViewById(R.id.textViewUsername)
        buttonExit = findViewById(R.id.buttonExit)

        val intent = intent
        val username = intent.getStringExtra("username")
        username?.let {
            textViewUsername.text = "$username 님,"
        }

        buttonExit.setOnClickListener {
            val signInIntent = Intent(this@HomeActivity, SignInActivity::class.java)
            startActivity(signInIntent)
            finish()
        }
    }
}
