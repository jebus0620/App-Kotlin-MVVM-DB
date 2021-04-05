package com.project.bcp.appexchangerate.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencyconvert")
data class CurrencyConvertEntity(
    @PrimaryKey(autoGenerate = true)  val id: Int,
    @ColumnInfo(name = "idCurrency") val idCurrency: Int?,
    @ColumnInfo(name = "idCurrencyConvert") val idCurrencyConvert: Int?,
    @ColumnInfo(name = "value") val value: Double,
    @ColumnInfo(name = "saleValue") val saleValue: Double,
    @ColumnInfo(name = "currencyText") val currencyText: String?
)