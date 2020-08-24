package com.qingmei2.sample.ui.main.trending

import androidx.paging.PagingData
import com.qingmei2.sample.entity.TrendingRepo

class TrendingViewState (val isLoading: Boolean,
                           val throwable: Throwable?,
                           val pagedList: PagingData<TrendingRepo>?){
    companion object {

        fun initial(): TrendingViewState {
            return TrendingViewState(
                    isLoading = false,
                    throwable = null,
                    pagedList = null
            )
        }
    }
}