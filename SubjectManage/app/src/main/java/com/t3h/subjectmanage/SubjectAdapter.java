package com.t3h.subjectmanage;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.subjectHolder> {
    private ArrayList<Subject> data;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    public SubjectAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<Subject> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public subjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.item_subject, viewGroup, false);

        return new subjectHolder(v);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull subjectHolder subjectHolder, final int i) {
        final Subject item = data.get(i);
        subjectHolder.bindData(item);

        if (itemClickListener != null) {
            subjectHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClicked(i);
                }
            });
            subjectHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemClickListener.onItemLongClicked(i);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class subjectHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtName, txtSubjectName, txtPoint;

        public subjectHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_subject);
            txtName = itemView.findViewById(R.id.text_name);
            txtSubjectName = itemView.findViewById(R.id.text_subject_name);
            txtPoint = itemView.findViewById(R.id.text_point);
        }

        public void bindData(Subject item) {
            imageView.setImageResource(item.getImage());
            txtName.setText(item.getName());
            txtSubjectName.setText(item.getSubjectName());
            String point = Float.toString(item.getPoint());
            txtPoint.setText(point);
        }
    }

    public interface ItemClickListener {
        void onItemClicked(int position);

        void onItemLongClicked(int position);
    }
}