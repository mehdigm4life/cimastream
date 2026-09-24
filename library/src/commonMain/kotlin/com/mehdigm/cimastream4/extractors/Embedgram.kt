package com.mehdigm.cimastream4.extractors

import com.mehdigm.cimastream4.SubtitleFile
import com.mehdigm.cimastream4.app
import com.mehdigm.cimastream4.utils.ExtractorApi
import com.mehdigm.cimastream4.utils.ExtractorLink
import com.mehdigm.cimastream4.utils.getQualityFromName
import com.mehdigm.cimastream4.utils.httpsify
import com.mehdigm.cimastream4.utils.newExtractorLink

open class Embedgram : ExtractorApi() {
    override val name = "Embedgram"
    override val mainUrl = "https://embedgram.com"
    override val requiresReferer = true

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val document = app.get(url, referer = referer).document
        val link = document.select("video source:last-child").attr("src")
        val quality = document.select("video source:last-child").attr("title")
        callback.invoke(
            newExtractorLink(
                this.name,
                this.name,
                httpsify(link),
            ) {
                this.referer = "$mainUrl/"
                this.quality = getQualityFromName(quality)
                this.headers = mapOf(
                    "Range" to "bytes=0-"
                )
            }
        )
    }
}