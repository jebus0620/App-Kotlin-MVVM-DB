package com.project.bcp.appexchangerate.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.bcp.appexchangerate.ConstantApp
import com.project.bcp.appexchangerate.databinding.ActivityListCurrencyBinding
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.view.adapter.CurrencyAdapter
import com.project.bcp.appexchangerate.view.base.BaseActivity
import com.project.bcp.appexchangerate.viewmodel.ListCurrencyViewModel
import com.project.bcp.appexchangerate.viewmodel.ViewModelFactory

class ListCurrencyActivity : BaseActivity() {

    private lateinit var listCurrencyViewModel: ListCurrencyViewModel
    private var currencyList = ArrayList<Currency>()
    private lateinit var currencyAdapter: CurrencyAdapter
    private var linearLayoutManager = LinearLayoutManager(this)

    private lateinit var binding: ActivityListCurrencyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        viewModelObserver()
        loadData()
    }

    private fun initUI(){
        listCurrencyViewModel = ViewModelProvider(
            this,
            ViewModelFactory(application, ConstantApp.VIEWMODEL_FACTORY_LIST_CURRENCY_ACTIVITY)
        ).get(
            ListCurrencyViewModel::class.java
        )

        currencyAdapter = CurrencyAdapter(currencyList, this){
            val intent = Intent()
            intent.putExtra(ConstantApp.BUNDLE_CURRENCY_SELECT, it)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


        binding.rviCurrencys.apply {
            layoutManager = linearLayoutManager
            adapter = currencyAdapter
        }
    }

    private fun loadData(){
        listCurrencyViewModel.listCurrency()
    }

    private fun viewModelObserver() {

        listCurrencyViewModel.orderList.observe(this, Observer {
            it.let {
                Log.i("LIST : ", it.toString())
                currencyList = it
                currencyAdapter.setChangeList(currencyList)
            }
        })

        listCurrencyViewModel.loading.observe(this, Observer {
            if (it) showLoading() else hideLoading()
        })

        listCurrencyViewModel.error.observe(this, Observer {
            listCurrencyViewModel.customDialogAlert(it, this)
        })


        listCurrencyViewModel.alertDialog.observe(this, Observer {
            it.show()
        })
    }

    private fun showLoading(){
        binding.claLoading.root.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.claLoading.root.visibility = View.GONE

    }
}