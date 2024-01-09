package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
var clsOrNot:Boolean = false
class MainActivity : AppCompatActivity() {

    lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shared = getSharedPreferences("CoinsDB", Context.MODE_PRIVATE)
        if (clsOrNot)
        {
            val edit = shared.edit()
            listForWords[1] = 0
            listForWords[2] = 0
            edit.putInt("TRIES_ANSW", listForWords[1])
            edit.putInt("TRIES_MIST", listForWords[2])
            edit.apply()
            clsOrNot = false
        }
        else{
            if (listForWords[1] > 0 || listForWords[2] > 0) {
                val edit = shared.edit()
                edit.putInt("TRIES_ANSW", listForWords[1])
                edit.putInt("TRIES_MIST", listForWords[2])
                edit.apply()
            }
            else {
                listForWords[1] = shared.getInt("TRIES_ANSW", 0)
                listForWords[2] = shared.getInt("TRIES_MIST", 0)
            }
        }

        val button = findViewById<Button>(R.id.btnTofk)
        button.setOnClickListener {
            callActivity()
        }

        val buttonStat = findViewById<ImageButton>(R.id.imageStats)
        buttonStat.setOnClickListener {
            callActivity2()
        }
    }

    private fun callActivity2() {
        val intent2 = Intent(this, Statistic::class.java)
        startActivity(intent2)
    }

    private fun callActivity() {
        val intent = Intent(this, ForWordsActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        shared = getSharedPreferences("CoinsDB", Context.MODE_PRIVATE)
        if (listForWords[1] > 0 || listForWords[2] > 0) {
            val edit = shared.edit()
            edit.putInt("TRIES_ANSW", listForWords[1])
            edit.putInt("TRIES_MIST", listForWords[2])
            edit.apply()
        } else {
            listForWords[1] = shared.getInt("TRIES_ANSW", 0)
            listForWords[2] = shared.getInt("TRIES_MIST", 0)
        }
    }

}
