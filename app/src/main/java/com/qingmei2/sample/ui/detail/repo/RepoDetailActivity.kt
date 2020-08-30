package com.qingmei2.sample.ui.detail.repo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qingmei2.sample.R

class RepoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repo_detail_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RepoDetailFragment.newInstance())
                    .commitNow()
        }
    }
}