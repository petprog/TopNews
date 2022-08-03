package com.demoapp.petprog.core.response


import android.os.Parcelable
import com.demoapp.petprog.core.model.News
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ArticleResponse(
    @Json(name = "articles")
    val articles: List<News>? = null,

    @Json(name = "status")
    val status: String? = null,

    @Json(name = "totalResults")
    val totalResults: Int? = null
) : Parcelable {
    companion object {
        fun mock() = ArticleResponse(
            status = "ok",
            totalResults = 121,
            articles = listOf(
                News.mock(),
                News.mock(),
                News.mock(),
                News.mock(),
                News.mock(),
                News.mock(),
                News.mock(),
                News.mock(),
            )
        )
    }
}