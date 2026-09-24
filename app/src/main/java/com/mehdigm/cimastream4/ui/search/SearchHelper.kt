package com.mehdigm.cimastream4.ui.search

import android.widget.Toast
import com.mehdigm.cimastream4.CommonActivity.activity
import com.mehdigm.cimastream4.CommonActivity.showToast
import com.mehdigm.cimastream4.MainActivity
import com.mehdigm.cimastream4.R
import com.mehdigm.cimastream4.ui.download.DOWNLOAD_ACTION_PLAY_FILE
import com.mehdigm.cimastream4.ui.download.DownloadButtonSetup.handleDownloadClick
import com.mehdigm.cimastream4.ui.download.DownloadClickEvent
import com.mehdigm.cimastream4.ui.result.START_ACTION_LOAD_EP
import com.mehdigm.cimastream4.utils.AppContextUtils.loadSearchResult
import com.mehdigm.cimastream4.utils.DataStoreHelper
import com.mehdigm.cimastream4.utils.downloader.DownloadObjects

object SearchHelper {
    fun handleSearchClickCallback(callback: SearchClickCallback) {
        val card = callback.card
        when (callback.action) {
            SEARCH_ACTION_LOAD -> {
                loadSearchResult(card)
            }

            SEARCH_ACTION_PLAY_FILE -> {
                if (card is DataStoreHelper.ResumeWatchingResult) {
                    val id = card.id
                    if (id == null) {
                        showToast(R.string.error_invalid_id, Toast.LENGTH_SHORT)
                    } else {
                        if (card.isFromDownload) {
                            handleDownloadClick(
                                DownloadClickEvent(
                                    DOWNLOAD_ACTION_PLAY_FILE,
                                    DownloadObjects.DownloadEpisodeCached(
                                        name = card.name,
                                        poster = card.posterUrl,
                                        episode = card.episode ?: 0,
                                        season = card.season,
                                        id = id,
                                        parentId = card.parentId ?: return,
                                        score = null,
                                        description = null,
                                        cacheTime = System.currentTimeMillis(),
                                    )
                                )
                            )
                        } else {
                            loadSearchResult(card, START_ACTION_LOAD_EP, id)
                        }
                    }
                } else {
                    handleSearchClickCallback(
                        SearchClickCallback(SEARCH_ACTION_LOAD, callback.view, -1, callback.card)
                    )
                }
            }

            SEARCH_ACTION_SHOW_METADATA -> {
                (activity as? MainActivity?)?.apply {
                    loadPopup(callback.card)
                } ?: kotlin.run {
                    showToast(callback.card.name, Toast.LENGTH_SHORT)
                }
            }
        }
    }
}