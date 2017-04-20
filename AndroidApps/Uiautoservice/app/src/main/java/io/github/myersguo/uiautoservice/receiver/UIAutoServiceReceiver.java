package io.github.myersguo.uiautoservice.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import io.github.myersguo.uiautoservice.constants.Constants;
import io.github.myersguo.uiautoservice.service.MyIntentService;

import static android.content.ContentValues.TAG;

public class UIAutoServiceReceiver extends BroadcastReceiver {

    private static final String TAG = UIAutoServiceReceiver.class.getName();

    public UIAutoServiceReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getStringExtra(Constants.SERVICE_DATA_RESULT_KEY);
        Log.d(TAG, "get service result" + result);
    }
}
