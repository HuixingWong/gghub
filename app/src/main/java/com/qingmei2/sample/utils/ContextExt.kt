package com.qingmei2.sample.utils

import android.content.Context
import android.content.Intent
import com.qingmei2.sample.ui.web.CommonWebViewActivity

fun Context.jumpBrowser(url: String) {
//    val uri = Uri.parse(url)
//    Intent(Intent.ACTION_VIEW, uri).apply {
//        flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        startActivity(this)
//    }
    Intent(this, CommonWebViewActivity::class.java).apply {
        putExtra("url", url)
        startActivity(this)
    }
}