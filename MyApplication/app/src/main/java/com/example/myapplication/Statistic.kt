package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.anychart.AnyChart
import com.anychart.AnyChart.pie
import com.anychart.data.Set
import com.anychart.data.View
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry

class Statistic : AppCompatActivity() {

    private lateinit var anyChartView:AnyChartView
    private val result = listOf("Right", "Mistakes")
    private val tipies = listOf(listForWords[1], listForWords[2])

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistic)

        anyChartView = findViewById(R.id.any_chart_view)
        setupPieChart()

        val backmenu = findViewById<Button>(R.id.backmenu)
        backmenu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val clsStat = findViewById<Button>(R.id.clearbutton)
        clsStat.setOnClickListener{
            clsOrNot = true
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupPieChart(){
        val pie = pie()
        val data:MutableList<DataEntry> = mutableListOf()
        for (i in result.indices)
        {
            data.add(i, ValueDataEntry(result[i], tipies[i]))
        }
        pie.data(data)
        anyChartView.setChart(pie)
    }
}