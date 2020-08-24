package com.qingmei2.sample.ui.main.trending

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.qingmei2.architecture.core.base.view.fragment.BaseFragment
import com.qingmei2.architecture.core.logger.loge
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingFragment : BaseFragment() {
    override val layoutId: Int = com.qingmei2.sample.R.layout.fragment_trending
    val viewmodel: TrendingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        binds()
    }

    private fun initViews(){

    }

    private  fun binds(){
        viewmodel.search()
        viewmodel.trendingList.observe(viewLifecycleOwner, Observer {
            it.forEach {
                loge {  it.name }
            }
        })
    }


}