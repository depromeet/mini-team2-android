package com.github.depromeet.a24cafe.ui.metroContent.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.MetroContent;
import com.github.depromeet.a24cafe.ui.content.ContentActivity;
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


    @BindView(R.id.metro_click)
    ScalableLayout click;

    public MetroViewHolder(final Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.metro_content_list_item, parent, false));

        this.context = context;
        this.onItemClickListener = onItemClickListener;

        ButterKnife.bind(this, itemView);

    }



    public void onBind(final MetroContent metroContent, final int position) {
        tvCafeName.setText(metroContent.getTitle());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(metroContent, position);
            }
        });

 
    }
}
