package com.ssiot.remote.yun.unit;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ssiot.remote.R;


//copy from huiyun
public class LinearLayoutForListView extends LinearLayout {
    private BaseAdapter adapter;
    private boolean mUseDivider = true;

    @NonNull
    private final DataSetObserver observer = new DataSetObserver() {
        public void onChanged() {
            super.onChanged();
            bindLinearLayout();
        }
    };
    private View.OnClickListener onClickListener = null;

    public LinearLayoutForListView(Context paramContext) {
        super(paramContext);
        init(paramContext);
    }

    public LinearLayoutForListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext);
    }

    private void addDivider(LayoutInflater paramLayoutInflater, int index) {
        View divideView = paramLayoutInflater.inflate(R.layout.divide_h, this, false);
        divideView.setTag(R.layout.divide_h, "");
        addView(divideView, index);
    }

    private View findNextChildView(int paramInt) {
        View localView;
        if (paramInt >= getChildCount()) {
            return null;
        } else {
            localView = getChildAt(paramInt);
            if (isDivideView(localView)) {
                removeView(localView);
                return null;
            }
            localView.setVisibility(View.VISIBLE);
        }
        return localView;
    }

    private static boolean isDivideView(View paramView) {
        if ((paramView != null) && ("".equals(paramView.getTag(R.layout.divide_h))))
            ;
        for (boolean bool = true;; bool = false)
            return bool;
    }

    public static void setListViewHeightBasedOnChildren(ListView paramListView) {//TODO
        if (paramListView == null) {
            return;
        }
        ListAdapter localListAdapter = paramListView.getAdapter();
        int i = 0;
        for (int j = 0;; j++) {
            if (j >= localListAdapter.getCount()) {
                ViewGroup.LayoutParams localLayoutParams = paramListView.getLayoutParams();
                localLayoutParams.height = (i + paramListView.getDividerHeight()
                        * (-1 + localListAdapter.getCount()));
                paramListView.setLayoutParams(localLayoutParams);
                break;
            }
            View localView = localListAdapter.getView(j, null, paramListView);
            localView.measure(0, 0);
            i += localView.getMeasuredHeight();
        }
    }

    void bindLinearLayout() {
        int i = 0;
        LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
        int count;
        int k;// i与k嵌套循环？//TODO
        if (adapter != null) {
            count = adapter.getCount();
            k = 0;
            if (k < count) {
                View localView1 = findNextChildView(i);
                View localView2 = adapter.getView(k, localView1, this);
                if (localView1 == localView2) {
                    if (localView2 != null) {
                        if (!localView2.isClickable()){
                            localView2.setOnClickListener(onClickListener);
                        }
                        if (mUseDivider) {
                            addDivider(localLayoutInflater, i);
                            i++;
                        }
                        i++;
                    }
                }
            }
        }
        //TODO removeViewAt removeView
    }

    void init(Context paramContext) {
        setOrientation(LinearLayout.VERTICAL);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (adapter != null) {
                adapter.registerDataSetObserver(observer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        try {
            if (null != adapter) {
                adapter.unregisterDataSetObserver(this.observer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAdapter(BaseAdapter paramBaseAdapter) {
        try {
            if (null != adapter) {
                adapter.unregisterDataSetObserver(this.observer);
            }
            adapter = paramBaseAdapter;
            if (null != adapter) {
                adapter.registerDataSetObserver(this.observer);
                bindLinearLayout();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setUseDevider(boolean paramBoolean) {
        mUseDivider = paramBoolean;
    }
}