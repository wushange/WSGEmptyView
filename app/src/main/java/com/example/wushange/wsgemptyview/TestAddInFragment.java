package com.example.wushange.wsgemptyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wushange on 2016/9/7.
 */
public class TestAddInFragment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new TestFragment()).commit();

    }

}
