package com.t3h.buoi14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.buoi14.databinding.ItemViewBinding;
import com.t3h.buoi14.model.Song;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    LayoutInflater inflater;
    List<Song> data;
    private ItemSOngClickListener listener;
    private SimpleDateFormat format = new SimpleDateFormat("mm:ss");

    public SongAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding = ItemViewBinding.inflate(inflater, parent, false);
        return new SongHolder(binding);
    }

    public void setData(List<Song> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(ItemSOngClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, final int position) {
        final Song item = data.get(position);
        holder.bindData(item);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    listener.onItemSongClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        private ItemViewBinding biding;

        public SongHolder(@NonNull ItemViewBinding biding) {
            super(biding.getRoot());
            this.biding = biding;
        }

        public void bindData(Song item) {
            biding.textName.setText(item.getTitle());
            biding.textArtist.setText(item.getArtist());
            String time = format.format(new Date(item.getDuration()));
            biding.textDuration.setText(time);
            biding.textSize.setText(readableFileSize(item.getSize()));
        }

    }

    public String readableFileSize(long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public interface ItemSOngClickListener {
        void onItemSongClick(int position);
    }
}
