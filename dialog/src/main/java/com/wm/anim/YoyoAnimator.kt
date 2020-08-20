package com.wm.anim

import android.view.View
import com.lxj.xpopup.animator.PopupAnimator


class YoyoAnimator(val animationTypeIn: AnimationType, val animationTypeOut: AnimationType): PopupAnimator() {
    override fun animateShow() {
        YoYo.with(animationTypeIn).duration(500).playOn(targetView)
    }

    override fun animateDismiss() {
        YoYo.with(animationTypeOut).duration(200).onEnd {
            targetView.visibility= View.GONE
        }.playOn(targetView)
    }

    override fun initAnimator() {

    }

}