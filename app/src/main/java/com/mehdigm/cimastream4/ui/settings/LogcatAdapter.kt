package com.mehdigm.cimastream4.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mehdigm.cimastream4.databinding.ItemLogcatBinding
import com.mehdigm.cimastream4.ui.BaseDiffCallback
import com.mehdigm.cimastream4.ui.NoStateAdapter
import com.mehdigm.cimastream4.ui.ViewHolderState

class LogcatAdapter() : NoStateAdapter<String>(
    diffCallback = BaseDiffCallback(
        itemSame = String::equals,
        contentSame = String::equals
    )
) {
    override fun onCreateContent(parent: ViewGroup): ViewHolderState<Any> {
        return ViewHolderState(
            ItemLogcatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindContent(holder: ViewHolderState<Any>, item: String, position: Int) {
        (holder.view as? ItemLogcatBinding)?.apply {
            logText.text = item
        }
    }
}