package com.t3h.buoi11.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.t3h.buoi11.MainActivity;
import com.t3h.buoi11.R;

public class LoginFragment extends BaseFragment<MainActivity> implements View.OnClickListener {
    private EditText edtUserName, edtPass;
    private Button btnLogin, btnRegister;
    private final String TAG = "LoginFragment";

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        Log.e(TAG, "onCreateView");
//        View v = inflater.inflate(R.layout.activity_login, container, false);
//        return v;
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onActivityCreated");
        initView();
        super.onActivityCreated(savedInstanceState);
    }

    private void initView() {
        edtUserName = findViewById(R.id.edt_user_name);
        edtPass = findViewById(R.id.edt_pass_word);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    public void setData(String userName, String passWord) {
        edtUserName.setText(userName);
        edtPass.setText(passWord);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                break;
            case R.id.btn_register:
                getParentActivity().showFragment(getParentActivity().getFmRegister());
//                MainActivity main = (MainActivity) getActivity();
//                main.showFragment(main.getFmRegister());
                break;
        }
    }
}
