package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var listForWords = IntArray(3)
class ForWordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.for_words)
        getWord()
        val knowword = findViewById<Button>(R.id.iknowword)
        knowword.setOnClickListener {
            listForWords[1] += 1
            getWord()
        }
        val main_menu = findViewById<Button>(R.id.buttonformenu)
        main_menu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun sendWordToTranslate(trans: String) {
        val editText = findViewById<TextView>(R.id.just_word)
        val message = editText.text.toString()
        Intent(this, Translate::class.java).also {
            it.putExtra("KNOWLES_WORD", message)
            it.putExtra("TRANSLATION_WORD", trans)
            startActivity(it)
        }
    }


    private fun getWord() {
        val inputString = """
        Hello;həˈloʊ;Привет
        Goodbye;ˌɡʊdˈbaɪ;Пока
        Friend;frɛnd;Друг
        Family;ˈfæməli;Семья
        Love;lʌv;Любовь
        Happiness;ˈhæpɪnɪs;Счастье
        Sadness;ˈsædnɪs;Грусть
        Peace;pis;Мир
        Nature;ˈneɪtʃər;Природа
        Ocean;ˈoʊʃən;Океан
        Mountain;ˈmaʊntən;Гора
        Sun;sʌn;Солнце
        Moon;mun;Луна
        Star;stɑr;Звезда
        Sky;skaɪ;Небо
        Rain;reɪn;Дождь
        Snow;snoʊ;Снег
        Wind;wɪnd;Ветер
        Fire;faɪr;Огонь
        Earth;ɜrθ;Земля
        Tree;tri;Дерево
        Flower;ˈflaʊər;Цветок
        Book;bʊk;Книга
        Music;ˈmjuːzɪk;Музыка
        Art;ɑrt;Искусство
        Science;ˈsaɪəns;Наука
        Technology;tekˈnɒlədʒi;Технология
        Happy;ˈhæpi;Счастливый
        Sad;sæd;Грустный
        Butterfly;[ˈbʌtərflaɪ];Бабочка
        Adventure;[ədˈvɛnʧər];Приключение
        Courage;[ˈkɜːrɪdʒ];Смелость
        Dream;[driːm];Мечта
        Journey;[ˈdʒɜːrni];Путешествие
        Explore;[ɪkˈsplɔːr];Исследовать
        Laughter;[ˈlæftər];Смех
        Whisper;[ˈwɪspər];Шепот
        Harmony;[ˈhɑːrməni];Гармония
        Serenity;[səˈrɛnəti];Безмятежность
        Enigma;[ɪˈnɪɡmə];Загадка
        Sparkle;[ˈspɑːrkəl];Блеск
        Wonder;[ˈwʌndər];Удивление
        Reflection;[rɪˈflɛkʃən];Отражение
        Symphony;[ˈsɪmfəni];Симфония
        Illuminate;[ɪˈluːmɪneɪt];Просветлять
        Tranquil;[ˈtræŋkwɪl];Спокойный
        Echo;[ˈɛkoʊ];Эхо
        Radiant;[ˈreɪdiənt];Сияющий
        Essence;[ˈɛsəns];Сущность
    """.trimIndent()

        val wordsList: MutableList<String> = inputString.split("\n").map { it.trim() }.toMutableList()
        val randomLine = wordsList.shuffled().firstOrNull()

        val ourWord: List<String> = randomLine!!.split(';')
        findViewById<TextView>(R.id.just_word).apply {
            text = ourWord[0]
        }
        findViewById<TextView>(R.id.textView2).apply {
            text = ourWord[1]
        }
        val button = findViewById<Button>(R.id.idontknowbutton)
        button.setOnClickListener {
            listForWords[2] += 1
            sendWordToTranslate(ourWord[2])
        }
    }
}
