package com.project.bcp.appexchangerate.domain.model

import kotlin.collections.ArrayList

class ResultData<T>() {
    companion object{
        var SUCCESS: Int = 1000
        val SUCCESSLIST = 1001
        val FAILURE = 1002
        val SESSION = 1003
        val MESSAGE = 1004
    }

    protected var items: ArrayList<T> = ArrayList()

    var data: T? = null
    var dataList: ArrayList<T>? = null
    var exception: Exception? = null
    var message: String? = null
    var session: Boolean? = null
    //val state: Int = FAILURE

    fun getStateResult(): Int {
        if(data != null) return SUCCESS
        if(dataList != null) return SUCCESSLIST
        if(exception != null) return FAILURE
        if(session != null) return SESSION
        if(message != null) return MESSAGE

        return FAILURE
    }


/*
    data class SuccessList<T>(val data: List<T>?): ResultData<T>()
    data class Success<T>(val data: T?): ResultData<T>()
    data class Failure(val exception: Exception?): ResultData<Nothing>()

 */


}

