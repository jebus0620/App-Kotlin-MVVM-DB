package com.project.bcp.appexchangerate.domain.usecase

import com.project.bcp.appexchangerate.data.repository.CurrencyRepository
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.ResultData

class InsertCurrencysUseCase(private val repository: CurrencyRepository) {

    suspend fun insertCurrencys(list: ArrayList<Currency>): ResultData<String> {
        var resultData = ResultData<String>()
        var resultResponse = repository.insertCurrencys(list)
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