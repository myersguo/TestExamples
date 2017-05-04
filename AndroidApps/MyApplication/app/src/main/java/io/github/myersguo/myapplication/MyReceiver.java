package io.github.myersguo.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = MyReceiver.class.getName();


    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getStringExtra("io.github.myersguo.uiautoservice.RESULT");
        Log.d(TAG, "get service result " + result);
    }
}
