package com.qingmei2.sample.ui.main.trending

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import com.qingmei2.architecture.core.base.viewmodel.BaseViewModel
import com.qingmei2.sample.entity.request.TrendingRequestData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class TrendingViewModel @ViewModelInject constructor(private val repository: TrendingRepository)
    : BaseViewModel() {

    private val _viewStateLiveData: MutableLiveData<TrendingViewState> = MutableLiveData(TrendingViewState.initial())
    val viewStateLiveData: LiveData<TrendingViewState> = _viewStateLiveData

    private val trendingRequestData = MutableLiveData<TrendingRequestData>(TrendingRequestData())

    fun search(key: String? = null, time: String? = null) {
        trendingRequestData.postValue(TrendingRequestData().apply {
            language = key ?: language
            since = time ?: since
        })
    }

    val trendingList = Transformations.switchMap(trendingRequestData) {
        repository.fetchTrending(it).flowOn(Dispatchers.Default).asLiveData()
    }

}