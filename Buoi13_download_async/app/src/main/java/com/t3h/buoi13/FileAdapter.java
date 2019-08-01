package com.t3h.buoi13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.buoi13.databinding.ItemFileBinding;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.FileHolder> {
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private LayoutInflater inflater;
    private File[] data;
    private onItemFileClickListener onItemFileClickListener;

    public FileAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(File[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemFileClickListener(FileAdapter.onItemFileClickListener onItemFileClickListener) {
        this.onItemFileClickListener = onItemFileClickListener;
    }

    @NonNull
    @Override
    public FileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFileBinding binding = ItemFileBinding.inflate(inflater, parent, false);
        return new FileHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FileHolder holder, int position) {
        final File item = data[position];
        holder.bindData(item);
        if (onItemFileClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemFileClickListener.onItemClickListener(item);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.length;
    }

    public class FileHolder extends RecyclerView.ViewHolder {
        private ItemFileBinding binding;

        public FileHolder(@NonNull ItemFileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(File item) {
            binding.txtTitle.setText(item.getName());
            if (item.isFile()) {
                binding.imgFile.setImageResource(R.drawable.ic_file);
            } else {
                binding.imgFile.setImageResource(R.drawable.ic_folder);
            }
            String time = format.format(new Date(item.lastModified()));
            binding.txtDuration.setText(time);
            binding.txtSize.setText(readableFileSize(item.length()));
        }
        public String readableFileSize(long size) {
            if(size <= 0) return "0";
            final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
            int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
            return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
        }
    }

    public interface onItemFileClickListener {
        void onItemClickListener(File file);
    }
}
