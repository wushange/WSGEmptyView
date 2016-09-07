package com.example.wushange.wsgemptyview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wushange.mywidget.sensoremptyview.EmptyView;
import com.wushange.mywidget.sensoremptyview.EmptyViewConfig;

public class TestFragment extends Fragment implements View.OnClickListener {

    Button add;
    Button remove;

    EmptyViewConfig emptyViewConfig;
    EmptyView emptyView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG", "onCreateView");
        ViewGroup main = (ViewGroup) inflater.inflate(R.layout.test_fragment, container, false);
        add = (Button) main.findViewById(R.id.btn_add);
        remove = (Button) main.findViewById(R.id.btn_remove);
        add.setOnClickListener(this);
        remove.setOnClickListener(this);
        return main;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_add:
                emptyViewConfig = new EmptyViewConfig();
                emptyViewConfig.setEmptyText("我是在Fragmnt中add的");
                emptyViewConfig.setOnEmptyViewClickListener(new EmptyViewConfig.OnEmptyViewClickListener() {
                    @Override
                    public void onEmptyViewClickListener(View view, EmptyView emptyView) {

                        Toast.makeText(getContext(), "点击操作", Toast.LENGTH_SHORT).show();
                    }
                });
                emptyView = new EmptyView();
                emptyView.setEmptyViewConfig(emptyViewConfig);
                emptyView.injectEmptyView(getFragmentManager(), R.id.content_layout);
                break;
            case R.id.btn_remove:
                if (emptyView != null)
                    emptyView.removeEmptyView(getFragmentManager());
                break;
        }

    }
}
