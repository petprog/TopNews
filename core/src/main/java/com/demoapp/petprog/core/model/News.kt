package com.demoapp.petprog.core.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.demoapp.petprog.common.util.DateUtils
import kotlinx.parcelize.Parcelize

class News {
    @JsonClass(generateAdapter = true)
    @Parcelize
    data class News(

        @Json(name = "source")
        val source: Source? = null,

        @Json(name = "author")
        val author: String? = null,

        @Json(name = "content")
        val content: String? = null,

        @Json(name = "description")
        val description: String? = null,

        @Json(name = "publishedAt")
        val publishedAt: String? = null,

        @Json(name = "title")
        val title: String? = null,

        @Json(name = "url")
        val url: String? = null,

        @Json(name = "urlToImage")
        val urlToImage: String? = null
    ) : Parcelable {
        val publishedTime: String
            get() = DateUtils.dateToString(
                DateUtils.stringToDateTime(
                    publishedAt!!
                )!!, DateUtils.DMYHM_FORMAT
            )!!

        companion object {
            fun mock() = News(
                author = "Jasmine Wright and Natasha Bertrand, CNN",
                title = "Harris faces the most critical foreign trip of her vice presidency - CNN",
                description = "When Vice President Kamala Harris enters the famed Hotel Bayerischer Hof on Friday in Munich, she'll do so under the largest international gaze of her career.",
                url = "https://www.cnn.com/2022/02/18/politics/kamala-harris-munich-security-conference/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/220217151100-harris-arrives-munich-0217-super-tease.jpg",
                publishedAt = "2022-02-18T13:17:00Z",
                content = "Munich and Washington, D.C. (CNN)When Vice President Kamala Harris enters the famed Hotel Bayerischer Hof on Friday in Munich, she'll do so under the largest international gaze of her career.\r\nShe le… [+11082 chars]",
                source = Source.mock(),
            )
        }
    }
}