package com.wushange.mywidget.sensoremptyview;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.schibsted.spain.parallaxlayerlayout.ParallaxLayerLayout;
import com.schibsted.spain.parallaxlayerlayout.SensorTranslationUpdater;
import com.wushange.mywidget.R;


/**
 * Created by wushange on 2016/8/29.
 */
public class EmptyView extends Fragment {

    public void injectEmptyView(FragmentManager fragmentManager) {
        fragmentManager.beginTransaction().replace(android.R.id.content, this).commit();
    }

    public void injectEmptyView(FragmentManager fragmentManager, @IdRes int layoutId) {
        fragmentManager.beginTransaction().replace(layoutId, this).commit();
    }

    public void removeEmptyView(FragmentManager fragmentManager) {
        fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();

    }

    private ParallaxLayerLayout parallaxLayout;
    private SensorTranslationUpdater translationUpdater;
    private RelativeLayout root;
    private TextView mEmptyTextView;
    private EmptyViewConfig emptyViewConfig;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG", "onCreateView");
        ViewGroup main = (ViewGroup) inflater.inflate(R.layout.view_empty_view_ovni, container, false);
        parallaxLayout = (ParallaxLayerLayout) main.findViewById(R.id.parallax);
        root = (RelativeLayout) main.findViewById(R.id.rl_empty_root);
        mEmptyTextView = (TextView) main.findViewById(R.id.tv_empty_tip);
        translationUpdater = new SensorTranslationUpdater(getActivity());
        parallaxLayout.setTranslationUpdater(translationUpdater);

        setUiandListener();
        return main;
    }


    void setUiandListener() {
        if (mEmptyTextView != null) {
            if (emptyViewConfig == null) {
                return;
            }
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (emptyViewConfig.getOnEmptyViewClickListener() != null)
                        emptyViewConfig.getOnEmptyViewClickListener().onEmptyViewClickListener(view,EmptyView.this);
                }
            });
            if (!emptyViewConfig.getEmptyText().isEmpty()) {
                mEmptyTextView.setText(emptyViewConfig.getEmptyText());
            }
            if (emptyViewConfig.getEmptyColor() != 0) {
                mEmptyTextView.setTextColor(getResources().getColor(emptyViewConfig.getEmptyColor()));
            }
            if (emptyViewConfig.getEmptySize() != 0) {
                mEmptyTextView.setTextSize(emptyViewConfig.getEmptySize());
            }
            if (emptyViewConfig.getEmptyBackColor() != 0) {
                root.setBackgroundColor(getResources().getColor(emptyViewConfig.getEmptyBackColor()));
            }
        } else {
            Log.e("TAG", "mEmptyTextView为空了");
        }
    }

    public void setEmptyViewConfig(EmptyViewConfig config) {
        this.emptyViewConfig = config;
    }



    @Override
    public void onResume() {
        Log.e("TAG", "onResume");
        super.onResume();
        translationUpdater.registerSensorManager();
    }

    @Override
    public void onPause() {
        Log.e("TAG", "onPause");
        super.onPause();
        translationUpdater.unregisterSensorManager();
    }

}
