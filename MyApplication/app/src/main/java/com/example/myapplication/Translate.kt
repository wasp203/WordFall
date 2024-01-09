package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

class Translate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)

        val message = intent.getStringExtra("KNOWLES_WORD")
        val translateText = intent.getStringExtra("TRANSLATION_WORD")

        val textView = findViewById<TextView>(R.id.word_for_translate).apply {
            text = message
        }

        val textView2 = findViewById<TextView>(R.id.translation).apply {
            text = translateText
        }

        val nextword = findViewById<Button>(R.id.next_word)
        nextword.setOnClickListener {
            val intent = Intent(this, ForWordsActivity::class.java)
            startActivity(intent)
        }
    }
}