package io.github.myersguo.uiautoservice.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import io.github.myersguo.uiautoservice.constants.*;

public class MyIntentService extends IntentService {
    private static final String TAG = MyIntentService.class.getName();

    Intent localIntent = new Intent(Constants.SERVICE_BROADCAST_ACTION);

    public MyIntentService() {
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "start service");
        System.out.println(TAG);
        synchronized (this) {
            try {
                wait(1000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //将测试结果发送出去
        localIntent.putExtra(Constants.SERVICE_DATA_RESULT_KEY, "ok");
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
        Log.d(TAG, "end service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.i(TAG, "Received start id " + startId + ": " + intent);
        return START_STICKY;
    }

}
