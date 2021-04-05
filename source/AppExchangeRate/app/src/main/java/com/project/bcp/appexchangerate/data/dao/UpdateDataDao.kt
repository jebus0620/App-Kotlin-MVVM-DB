package com.project.bcp.appexchangerate.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.bcp.appexchangerate.data.entity.UpdateDataEntity

@Dao
interface UpdateDataDao {

    @Query("SELECT * FROM updatedata")
    fun getUpdateData(): UpdateDataEntity

    @Insert
    fun insertUpdateData(vararg updateDataEntity: UpdateDataEntity)

}
