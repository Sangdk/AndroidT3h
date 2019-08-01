package com.t3h.buoi12;

import android.content.Context;
import android.content.SharedPreferences;

public class MyShared {
    private SharedPreferences preferences;

    public MyShared(Context context) {
        preferences = context.getSharedPreferences("MyShared", Context.MODE_PRIVATE);

    }

    public void put(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String get(String key){
        return preferences.getString(key,"");
    }

    public void reset(){
        preferences.edit().clear().commit();
    }
}
