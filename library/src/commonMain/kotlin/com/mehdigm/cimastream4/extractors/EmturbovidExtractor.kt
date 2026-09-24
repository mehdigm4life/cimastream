package com.mehdigm.cimastream4.extractors

import com.mehdigm.cimastream4.app
import com.mehdigm.cimastream4.utils.ExtractorApi
import com.mehdigm.cimastream4.utils.ExtractorLink
import com.mehdigm.cimastream4.utils.ExtractorLinkType
import com.mehdigm.cimastream4.utils.Qualities
import com.mehdigm.cimastream4.utils.newExtractorLink

open class EmturbovidExtractor : ExtractorApi() {
    override val name = "Emturbovid"
    override val mainUrl = "https://emturbovid.com"
    override val requiresReferer = false

    override suspend fun getUrl(url: String, referer: String?): List<ExtractorLink>? {
        val response = app.get(url, referer = referer ?: "$mainUrl/")
        val playerScript = response.document
            .select("script")
            .first { it.data().contains("var urlPlay") }
            .html()

        val sources = mutableListOf<ExtractorLink>()
        if (playerScript.isNotBlank()) {
            val m3u8Url = playerScript.substringAfter("var urlPlay = '").substringBefore("'")
            sources.add(
                newExtractorLink(
                    source = name,
                    name = name,
                    url = m3u8Url,
                    type = ExtractorLinkType.M3U8,
                ) {
                    this.referer = "$mainUrl/"
                    this.quality = Qualities.Unknown.value
                }
            )
        }

        return sources
    }
}
