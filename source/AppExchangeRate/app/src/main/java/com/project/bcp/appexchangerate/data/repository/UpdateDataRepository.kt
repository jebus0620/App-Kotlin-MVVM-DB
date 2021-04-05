package com.project.bcp.appexchangerate.data.repository

import com.project.bcp.appexchangerate.data.datasource.CurrencyDataSource
import com.project.bcp.appexchangerate.data.datasource.UpdateDataDataSource
import com.project.bcp.appexchangerate.data.mapper.CurrencyConvertDataMapper
import com.project.bcp.appexchangerate.data.mapper.CurrencyDataMapper
import com.project.bcp.appexchangerate.data.mapper.UpdateDataDataMapper
import com.project.bcp.appexchangerate.domain.model.Currency
import com.project.bcp.appexchangerate.domain.model.CurrencyConvert
import com.project.bcp.appexchangerate.domain.model.ResultData
import com.project.bcp.appexchangerate.domain.model.UpdateData

class UpdateDataRepository(private val dataSource: UpdateDataDataSource) {

    suspend fun insertUpdateData(updateData: UpdateData): ResultData<String> {

        var resultData = ResultData<String>()
        var resultResponse = dataSource.insertUpdateData(UpdateDataDataMapper.mapperUpdateDataToUpdateDataEntity(updateData))
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {
                resultData.data = resultResponse.data
            }
            ResultData.SUCCESSLIST -> {

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

    suspend fun getUpdateData(): ResultData<UpdateData> {

        var resultData = ResultData<UpdateData>()
        var resultResponse = dataSource.getUpdateData()
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {
                resultData.data = resultResponse.data?.let {
                    UpdateDataDataMapper.mapperUpdateDataEntityToUpdateData(it)
                }
            }
            ResultData.SUCCESSLIST -> {

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