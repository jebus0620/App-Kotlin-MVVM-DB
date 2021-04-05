package com.project.bcp.appexchangerate.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.bcp.appexchangerate.ConstantApp

class ViewModelFactory(private val application: Application, private val typeViewModel: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when(typeViewModel){
            ConstantApp.VIEWMODEL_FACTORY_LIST_CURRENCY_ACTIVITY -> return ListCurrencyViewModel(application) as T
            ConstantApp.VIEWMODEL_FACTORY_MAIN_ACTIVITY -> return MainViewModel(application) as T
            ConstantApp.VIEWMODEL_FACTORY_EXCHANGE_RATE_ACTIVITY -> return ExchangeRateViewModel(application) as T
        }
        return AndroidViewModel(application) as T
    }
}