package com.example.android.androidProject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null){
            if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(context,"Internet is running by using Wifi Data", Toast.LENGTH_SHORT).show();
            }
            if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(context,"Internet is running by using Mobile Data", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(context,"No Internet", Toast.LENGTH_SHORT).show();
        }

    }
}
