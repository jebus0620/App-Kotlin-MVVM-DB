package com.project.bcp.appexchangerate.data.local

import com.project.bcp.appexchangerate.data.dao.CurrencyDao
import com.project.bcp.appexchangerate.data.datasource.CurrencyDataSource
import com.project.bcp.appexchangerate.data.entity.CurrencyEntity
import com.project.bcp.appexchangerate.data.entity.CurrencyConvertEntity
import com.project.bcp.appexchangerate.domain.model.ResultData

class CurrencyLocalDataSource(private val currencyDao: CurrencyDao): CurrencyDataSource {

    override suspend fun list(): ResultData<CurrencyEntity> {

        val resultData = ResultData<CurrencyEntity>()
        val response = currencyDao.getAll()
        if(response == null)  resultData.exception = Exception("ERROR")
        else resultData.dataList = ArrayList(response)
        return resultData
    }

    override suspend fun insert(currencyEntity: List<CurrencyEntity>): ResultData<String> {
        val resultData = ResultData<String>()
        for (currencyEntity in currencyEntity) {
            currencyDao.insertAll(currencyEntity)
        }
        resultData.data = "INSERT_CURRENCY"
        return resultData
    }

    override suspend fun insertCurrencyConvert(list: List<CurrencyConvertEntity>): ResultData<String> {
        val resultData = ResultData<String>()
        for (currencyEntity in list) {
            currencyDao.insertCurrencyConvertAll(currencyEntity)
        }
        resultData.data = "INSERT_CURRENCY_CONVERT"
        return resultData
    }

    override suspend fun getCurrencyConvert(idCurrency: Int, idCurrencyConvert: Int): ResultData<CurrencyConvertEntity> {
        val resultData = ResultData<CurrencyConvertEntity>()
        val response = currencyDao.getCurrencyConvert(idCurrency, idCurrencyConvert)
        if(response == null)  resultData.exception = Exception("ERROR")
        else resultData.data = response
        return resultData
    }

}