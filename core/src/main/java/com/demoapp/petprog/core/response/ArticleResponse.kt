/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.core.response


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.yodeput.newsapp.core.model.News
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ArticleResponse(
    @Json(name = "articles") val articles: List<News>? = null,
    @Json(name = "status") val status: String? = null,
    @Json(name = "totalResults") val totalResults: Int? = null
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

        fun mockHeadline() = ArticleResponse(
            status = "ok",
            totalResults = 4,
            articles = listOf(
                News.mock(),
                News.mock(),
                News.mock(),
                News.mock(),
            )
        )
    }
}