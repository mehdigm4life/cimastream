package com.mehdigm.cimastream4.ui.settings.extensions

import android.content.res.ColorStateList
import android.text.format.Formatter.formatFileSize
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.mehdigm.cimastream4.CimaStreamApp.Companion.openBrowser
import com.mehdigm.cimastream4.databinding.FragmentPluginDetailsBinding
import com.mehdigm.cimastream4.plugins.PluginManager
import com.mehdigm.cimastream4.plugins.VotingApi.canVote
import com.mehdigm.cimastream4.plugins.VotingApi.getVotes
import com.mehdigm.cimastream4.plugins.VotingApi.hasVoted
import com.mehdigm.cimastream4.plugins.VotingApi.vote
import com.mehdigm.cimastream4.R
import com.mehdigm.cimastream4.ui.BaseBottomSheetDialogFragment
import com.mehdigm.cimastream4.ui.BaseFragment
import com.mehdigm.cimastream4.ui.settings.Globals.EMULATOR
import com.mehdigm.cimastream4.ui.settings.Globals.TV
import com.mehdigm.cimastream4.ui.settings.Globals.isLandscape
import com.mehdigm.cimastream4.ui.settings.Globals.isLayout
import com.mehdigm.cimastream4.utils.Coroutines.ioSafe
import com.mehdigm.cimastream4.utils.Coroutines.main
import com.mehdigm.cimastream4.utils.getImageFromDrawable
import com.mehdigm.cimastream4.utils.ImageLoader.loadImage
import com.mehdigm.cimastream4.utils.SubtitleHelper.getNameNextToFlagEmoji
import com.mehdigm.cimastream4.utils.UIHelper.colorFromAttribute
import com.mehdigm.cimastream4.utils.UIHelper.fixSystemBarsPadding
import com.mehdigm.cimastream4.utils.UIHelper.toPx

class PluginDetailsFragment(val data: PluginViewData) : BaseBottomSheetDialogFragment<FragmentPluginDetailsBinding>(
    BaseFragment.BindingCreator.Inflate(FragmentPluginDetailsBinding::inflate)
) {

    companion object {
        private tailrec fun findClosestBase2(target: Int, current: Int = 16, max: Int = 512): Int {
            if (current >= max) return max
            if (current >= target) return current
            return findClosestBase2(target, current * 2, max)
        }

        private val iconSizeExact = 50.toPx
        private val iconSize by lazy {
            findClosestBase2(iconSizeExact, 16, 512)
        }
    }

    override fun fixLayout(view: View) {
        fixSystemBarsPadding(
            view,
            padBottom = isLandscape(),
            padLeft = isLayout(TV or EMULATOR)
        )
    }

    override fun onBindingCreated(binding: FragmentPluginDetailsBinding) {
        val metadata = data.pluginWrapper.plugin
        binding.apply {
            pluginIcon.loadImage(metadata.iconUrl?.replace("%size%", "$iconSize")
                ?.replace("%exact_size%", "$iconSizeExact")) {
                error { getImageFromDrawable(context ?: return@error null , R.drawable.ic_baseline_extension_24) }
            }
            pluginName.text = metadata.name.removeSuffix("Provider")
            pluginVersion.text = metadata.version.toString()
            pluginDescription.text = metadata.description ?: getString(R.string.no_data)
            pluginSize.text =
                if (metadata.fileSize == null) getString(R.string.no_data) else formatFileSize(
                    context,
                    metadata.fileSize
                )
            pluginAuthor.text =
                if (metadata.authors.isEmpty()) getString(R.string.no_data) else metadata.authors.joinToString(
                    ", "
                )
            pluginStatus.text =
                resources.getStringArray(R.array.extension_statuses)[metadata.status]
            pluginTypes.text =
                if (metadata.tvTypes.isNullOrEmpty()) getString(R.string.no_data) else metadata.tvTypes.joinToString(
                    ", "
                )
            pluginLang.text = if (metadata.language == null)
                    getString(R.string.no_data)
                else
                    getNameNextToFlagEmoji(metadata.language) ?: metadata.language

            githubBtn.setOnClickListener {
                if (metadata.repositoryUrl != null) {
                    openBrowser(metadata.repositoryUrl)
                }
            }

            if (!metadata.canVote()) {
                upvote.alpha = .6f
            }

            if (data.isDownloaded) {
                // On local plugins page the filepath is provided instead of url.
                val plugin =
                    (PluginManager.urlPlugins[metadata.url] ?: PluginManager.plugins[metadata.url]) as? com.mehdigm.cimastream4.plugins.Plugin
                if (plugin?.openSettings != null && context != null) {
                    actionSettings.isVisible = true
                    actionSettings.setOnClickListener {
                        try {
                            plugin.openSettings!!.invoke(requireContext())
                        } catch (e: Throwable) {
                            Log.e(
                                "PluginAdapter",
                                "Failed to open ${metadata.name} settings: ${
                                    Log.getStackTraceString(e)
                                }"
                            )
                        }
                    }
                } else {
                    actionSettings.isVisible = false
                }
            } else {
                actionSettings.isVisible = false
            }

            upvote.setOnClickListener {
                ioSafe {
                    metadata.vote().main {
                        updateVoting(it)
                    }
                }
            }

            ioSafe {
                metadata.getVotes().main {
                    updateVoting(it)
                }
            }
        }
    }

    private fun updateVoting(value: Int) {
        val metadata = data.pluginWrapper.plugin
        binding?.apply {
            pluginVotes.text = value.toString()
            if (metadata.hasVoted()) {
                upvote.imageTintList = ColorStateList.valueOf(
                    context?.colorFromAttribute(R.attr.colorPrimary) ?: R.color.colorPrimary
                )
            } else {
                upvote.imageTintList = ColorStateList.valueOf(
                    context?.colorFromAttribute(com.google.android.material.R.attr.colorOnSurface) ?: R.color.white
                )
            }
        }
    }
}