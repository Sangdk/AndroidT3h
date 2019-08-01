package com.t3h.buoi13.download;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadAsync extends AsyncTask<String, Integer, String> {

    private DownloadCallback callback;

    public DownloadAsync(DownloadCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String link = strings[0];
        return download(link);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        callback.onDownloadUpdate(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        callback.onDownloadSuccess(s);
        Log.d("xxx",s);
    }

    private String download(String link) {
        try {
            //connect file internet
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();

            //create local file
            String path = Environment.getExternalStorageDirectory().getPath()
                    + "/1902/" + System.currentTimeMillis()
                    + ".mp4";
            File file = new File(path);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);

            //write file
            byte[] b = new byte[1024];
            int total = connection.getContentLength();
            int current = 0;
            int count = in.read(b);
            while (count > 0) {
                // calculator percent of downloaded
                current += count;
                int percent = current * 100 / total;
                //update ui
                publishProgress(percent);
                //write file
                out.write(b, 0, count);
                count = in.read(b);
            }
            in.close();
            out.close();
            return file.getPath();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface DownloadCallback {
        void onDownloadUpdate(int percent);

        void onDownloadSuccess(String path);
    }
}
