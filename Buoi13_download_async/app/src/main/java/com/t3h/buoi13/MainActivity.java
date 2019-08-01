package com.t3h.buoi13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.t3h.buoi13.databinding.ActivityMainBinding;

import java.io.File;

public class MainActivity extends AppCompatActivity implements FileAdapter.onItemFileClickListener {
    private ActivityMainBinding binding;
    private FileAdapter adapter;
    private FileManager manager = new FileManager();
    private String currentFolder;

    private final String[] PERMISSION = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        if (checkPermission()) {
            initView();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(PERMISSION, 0);
            }
        }
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : PERMISSION
            ) {
                int check = checkSelfPermission(p);
                if (check != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_download:
                Intent intent = new Intent(this,DownloadActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initView() {
        adapter = new FileAdapter(this);
        binding.recyclerFile.setAdapter(adapter);
        adapter.setOnItemFileClickListener(this);
        readFile(FileManager.PATH);
    }

    private void readFile(String path) {
        currentFolder = path;
        File[] files = manager.getFiles(path);
        adapter.setData(files);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            initView();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (currentFolder.equals(FileManager.PATH)) {
            super.onBackPressed();
        } else {
            File f = new File(currentFolder);
            readFile(f.getParent());
        }

    }

    @Override
    public void onItemClickListener(File file) {
        if (file.isDirectory()) {
            readFile(file.getPath());
        }
    }
}
