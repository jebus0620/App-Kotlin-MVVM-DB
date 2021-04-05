package com.project.bcp.appexchangerate.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.bcp.appexchangerate.di.Injector
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert
import com.project.bcp.appexchangerate.domain.model.ResultData
import com.project.bcp.appexchangerate.domain.usecase.GetCurrencyConvertUseCase
import com.project.bcp.appexchangerate.domain.usecase.GetCurrencysUseCase
import com.project.bcp.appexchangerate.view.base.BaseAndroidViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExchangeRateViewModel(application: Application): BaseAndroidViewModel(application) {

    private val getCurrencyConvertUseCase: GetCurrencyConvertUseCase =  Injector.currencyConvertUseCase(application)

    var error = MutableLiveData<String>()
    var loading = MutableLiveData<Boolean>()
    var session = MutableLiveData<Boolean>()
    var currencyConvert = MutableLiveData<CurrencyConvert>()

    fun getCurrencyConvert(idCurrency: Int, idCurrencyConvert: Int){
        loading.postValue(true)
        viewModelScope.launch {
            var result: ResultData<CurrencyConvert> = withContext(Dispatchers.IO){
                getCurrencyConvertUseCase.getCurrencyConvert(idCurrency, idCurrencyConvert)
            }
            loading.postValue(false)
            when(result.getStateResult()){
                ResultData.SUCCESS -> {
                    currencyConvert.value = result.data
                }
                ResultData.SUCCESSLIST -> {
                }
                ResultData.SESSION -> {
                    session.value = result.session
                }
                ResultData.FAILURE -> {
                    error.value = result.exception?.message
                }
            }
        }
    }

    fun calculateConvertion(amountSend: Double, amountConvert: Double): Double{
        return amountSend*amountConvert
    }

}