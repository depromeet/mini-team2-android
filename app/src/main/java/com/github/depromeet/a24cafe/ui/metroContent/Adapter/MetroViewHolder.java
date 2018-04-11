package com.github.depromeet.a24cafe.ui.metroContent.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.ui.metroContent.Callback.OnItemClickListener;
import com.ssomai.android.scalablelayout.ScalableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MetroViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = MetroViewHolder.class.getSimpleName();

    private Context context;
    private OnItemClickListener onItemClickListener;

    @BindView(R.id.metro_content_list_linear)
    LinearLayout linearLayout; // 리스트 아이템 전체 view
    @BindView(R.id.metro_content_list_cafe_name)
    TextView tvCafeName;
    @BindView(R.id.metro_clickframe_top)
    FrameLayout frame_top;
    @BindView(R.id.metro_clickframe_bottom)
    FrameLayout frame_bottom;
    @BindView(R.id.metro_click_time)
    TextView time;
    @BindView(R.id.metro_click_price)
    TextView price;


    @BindView(R.id.metro_click)
    ScalableLayout click;

    public MetroViewHolder(final Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.metro_content_list_item, parent, false));

        this.context = context;
        this.onItemClickListener = onItemClickListener;

        ButterKnife.bind(this, itemView);

    }


    public void onBind(final CafeContent cafeContent, final int position) {
        tvCafeName.setText(cafeContent.getTitle());
        price.setText("매일 09:00 ~ 04:00");
        time.setText("아메리카노 4,500원 부터~");

        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        frame_top.setVisibility(View.VISIBLE);
                        frame_bottom.setVisibility(View.VISIBLE);
                        break;
                    case MotionEvent.ACTION_UP:
                        frame_top.setVisibility(View.GONE);
                        frame_bottom.setVisibility(View.GONE);
                        if ((event.getEventTime() - event.getDownTime()) < 1000)
                            linearLayout.performClick();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        frame_top.setVisibility(View.GONE);
                        frame_bottom.setVisibility(View.GONE);
                        break;
                }
                return true;
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(cafeContent, position);
            }
        });


    }
}
