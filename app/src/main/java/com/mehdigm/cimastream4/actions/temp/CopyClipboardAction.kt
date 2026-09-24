package com.mehdigm.cimastream4.actions.temp

import android.content.Context
import com.mehdigm.cimastream4.actions.VideoClickAction
import com.mehdigm.cimastream4.ui.result.LinkLoadingResult
import com.mehdigm.cimastream4.ui.result.ResultEpisode
import com.mehdigm.cimastream4.utils.txt
import com.mehdigm.cimastream4.utils.UIHelper.clipboardHelper

class CopyClipboardAction: VideoClickAction() {
    override val name = txt("Copy to clipboard")

    override val oneSource = true

    override fun shouldShow(context: Context?, video: ResultEpisode?) = true

    override suspend fun runAction(
        context: Context?,
        video: ResultEpisode,
        result: LinkLoadingResult,
        index: Int?
    ) {
        if (index == null) return
        val link = result.links.getOrNull(index) ?: return
        clipboardHelper(txt(link.name), link.url)
    }
}