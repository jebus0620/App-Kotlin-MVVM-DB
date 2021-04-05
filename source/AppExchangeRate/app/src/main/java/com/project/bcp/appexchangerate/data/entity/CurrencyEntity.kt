package com.project.bcp.appexchangerate.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "detail") val detail: String?,
    @ColumnInfo(name = "description") val description: String?
)