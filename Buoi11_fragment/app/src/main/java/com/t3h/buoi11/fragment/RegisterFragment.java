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

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private final String TAG="RegisterFragment";
    private EditText edtUsername, edtPass;
    private Button btnRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        View v = inflater.inflate(R.layout.activity_register,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onActivityCreated");
        initView();
        super.onActivityCreated(savedInstanceState);
    }

    private void initView() {
        edtUsername = getActivity().findViewById(R.id.edt_user_name_re);
        edtPass = getActivity().findViewById(R.id.edt_pass_word_re);
        btnRegister = getActivity().findViewById(R.id.btn_register_re);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        main.showFragment(main.getFmLogin());

        String user = edtUsername.getText().toString();
        String pass = edtPass.getText().toString();

        main.getFmLogin().setData(user,pass);

        edtUsername.setText("");
        edtPass.setText("");

    }
}
