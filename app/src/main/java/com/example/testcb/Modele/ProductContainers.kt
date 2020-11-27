package com.example.testcb.Modele

import android.annotation.SuppressLint
import java.time.LocalDate
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import java.io.Serializable
@SuppressLint("NewApi")

public class ProductContainers : Serializable  {
    var ProductMap : HashMap<Int,ArrayList<LocalDate>>

    init {
        ProductMap = HashMap<Int,ArrayList<LocalDate>>()
        val ExpiryDate1 = arrayListOf(
            LocalDate.of(2018, 11, 5),
            LocalDate.of(2018, 11, 3),
            LocalDate.of(2018, 11, 2)

        )
        val ExpiryDate2 = arrayListOf(
            LocalDate.of(2018, 6, 10),
            LocalDate.of(2018, 6, 6)
        )
        val ExpiryDate3 = arrayListOf(
            LocalDate.of(2018, 12, 31),
            LocalDate.of(2018, 12, 4),
            LocalDate.of(2018, 12, 1)

        )
        ProductMap[111111] = ExpiryDate1
        ProductMap[222222] = ExpiryDate2
        ProductMap[333333] = ExpiryDate3
    }

    fun addProduct(GTIN : Int,ExpiryDates : ArrayList<LocalDate>){
        ProductMap.put(GTIN,ExpiryDates)
    }
    fun findShortestDateByGTIN(GTIN:Int) : LocalDate? {
       return ProductMap.get(GTIN)?.min()
    }

    fun addnewEntry(GTIN: Int,date : LocalDate?){
        if (ProductMap.containsKey(GTIN)){
            if (date != null) {
                ProductMap[GTIN]?.add(date)
            }
        }else{
            createNewEntry(GTIN,date)
        }
    }
    fun createNewEntry(GTIN: Int,date: LocalDate?){
        var dateArray : ArrayList<LocalDate> = ArrayList<LocalDate>()
        if (date != null) {
            dateArray.add(date)
        }
        ProductMap.put(GTIN,dateArray)
    }


}