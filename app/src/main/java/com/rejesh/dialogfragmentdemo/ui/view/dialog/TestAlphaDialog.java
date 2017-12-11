package com.rejesh.dialogfragmentdemo.ui.view.dialog;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rejesh.dialogfragmentdemo.R;

/**
 * Created by zhufeng on 2017/1/12.
 */

public class TestAlphaDialog extends BaseDialog {
    private TextView numTv;
    private Button plusBtn;
    private Button minusBtn;
    private Button dismissBtn;
    private int countNum = 0;

    public static TestAlphaDialog getInstance(){
        TestAlphaDialog dialog = new TestAlphaDialog();
        return dialog;
    }

    @NonNull
    @Override
    protected DialogOptions initDialogOptions() {
        return DialogOptions.normalDialogOptions();
    }

    @NonNull
    @Override
    protected int injectLayoutDependency() {
        return R.layout.view_dialog;
    }

    @Override
    protected void initView(){
        numTv = (TextView) mContentView.findViewById(R.id.num);
        plusBtn = (Button) mContentView.findViewById(R.id.plus);
        minusBtn = (Button) mContentView.findViewById(R.id.minus);
        dismissBtn = (Button) mContentView.findViewById(R.id.dismiss);
    }

    @Override
    protected void initData(){
        numTv.setText(String.valueOf(countNum));
    }

    @Override
    protected void initEvents(){
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countNum++;
                numTv.setText(String.valueOf(countNum));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countNum--;
                numTv.setText(String.valueOf(countNum));
            }
        });
        dismissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
