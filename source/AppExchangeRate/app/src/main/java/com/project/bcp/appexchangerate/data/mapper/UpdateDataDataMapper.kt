package com.project.bcp.appexchangerate.data.mapper

import com.project.bcp.appexchangerate.data.entity.UpdateDataEntity
import com.project.bcp.appexchangerate.domain.model.UpdateData

object UpdateDataDataMapper {

    fun mapperUpdateDataEntityToUpdateData(updateDataEntity: UpdateDataEntity) : UpdateData {
       return UpdateData(updateDataEntity.id, updateDataEntity.stateUpdate)
   }

    fun mapperUpdateDataToUpdateDataEntity(updateData: UpdateData) : UpdateDataEntity {
        return UpdateDataEntity(updateData.id, updateData.stateUpdate)
    }

}