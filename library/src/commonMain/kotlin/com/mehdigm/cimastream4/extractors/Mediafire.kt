package com.mehdigm.cimastream4.extractors

import com.mehdigm.cimastream4.SubtitleFile
import com.mehdigm.cimastream4.app
import com.mehdigm.cimastream4.utils.ExtractorApi
import com.mehdigm.cimastream4.utils.ExtractorLink
import com.mehdigm.cimastream4.utils.INFER_TYPE
import com.mehdigm.cimastream4.utils.Qualities
import com.mehdigm.cimastream4.utils.newExtractorLink

open class Mediafire : ExtractorApi() {
    override val name = "Mediafire"
    override val mainUrl = "https://www.mediafire.com"
    override val requiresReferer = true

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val res = app.get(url, referer = referer).document
        val title = res.select("div.dl-btn-label").text()
        val video = res.selectFirst("a#downloadButton")?.attr("href")

        callback.invoke(
            newExtractorLink(
                this.name,
                this.name,
                video ?: return
            ) {
                this.quality = getQuality(title)
            }
        )

    }

    private fun getQuality(str: String?): Int {
        return Regex("(\\d{3,4})[pP]").find(str ?: "")?.groupValues?.getOrNull(1)?.toIntOrNull()
            ?: Qualities.Unknown.value
    }

}