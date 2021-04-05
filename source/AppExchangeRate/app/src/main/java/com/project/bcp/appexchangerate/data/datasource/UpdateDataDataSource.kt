
package com.project.bcp.appexchangerate.data.datasource

import com.project.bcp.appexchangerate.data.entity.UpdateDataEntity
import com.project.bcp.appexchangerate.domain.model.ResultData

interface UpdateDataDataSource {

    suspend fun getUpdateData() : ResultData<UpdateDataEntity>
    suspend fun insertUpdateData(updateDataEntity: UpdateDataEntity) : ResultData<String>

}