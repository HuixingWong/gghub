package com.qingmei2.sample.utils

import android.content.Context
import android.content.Intent
import com.qingmei2.sample.ui.web.CommonWebViewActivity

fun Context.jumpBrowser(url: String) {
    Intent(this, CommonWebViewActivity::class.java).apply {
        putExtra("url", url)
        startActivity(this)
    }
}