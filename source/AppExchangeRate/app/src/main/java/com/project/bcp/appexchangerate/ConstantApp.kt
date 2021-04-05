package com.project.bcp.appexchangerate

import com.project.bcp.appexchangerate.data.entity.CurrencyConvertEntity
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert

class ConstantApp {

    companion object{

        /**
         * Constant ViewModelFactory
         */
        const val VIEWMODEL_FACTORY_MAIN_ACTIVITY = 1
        const val VIEWMODEL_FACTORY_LIST_CURRENCY_ACTIVITY = 2
        const val VIEWMODEL_FACTORY_EXCHANGE_RATE_ACTIVITY = 3

        /**
         * Constant bundle
         */

        const val BUNDLE_CURRENCY_SELECT = "BUNDLE_CURRENCY_SELECT"


        /**
         * Constant option select
         */

        const val INDEX_CURRENCY_SEND = 0
        const val INDEX_CURRENCY_RECEIVE = 1

        /**
         * Constant
         */

        const val ID_CURRENCY_DOLARES = 3
        const val ID_CURRENCY_SOLES = 1

        /**
         * Constant result
         */
        const val ACTIVITY_RESULT_SELECT_CURRENCY_SEND = 1001
        const val ACTIVITY_RESULT_SELECT_CURRENCY_RECEIVE = 1002

        /**
         * Constant List
         */

        private val listCurrency = ArrayList<Currency>()
        fun initListCurrency(): ArrayList<Currency>{
            listCurrency.clear()
            listCurrency.add(Currency(1, "Peru", "PEN", "Soles"))
            listCurrency.add(Currency(2, "European Union", "EUR", "Euros"))
            listCurrency.add(Currency(3, "United State", "USD", "Dolares"))
            listCurrency.add(Currency(4, "Japon", "JPY", "Yen"))
            listCurrency.add(Currency(5, "United Kingdom", "GBP", "Libra esterlina"))
            listCurrency.add(Currency(6, "Switzerland", "CHF", "Franco suizo"))
            listCurrency.add(Currency(7, "Canada", "CAD", "Dolar canadiense"))
            return listCurrency
        }

        private val listCurrencyConvert = ArrayList<CurrencyConvert>()
        fun initListCurrencyConvert(): ArrayList<CurrencyConvert>{
            listCurrencyConvert.clear()
            listCurrencyConvert.add(CurrencyConvert(0, 1, 1, 1.0,1.0, "Soles"))
            listCurrencyConvert.add(CurrencyConvert(0, 1, 2, 0.27,0.25, "Euro"))
            listCurrencyConvert.add(CurrencyConvert(0, 1, 3, 0.284,0.274, "Dolar"))
            listCurrencyConvert.add(CurrencyConvert(0, 1, 4, 0.035,0.033, "Yen"))
            listCurrencyConvert.add(CurrencyConvert(0, 1, 5, 0.199,0.198, "Libra Esterlina"))
            listCurrencyConvert.add(CurrencyConvert(0, 1, 6, 0.266,0.258, "Franco"))
            listCurrencyConvert.add(CurrencyConvert(0, 1, 7, 0.364,0.344, "Dolar Can"))

            listCurrencyConvert.add(CurrencyConvert(0, 2, 1, 4.34,4.294, "Soles"))
            listCurrencyConvert.add(CurrencyConvert(0, 2, 2, 1.0,1.0, "Euro"))
            listCurrencyConvert.add(CurrencyConvert(0, 2, 3, 0.197,0.177, "Dolar"))
            listCurrencyConvert.add(CurrencyConvert(0, 2, 4, 131.158,130.158, "Yen"))
            listCurrencyConvert.add(CurrencyConvert(0, 2, 5, 0.951,0.851, "Libra Esterlina"))
            listCurrencyConvert.add(CurrencyConvert(0, 2, 6, 1.149,1.109, "Franco"))
            listCurrencyConvert.add(CurrencyConvert(0, 2, 7, 1.499,1.479, "Dolar Can"))

            listCurrencyConvert.add(CurrencyConvert(0, 3, 1, 3.747,3.647, "Soles"))
            listCurrencyConvert.add(CurrencyConvert(0, 3, 2, 0.949,0.849, "Euro"))
            listCurrencyConvert.add(CurrencyConvert(0, 3, 3, 1.0,1.0, "Dolar"))
            listCurrencyConvert.add(CurrencyConvert(0, 3, 4, 111.556,110.556, "Yen"))
            listCurrencyConvert.add(CurrencyConvert(0, 3, 5, 0.823,0.723, "Libra Esterlina"))
            listCurrencyConvert.add(CurrencyConvert(0, 3, 6, 0.982,0.942, "Franco"))
            listCurrencyConvert.add(CurrencyConvert(0, 3, 7, 1.296,1.256, "Dolar Can"))

            listCurrencyConvert.add(CurrencyConvert(0, 4, 1, 0.043,0.033, "Soles"))
            listCurrencyConvert.add(CurrencyConvert(0, 4, 2, 0.009,0.008, "Euro"))
            listCurrencyConvert.add(CurrencyConvert(0, 4, 3, 0.01,0.009, "Dolar"))
            listCurrencyConvert.add(CurrencyConvert(0, 4, 4, 1.0,1.0, "Yen"))
            listCurrencyConvert.add(CurrencyConvert(0, 4, 5, 0.008,0.007, "Libra Esterlina"))
            listCurrencyConvert.add(CurrencyConvert(0, 4, 6, 0.011,0.009, "Franco"))
            listCurrencyConvert.add(CurrencyConvert(0, 4, 7, 0.013,0.011, "Dolar Can"))

            listCurrencyConvert.add(CurrencyConvert(0, 5, 1, 5.157,5.057, "Soles"))
            listCurrencyConvert.add(CurrencyConvert(0, 5, 2, 1.19,1.18, "Euro"))
            listCurrencyConvert.add(CurrencyConvert(0, 5, 3, 1.455,1.386, "Dolar"))
            listCurrencyConvert.add(CurrencyConvert(0, 5, 4, 154.698,153.328, "Yen"))
            listCurrencyConvert.add(CurrencyConvert(0, 5, 5, 1.0,1.0, "Libra Esterlina"))
            listCurrencyConvert.add(CurrencyConvert(0, 5, 6, 1.425,1.307, "Franco"))
            listCurrencyConvert.add(CurrencyConvert(0, 5, 7, 1.874, 1.741,  "Dolar Can"))

            listCurrencyConvert.add(CurrencyConvert(0, 6, 1, 3.966,3.866, "Soles"))
            listCurrencyConvert.add(CurrencyConvert(0, 6, 2, 1.102,0.902, "Euro"))
            listCurrencyConvert.add(CurrencyConvert(0, 6, 3, 1.26,1.06, "Dolar"))
            listCurrencyConvert.add(CurrencyConvert(0, 6, 4, 118.298,117.298, "Yen"))
            listCurrencyConvert.add(CurrencyConvert(0, 6, 5, 0.867,0.767, "Libra Esterlina"))
            listCurrencyConvert.add(CurrencyConvert(0, 6, 6, 1.0,1.0, "Franco"))
            listCurrencyConvert.add(CurrencyConvert(0, 6, 7, 1.434,1.334, "Dolar Can"))

            listCurrencyConvert.add(CurrencyConvert(0, 7, 1, 2.978,2.898, "Soles"))
            listCurrencyConvert.add(CurrencyConvert(0, 7, 2, 0.752,0.676, "Euro"))
            listCurrencyConvert.add(CurrencyConvert(0, 7, 3, 0.865,0.795, "Dolar"))
            listCurrencyConvert.add(CurrencyConvert(0, 7, 4, 88.11,87.932, "Yen"))
            listCurrencyConvert.add(CurrencyConvert(0, 7, 5, 0.584,0.575, "Libra Esterlina"))
            listCurrencyConvert.add(CurrencyConvert(0, 7, 6, 0.81,0.75, "Franco"))
            listCurrencyConvert.add(CurrencyConvert(0, 7, 7, 1.0, 1.0,  "Dolar Can"))

            return listCurrencyConvert
        }

    }



}