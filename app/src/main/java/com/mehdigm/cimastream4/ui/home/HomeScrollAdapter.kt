package com.mehdigm.cimastream4.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.mehdigm.cimastream4.LoadResponse
import com.mehdigm.cimastream4.databinding.HomeScrollViewBinding
import com.mehdigm.cimastream4.databinding.HomeScrollViewTvBinding
import com.mehdigm.cimastream4.ui.BaseDiffCallback
import com.mehdigm.cimastream4.ui.NoStateAdapter
import com.mehdigm.cimastream4.ui.ViewHolderState
import com.mehdigm.cimastream4.ui.result.ResultFragment.bindLogo
import com.mehdigm.cimastream4.ui.settings.Globals.EMULATOR
import com.mehdigm.cimastream4.ui.settings.Globals.TV
import com.mehdigm.cimastream4.ui.settings.Globals.isLayout
import com.mehdigm.cimastream4.utils.AppContextUtils.html
import com.mehdigm.cimastream4.utils.ImageLoader.loadImage

class HomeScrollAdapter(
    val callback: ((View, Int, LoadResponse) -> Unit)
) : NoStateAdapter<LoadResponse>(diffCallback = BaseDiffCallback(itemSame = { a, b ->
    a.uniqueUrl == b.uniqueUrl && a.name == b.name
})) {
    var hasMoreItems: Boolean = false

    override fun onCreateContent(parent: ViewGroup): ViewHolderState<Any> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = if (isLayout(TV or EMULATOR)) {
            HomeScrollViewTvBinding.inflate(inflater, parent, false)
        } else {
            HomeScrollViewBinding.inflate(inflater, parent, false)
        }

        return ViewHolderState(binding)
    }

    override fun onClearView(holder: ViewHolderState<Any>) {
        when (val binding = holder.view) {
            is HomeScrollViewBinding -> {
                clearImage(binding.homeScrollPreview)
            }

            is HomeScrollViewTvBinding -> {
                clearImage(binding.homeScrollPreview)
            }
        }
    }

    override fun onBindContent(
        holder: ViewHolderState<Any>,
        item: LoadResponse,
        position: Int,
    ) {
        val binding = holder.view

        val posterUrl = item.backgroundPosterUrl ?: item.posterUrl

        when (binding) {
            is HomeScrollViewBinding -> {
                binding.homeScrollPreview.loadImage(posterUrl, item.posterHeaders)
                binding.homeScrollPreviewTags.apply {
                    text = item.tags?.joinToString(" • ") ?: ""
                    isGone = item.tags.isNullOrEmpty()
                    maxLines = 2
                }
                binding.homeScrollPreviewTitle.text = item.name.html()

                bindLogo(
                    url = item.logoUrl,
                    headers = item.posterHeaders,
                    titleView = binding.homeScrollPreviewTitle,
                    logoView = binding.homePreviewLogo
                )
            }

            is HomeScrollViewTvBinding -> {
                binding.homeScrollPreview.isFocusable = false
                binding.homeScrollPreview.setOnClickListener { view ->
                    callback.invoke(view ?: return@setOnClickListener, position, item)
                }
                binding.homeScrollPreview.loadImage(posterUrl, item.posterHeaders)
            }
        }
    }
}
