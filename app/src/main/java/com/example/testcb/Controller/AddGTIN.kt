package com.example.testcb.Controller

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.testcb.Modele.ProductContainers
import com.example.testcb.R
import java.time.LocalDate


class addGTIN : AppCompatActivity() {
    var myDatas: ProductContainers? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_g_t_i_n)
        val i = intent
        myDatas = i.getSerializableExtra("myDatas") as ProductContainers
        val buttonNEW : Button = findViewById(R.id.buttonNew)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addnewEntry(view: View){

        val textViewGTIN : EditText = findViewById(R.id.EditTextGTIN)
        val Datepick : DatePicker = findViewById(R.id.datePicker1)

        val GTIN : String = textViewGTIN.text.toString()
        val date : LocalDate = LocalDate.of(Datepick.year,Datepick.month,Datepick.dayOfMonth)

        myDatas?.addnewEntry(GTIN.toInt(),date)

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("myDatas",myDatas)
        startActivity(intent)
    }


}