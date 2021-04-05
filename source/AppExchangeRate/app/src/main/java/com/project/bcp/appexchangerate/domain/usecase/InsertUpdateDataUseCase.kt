package com.project.bcp.appexchangerate.domain.usecase

import com.project.bcp.appexchangerate.data.repository.UpdateDataRepository
import com.project.bcp.appexchangerate.domain.model.ResultData
import com.project.bcp.appexchangerate.domain.model.UpdateData

class InsertUpdateDataUseCase(private val repository: UpdateDataRepository) {

    suspend fun insertUpdateData(updateData: UpdateData): ResultData<String> {
        var resultData = ResultData<String>()
        var resultResponse = repository.insertUpdateData(updateData)
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
}