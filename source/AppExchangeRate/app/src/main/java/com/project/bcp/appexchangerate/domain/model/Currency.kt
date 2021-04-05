package com.project.bcp.appexchangerate.domain.model

import java.io.Serializable

data class Currency(
    val id: Int,
    val name: String?,
    val detail: String?,
    val description: String?
) : Serializable