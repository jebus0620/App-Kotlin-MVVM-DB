package com.project.bcp.appexchangerate.di

import android.content.Context
import androidx.room.Room
import com.project.bcp.appexchangerate.data.AppDatabase
import com.project.bcp.appexchangerate.data.datasource.UpdateDataDataSource
import com.project.bcp.appexchangerate.data.local.CurrencyLocalDataSource
import com.project.bcp.appexchangerate.data.local.UpdateDataLocalDataSource
import com.project.bcp.appexchangerate.data.repository.CurrencyRepository
import com.project.bcp.appexchangerate.data.repository.UpdateDataRepository
import com.project.bcp.appexchangerate.domain.usecase.*

object Injector {

    fun currencyUseCase(context: Context) : GetCurrencysUseCase {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name").build()
        val dataSource = CurrencyLocalDataSource(db.currencyDao())
        val repository = CurrencyRepository(dataSource)
        return GetCurrencysUseCase(repository)
    }

    fun insertCurrencysUseCase(context: Context) : InsertCurrencysUseCase {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name").build()
        val dataSource = CurrencyLocalDataSource(db.currencyDao())
        val repository = CurrencyRepository(dataSource)
        return InsertCurrencysUseCase(repository)
    }

    fun insertCurrencysConvertUseCase(context: Context) : InsertCurrencyConvertUseCase {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name").build()
        val dataSource = CurrencyLocalDataSource(db.currencyDao())
        val repository = CurrencyRepository(dataSource)
        return InsertCurrencyConvertUseCase(repository)
    }

    fun currencyConvertUseCase(context: Context) : GetCurrencyConvertUseCase {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name").build()
        val dataSource = CurrencyLocalDataSource(db.currencyDao())
        val repository = CurrencyRepository(dataSource)
        return GetCurrencyConvertUseCase(repository)
    }

    fun insertUpdateDataUseCase(context: Context) : InsertUpdateDataUseCase {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name").build()
        val dataSource = UpdateDataLocalDataSource(db.updateDataDao())
        val repository = UpdateDataRepository(dataSource)
        return InsertUpdateDataUseCase(repository)
    }

    fun getUpdateDatatUseCase(context: Context) : GetUpdateDataUseCase {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name").build()
        val dataSource = UpdateDataLocalDataSource(db.updateDataDao())
        val repository = UpdateDataRepository(dataSource)
        return GetUpdateDataUseCase(repository)
    }

}