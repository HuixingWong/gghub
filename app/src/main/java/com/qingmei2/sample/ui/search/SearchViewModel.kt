package com.qingmei2.sample.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.qingmei2.architecture.core.base.viewmodel.BaseViewModel
import com.qingmei2.sample.entity.Repo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest

class SearchViewModel @ViewModelInject constructor(
        private val repository: SearchRepository
) : BaseViewModel() {

    private val mSearchKeyLiveData = MutableLiveData<String>(SEARCH_KEY_DEFAULT)

    @ExperimentalCoroutinesApi
    @FlowPreview
    val repoListLiveData: LiveData<PagingData<Repo>> =
            mSearchKeyLiveData.asFlow().debounce(1500)
                    .flatMapLatest { repository.fetchPager(it).flow.cachedIn(viewModelScope) }.asLiveData()

    fun search(keyWord: String?) {
        if (!keyWord.isNullOrEmpty()) {
            mSearchKeyLiveData.postValue(keyWord)
        }
    }

    companion object {
        private const val SEARCH_KEY_DEFAULT = "kotlin"
    }
}
