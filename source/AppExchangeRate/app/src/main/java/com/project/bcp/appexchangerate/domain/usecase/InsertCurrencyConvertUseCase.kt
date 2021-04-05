package com.project.bcp.appexchangerate.domain.usecase

import com.project.bcp.appexchangerate.data.repository.CurrencyRepository
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert
import com.project.bcp.appexchangerate.domain.model.ResultData

class InsertCurrencyConvertUseCase(private val repository: CurrencyRepository) {

    suspend fun insertCurrencysConvert(list: ArrayList<CurrencyConvert>): ResultData<String> {
        var resultData = ResultData<String>()
        var resultResponse = repository.insertCurrencyConvert(list)
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
}