package com.wm.dialog

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lxj.easyadapter.EasyAdapter
import com.lxj.easyadapter.MultiItemTypeAdapter
import com.lxj.easyadapter.ViewHolder
import com.lxj.xpopup.core.BottomPopupView
import com.lxj.xpopup.interfaces.OnSelectListener
import com.lxj.xpopup.widget.CheckView
import com.lxj.xpopup.widget.VerticalRecyclerView

class BottomListDialog(context: Context, var textColor:Int): BottomPopupView(context) {
    var recyclerView: RecyclerView? = null
    var tv_title: TextView? = null

    private var bindLayoutId = 0
    private var bindItemLayoutId = 0

    /**
     * 传入自定义的布局，对布局中的id有要求
     *
     * @param layoutId 要求layoutId中必须有一个id为recyclerView的RecyclerView，如果你需要显示标题，则必须有一个id为tv_title的TextView
     * @return
     */
    fun bindLayout(layoutId: Int): BottomListDialog? {
        bindLayoutId = layoutId
        return this
    }

    /**
     * 传入自定义的 item布局
     *
     * @param itemLayoutId 条目的布局id，要求布局中必须有id为iv_image的ImageView，和id为tv_text的TextView
     * @return
     */
    fun bindItemLayout(itemLayoutId: Int): BottomListDialog {
        bindItemLayoutId = itemLayoutId
        return this
    }

    override fun getImplLayoutId(): Int {
        return if (bindLayoutId == 0) com.lxj.xpopup.R.layout._xpopup_bottom_impl_list else bindLayoutId
    }

    override fun initPopupContent() {
        super.initPopupContent()
        recyclerView = findViewById(R.id.recyclerView)
        if (recyclerView is VerticalRecyclerView) {
            (recyclerView as VerticalRecyclerView).setupDivider(popupInfo.isDarkTheme)
        } else {
            recyclerView?.layoutManager = LinearLayoutManager(context)
        }
        tv_title = findViewById(R.id.tv_title)
        if (tv_title != null) {
            if (TextUtils.isEmpty(title)) {
                tv_title!!.visibility = View.GONE
                findViewById<View>(R.id.xpopup_divider).visibility = View.GONE
            } else {
                tv_title!!.text = title
            }
        }
        val adapter: EasyAdapter<String> = object : EasyAdapter<String>(
            data,
            if (bindItemLayoutId == 0) R.layout._xpopup_adapter_text_match else bindItemLayoutId
        ) {
             override fun bind(
                holder: ViewHolder,
                s: String,
                position: Int
            ) {
                holder.setText(R.id.tv_text, s)
                if (iconIds != null && iconIds!!.size > position) {
                    holder.getView<ImageView>(R.id.iv_image).visibility = View.VISIBLE
                    holder.getView<ImageView>(R.id.iv_image).setBackgroundResource(iconIds!![position])
                } else {
                    holder.getView<ImageView>(R.id.iv_image).visibility = View.GONE
                }

                // 对勾View
                if (checkedPosition != -1) {
                    holder.getView<CheckView>(R.id.check_view)
                        .visibility = (if (position == checkedPosition) View.VISIBLE else View.GONE)
                    holder.getView<CheckView>(R.id.check_view).setColor(textColor)
                    holder.getView<TextView> (R.id.tv_text).setTextColor(textColor)
                } else {
                    holder.getView<CheckView>(R.id.check_view).visibility = View.GONE
                    //如果没有选择，则文字居中
                    holder.getView <TextView>(R.id.tv_text).gravity = Gravity.CENTER
                }
                    holder.getView<TextView>(R.id.tv_text).setTextColor(textColor)
            }
        }
        adapter.setOnItemClickListener(object : MultiItemTypeAdapter.SimpleOnItemClickListener() {
            override fun onItemClick(view: View, holder: RecyclerView.ViewHolder, position: Int) {
                if (selectListener != null) {
                    if (position >= 0 && position < adapter.data.size
                    ) selectListener!!.onSelect(position, adapter.data[position])
                }
                if (checkedPosition != -1) {
                    checkedPosition = position
                    adapter.notifyDataSetChanged()
                }
                if (popupInfo.autoDismiss) dismiss()
            }
        })
        recyclerView?.adapter = adapter
        if (bindLayoutId == 0 && popupInfo.isDarkTheme) {
            applyDarkTheme()
        }
    }

    override fun applyDarkTheme() {
        super.applyDarkTheme()
        tv_title!!.setTextColor(resources.getColor(R.color._xpopup_white_color))
        (tv_title!!.parent as ViewGroup).setBackgroundResource(R.drawable._xpopup_round3_dark_bg)
        findViewById<View>(R.id.xpopup_divider).setBackgroundColor(
            resources.getColor(
                R.color._xpopup_list_dark_divider
            )
        )
    }

    var title: CharSequence? = null
    var data: MutableList<String> = mutableListOf()
    var iconIds: IntArray? = null

    fun setStringData(
        title: CharSequence?,
        data: Array<String>,
        iconIds: IntArray?
    ): BottomListDialog {
        this.title = title
        data.forEach {
            this.data.add(it)
        }
        this.iconIds = iconIds
        return this
    }

    private var selectListener: OnSelectListener? = null

    fun setOnSelectListener(selectListener: OnSelectListener?): BottomListDialog? {
        this.selectListener = selectListener
        return this
    }

    var checkedPosition = -1

    /**
     * 设置默认选中的位置
     *
     * @param position
     * @return
     */
    fun setCheckedPosition(position: Int): BottomListDialog {
        checkedPosition = position
        return this
    }
}