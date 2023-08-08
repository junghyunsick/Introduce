package com.example.introduce

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var textViewUsername: TextView
    private lateinit var textViewInfo: TextView // 이름, 나이, MBTI 정보를 표시할 TextView
    private lateinit var buttonExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)

        textViewUsername = findViewById(R.id.textViewUsername)
        textViewInfo = findViewById(R.id.textViewInfo) // XML 레이아웃에 추가한 TextView 연결
        buttonExit = findViewById(R.id.buttonExit)

        val intent = intent
        val username = intent.getStringExtra("username")
        username?.let {
            textViewUsername.text = "$username 님,"
        }

        // 추가된 부분: 이름, 나이, MBTI 정보 설정 및 표시
        val name = "정현식"
        val age = "27"
        val mbti = "ISTP"
        val infoText = "이름: $name\n나이: $age\nMBTI: $mbti"
        textViewInfo.text = infoText

        buttonExit.setOnClickListener {
            val signInIntent = Intent(this@HomeActivity, SignInActivity::class.java)
            startActivity(signInIntent)
            finish()
        }
    }
}
