package com.qingmei2.sample.ui.main.trending

class TrendingViewState (val isLoading: Boolean,
                           val throwable: Throwable?){
    companion object {

        fun initial(): TrendingViewState {
            return TrendingViewState(
                    isLoading = false,
                    throwable = null
            )
        }
    }
}