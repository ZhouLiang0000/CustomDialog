package com.rejesh.dialogfragmentdemo.ui.view.dialog;

import android.view.Gravity;
import android.view.ViewGroup;

import com.rejesh.dialogfragmentdemo.R;

/**
 * Created by zhufeng on 2017/1/13.
 * 弹窗参数设置（默认为从下方弹出）
 */
public class DialogOptions {
    private boolean cancelable;
    private int gravity;
    private int showAnim;
    private float dialogAlpha;
    private float windowAlpha;
    private int moveXBy;
    private int moveYby;
    private int width;
    private int height;

    /**
     * 普通弹窗参数设置
     *
     * @return
     */
    public static DialogOptions normalDialogOptions() {
        return new Builder().setLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).setShowAnim(R.style.dialogWindowAnim).setGravity(Gravity.CENTER).build();
    }

    /**
     * 从上方弹出弹窗参数设置
     *
     * @return
     */
    public static DialogOptions popupDialogOptions() {
        return new Builder().build();
    }

    /**
     * 从下方弹出弹窗参数设置
     *
     * @return
     */
    public static DialogOptions popdownDialogOptions() {
        return new Builder().setShowAnim(R.style.pop_down_anim_style).setGravity(Gravity.TOP).build();
    }

    private DialogOptions(Builder builder) {
        this.cancelable = builder.cancelable;
        this.gravity = builder.gravity;
        this.showAnim = builder.showAnim;
        this.dialogAlpha = builder.dialogAlpha;
        this.windowAlpha = builder.windowAlpha;
        this.moveXBy = builder.moveXBy;
        this.moveYby = builder.moveYby;
        this.width = builder.width;
        this.height = builder.height;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public int getGravity() {
        return gravity;
    }

    public int getShowAnim() {
        return showAnim;
    }

    public float getDialogAlpha() {
        return dialogAlpha;
    }

    public float getWindowAlpha() {
        return windowAlpha;
    }

    public int getMoveXBy() {
        return moveXBy;
    }

    public int getMoveYby() {
        return moveYby;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static class Builder {
        private boolean cancelable = true;
        private int gravity = Gravity.BOTTOM;
        private int showAnim = R.style.pop_anim_style;
        private float dialogAlpha = 1.0f;
        private float windowAlpha = 0.5f;
        private int moveXBy = 0;
        private int moveYby = 0;
        private int width = ViewGroup.LayoutParams.MATCH_PARENT;
        private int height = ViewGroup.LayoutParams.WRAP_CONTENT;

        public Builder() {

        }

        public DialogOptions.Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public DialogOptions.Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public DialogOptions.Builder setShowAnim(int showAnim) {
            this.showAnim = showAnim;
            return this;
        }

        public DialogOptions.Builder setDialogAlpha(float dialogAlpha) {
            this.dialogAlpha = dialogAlpha;
            return this;
        }

        public DialogOptions.Builder setWindowAlpha(float windowAlpha) {
            this.windowAlpha = windowAlpha;
            return this;
        }

        public DialogOptions.Builder moveBy(int x, int y) {
            this.moveXBy = x;
            this.moveYby = y;
            return this;
        }

        public DialogOptions.Builder setLayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public DialogOptions build() {
            return new DialogOptions(this);
        }
    }
}
