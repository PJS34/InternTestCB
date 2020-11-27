package com.example.testcb.Modele

import android.annotation.SuppressLint
import java.time.LocalDate
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@SuppressLint("NewApi")
class ProductContainers {
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

}