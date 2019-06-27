package com.t3h.buoi8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FaceAdapter.ItemClickListener {

    private RecyclerView rvFace;
    private ArrayList<Face> data;
    private FaceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Face(R.drawable.cry,"cry"));
        data.add(new Face(R.drawable.cryy,"cryy"));
        data.add(new Face(R.drawable.cryyyy,"cryyyy"));
        data.add(new Face(R.drawable.cry,"cry"));
        data.add(new Face(R.drawable.cryy,"cryy"));
        data.add(new Face(R.drawable.cryyyy,"cryyyy"));data.add(new Face(R.drawable.cry,"cry"));
        data.add(new Face(R.drawable.cryy,"cryy"));
        data.add(new Face(R.drawable.cryyyy,"cryyyy"));data.add(new Face(R.drawable.cry,"cry"));
        data.add(new Face(R.drawable.cryy,"cryy"));
        data.add(new Face(R.drawable.cryyyy,"cryyyy"));


        adapter.setData(data);
    }

    private void initView() {
        rvFace = findViewById(R.id.rc_list_view);
        adapter = new FaceAdapter(this);
        rvFace.setAdapter(adapter);
        adapter.setItemClickListener(this);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this,data.get(position).getName(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemLongClick(int position) {
        data.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position,data.size());
    }
}
