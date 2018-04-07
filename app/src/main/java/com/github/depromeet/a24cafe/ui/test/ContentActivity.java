package com.github.depromeet.a24cafe.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.github.depromeet.a24cafe.R;
import com.skt.Tmap.TMapView;

public class ContentActivity extends AppCompatActivity {
    private static final String TAG = ContentActivity.class.getSimpleName();
    private LinearLayout tMapLayout;
    private TMapView tMapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);

        tMapLayout = findViewById(R.id.tMapLayout);

        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey("3842ec01-f3eb-4d40-9408-1b464b067e43");
        tMapLayout.addView(tMapView);

    }
}
