package com.project.bcp.appexchangerate.view.activity

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.bcp.appexchangerate.ConstantApp
import com.project.bcp.appexchangerate.databinding.ActivityExchangeRateBinding
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.view.base.BaseActivity
import com.project.bcp.appexchangerate.viewmodel.ExchangeRateViewModel
import com.project.bcp.appexchangerate.viewmodel.ViewModelFactory

class ExchangeRateActivity : BaseActivity() {

    private lateinit var binding: ActivityExchangeRateBinding
    private lateinit var exchangeRateViewModel: ExchangeRateViewModel

    private lateinit var currencySendSelect : Currency
    private lateinit var currencyReceiveSelect : Currency
    private var amountConvertion = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExchangeRateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        initCurrency()
        viewModelObserver()
        loadData()
    }

    private fun initUI(){

        exchangeRateViewModel = ViewModelProvider(
            this,
            ViewModelFactory(application, ConstantApp.VIEWMODEL_FACTORY_EXCHANGE_RATE_ACTIVITY)
        ).get(
            ExchangeRateViewModel::class.java
        )

        binding.tviSend.setOnLongClickListener {
            goToActivityForResult(ListCurrencyActivity::class.java, null, ConstantApp.ACTIVITY_RESULT_SELECT_CURRENCY_SEND)
            true
        }

        binding.tviReceive.setOnLongClickListener {
            goToActivityForResult(ListCurrencyActivity::class.java, null, ConstantApp.ACTIVITY_RESULT_SELECT_CURRENCY_RECEIVE)
            true
        }

        binding.eteSend.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var amoutSend = 0.0
                try {
                    amoutSend = if(s.toString().isNotEmpty()) s.toString().toDouble() else 0.0
                }catch (e: Exception){
                    e.printStackTrace()
                    amoutSend = 0.0
                }
                calculateValConvertion(amoutSend)
            }
            override fun afterTextChanged(s: Editable) {}
        })

        binding.iviChange.setOnClickListener {
            var temp = currencyReceiveSelect
            currencyReceiveSelect = currencySendSelect
            currencySendSelect = temp

            exchangeRateViewModel.getCurrencyConvert(currencySendSelect.id, currencyReceiveSelect.id)
            binding.tviReceive.text = currencyReceiveSelect.let { it?.description }
            binding.tviSend.text = currencySendSelect.let { it?.description }
            binding.iviChange.apply {
                animate()
                    .rotation(binding.iviChange.rotation + 360f)
                    .setDuration(1500)
                    .setListener(object : Animator.AnimatorListener {
                        override fun onAnimationStart(animation: Animator?) {}
                        override fun onAnimationRepeat(animation: Animator?) {}
                        override fun onAnimationEnd(animation: Animator?) {

                        }
                        override fun onAnimationCancel(animation: Animator?) {}
                    })
            }
        }
    }

    private fun loadData(){
        exchangeRateViewModel.getCurrencyConvert(currencySendSelect.id, currencyReceiveSelect.id)
    }

    private fun viewModelObserver() {

        exchangeRateViewModel.currencyConvert.observe(this, Observer {
            it.let {
                amountConvertion = it.saleValue
                calculateValConvertion(binding.eteSend.text.toString().toDouble())
                printTypeChange(it.saleValue, it.value)
            }
        })

        exchangeRateViewModel.loading.observe(this, Observer {
            if (it) showLoading() else hideLoading()
        })

        exchangeRateViewModel.error.observe(this, Observer {
            exchangeRateViewModel.customDialogAlert(it, this)
        })

        exchangeRateViewModel.alertDialog.observe(this, Observer {
            it.show()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            ConstantApp.ACTIVITY_RESULT_SELECT_CURRENCY_SEND -> {
                if (resultCode == RESULT_OK) {
                    currencySendSelect = data?.getSerializableExtra(ConstantApp.BUNDLE_CURRENCY_SELECT) as Currency
                    binding.tviSend.text = currencySendSelect.let { it?.description }
                    exchangeRateViewModel.getCurrencyConvert(currencySendSelect!!.id, currencyReceiveSelect!!.id)
                }
            }

            ConstantApp.ACTIVITY_RESULT_SELECT_CURRENCY_RECEIVE -> {
                if (resultCode == RESULT_OK) {
                    currencyReceiveSelect = data?.getSerializableExtra(ConstantApp.BUNDLE_CURRENCY_SELECT) as Currency
                    binding.tviReceive.text = currencyReceiveSelect.let { it?.description }
                    exchangeRateViewModel.getCurrencyConvert(currencySendSelect!!.id, currencyReceiveSelect!!.id)
                }
            }
        }
    }

    private fun calculateValConvertion(amoutSend: Double){

        //var amoutSend = binding.eteSend.text.toString().toDouble()
        var amoutReceive = exchangeRateViewModel.calculateConvertion(amoutSend, amountConvertion)
        binding.eteReceive.setText(amoutReceive.toString())
    }

    private fun printTypeChange(purchase: Double, sale: Double){
        binding.tviChange.text = "Compra: ${purchase} | venta: ${sale}"
    }

    private fun showLoading(){
        binding.claLoading.root.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.claLoading.root.visibility = View.GONE

    }

    private fun initCurrency(){
        currencyReceiveSelect = Currency(1, "Peru", "PEN", "Soles")
        currencySendSelect = Currency(3, "United State", "USD", "Dolares")
    }
}