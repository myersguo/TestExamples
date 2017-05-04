package io.github.myersguo.myapplication;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import static android.R.attr.type;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册服务接收器
        MyReceiver serviceReceiver = new MyReceiver();
        IntentFilter statusIntentFilter = new IntentFilter("io.github.myersguo.uiautoservice.BROADCAST");
        registerReceiver(serviceReceiver, statusIntentFilter);
        //启动服务
        Intent i = new Intent("io.github.myersguo.uiautoservice");
        i.setPackage("io.github.myersguo.uiautoservice");
        Bundle bundle = new Bundle();
        String cmd = "[{\"type\":\"shell\", \"shell\": \"monkey 5000\"}]";
        bundle.putString("case", cmd);
        i.putExtras(bundle);
        startService(i);

    }

}
