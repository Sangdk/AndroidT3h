package com.t3h.buoi13;

import android.os.Environment;

import java.io.File;

public class FileManager {
    public static final String PATH =
            Environment.getExternalStorageDirectory().getPath();

    public File[] getFiles(String path) {
        File f = new File(path);
        return f.listFiles();
    }
}
