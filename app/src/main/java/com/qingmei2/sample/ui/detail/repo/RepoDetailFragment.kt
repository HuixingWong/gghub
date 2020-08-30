package com.qingmei2.sample.ui.detail.repo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qingmei2.sample.R
import com.qingmei2.sample.entity.Repo

class RepoDetailFragment : Fragment() {

    lateinit var rePoUrl: String

    private lateinit var viewModel: RepoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RepoViewModel::class.java)
        // TODO: Use the ViewModel
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