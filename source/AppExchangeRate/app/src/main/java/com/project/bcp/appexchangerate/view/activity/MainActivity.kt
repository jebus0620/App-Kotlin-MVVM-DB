package com.project.bcp.appexchangerate.view.activity

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.bcp.appexchangerate.ConstantApp
import com.project.bcp.appexchangerate.databinding.ActivityMainBinding
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert
import com.project.bcp.appexchangerate.domain.model.UpdateData
import com.project.bcp.appexchangerate.view.base.BaseActivity
import com.project.bcp.appexchangerate.viewmodel.MainViewModel
import com.project.bcp.appexchangerate.viewmodel.ViewModelFactory
import kotlin.collections.ArrayList

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        viewModelObserver()

    }

    private fun initUI(){

        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(application, ConstantApp.VIEWMODEL_FACTORY_MAIN_ACTIVITY)
        ).get(
            MainViewModel::class.java
        )

        binding.iviLogo.apply {
            alpha = 0f
            visibility = View.VISIBLE

            animate()
                .alpha(1f)
                .setDuration(1500)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator?) {}
                    override fun onAnimationRepeat(animation: Animator?) {}
                    override fun onAnimationEnd(animation: Animator?) {
                        mainViewModel.getUpdateData()
                    }
                    override fun onAnimationCancel(animation: Animator?) {}
                })
        }

    }

    private fun viewModelObserver() {

        mainViewModel.message.observe(this, Observer {
            it.let {
                when(it){
                    "INSERT_CURRENCY" ->  mainViewModel.insertCurrencyConvertAll(ConstantApp.initListCurrencyConvert())
                    "INSERT_CURRENCY_CONVERT" ->  mainViewModel.insertUpdateData(UpdateData(0, 1))
                    "INSERT_UPDATE_STATE" ->   goToActivity(ExchangeRateActivity::class.java, null, false)
                }
            }
        })

        mainViewModel.updateData.observe(this, Observer {
            validateLoadData(it)
        })

        mainViewModel.loading.observe(this, Observer {
            if (it) showLoading() else hideLoading()
        })

        mainViewModel.error.observe(this, Observer {
            //mainViewModel.customDialogAlert(it, this)
            loadData()
        })

        mainViewModel.alertDialog.observe(this, Observer {
            it.show()
        })
    }

    private fun loadData(){
        mainViewModel.insertAll(ConstantApp.initListCurrency())

    }

    private fun validateLoadData(updateData: UpdateData){
        updateData.let {
            if(updateData.stateUpdate == 0) loadData() else goToActivity(ExchangeRateActivity::class.java, null, false)
        }

    }

    private fun showLoading(){
        binding.claLoading.root.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.claLoading.root.visibility = View.GONE
    }
}