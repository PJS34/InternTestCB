package com.example.testcb

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    val myDatas = ProductContainers()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateText = myDatas.findShortestDateByGTIN(111111).toString()
        System.err.println(dateText)

    }


}