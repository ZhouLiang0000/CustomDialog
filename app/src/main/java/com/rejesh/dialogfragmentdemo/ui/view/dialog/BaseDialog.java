package com.rejesh.dialogfragmentdemo.ui.view.dialog;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.rejesh.dialogfragmentdemo.R;

/**
 * Created by zhufeng on 2017/1/12.
 */
public abstract class BaseDialog extends DialogFragment {
    protected View mContentView;
    protected DialogOptions options = null;

    @NonNull
    protected abstract DialogOptions initDialogOptions();

    @NonNull
    protected abstract int injectLayoutDependency();

    @Override
    public void show(FragmentManager manager, String tag) {
        options = initDialogOptions();
        if (options == null) {
            options = DialogOptions.popupDialogOptions();
        }
        super.show(manager, tag);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, R.style.BaseDialog);
        setCancelable(options.isCancelable());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window = getDialog().getWindow();
        mContentView = LayoutInflater.from(getActivity()).inflate(injectLayoutDependency(), ((ViewGroup) window.findViewById(android.R.id.content)), false);

        window.setLayout(options.getWidth(), options.getHeight());
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setWindowAnimations(options.getShowAnim());

        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = options.getWindowAlpha();
        windowParams.alpha = options.getDialogAlpha();
        windowParams.gravity = options.getGravity();
        windowParams.x = options.getMoveXBy();
        windowParams.y = options.getMoveYby();
        window.setAttributes(windowParams);

        return mContentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initEvents();
    }

    protected void initView() {
    }

    protected void initData() {
    }

    protected void initEvents() {
    }

}
