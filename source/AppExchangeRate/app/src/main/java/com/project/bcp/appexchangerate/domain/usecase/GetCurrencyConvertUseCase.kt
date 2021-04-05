package com.project.bcp.appexchangerate.domain.usecase

import com.project.bcp.appexchangerate.data.repository.CurrencyRepository
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert
import com.project.bcp.appexchangerate.domain.model.ResultData

class GetCurrencyConvertUseCase(private val repository: CurrencyRepository) {

    suspend fun getCurrencyConvert(idCurrency: Int, idCurrencyConvert: Int): ResultData<CurrencyConvert> {
        var resultData = ResultData<CurrencyConvert>()
        var resultResponse = repository.getCurrencyConvert(idCurrency, idCurrencyConvert)
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {
                resultData.data = resultResponse.data?.let {
                    it
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