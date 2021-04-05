package com.project.bcp.appexchangerate.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.bcp.appexchangerate.data.dao.CurrencyDao
import com.project.bcp.appexchangerate.data.dao.UpdateDataDao
import com.project.bcp.appexchangerate.data.entity.CurrencyConvertEntity
import com.project.bcp.appexchangerate.data.entity.CurrencyEntity
import com.project.bcp.appexchangerate.data.entity.UpdateDataEntity

@Database(entities = [CurrencyEntity::class, CurrencyConvertEntity::class, UpdateDataEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun updateDataDao(): UpdateDataDao
}