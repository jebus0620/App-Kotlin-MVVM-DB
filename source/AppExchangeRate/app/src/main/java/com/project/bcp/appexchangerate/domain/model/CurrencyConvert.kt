package com.project.bcp.appexchangerate.domain.model

data class CurrencyConvert(
    val id: Int,
    val idCurrency: Int?,
    val idCurrencyConvert: Int?,
    val value: Double,
    val saleValue: Double,
    val currencyText: String?
)