package com.wm.dialog

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.SpanUtils
import com.lxj.xpopup.impl.ConfirmPopupView
import kotlinx.android.synthetic.main.layout_agre.view.*

class AgreeDialog(context: Context,var onCancel:()->Unit,var onAgree:()->Unit,var onPrivacy:()->Unit): ConfirmPopupView(context){
    private lateinit var agree:String
    private lateinit var privacy:String
    override fun initPopupContent() {
        bindLayoutId = R.layout.layout_agre
        super.initPopupContent()
        val msg = tv_content.text
        tv_content.text = ""
        val agreeIndex = msg.indexOf(agree)
        val privacyIndex = msg.indexOf(privacy)
        SpanUtils.with(tv_content).apply {
            append(msg.substring(0,agreeIndex))
            append(agree) //设置用户协议及点击事件
            setClickSpan(ContextCompat.getColor(context,R.color.lib_colorPrimary),false){onAgree()}
            append(msg.substring(agreeIndex + agree.length,privacyIndex))
            append(privacy)//设置隐私协议及点击事件
            setClickSpan(ContextCompat.getColor(context,R.color.lib_colorPrimary),false){onPrivacy()}
            append(msg.substring(privacyIndex+privacy.length))
        }.create()
        tv_content.highlightColor = Color.TRANSPARENT
        tv_confirm.setTextColor(ContextCompat.getColor(context,R.color.lib_colorPrimary))
        tv_cancel.setOnClickListener{
            dismissWith(onCancel)
        }
    }

    fun setAgree(agree:String){
        this.agree = agree
    }

    fun setPrivacy(privacy:String){
        this.privacy = privacy
    }

}