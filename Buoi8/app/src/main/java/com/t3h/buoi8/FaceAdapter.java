package com.t3h.buoi8;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder> {
    private ArrayList<Face> data;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    public FaceAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(ArrayList<Face> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_face, parent, false);
        return new FaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceHolder holder, final int position) {
        Face item = data.get(position);
        holder.bindData(item);

        if (itemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClicked(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemClickListener.onItemLongClick(position);
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class FaceHolder extends RecyclerView.ViewHolder {
        private ImageView imAvatar;
        private TextView tvName;

        public FaceHolder(@NonNull View itemView) {
            super(itemView);

            imAvatar = itemView.findViewById(R.id.im_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bindData(Face item) {
            imAvatar.setImageResource(item.getAvatar());
            tvName.setText(item.getName());
        }
    }

    public interface ItemClickListener {
        void onItemClicked(int position);

        void onItemLongClick(int position);

    }
}
