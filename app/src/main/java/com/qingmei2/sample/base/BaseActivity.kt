package com.qingmei2.sample.base

import android.databinding.ViewDataBinding
import com.qingmei2.rhine.base.viewdelegate.IViewDelegate
import com.qingmei2.rhine.base.view.RhineActivity

abstract class BaseActivity<B : ViewDataBinding, D : IViewDelegate> : RhineActivity<B, D>()