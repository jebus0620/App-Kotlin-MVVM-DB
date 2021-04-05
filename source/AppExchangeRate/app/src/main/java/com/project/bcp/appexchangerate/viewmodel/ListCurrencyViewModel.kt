package com.project.bcp.appexchangerate.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.bcp.appexchangerate.data.repository.CurrencyRepository
import com.project.bcp.appexchangerate.di.Injector
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.ResultData
import com.project.bcp.appexchangerate.domain.usecase.GetCurrencysUseCase
import com.project.bcp.appexchangerate.view.base.BaseAndroidViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListCurrencyViewModel(application: Application): BaseAndroidViewModel(application) {

    private val currencysUseCase: GetCurrencysUseCase =  Injector.currencyUseCase(application)

    var error = MutableLiveData<String>()
    var loading = MutableLiveData<Boolean>()
    var session = MutableLiveData<Boolean>()
    var orderList = MutableLiveData<ArrayList<Currency>>()

    fun listCurrency(){
        loading.postValue(true)
        viewModelScope.launch {
            var result: ResultData<Currency> = withContext(Dispatchers.IO){
                currencysUseCase.listCurrency()
            }
            loading.postValue(false)
            when(result.getStateResult()){
                ResultData.SUCCESS -> {

                }
                ResultData.SUCCESSLIST -> {
                    orderList.value = result.dataList
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
}