package com.project.bcp.appexchangerate.data.mapper

import com.project.bcp.appexchangerate.data.entity.CurrencyEntity
import com.project.bcp.appexchangerate.domain.model.Currency

object CurrencyDataMapper {

   private fun mapperCurrencyEntityToCurrency(currencyEntity: CurrencyEntity) : Currency {
       return Currency(currencyEntity.id, currencyEntity.name, currencyEntity.detail, currencyEntity.description)
   }

    private fun mapperCurrencToCurrencyyEntity(currencyEntity: Currency) : CurrencyEntity {
        return CurrencyEntity(currencyEntity.id, currencyEntity.name, currencyEntity.detail, currencyEntity.description)
    }

    fun mapperCurrencyEntityListToCurrencyList(list: ArrayList<CurrencyEntity>) : ArrayList<Currency>{
        var listNew = ArrayList<Currency>()
        for (entity in list) {
            listNew.add(mapperCurrencyEntityToCurrency(entity))
        }
        return listNew
    }

    fun mapperCurrencyListToCurrencyEntityList(list: ArrayList<Currency>) : ArrayList<CurrencyEntity>{
        var listNew = ArrayList<CurrencyEntity>()
        for (entity in list) {
            listNew.add(mapperCurrencToCurrencyyEntity(entity))
        }
        return listNew
    }

}