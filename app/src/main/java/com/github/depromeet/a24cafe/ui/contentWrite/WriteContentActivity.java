package com.github.depromeet.a24cafe.ui.contentWrite;

import android.Manifest;
import android.net.Uri;
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

import com.bumptech.glide.Glide;
import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.ui.contentWrite.Presenter.WriteContentContract;
import com.github.depromeet.a24cafe.ui.contentWrite.Presenter.WriteContentPresenter;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
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
import gun0912.tedbottompicker.TedBottomPicker;

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
    @BindView(R.id.content_write_phone)
    EditText editPhone;
    @BindView(R.id.content_write_coffee_price)
    EditText editCoffeePrice;
    @BindView(R.id.write_image)
    ImageView write_image;
    @BindView(R.id.write_image_tmp)
    ScalableLayout write_image_tmp;


    @OnClick(R.id.uploadbutton)
    void click() {
        setImage();
    }

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
        checkPermission();
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

        if (editPhone.getText().toString().equals("")) {
            toast("카페 전화번호를 입력해주세요");
            return;
        }

        if (editPhone.getText().toString().length() > 11 && editPhone.getText().toString().length() < 7) {
            toast("유효한 번호를 입력해주세요");
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

        if (editNearestExit.getText().toString().equals("")) {
            toast("커피가격을 입력해 주세요");
            return;
        }

        if (lat == 0.0 || lon == 0.0) {
            toast("카페 위치를 선택해 주세요.");
            return;
        }

        if (editContent.getText().toString().equals("")) {
            toast("작성평을 입력해주세요");
            return;
        }


        CafeContent content = new CafeContent(
                getIntent().getIntExtra("boardId", -1),
                editCafeName.getText().toString(),
                editContent.getText().toString(),
                lat, lon,
                getDate(),
                startTime, endTime,
                editPhone.getText().toString(),
                Integer.parseInt(editNearestExit.getText().toString()));
        presenter.connect(content);
    }

    private String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

      private void setImage() {
        PermissionListener permissionListener = new PermissionListener() {

            @Override
            public void onPermissionGranted() {

                TedBottomPicker bottomSheetDialogFragment = new TedBottomPicker.Builder(WriteContentActivity.this)
                        .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
                            @Override
                            public void onImageSelected(Uri uri) {
                                Glide.with(getApplicationContext())
                                        .load(uri)
                                        .into(write_image);

                                write_image.setVisibility(View.VISIBLE);
                                write_image_tmp.setVisibility(View.GONE);

                            }
                        })
                        .create();

                bottomSheetDialogFragment.show(getSupportFragmentManager());

            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            }
        };

        new TedPermission(this)
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
    }

    private void checkPermission() {
        PermissionListener camerapermission = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            }
        };

        new TedPermission(getApplicationContext())
                .setPermissionListener(camerapermission)
                // .setDeniedMessage("권한 설정 동의를 안하신다면, 나중에 이곳에서 설정해 주세요. [설정] > [권한]")
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();
    }

    @Override
    public void onLongPressEvent(ArrayList<TMapMarkerItem> arrayList, ArrayList<TMapPOIItem> arrayList1, TMapPoint tMapPoint) {
        Log.d(TAG, "onPressEvent");
        Log.d(TAG, "lat : " + tMapPoint.getLatitude());
        Log.d(TAG, "lon : " + tMapPoint.getLongitude());

        TMapMarkerItem mapMarkerItem = new TMapMarkerItem();
        mapMarkerItem.setPosition(0.5f, 1.0f);
        mapMarkerItem.setTMapPoint(tMapPoint);
        tMapView.removeAllMarkerItem();
        tMapView.addMarkerItem("marker", mapMarkerItem);

        lat = tMapPoint.getLatitude();
        lon = tMapPoint.getLongitude();
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
