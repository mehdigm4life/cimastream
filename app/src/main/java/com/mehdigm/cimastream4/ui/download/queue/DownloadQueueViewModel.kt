package com.mehdigm.cimastream4.ui.download.queue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehdigm.cimastream4.mvvm.launchSafe
import com.mehdigm.cimastream4.services.DownloadQueueService.Companion.downloadInstances
import com.mehdigm.cimastream4.utils.downloader.DownloadObjects
import com.mehdigm.cimastream4.utils.downloader.DownloadQueueManager
import com.mehdigm.cimastream4.utils.downloader.VideoDownloadManager
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

data class DownloadAdapterQueue(
    val currentDownloads: List<DownloadObjects.DownloadQueueWrapper>,
    val queue: List<DownloadObjects.DownloadQueueWrapper>,
)

class DownloadQueueViewModel : ViewModel() {
    private val _childCards = MutableLiveData<DownloadAdapterQueue>()
    val childCards: LiveData<DownloadAdapterQueue> = _childCards
    private val totalDownloadFlow =
        downloadInstances.combine(DownloadQueueManager.queue) { instances, queue ->
            val current = instances.map { it.downloadQueueWrapper }
            DownloadAdapterQueue(current, queue.toList())
        }.combine(VideoDownloadManager.currentDownloads) { total, _ ->
            // We want to update the flow when currentDownloads updates, but we do not care about its value
            total
        }

    init {
        viewModelScope.launch {
            totalDownloadFlow.collect { queue ->
                updateChildList(queue)
            }
        }
    }

    fun updateChildList(downloads: DownloadAdapterQueue) {
        _childCards.postValue(downloads)
    }
}