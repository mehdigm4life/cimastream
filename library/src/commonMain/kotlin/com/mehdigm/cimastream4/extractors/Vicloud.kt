package com.mehdigm.cimastream4.extractors

import com.fasterxml.jackson.annotation.JsonProperty
import com.mehdigm.cimastream4.APIHolder.unixTimeMS
import com.mehdigm.cimastream4.SubtitleFile
import com.mehdigm.cimastream4.app
import com.mehdigm.cimastream4.utils.ExtractorApi
import com.mehdigm.cimastream4.utils.ExtractorLink
import com.mehdigm.cimastream4.utils.getQualityFromName
import com.mehdigm.cimastream4.utils.newExtractorLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

open class Vicloud : ExtractorApi() {
    override val name = "Vicloud"
    override val mainUrl = "https://vicloud.sbs"
    override val requiresReferer = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ) {
        val id = Regex("\"apiQuery\":\"(.*?)\"").find(app.get(url).text)?.groupValues?.getOrNull(1)
        app.get(
            "$mainUrl/api/?$id=&_=$unixTimeMS",
            headers = mapOf("X-Requested-With" to "XMLHttpRequest"),
            referer = url,
        ).parsedSafe<Responses>()?.sources?.map { source ->
            callback.invoke(
                newExtractorLink(
                    name,
                    name,
                    source.file ?: return@map null,
                ) {
                    this.referer = url
                    this.quality = getQualityFromName(source.label)
                }
            )
        }
    }

    @Serializable
    private data class Sources(
        @JsonProperty("file") @SerialName("file") val file: String? = null,
        @JsonProperty("label") @SerialName("label") val label: String? = null,
    )

    @Serializable
    private data class Responses(
        @JsonProperty("sources") @SerialName("sources") val sources: List<Sources>? = arrayListOf(),
    )
}
