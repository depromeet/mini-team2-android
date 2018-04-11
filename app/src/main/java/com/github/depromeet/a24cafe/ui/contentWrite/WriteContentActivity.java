package com.github.depromeet.a24cafe.ui.contentWrite;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.ui.contentWrite.Presenter.WriteContentContract;
import com.github.depromeet.a24cafe.ui.contentWrite.Presenter.WriteContentPresenter;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;
import com.ssomai.android.scalablelayout.ScalableLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WriteContentActivity extends AppCompatActivity implements WriteContentContract.View, TMapView.OnLongClickListenerCallback {
    private static final String TAG = WriteContentActivity.class.getSimpleName();

    @BindView(R.id.content_write_tmap)
    RelativeLayout tMapLayout;
    @BindView(R.id.content_write_btn)
    ImageView btnWrite;
    @BindView(R.id.content_write_map_framelayout)
    FrameLayout mapView;
    @BindView(R.id.content_write_map_invisible)
    ScalableLayout scalableLayoutMain; // 맵 처음화면
    @BindView(R.id.content_write_map_visible)
    ScalableLayout scalableLayoutMap; // 맵 화면
    @BindView(R.id.content_write_cafe_name)
    EditText editCafeName;
    @BindView(R.id.content_write_start_time)
    EditText editStartTime;
    @BindView(R.id.content_write_end_time)
    EditText editEndTime;
    @BindView(R.id.nearestExit)
    EditText editNearestExit;
    @BindView(R.id.content_write_content)
    EditText editContent;

    private WriteContentPresenter presenter;
    private TMapView tMapView;

    private double lat = 0.0;
    private double lon = 0.0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_content_write);

        ButterKnife.bind(this);

        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey(getString(R.string.tmap_key));
        tMapView.setOnLongClickListenerCallback(this);
        tMapLayout.addView(tMapView);

        presenter = new WriteContentPresenter(this);
        presenter.attachView(this);

    }

    @OnClick(R.id.content_write_map_framelayout)
    public void mapClick(View view) {
        scalableLayoutMain.setVisibility(View.INVISIBLE);
        scalableLayoutMap.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.content_write_btn)
    public void writeBtnClick(View view) {

        if (editCafeName.getText().toString().equals("")) {
            toast("카페 이름을 입력해주세요");
            return;
        }

        if (editStartTime.getText().toString().equals("")) {
            toast("시작 시간을 입력해주세요");
            return;
        }

        if (editEndTime.getText().toString().equals("")) {
            toast("종료 시간을 입력해주세요");
            return;
        }

        int startTime = Integer.parseInt(editStartTime.getText().toString());
        int endTime = Integer.parseInt(editEndTime.getText().toString());

        if (startTime > 24 || startTime < 0) {
            toast("0 - 24 사이 시간을 입력해주세요");
            return;
        }

        if (endTime > 24 || endTime < 0) {
            toast("0 - 24 사이 시간을 입력해주세요");
            return;
        }

        if (editNearestExit.getText().toString().equals("")) {
            toast("인접 출구를 입력해주세요");
            return;
        }

        if (editContent.getText().toString().equals("")) {
            toast("작성평을 입력해주세요");
            return;
        }

        CafeContent content = new CafeContent(
                1,
                editCafeName.getText().toString(),
                editContent.getText().toString(),
                0.0, 0.0,
                getDate(),
                startTime, endTime,
                "00012341234",
                Integer.parseInt(editNearestExit.getText().toString()));

        presenter.connect(content);
    }

    private String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    @Override
    public void onLongPressEvent(ArrayList<TMapMarkerItem> arrayList, ArrayList<TMapPOIItem> arrayList1, TMapPoint tMapPoint) {
        Log.d(TAG, "onPressEvent");
        Log.d(TAG, "lat : " + tMapPoint.getLatitude());
        Log.d(TAG, "lon : " + tMapPoint.getLongitude());

        arrayList.clear();

    }

    @Override
    public void toast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(WriteContentActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
