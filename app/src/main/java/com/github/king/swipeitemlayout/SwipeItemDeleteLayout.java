package com.github.king.swipeitemlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Created by jinxl on 2019/2/18.
 */
public class SwipeItemDeleteLayout extends LinearLayout implements View.OnClickListener, SwipeItemLayout.SwipeItemLayoutDelegate {
    //删除图标
    private ImageView mIv_delete;
    //删除按钮
    private TextView mTv_delete_text;
    //滑动容器
    private SwipeItemLayout mSwipeitem_container;

    private OnMenuClickListener mOnMenuClickListener;

    public SwipeItemDeleteLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeItemDeleteLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.layout_swipe_item_delete, this);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mIv_delete = findViewById(R.id.iv_delete);
        mTv_delete_text = findViewById(R.id.tv_delete_text);
        mSwipeitem_container = findViewById(R.id.sil_swipeitem_container);
        mSwipeitem_container.setDelegate(this);
        mIv_delete.setOnClickListener(this);
        mTv_delete_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mIv_delete) {
            //删除图标
            mIv_delete.setVisibility(INVISIBLE);
            mSwipeitem_container.openWithAnim();
        }

        if (v == mTv_delete_text) {
            if (mOnMenuClickListener != null) {
                mOnMenuClickListener.onDeleteClick(v);
            }
        }
    }

    public void close() {
        mIv_delete.setVisibility(VISIBLE);
        mSwipeitem_container.closeWithAnim();
    }

    @Override
    public void onSwipeItemLayoutOpened(SwipeItemLayout swipeItemLayout) {
        mIv_delete.setVisibility(INVISIBLE);
    }

    @Override
    public void onSwipeItemLayoutClosed(SwipeItemLayout swipeItemLayout) {
        mIv_delete.setVisibility(VISIBLE);
    }

    @Override
    public void onSwipeItemLayoutStartOpen(SwipeItemLayout swipeItemLayout) {

    }

    public void setOnMenuClickListener(OnMenuClickListener listener) {
        mOnMenuClickListener = listener;
    }

    public interface OnMenuClickListener {
        /**
         *
         */
        void onDeleteClick(View v);
    }
}
