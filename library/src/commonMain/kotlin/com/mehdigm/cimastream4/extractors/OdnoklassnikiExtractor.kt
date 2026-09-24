// ! Bu araç @keyiflerolsun tarafından | @KekikAkademi için yazılmıştır.

package com.mehdigm.cimastream4.extractors

import com.fasterxml.jackson.annotation.JsonProperty
import com.mehdigm.cimastream4.ErrorLoadingException
import com.mehdigm.cimastream4.SubtitleFile
import com.mehdigm.cimastream4.USER_AGENT
import com.mehdigm.cimastream4.app
import com.mehdigm.cimastream4.utils.AppUtils.tryParseJson
import com.mehdigm.cimastream4.utils.ExtractorApi
import com.mehdigm.cimastream4.utils.ExtractorLink
import com.mehdigm.cimastream4.utils.INFER_TYPE
import com.mehdigm.cimastream4.utils.getQualityFromName
import com.mehdigm.cimastream4.utils.newExtractorLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

open class Odnoklassniki : ExtractorApi() {
    override val name = "Odnoklassniki"
    override val mainUrl = "https://odnoklassniki.ru"
    override val requiresReferer = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ) {
        val headers = mapOf(
            "Accept" to "*/*",
            "Connection" to "keep-alive",
            "Sec-Fetch-Dest" to "empty",
            "Sec-Fetch-Mode" to "cors",
            "Sec-Fetch-Site" to "cross-site",
            "Origin" to mainUrl,
            "User-Agent" to USER_AGENT,
        )

        val embedUrl = url.replace("/video/", "/videoembed/")
        val videoReq = app.get(embedUrl, headers = headers).text.replace("\\&quot;", "\"").replace("\\\\", "\\")
            .replace(Regex("\\\\u([0-9A-Fa-f]{4})")) { matchResult ->
                matchResult.groupValues[1].toInt(16).toChar().toString()
            }

        val videosStr = Regex(""""videos":(\[[^]]*])""").find(videoReq)?.groupValues?.get(1) ?: throw ErrorLoadingException("Video not found")
        val videos = tryParseJson<List<OkRuVideo>>(videosStr) ?: throw ErrorLoadingException("Video not found")
        for (video in videos) {
            val videoUrl = if (video.url.startsWith("//")) "https:${video.url}" else video.url
            val quality = video.name.uppercase()
                .replace("MOBILE", "144p")
                .replace("LOWEST", "240p")
                .replace("LOW", "360p")
                .replace("SD", "480p")
                .replace("HD", "720p")
                .replace("FULL", "1080p")
                .replace("QUAD", "1440p")
                .replace("ULTRA", "4k")

            callback.invoke(
                newExtractorLink(
                    source = this.name,
                    name = this.name,
                    url = videoUrl,
                    type = INFER_TYPE,
                ) {
                    this.referer = "$mainUrl/"
                    this.quality = getQualityFromName(quality)
                    this.headers = headers
                }
            )
        }
    }

    @Serializable
    data class OkRuVideo(
        @JsonProperty("name") @SerialName("name") val name: String,
        @JsonProperty("url") @SerialName("url") val url: String,
    )
}
