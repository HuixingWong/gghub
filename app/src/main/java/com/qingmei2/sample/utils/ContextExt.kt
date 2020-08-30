package com.qingmei2.sample.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.qingmei2.sample.ui.detail.repo.RepoDetailActivity
import com.qingmei2.sample.ui.web.CommonWebViewActivity

fun Context.jumpBrowser(url: String) {
    val intent = Intent(this, CommonWebViewActivity::class.java).apply {
        putExtra("url", url)
    }
    if (url.contains("repo")){
        RepoDetailActivity.launch(this as FragmentActivity, url)
    }else{
        startActivity(intent)
    }
}