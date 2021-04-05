package com.project.bcp.appexchangerate.domain.usecase

import com.project.bcp.appexchangerate.data.repository.CurrencyRepository
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.ResultData

class GetCurrencysUseCase(private val repository: CurrencyRepository) {

    suspend fun listCurrency(): ResultData<Currency> {
        var resultData = ResultData<Currency>()
        var resultResponse = repository.listCurrencys()
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {

            }
            ResultData.SUCCESSLIST -> {
                resultData.dataList = resultResponse.dataList?.let {
                    it
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
}