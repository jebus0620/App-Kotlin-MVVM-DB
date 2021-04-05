
package com.project.bcp.appexchangerate.data.datasource

import com.project.bcp.appexchangerate.data.entity.CurrencyConvertEntity
import com.project.bcp.appexchangerate.data.entity.CurrencyEntity
import com.project.bcp.appexchangerate.domain.model.ResultData

interface CurrencyDataSource {

    suspend fun list() : ResultData<CurrencyEntity>
    suspend fun insert(currencyEntity: List<CurrencyEntity>) : ResultData<String>
    suspend fun insertCurrencyConvert(currencyEntity: List<CurrencyConvertEntity>) : ResultData<String>
    suspend fun getCurrencyConvert(idCurrency: Int, idCurrencyConvert: Int) : ResultData<CurrencyConvertEntity>

}