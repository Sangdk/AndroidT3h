package com.t3h.doc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder> {
    private ArrayList<Story> data;
    private LayoutInflater inflater;

    public StoryAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<Story> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_story,parent,false);

        return new StoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryHolder holder, int position) {
        Story item = data.get(position);
        holder.bindData(item);

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class StoryHolder extends RecyclerView.ViewHolder {
        private CircleImageView circleImage;
        private TextView txtName, txtStatus, txtPubDate;

        public StoryHolder(@NonNull View itemView) {
            super(itemView);

            circleImage = itemView.findViewById(R.id.circle_img);
            txtName = itemView.findViewById(R.id.txt_name);
            txtStatus = itemView.findViewById(R.id.txt_status_author);
            txtPubDate = itemView.findViewById(R.id.txt_pub_date);
        }

        public void bindData(Story item) {
            circleImage.setImageResource(item.getImage());
            txtName.setText(item.getName());
            txtPubDate.setText(item.getPubDate());
            txtStatus.setText(item.getStatus());

        }
    }

}
