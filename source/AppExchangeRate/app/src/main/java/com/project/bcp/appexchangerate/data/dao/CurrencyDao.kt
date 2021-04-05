package com.project.bcp.appexchangerate.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.bcp.appexchangerate.data.entity.CurrencyEntity
import com.project.bcp.appexchangerate.data.entity.CurrencyConvertEntity
import com.project.bcp.appexchangerate.data.entity.UpdateDataEntity

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currency")
    fun getAll(): List<CurrencyEntity>

    @Insert
    fun insertCurrencyConvertAll(vararg currencyConvertEntity: CurrencyConvertEntity)

    @Insert
    fun insertAll(vararg currencyEntity: CurrencyEntity)

    @Query("DELETE FROM currency")
    fun deleteAll()

    @Query("SELECT * FROM CurrencyConvert WHERE idCurrency = :idCurrency AND idCurrencyConvert = :idCurrencyConvert")
    fun getCurrencyConvert(idCurrency: Int, idCurrencyConvert: Int): CurrencyConvertEntity

    @Query("SELECT * FROM currencyconvert")
    fun getCurrencyConvertAll(): List<CurrencyConvertEntity>

/*
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

 */
}
