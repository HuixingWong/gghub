package com.qingmei2.sample.ui.main.trending

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.qingmei2.architecture.core.base.view.fragment.BaseFragment
import com.qingmei2.architecture.core.ext.observe
import com.qingmei2.sample.ui.main.trending.adapter.TrendingAdapter
import com.qingmei2.sample.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_trending.*

@AndroidEntryPoint
class TrendingFragment : BaseFragment() {
    override val layoutId: Int = com.qingmei2.sample.R.layout.fragment_trending
    private val viewModel: TrendingViewModel by viewModels()
    private val trendingAdapter: TrendingAdapter by lazy {
        TrendingAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        binds()
    }

    private fun initViews() {
        mRecyclerView.adapter = trendingAdapter
        mSwipeRefreshLayout.setOnRefreshListener {
            viewModel.search()
        }
    }

    private fun binds() {
        viewModel.search()
        viewModel.trendingList.observe(viewLifecycleOwner, Observer {
           trendingAdapter.submitList(it)
        })
        observe(viewModel.viewStateLiveData, this::onNewState)
    }

    private fun onNewState(state: TrendingViewState) {
        if (state.throwable != null) {
            toast { "network failure." }
        }
        if (state.isLoading != mSwipeRefreshLayout.isRefreshing) {
            mSwipeRefreshLayout.isRefreshing = state.isLoading
        }
    }

}