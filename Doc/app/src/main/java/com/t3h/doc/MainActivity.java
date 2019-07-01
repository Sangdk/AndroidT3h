package com.t3h.doc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<Story> data;
    private StoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        initData();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Story(R.drawable.nt_1,"Ben nhau tron doi","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_2,"Thuong cung","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_3,"Vi em gap anh","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_4,"Cong tac tinh yeu","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_1,"Ben nhau tron doi","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_2,"Thuong cung","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_3,"Vi em gap anh","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_4,"Cong tac tinh yeu","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));data.add(new Story(R.drawable.nt_1,"Ben nhau tron doi","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_2,"Thuong cung","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_3,"Vi em gap anh","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_4,"Cong tac tinh yeu","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_1,"Ben nhau tron doi","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_2,"Thuong cung","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_3,"Vi em gap anh","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));
        data.add(new Story(R.drawable.nt_4,"Cong tac tinh yeu","Chuong 53","Tieu Tuyet","17/9/1997 01:07:2019"));

        adapter.setData(data);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_story);
        adapter = new StoryAdapter(this);
        recyclerView.setAdapter(adapter);
        
    }
}
