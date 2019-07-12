package com.t3h.buoi11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.t3h.buoi11.fragment.LoginFragment;
import com.t3h.buoi11.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {
    private LoginFragment fmLogin = new LoginFragment();
    private RegisterFragment fmRegister = new RegisterFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        showFragment(fmLogin);
//        showFragment(fmLogin);
    }

//    public void showFragment(Fragment fmShow) {
//        FragmentTransaction fragmentTransaction =
//                getSupportFragmentManager().beginTransaction();
//
//        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//
//        fragmentTransaction.replace(R.id.panel, fmShow);
//        fragmentTransaction.commit();
//    }

    public void initFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.panel,fmLogin);
        transaction.add(R.id.panel,fmRegister);

        transaction.commit();
    }

    public void showFragment(Fragment fmShow){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fmRegister);
        transaction.hide(fmLogin);

        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.show(fmShow);
        transaction.commit();
    }

    public LoginFragment getFmLogin() {
        return fmLogin;
    }

    public void setFmLogin(LoginFragment fmLogin) {
        this.fmLogin = fmLogin;
    }

    public RegisterFragment getFmRegister() {
        return fmRegister;
    }

    public void setFmRegister(RegisterFragment fmRegister) {
        this.fmRegister = fmRegister;
    }
}
