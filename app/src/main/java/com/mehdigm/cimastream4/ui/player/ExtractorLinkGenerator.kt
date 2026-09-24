package com.mehdigm.cimastream4.ui.player

import com.mehdigm.cimastream4.utils.ExtractorLink
import com.mehdigm.cimastream4.utils.ExtractorLinkType

class ExtractorLinkGenerator(
    private val links: List<ExtractorLink>,
    private val subtitles: List<SubtitleData>,
) : NoVideoGenerator(null) {
    override suspend fun generateLinks(
        clearCache: Boolean,
        sourceTypes: Set<ExtractorLinkType>,
        callback: (Pair<ExtractorLink?, ExtractorUri?>) -> Unit,
        subtitleCallback: (SubtitleData) -> Unit,
        offset: Int,
        isCasting: Boolean
    ): Boolean {
        subtitles.forEach(subtitleCallback)
        links.forEach {
            if(sourceTypes.contains(it.type)) {
                callback.invoke(it to null)
            }
        }

        return true
    }
}