package com.wm.extension

import androidx.annotation.ColorRes
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ColorUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.enums.PopupType
import com.lxj.xpopup.impl.ConfirmPopupView
import com.lxj.xpopup.interfaces.OnSelectListener
import com.wm.anim.AnimationType
import com.wm.anim.YoyoAnimator
import com.wm.dialog.*

lateinit var msgPopup: ConfirmPopupView
fun XPopup.Builder.showMessageDialog(
    title: String,
    msg: String,
    cancel: String,
    confirm: String,
    onConfirm: () -> Unit
): ConfirmPopupView {
    msgPopup = asConfirm(title, msg) {
        msgPopup.dismissWith(onConfirm)
    }
    msgPopup.setCancelText(cancel)
    msgPopup.setConfirmText(confirm)
    msgPopup.show()
    return msgPopup
}

fun XPopup.Builder.showPrivacyPolicy(
    title: String,
    msg: String,
    agree: String,
    privacy: String,
    confirmText: String,
    cancelText:String,
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    onAgree: () -> Unit,
    onPrivacy: () -> Unit
): BasePopupView {
    popupType(PopupType.Center)
    val agreeDialog = AgreeDialog(ActivityUtils.getTopActivity(), onCancel, onAgree, onPrivacy)
    agreeDialog.setTitleContent(title, msg, null)
    agreeDialog.setListener({
        agreeDialog.dismissWith(onConfirm)
    }, null)
    agreeDialog.setAgree(agree)
    agreeDialog.setPrivacy(privacy)
    agreeDialog.setConfirmText(confirmText)
    agreeDialog.setCancelText(cancelText)
    return asCustom(agreeDialog).show()
}

var popup: BasePopupView? = null
fun XPopup.Builder.showListDialog(
    title: String,
    list: Array<String>,
    iconIds: IntArray?,
    checkedPosition: Int,
    isBottom: Boolean,
    @ColorRes primaryColor: Int,
    onItem: (position: Int, str: String) -> Unit
): BasePopupView {
    popup = if (isBottom) {
        asCustom(
            BottomListDialog(
                ActivityUtils.getTopActivity(),
                ColorUtils.getColor(primaryColor)
            ).setCheckedPosition(checkedPosition).setStringData(
                title,
                list,
                iconIds
            ).bindItemLayout(R.layout.adapter_list_item).setOnSelectListener(
                OnSelectListener { position, text ->
                    popup?.dismissWith {
                        onItem(
                            position,
                            text
                        )
                    }
                })
        ).show()
    } else {
        asCustom(
            CenterListDialog(
                ActivityUtils.getTopActivity(),
                ColorUtils.getColor(primaryColor)
            ).setCheckedPosition(checkedPosition).setStringData(
                title,
                list,
                iconIds
            ).bindItemLayout(R.layout.adapter_list_item).setOnSelectListener(
                OnSelectListener { position, text ->
                    popup?.dismissWith {
                        onItem(
                            position,
                            text
                        )
                    }
                })
        ).show()
    }
    return popup!!
}

fun XPopup.Builder.showLoadingDialog(
    msg: String,
    indicator: String,
    @ColorRes indicatorColor: Int
): BasePopupView {
    val loadingPopupView = asCustom(
        LoadingDialog(ActivityUtils.getTopActivity(), indicator, indicatorColor).setTitle(msg)
    )
    loadingPopupView.show()
    return loadingPopupView
}


fun dialogBuild(
    autoDismiss: Boolean = false,
    animationTypeIn: AnimationType,
    animationTypeOut: AnimationType,
    dismissOnBack: Boolean,
    dismissOnTouch: Boolean
): XPopup.Builder {
    return XPopup.Builder(ActivityUtils.getTopActivity()).autoDismiss(autoDismiss)
        .dismissOnBackPressed(dismissOnBack).dismissOnTouchOutside(dismissOnTouch).customAnimator(
        YoyoAnimator(animationTypeIn, animationTypeOut)
    )
}
