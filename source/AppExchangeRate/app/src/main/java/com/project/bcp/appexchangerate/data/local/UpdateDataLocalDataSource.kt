package com.project.bcp.appexchangerate.data.local

import com.project.bcp.appexchangerate.data.dao.UpdateDataDao
import com.project.bcp.appexchangerate.data.datasource.UpdateDataDataSource
import com.project.bcp.appexchangerate.data.entity.UpdateDataEntity
import com.project.bcp.appexchangerate.domain.model.ResultData

class UpdateDataLocalDataSource(private val dao: UpdateDataDao): UpdateDataDataSource {

    override suspend fun getUpdateData(): ResultData<UpdateDataEntity> {
        val resultData = ResultData<UpdateDataEntity>()
        val response = dao.getUpdateData()
        if(response == null)  resultData.exception = Exception("ERROR")
        else resultData.data = response
        return resultData
    }

    override suspend fun insertUpdateData(updateDataEntity: UpdateDataEntity): ResultData<String> {
        val resultData = ResultData<String>()
        dao.insertUpdateData(updateDataEntity)
        resultData.data = "INSERT_UPDATE_STATE"
        return resultData
    }
}