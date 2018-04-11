package com.github.depromeet.a24cafe.ui.metroContent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.ui.content.ContentActivity;
import com.github.depromeet.a24cafe.ui.contentWrite.WriteContentActivity;
import com.github.depromeet.a24cafe.ui.metroContent.Adapter.MetroAdapter;
import com.github.depromeet.a24cafe.ui.metroContent.Presenter.MetroContentContract;
import com.github.depromeet.a24cafe.ui.metroContent.Presenter.MetroContentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MetroContentActivity extends AppCompatActivity implements MetroContentContract.View {
    private static final String TAG = MetroContentActivity.class.getSimpleName();

    @BindView(R.id.metro_content_add_btn)
    ImageView btnContent;
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

        btnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MetroContentActivity.this, WriteContentActivity.class);
                intent.putExtra("boardId", getBoardId());
                startActivity(intent);
            }
        });
    }

    private void init() {
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MetroAdapter(this);
        recyclerView.setAdapter(adapter);


        presenter = new MetroContentPresenter(this);
        presenter.attachView(this);
        presenter.setListModelCallback(adapter);
        presenter.setListViewCallback(adapter);
    }

    private int getBoardId() {
        int id = getIntent().getIntExtra("boardId", 0);
        return id;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.connect(getBoardId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void startContentActivity(CafeContent item) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra("boardId", item.getId());
        intent.putExtra("postId", item.getId());
        startActivity(intent);
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
