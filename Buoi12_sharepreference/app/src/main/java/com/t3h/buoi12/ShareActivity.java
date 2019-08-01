package com.t3h.buoi12;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.t3h.buoi12.databinding.ActivityShareBinding;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_VALUE = "key_value" ;
    private ActivityShareBinding binding;
    private MyShared shared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_share);
        binding.btnSave.setOnClickListener(this);
        binding.btnDelete.setOnClickListener(this);
        shared = new MyShared(this);
        binding.edtInput.setText(shared.get(KEY_VALUE));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                shared.put(KEY_VALUE, binding.edtInput.getText().toString());
                break;
            case R.id.btn_delete:
                shared.reset();
                break;
        }
    }
}
