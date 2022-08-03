package com.demoapp.petprog.core.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Source(

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "name")
    val name: String? = null,
) : Parcelable {
    companion object {
        fun mock() = Source(
            id = "engadget",
            name = "Engadget",
        )
    }
}