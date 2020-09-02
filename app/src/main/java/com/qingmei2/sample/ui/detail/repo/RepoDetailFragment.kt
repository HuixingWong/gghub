package com.qingmei2.sample.ui.detail.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.qingmei2.sample.R

class RepoDetailFragment : Fragment() {

    lateinit var rePoUrl: String

    private lateinit var viewModel: RepoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.repo_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RepoViewModel::class.java)
    }

    companion object {
        @JvmStatic
        fun newInstance(url: String): RepoDetailFragment {
            val repoDetailFragment = RepoDetailFragment()
            repoDetailFragment.rePoUrl = url
            return repoDetailFragment
        }
    }

}