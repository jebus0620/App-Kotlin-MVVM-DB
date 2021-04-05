package com.project.bcp.appexchangerate.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.bcp.appexchangerate.di.Injector
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert
import com.project.bcp.appexchangerate.domain.model.ResultData
import com.project.bcp.appexchangerate.domain.model.UpdateData
import com.project.bcp.appexchangerate.domain.usecase.*
import com.project.bcp.appexchangerate.view.base.BaseAndroidViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application): BaseAndroidViewModel(application) {

    private val insertCurrencysUseCase: InsertCurrencysUseCase =  Injector.insertCurrencysUseCase(application)
    private val insertCurrencysConvertUseCase: InsertCurrencyConvertUseCase =  Injector.insertCurrencysConvertUseCase(application)
    private val insertUpdateDataUseCase: InsertUpdateDataUseCase =  Injector.insertUpdateDataUseCase(application)
    private val getCurrencyConvertUseCase: GetUpdateDataUseCase =  Injector.getUpdateDatatUseCase(application)

    var error = MutableLiveData<String>()
    var message = MutableLiveData<String>()
    var loading = MutableLiveData<Boolean>()
    var session = MutableLiveData<Boolean>()
    var updateData = MutableLiveData<UpdateData>()

    fun insertAll(currencyList: ArrayList<Currency>){
        loading.postValue(true)
        viewModelScope.launch {
            var result: ResultData<String> = withContext(Dispatchers.IO){
                insertCurrencysUseCase.insertCurrencys(currencyList)
            }
            loading.postValue(false)
            when(result.getStateResult()){
                ResultData.SUCCESS -> {
                    message.value = result.data
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

    fun insertCurrencyConvertAll(currencyList: ArrayList<CurrencyConvert>){
        loading.postValue(true)
        viewModelScope.launch {
            var result: ResultData<String> = withContext(Dispatchers.IO){
                insertCurrencysConvertUseCase.insertCurrencysConvert(currencyList)
            }
            loading.postValue(false)
            when(result.getStateResult()){
                ResultData.SUCCESS -> {
                    message.value = result.data
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

    fun insertUpdateData(updateData: UpdateData){
        loading.postValue(true)
        viewModelScope.launch {
            var result: ResultData<String> = withContext(Dispatchers.IO){
                insertUpdateDataUseCase.insertUpdateData(updateData)
            }
            loading.postValue(false)
            when(result.getStateResult()){
                ResultData.SUCCESS -> {
                    message.value = result.data
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

    fun getUpdateData(){
        loading.postValue(true)
        viewModelScope.launch {
            var result: ResultData<UpdateData> = withContext(Dispatchers.IO){
                getCurrencyConvertUseCase.getUpdateData()
            }
            loading.postValue(false)
            when(result.getStateResult()){
                ResultData.SUCCESS -> {
                    updateData.value = result.data
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
}