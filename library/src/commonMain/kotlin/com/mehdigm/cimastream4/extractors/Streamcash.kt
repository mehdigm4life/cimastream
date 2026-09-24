package com.mehdigm.cimastream4.extractors

import com.mehdigm.cimastream4.Prerelease
import com.mehdigm.cimastream4.SubtitleFile
import com.mehdigm.cimastream4.utils.ExtractorApi
import com.mehdigm.cimastream4.utils.ExtractorLink
import com.mehdigm.cimastream4.utils.ExtractorLinkType
import com.mehdigm.cimastream4.utils.newExtractorLink

open class Streamcash: ExtractorApi() {
    override val name: String = "Streamcash"
    override val mainUrl: String = "https://streamcash.to"
    open val cdnUrl: String = "https://cdn.streamcash.to"
    override val requiresReferer: Boolean = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val id = url.removeSuffix("/").substringAfterLast("/")
        callback.invoke(
            newExtractorLink(
                name = name,
                source = name,
                url = "$cdnUrl/videos/$id/index.m3u8",
                type = ExtractorLinkType.M3U8
            )
        )
    }
}