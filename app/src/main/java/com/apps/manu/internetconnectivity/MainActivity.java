package com.apps.manu.internetconnectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!haveNetworkConnection()) {
            Log.d("main", "no");
            Toast.makeText(getApplicationContext(),"Please Check your internet Connectivity",Toast.LENGTH_LONG).show();
            finish();
        }else{
            Log.d("main", "yes");
            Toast.makeText(getApplicationContext(),"Internet in connected",Toast.LENGTH_LONG).show();
        }
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        Log.d("module", "entered");

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            Log.d("module", "WIFI"+haveConnectedWifi);
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
            Log.d("module", "MD"+haveConnectedMobile);
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
