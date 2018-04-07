package com.github.depromeet.a24cafe.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.ui.test.Presenter.ContentContract;
import com.github.depromeet.a24cafe.ui.test.Presenter.ContentPresenter;
import com.skt.Tmap.TMapView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentActivity extends AppCompatActivity implements ContentContract.View {
    private static final String TAG = ContentActivity.class.getSimpleName();

    @BindView(R.id.tMapLayout)
    LinearLayout tMapLayout;

    private ContentContract.Presenter presenter;
    private TMapView tMapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);
        ButterKnife.bind(this);

        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey(getString(R.string.tmap_key));
        tMapLayout.addView(tMapView);

        presenter = new ContentPresenter(this);
        presenter.attachView(this);
        init();
    }

    private void init() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void toast(String msg) {

    }
}
