package com.mehdigm.cimastream4.ui.search

import com.mehdigm.cimastream4.Score
import com.mehdigm.cimastream4.SearchQuality
import com.mehdigm.cimastream4.SearchResponse
import com.mehdigm.cimastream4.TvType

//TODO Relevance of this class since it's not used
class SyncSearchViewModel {
    data class SyncSearchResultSearchResponse(
        override val name: String,
        override val url: String,
        override val apiName: String,
        override var type: TvType?,
        override var posterUrl: String?,
        override var id: Int?,
        override var quality: SearchQuality? = null,
        override var posterHeaders: Map<String, String>? = null,
        override var score: Score? = null,
    ) : SearchResponse
}