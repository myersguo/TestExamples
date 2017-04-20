package io.github.myersguo.uiautoservice.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.myersguo.uiautoservice.R;
import io.github.myersguo.uiautoservice.constants.Constants;
import io.github.myersguo.uiautoservice.receiver.UIAutoServiceReceiver;
import io.github.myersguo.uiautoservice.service.MyIntentService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册服务接收器
        UIAutoServiceReceiver serviceReceiver = new UIAutoServiceReceiver();
        IntentFilter statusIntentFilter = new IntentFilter(
                Constants.SERVICE_BROADCAST_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(serviceReceiver, statusIntentFilter);
        //启动服务
        Intent i = new Intent(this, MyIntentService.class);
        //Intent i = new Intent(this, MyIntentService.class);
        Bundle bundle = new Bundle();
        bundle.putString("key", "value");
        i.putExtras(bundle);
        startService(i);
    }


}
