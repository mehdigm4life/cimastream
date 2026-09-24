package com.mehdigm.cimastream4.extractors

import com.mehdigm.cimastream4.Prerelease
import com.mehdigm.cimastream4.SubtitleFile
import com.mehdigm.cimastream4.app
import com.mehdigm.cimastream4.utils.ExtractorApi
import com.mehdigm.cimastream4.utils.ExtractorLink
import com.mehdigm.cimastream4.utils.newExtractorLink

@Prerelease
open class HubuCloud: ExtractorApi() {
    override val name: String = "Hubu"
    override val mainUrl: String = "https://hubu.cloud"
    override val requiresReferer: Boolean = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val doc = app.get(url).document

        val streamUrl = doc.select("source").attr("src")
        callback.invoke(newExtractorLink(source = name, name = name, url = streamUrl))
    }
}