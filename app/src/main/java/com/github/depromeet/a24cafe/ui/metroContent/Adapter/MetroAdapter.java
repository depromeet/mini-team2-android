package com.github.depromeet.a24cafe.ui.metroContent.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.ui.metroContent.Callback.OnItemClickListener;

import java.util.ArrayList;

public class MetroAdapter extends RecyclerView.Adapter<MetroViewHolder>
                implements MetroAdapterContract.View, MetroAdapterContract.Model {
    private static final String TAG = MetroAdapter.class.getSimpleName();

    private Context context;
    private ArrayList<CafeContent> items;
    private OnItemClickListener onItemClickListener;

    public MetroAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    @Override
    public MetroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MetroViewHolder(context, parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(MetroViewHolder holder, int position) {
        if (holder == null)
            return;
        holder.onBind(items.get(position), position);
    }

    @Override
    public void setOnClickListener(OnItemClickListener onClickListener) {
        this.onItemClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public ArrayList getItems() {
        return items;
    }

    @Override
    public CafeContent getItem(int position) {
        return items.get(position);
    }

    @Override
    public void setItems(ArrayList items) {
        this.items.clear();
        this.items = items;
        notifyDataSetChanged();
    }
}
