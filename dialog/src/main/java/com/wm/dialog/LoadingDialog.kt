package com.wm.dialog

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.lxj.xpopup.impl.LoadingPopupView
import com.wang.avi.AVLoadingIndicatorView
import com.wang.avi.Indicator

class LoadingDialog(context: Context,var indicator: String,@ColorRes var color:Int): LoadingPopupView(context) {
    lateinit var loading:AVLoadingIndicatorView
    override fun getImplLayoutId(): Int {
        return R.layout.layout_load
    }

    override fun initPopupContent() {
        super.initPopupContent()
        loading = findViewById(R.id.loading)
        loading.setIndicator(indicator)
        loading.setIndicatorColor(ContextCompat.getColor(context,color))
    }
}