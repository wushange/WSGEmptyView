package com.example.wushange.wsgemptyview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wushange.mywidget.sensoremptyview.EmptyView;
import com.wushange.mywidget.sensoremptyview.EmptyViewConfig;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button addInAct;
    Button addInFgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addInAct = (Button) findViewById(R.id.btn_add_in_activity);
        addInFgm = (Button) findViewById(R.id.btn_add_in_fragment);
        addInAct.setOnClickListener(this);
        addInFgm.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_in_activity:
                EmptyViewConfig emptyViewConfig = new EmptyViewConfig();
                emptyViewConfig.setEmptyText("请求错误点击重试,(点击销毁)");
                emptyViewConfig.setOnEmptyViewClickListener(new EmptyViewConfig.OnEmptyViewClickListener() {
                    @Override
                    public void onEmptyViewClickListener(View view, EmptyView emptyView) {
                        //这个是隐藏了view 但是fragment还在  这里为了演示
                        // view.setVisibility(View.GONE);
                        //需要销毁fragment 请调用EmptyView.removeEmptyView
                        emptyView.removeEmptyView(getSupportFragmentManager());
                    }
                });
                EmptyView emptyView = new EmptyView();
                emptyView.setEmptyViewConfig(emptyViewConfig);
                emptyView.injectEmptyView(getSupportFragmentManager());
                break;
            case R.id.btn_add_in_fragment:
                Log.e("TAG", "aaaaa");
                startActivity(new Intent(this, TestAddInFragment.class));
                break;
        }

    }
}
