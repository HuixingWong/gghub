package com.qingmei2.sample.ui.web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qingmei2.sample.R
import kotlinx.android.synthetic.main.activity_common_web_view.*

class CommonWebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_web_view)
        intent.extras?.getString("url")?.let {
            webview.loadUrl(it)
        }
    }
}