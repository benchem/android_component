package team.benchan.androiddemo.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BarcodeBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "BarcodeBroadcastReceive";

    @Override
    public void onReceive(Context context, Intent intent) {
        String recBarcode =  intent.getStringExtra("barcode_string");
        Log.d(TAG, "onReceive: "+recBarcode);
    }
}
