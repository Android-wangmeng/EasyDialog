package com.wm

import androidx.annotation.ColorRes
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.wm.anim.AnimationType
import com.wm.constant.IndicatorType
import com.wm.dialog.R
import com.wm.extension.*

object EasyDialog {
    private var dialog: BasePopupView? = null
    private var builder: XPopup.Builder? = null

    /**
     * 构建设置
     * @param animationTypeIn 进入动画(默认AnimationType.ZoomIn)
     * @param animationTypeOut 退出动画(默认AnimationType.ZoomOut)
     * @param dismissOnBack 点击返回建是否关闭Dialog(默认可以关闭)
     * @param dismissOnTouch 触摸空白区域是否关闭Dialog(默认可以关闭)
     */
    fun build(
        animationTypeIn: AnimationType = AnimationType.ZoomIn,
        animationTypeOut: AnimationType = AnimationType.ZoomOut,
        dismissOnBack: Boolean = true,
        dismissOnTouch: Boolean = true
    ): EasyDialog {
        builder =
            dialogBuild(false, animationTypeIn, animationTypeOut, dismissOnBack, dismissOnTouch)
        return this
    }

    /**
     * 显示取消、确定Dialog
     * @param title 标题
     * @param msg 内容
     * @param cancelText 左边按扭文字
     * @param confirmText 右边按扭文字
     * @param onConfirm 点击确定回调
     */
    fun showMessageDialog(
        title: String,
        msg: String,
        cancelText: String = "取消",
        confirmText: String = "确认",
        onConfirm: () -> Unit
    ): BasePopupView {
        dialog = builder?.showMessageDialog(title, msg, cancelText, confirmText, onConfirm)
        builder = null
        return dialog!!
    }

    /**
     * 显示中间列表Dialog
     * @param title 标题
     * @param list 显示的列表集合
     * @param iconIds 显示的图标集合
     * @param checkedPosition 选中的位置，传-1为不选中
     * @param primaryColor 文字主题颜色
     * @param onItem 列表点击回调
     */
    fun showCenterListDialog(
        title: String,
        list: Array<String>,
        iconIds: IntArray? = null,
        checkedPosition: Int = -1,
        @ColorRes primaryColor: Int = R.color.lib_colorPrimary,
        onItem: (position: Int, str: String) -> Unit
    ): BasePopupView {
        dialog =
            builder?.showListDialog(
                title,
                list,
                iconIds,
                checkedPosition,
                false,
                primaryColor,
                onItem
            )
        builder = null
        return dialog!!
    }

    /**
     * 显示底部列表Dialog
     * @param title 标题
     * @param list 显示的列表集合
     * @param iconIds 显示的图标集合
     * @param checkedPosition 选中的位置，传-1为不选中
     * @param primaryColor 文字主题颜色
     * @param onItem 列表点击回调
     */
    fun showBottomListDialog(
        title: String,
        list: Array<String>,
        iconIds: IntArray? = null,
        checkedPosition: Int = -1,
        @ColorRes primaryColor: Int = R.color.lib_colorPrimary,
        onItem: (position: Int, str: String) -> Unit
    ): BasePopupView {
        dialog = builder?.showListDialog(
            title,
            list,
            iconIds,
            checkedPosition,
            true,
            primaryColor,
            onItem
        )
        builder = null
        return dialog!!
    }

    /**
     * 加载Dialog
     * @param msg 显示的内容
     * @param indicator 指示器样式
     * @param indicatorColor 指示器颜色
     */
    fun showLoadDialog(
        msg: String,
        indicator: String = IndicatorType.LINE_SCALE_PULSE_OUT_RAPID_INDICATOR,
        @ColorRes indicatorColor: Int = R.color.lib_colorPrimary
    ): BasePopupView {
        dialog = builder?.showLoadingDialog(msg, indicator, indicatorColor)
        builder = null
        return dialog!!
    }

    /**
     * 隐私政策dialog
     * @param title 标题
     * @param msg 显示的内容
     * @param agreement 用户协议高亮显示
     * @param privacy 隐私政策高亮显示
     * @param onConfirm 确定回调
     * @param onCancel 取消回调
     * @param onAgreement 服务协议点击回调
     * @param onPrivacy 隐私政策点击回调
     */
    fun showPrivacyPolicy(
        title: String,
        msg: String,
        agreement: String,
        privacy: String,
        confirmText: String,
        cancelText: String,
        onConfirm: () -> Unit,
        onCancel: () -> Unit,
        onAgreement: () -> Unit,
        onPrivacy: () -> Unit
    ): BasePopupView {
        dialog = builder?.showPrivacyPolicy(
            title,
            msg,
            agreement,
            privacy,
            confirmText,
            cancelText,
            onConfirm,
            onCancel,
            onAgreement,
            onPrivacy
        )
        builder = null
        return dialog!!
    }

    /**
     * 关闭Dialog
     */
    fun dismissDialog() {
        dialog?.dismiss()
    }

    /**
     * 关闭动画之后进行逻辑操作(防止抖动)
     */
    fun dismissWithDialog(dismiss: () -> Unit) {
        dialog?.dismissWith { dismiss() }
    }
}