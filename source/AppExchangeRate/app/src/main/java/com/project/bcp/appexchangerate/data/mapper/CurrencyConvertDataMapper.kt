package com.project.bcp.appexchangerate.data.mapper

import com.project.bcp.appexchangerate.data.entity.CurrencyConvertEntity
import com.project.bcp.appexchangerate.data.entity.CurrencyEntity
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert

object CurrencyConvertDataMapper {
    fun mapperCurrencyConvertEntityToCurrencyConvert(currencyConvertEntity: CurrencyConvertEntity) : CurrencyConvert {
       return CurrencyConvert(
           currencyConvertEntity.id,
           currencyConvertEntity.idCurrency,
           currencyConvertEntity.idCurrencyConvert,
           currencyConvertEntity.value,
           currencyConvertEntity.saleValue,
           currencyConvertEntity.currencyText)
   }

    private fun mapperCurrencyConvertToCurrencyConvertEntity(currencyConvert: CurrencyConvert) : CurrencyConvertEntity {
        return CurrencyConvertEntity(currencyConvert.id,
            currencyConvert.idCurrency,
            currencyConvert.idCurrencyConvert,
            currencyConvert.value,
            currencyConvert.saleValue,
            currencyConvert.currencyText)
    }

    fun mapperCurrencyConvertEntityListToCurrencyConvertList(list: ArrayList<CurrencyConvertEntity>) : ArrayList<CurrencyConvert>{
        var listNew = ArrayList<CurrencyConvert>()
        for (entity in list) {
            listNew.add(mapperCurrencyConvertEntityToCurrencyConvert(entity))
        }
        return listNew
    }

    fun mapperCurrencyListToCurrencyEntityList(list: ArrayList<CurrencyConvert>) : ArrayList<CurrencyConvertEntity>{
        var listNew = ArrayList<CurrencyConvertEntity>()
        for (entity in list) {
            listNew.add(mapperCurrencyConvertToCurrencyConvertEntity(entity))
        }
        return listNew
    }

}