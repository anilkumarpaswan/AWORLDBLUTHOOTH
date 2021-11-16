package com.example.checkbox;

import android.content.Context;
import android.widget.Toast;

public class ToastClass {

    public static void toastClass(Context context,String mass){
        Toast.makeText(context,mass,Toast.LENGTH_SHORT).show();
    }
}
