package com.rejesh.dialogfragmentdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rejesh.dialogfragmentdemo.R;
import com.rejesh.dialogfragmentdemo.ui.view.dialog.TestAlphaDialog;
import com.rejesh.dialogfragmentdemo.ui.view.dialog.TestDownDialog;
import com.rejesh.dialogfragmentdemo.ui.view.dialog.TestUpDialog;

public class MainActivity extends AppCompatActivity {
    TestUpDialog testUpDialog = null;
    TestDownDialog testDownDialog = null;
    TestAlphaDialog testAlphaDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testUpDialog = TestUpDialog.getInstance();
        testDownDialog = TestDownDialog.getInstance();
        testAlphaDialog = TestAlphaDialog.getInstance();

        findViewById(R.id.btn_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testUpDialog.show(getFragmentManager(),"testUpDialog");
            }
        });

        findViewById(R.id.btn_down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testDownDialog.show(getFragmentManager(),"testDownDialog");
            }
        });

        findViewById(R.id.btn_alpha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testAlphaDialog.show(getFragmentManager(),"testAlphaDialog");
            }
        });
    }
}
