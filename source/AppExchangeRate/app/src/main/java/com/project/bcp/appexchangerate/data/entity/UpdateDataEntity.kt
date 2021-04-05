package com.project.bcp.appexchangerate.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "updatedata")
data class UpdateDataEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "stateUpdate") val stateUpdate: Int,
)