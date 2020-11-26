package com.example.testcb

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    val myDatas = ProductContainers()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FillTableLayout()
    }
    fun FillTableLayout(){
        var table : TableLayout = findViewById(R.id.idTable)
        var row : TableRow //Ligne
        var t1 : TextView//Cellules
        var t2 : TextView
        for((key, value) in myDatas.ProductMap){
            println("$key = $value")
            row = TableRow(this)

            //Left cell
            t1 = TextView(this)
            t1.setText(key.toString())
            t1.setGravity(Gravity.CENTER)
            t1.setLayoutParams(TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1F))

            //right cell
            t2 = TextView(this)
            t2.setText(myDatas.findShortestDateByGTIN(key).toString())
            t2.setGravity(Gravity.CENTER)
            t2.setLayoutParams(TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1F))

            //add cells in a row
            row.addView(t1)
            row.addView(t2)

            //Add row to the table
            table.addView(row)
            println("fin")
        }


    }


}