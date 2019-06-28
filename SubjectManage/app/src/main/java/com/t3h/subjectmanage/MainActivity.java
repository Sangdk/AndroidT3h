package com.t3h.subjectmanage;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SubjectAdapter.ItemClickListener {

    private RecyclerView recyclerSubject;
    private ArrayList<Subject> data;
    private SubjectAdapter adapter;
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Subject(R.drawable.english,"English","iKeD",3.0f));
        data.add(new Subject(R.drawable.geography,"Geography","iKeD",2.0f));
        data.add(new Subject(R.drawable.science,"Science","iKeD",2.5f));
        data.add(new Subject(R.drawable.english,"English","iKeD",3.0f));
        data.add(new Subject(R.drawable.geography,"Geography","iKeD",2.0f));
        data.add(new Subject(R.drawable.science,"Science","iKeD",2.5f));
        data.add(new Subject(R.drawable.english,"English","iKeD",3.0f));
        data.add(new Subject(R.drawable.geography,"Geography","iKeD",2.0f));
        data.add(new Subject(R.drawable.science,"Science","iKeD",2.5f));
        data.add(new Subject(R.drawable.english,"English","iKeD",3.0f));
        data.add(new Subject(R.drawable.geography,"Geography","iKeD",2.0f));
        data.add(new Subject(R.drawable.science,"Science","iKeD",2.5f));
        data.add(new Subject(R.drawable.english,"English","iKeD",3.0f));
        data.add(new Subject(R.drawable.geography,"Geography","iKeD",2.0f));
        data.add(new Subject(R.drawable.science,"Science","iKeD",2.5f));

        adapter.setData(data);

    }

    private void initView() {
        recyclerSubject = findViewById(R.id.recycler_subject);
        adapter = new SubjectAdapter(this);
        recyclerSubject.setAdapter(adapter);
        adapter.setItemClickListener(this);
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(this,UpdateActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemLongClicked(int position) {
        confirm(position);
    }

    private void confirm(final int position) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Are you sure want to delete?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                data.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position,data.size());

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }
}
