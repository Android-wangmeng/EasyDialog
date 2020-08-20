package com.wm.easydialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ToastUtils
import com.wm.EasyDialog
import com.wm.anim.AnimationType
import com.wm.constant.IndicatorType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val loadingList: Array<String> = IndicatorType.getAllIndicator()
    private var selectPosition: Int = 0
    private var selectBottomPosition: Int = 0
    private lateinit var array:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        array = arrayOf("${getString(R.string.dialog_listing)}1", "${getString(R.string.dialog_listing)}2", "${getString(R.string.dialog_listing)}3")
        applyDebouncingClickListener(
            dialog_msg,
            dialog_load,
            dialog_center_list,
            dialog_select_center_list,
            dialog_bottom_list,
            dialog_select_bottom_list,
            dialog_privacy
        )
    }

    override fun onClick(v: View?) {
        when (v) {
            //确认、取消dialog
            dialog_msg -> EasyDialog.build(AnimationType.Swing, AnimationType.ZoomOut)
                .showMessageDialog(
                    getString(R.string.dialog_warm_prompt),
                    getString(R.string.dialog_quit),
                    cancelText = getString(R.string.dialog_cancel),
                    confirmText = getString(R.string.dialog_confirm)
                ) { ToastUtils.showShort(getString(R.string.dialog_confirm)) }
            //加载Dialog
            dialog_load -> EasyDialog.build().showBottomListDialog(
                getString(R.string.dialog_loading_style),
                loadingList
            ) { index: Int, str: String ->
                EasyDialog.build(AnimationType.BounceIn, AnimationType.ZoomOut,dismissOnTouch = false).showLoadDialog(
                    getString(R.string.dialog_loading),
                    str
                )
            }
            //中间列表Dialog
            dialog_center_list -> EasyDialog.build(AnimationType.FlipInX, AnimationType.FlipOutX)
                .showCenterListDialog(
                    getString(R.string.dialog_select),
                    array
                ) { position: Int, str: String ->
                    ToastUtils.showShort("$str")
                }
            //带选中效果的中间列表Dialog
            dialog_select_center_list -> EasyDialog.build(
                AnimationType.FlipInX,
                AnimationType.FlipOutX
            ).showCenterListDialog(
                getString(R.string.dialog_select),
                array,
                checkedPosition = selectPosition
            ) { position, str ->
                this.selectPosition = position
                ToastUtils.showShort(str)
            }

            dialog_bottom_list -> EasyDialog.build().showBottomListDialog(
                getString(R.string.dialog_select),
                array
            ) { position, str ->
                ToastUtils.showShort(str)
            }
            dialog_select_bottom_list -> EasyDialog.build().showBottomListDialog(
                getString(R.string.dialog_select),
                array,
                checkedPosition = selectBottomPosition
            ) { position, str ->
                ToastUtils.showShort(str)
                this.selectBottomPosition = position
            }
            //隐私政策Dialog
            dialog_privacy -> {
                EasyDialog.build(
                    animationTypeIn = AnimationType.FlipInY,
                    animationTypeOut = AnimationType.FlipOutY,
                    dismissOnTouch = false,
                    dismissOnBack = false
                ).showPrivacyPolicy(
                    getString(R.string.dialog_privacy_title),
                    getString(R.string.dialog_privacy_msg),
                    getString(R.string.use_terms),
                    getString(R.string.use_privacy),
                    confirmText = getString(R.string.dialog_agree),
                    cancelText = getString(R.string.dialog_nonuse),
                    onConfirm = {
                        ToastUtils.showShort(getString(R.string.dialog_agree))
                    },
                    onCancel = {
                        ToastUtils.showShort(getString(R.string.dialog_nonuse))
                    },
                    onAgreement = {
                        ToastUtils.showShort(getString(R.string.use_terms))
                    },
                    onPrivacy = { ToastUtils.showShort(getString(R.string.use_privacy)) })
            }

        }
    }

    /**
     * 绑定点击事件
     */
    private fun applyDebouncingClickListener(vararg views: View) {
        ClickUtils.applyGlobalDebouncing(views, this)
        for (v in views) {
            ClickUtils.applyPressedBgDark(v)
        }
    }

}