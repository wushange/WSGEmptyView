package com.wushange.mywidget.sensoremptyview;

import android.view.View;

import java.io.Serializable;

/**
 * Created by wushange on 2016/9/7.
 */
public class EmptyViewConfig implements Serializable {

    private String emptyText;
    private int emptyColor;
    private int emptySize;
    private int emptyBackColor;
    private OnEmptyViewClickListener onEmptyViewClickListener;


    public String getEmptyText() {
        return emptyText;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }

    public int getEmptyColor() {
        return emptyColor;
    }

    public void setEmptyColor(int emptyColor) {
        this.emptyColor = emptyColor;
    }

    public int getEmptySize() {
        return emptySize;
    }

    public void setEmptySize(int emptySize) {
        this.emptySize = emptySize;
    }

    public int getEmptyBackColor() {
        return emptyBackColor;
    }

    public void setEmptyBackColor(int emptyBackColor) {
        this.emptyBackColor = emptyBackColor;
    }

    public OnEmptyViewClickListener getOnEmptyViewClickListener() {
        return onEmptyViewClickListener;
    }

    public void setOnEmptyViewClickListener(OnEmptyViewClickListener onEmptyViewClickListener) {
        this.onEmptyViewClickListener = onEmptyViewClickListener;
    }

    public interface OnEmptyViewClickListener {
        void onEmptyViewClickListener(View view,EmptyView emptyView);
    }

}
