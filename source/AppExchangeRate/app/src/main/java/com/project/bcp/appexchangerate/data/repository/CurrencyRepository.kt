package com.project.bcp.appexchangerate.data.repository

import com.project.bcp.appexchangerate.data.datasource.CurrencyDataSource
import com.project.bcp.appexchangerate.data.mapper.CurrencyConvertDataMapper
import com.project.bcp.appexchangerate.data.mapper.CurrencyDataMapper
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert
import com.project.bcp.appexchangerate.domain.model.ResultData

class CurrencyRepository(private val dataSource: CurrencyDataSource) {

    suspend fun listCurrencys(): ResultData<Currency> {

        var resultData = ResultData<Currency>()
        var resultResponse = dataSource.list()
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {

            }
            ResultData.SUCCESSLIST -> {
                resultData.dataList = resultResponse.dataList?.let {
                    CurrencyDataMapper.mapperCurrencyEntityListToCurrencyList(it)
                }
            }
            ResultData.SESSION -> {
                resultData.session = resultResponse.session?.let {
                    equals(it)
                }
            }
            ResultData.FAILURE -> {
                resultData.exception = resultResponse.exception
            }
        }
        return resultData
    }

    suspend fun insertCurrencys(arrayList: ArrayList<Currency>): ResultData<String> {

        var resultData = ResultData<String>()
        var resultResponse = dataSource.insert(CurrencyDataMapper.mapperCurrencyListToCurrencyEntityList(arrayList))
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {
                resultData.data = resultResponse.data
            }
            ResultData.SUCCESSLIST -> {

            }
            ResultData.SESSION -> {
                resultData.session = resultResponse.session?.let {
                    equals(it)
                }
            }
            ResultData.FAILURE -> {
                resultData.exception = resultResponse.exception
            }
        }
        return resultData
    }

    suspend fun insertCurrencyConvert(arrayList: ArrayList<CurrencyConvert>): ResultData<String> {

        var resultData = ResultData<String>()
        var resultResponse = dataSource.insertCurrencyConvert(CurrencyConvertDataMapper.mapperCurrencyListToCurrencyEntityList(arrayList))
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {
                resultData.data = resultResponse.data
            }
            ResultData.SUCCESSLIST -> {

            }
            ResultData.SESSION -> {
                resultData.session = resultResponse.session?.let {
                    equals(it)
                }
            }
            ResultData.FAILURE -> {
                resultData.exception = resultResponse.exception
            }
        }
        return resultData
    }

    suspend fun getCurrencyConvert(idCurrency: Int, idCurrencyConvert: Int): ResultData<CurrencyConvert> {

        var resultData = ResultData<CurrencyConvert>()
        var resultResponse = dataSource.getCurrencyConvert(idCurrency, idCurrencyConvert)
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {
                resultData.data = resultResponse.data?.let {
                    CurrencyConvertDataMapper.mapperCurrencyConvertEntityToCurrencyConvert(it)
                }
            }
            ResultData.SUCCESSLIST -> {

            }
            ResultData.SESSION -> {
                resultData.session = resultResponse.session?.let {
                    equals(it)
                }
            }
            ResultData.FAILURE -> {
                resultData.exception = resultResponse.exception
            }
        }
        return resultData
    }
}