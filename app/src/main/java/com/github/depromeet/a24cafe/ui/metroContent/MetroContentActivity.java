package com.github.depromeet.a24cafe.ui.metroContent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.MetroContent;
import com.github.depromeet.a24cafe.ui.metroContent.Adapter.MetroAdapter;
import com.github.depromeet.a24cafe.ui.metroContent.Presenter.MetroContentContract;
import com.github.depromeet.a24cafe.ui.metroContent.Presenter.MetroContentPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MetroContentActivity extends AppCompatActivity implements MetroContentContract.View {
    private static final String TAG = MetroContentActivity.class.getSimpleName();

    @BindView(R.id.metro_name)
    TextView tvMetroName;
    @BindView(R.id.metro_content_list)
    RecyclerView recyclerView;
    MetroAdapter adapter;

    private MetroContentContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metro_content);

        /*tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey(getString(R.string.tmap_key));
        tMapLayout.addView(tMapView);*/

        init();
    }

    private void init() {
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MetroAdapter(this);
        recyclerView.setAdapter(adapter);

        ArrayList<MetroContent> items = new ArrayList<>();
        items.add(new MetroContent("그린클라우드", 1));
        items.add(new MetroContent("그린클라우드", 2));
        items.add(new MetroContent("그린클라우드", 3));

        presenter = new MetroContentPresenter(this);
        presenter.attachView(this);
        presenter.setListModelCallback(adapter);
        presenter.setListViewCallback(adapter);
        presenter.loadItems(items);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void toast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MetroContentActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
