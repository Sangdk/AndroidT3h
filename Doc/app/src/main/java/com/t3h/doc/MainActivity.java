package com.t3h.doc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements StoryAdapter.ItemOnClickListener {
    private RecyclerView recyclerView;
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
        data.add(new Story(R.drawable.nt_1, "Ben nhau tron doi", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Ben nhau tron doi" +
                "This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi " +
                "This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi" +
                "This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doiThis is detail of Ben nhau tron doi " +
                "This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi " +
                "This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi" +
                "This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi This is detail of Ben nhau tron doi" +
                "The options menu is where you should include actions and other options that are relevant to the current activity context, such as \"Search,\" \"Compose email,\" and \"Settings.\"\n" +
                "\n" +
                "Where the items in your options menu appear on the screen depends on the version for which you've developed your application:\n" +
                "\n" +
                "If you've developed your application for Android 2.3.x (API level 10) or lower, the contents of your options menu appear at the bottom of the screen when the user presses the Menu button, as shown in figure " +
                "1. When opened, the first visible portion is the icon menu, which holds up to six menu items. If your menu includes more than six items, Android places the sixth item and the rest into the overflow menu, which the user can open by selecting More.\n" +
                "If you've developed your application for Android 3.0 (API level 11) and higher, items from the options menu are available in the app bar. By default, the system places all items in the action overflow, which the user can reveal with the action overflow icon on the right side of the app bar (or by pressing the device Menu button, " +
                "if available). " +
                "To enable quick access to important actions, you can promote a few items to appear in the app bar by adding android:showAsAction=\"ifRoom\" to the corresponding <item> elements (see figure 2)."));
        data.add(new Story(R.drawable.nt_2, "Thuong cung", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Thuong cung"));
        data.add(new Story(R.drawable.nt_3, "Vi em gap anh", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Vi em gap anh"));
        data.add(new Story(R.drawable.nt_4, "Cong tac tinh yeu", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Cong tac tinh yeu"));
        data.add(new Story(R.drawable.nt_1, "Ben nhau tron doi", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Ben nhau tron doi"));
        data.add(new Story(R.drawable.nt_2, "Thuong cung", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Thuong cung"));
        data.add(new Story(R.drawable.nt_3, "Vi em gap anh", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Vi em gap anh"));
        data.add(new Story(R.drawable.nt_4, "Cong tac tinh yeu", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Cong tac tinh yeu"));
        data.add(new Story(R.drawable.nt_1, "Ben nhau tron doi", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Ben nhau tron doi"));
        data.add(new Story(R.drawable.nt_2, "Thuong cung", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Thuong cung"));
        data.add(new Story(R.drawable.nt_3, "Vi em gap anh", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Vi em gap anh"));
        data.add(new Story(R.drawable.nt_4, "Cong tac tinh yeu", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Cong tac tinh yeu"));
        data.add(new Story(R.drawable.nt_1, "Ben nhau tron doi", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Ben nhau tron doi"));
        data.add(new Story(R.drawable.nt_2, "Thuong cung", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Thuong cung"));
        data.add(new Story(R.drawable.nt_3, "Vi em gap anh", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Vi em gap anh"));
        data.add(new Story(R.drawable.nt_4, "Cong tac tinh yeu", "Chuong 53", "Tieu Tuyet", "01/07/2019 00:00:00", "This is detail of Cong tac tinh yeu"));

        adapter.setData(data);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_story);
        adapter = new StoryAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setItemOnClickListener(this);

    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(this, DetailActivity.class);

        Bundle bundle = new Bundle();

        bundle.putString(Const.EXTRA_NAME, data.get(position).getName());
        bundle.putString(Const.EXTRA_AUTHOR, data.get(position).getAuthor());
        bundle.putInt(Const.EXTRA_IMAGE, data.get(position).getImage());
        bundle.putString(Const.EXTRA_STATUS, data.get(position).getStatus());
        bundle.putString(Const.EXTRA_DETAIL, data.get(position).getDetail());

        intent.putExtra(Const.EXTRA_BUNDLE, bundle);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(int position) {

    }
}
