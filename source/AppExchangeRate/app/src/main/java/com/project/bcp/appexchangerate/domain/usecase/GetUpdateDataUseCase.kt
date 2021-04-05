package com.project.bcp.appexchangerate.domain.usecase

import com.project.bcp.appexchangerate.data.repository.UpdateDataRepository
import com.project.bcp.appexchangerate.domain.model.ResultData
import com.project.bcp.appexchangerate.domain.model.UpdateData

class GetUpdateDataUseCase(private val repository: UpdateDataRepository) {

    suspend fun getUpdateData(): ResultData<UpdateData> {
        var resultData = ResultData<UpdateData>()
        var resultResponse = repository.getUpdateData()
        when (resultResponse.getStateResult()) {
            ResultData.SUCCESS -> {
                resultData.data = resultResponse.data?.let {
                    it
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