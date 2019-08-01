package com.t3h.buoi13;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.t3h.buoi13.databinding.ActivityDownloadBinding;
import com.t3h.buoi13.download.DownloadAsync;
import com.t3h.buoi13.download.DownloadListener;

import java.io.File;
import java.lang.reflect.Method;

public class DownloadActivity extends AppCompatActivity implements DownloadListener, DownloadAsync.DownloadCallback {
    private ActivityDownloadBinding binding;
    private String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=24){
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_download);
        binding.setSuccess(true);
        binding.setListener(this);
    }

    @Override
    public void onDownloadClick() {
        binding.setSuccess(false);
        String link = binding.edtLink.getText().toString();
        if (link.isEmpty()) {
            Toast.makeText(this, "Link is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        DownloadAsync async = new DownloadAsync(this);
        async.execute(link);
    }

    @Override
    public void onPreviewClick() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setType("video/*");
        intent.setData(Uri.fromFile(new File(path)));
        startActivity(intent);
    }

    @Override
    public void onDownloadUpdate(int percent) {
        binding.setPercent(percent);
    }

    @Override
    public void onDownloadSuccess(String path) {
        binding.setSuccess(true);
        this.path =path;
        Log.d("DownloadActivity",path);
    }
}
