package com.t3h.mp3music.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.mp3music.model.BaseModel;

import java.util.ArrayList;

public class BaseAdapter<T extends BaseModel> extends RecyclerView.Adapter<BaseAdapter<T>.BaseHolder> {

    private ArrayList<T> data;
    private LayoutInflater inflater;
    private int layoutId;
    private BaseItemListener listener;

    public BaseAdapter(Context contex, @LayoutRes int layoutId) {
        inflater = LayoutInflater.from(contex);
        this.layoutId = layoutId;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(BaseItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding biding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        return new BaseHolder(biding);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder holder, int position) {
        T item = data.get(position);
//        holder.binding.setVariable(BR.item, item);
//        holder.binding.setVariable(BR.listener, listener);
        holder.binding.executePendingBindings();
    }

    public class BaseHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;

        public BaseHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

    public interface BaseItemListener {
    }
}
