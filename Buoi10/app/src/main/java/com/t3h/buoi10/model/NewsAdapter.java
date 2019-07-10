package com.t3h.buoi10.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.t3h.buoi10.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private LayoutInflater inflater;
    private List<News> data;

    public NewsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.item_news, parent, false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News item = data.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        private ImageView imgNews;
        private TextView txtTitle, txtDesc, txtDate;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imgNews = itemView.findViewById(R.id.image_news);
            txtTitle = itemView.findViewById(R.id.text_title);
            txtDesc = itemView.findViewById(R.id.text_desc);
            txtDate = itemView.findViewById(R.id.text_pub_date);

        }

        public void bindData(News item) {
            txtTitle.setText(item.getTitle());
            txtDesc.setText(item.getDesc());
            txtDate.setText(item.getPublishedAt());

            Glide.with(imgNews).load(item.getUrlToImage()).into(imgNews);
        }
    }


}
