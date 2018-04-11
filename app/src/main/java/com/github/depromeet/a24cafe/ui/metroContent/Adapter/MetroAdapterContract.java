package com.github.depromeet.a24cafe.ui.metroContent.Adapter;

import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.ui.metroContent.Callback.OnItemClickListener;

import java.util.ArrayList;

public interface MetroAdapterContract {
    interface View {
        void setOnClickListener(OnItemClickListener onClickListener);

        void notifyAdapter();
    }

    interface Model {
        ArrayList getItems();

        CafeContent getItem(int position);

        void setItems(ArrayList items);
    }
}
