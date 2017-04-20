package io.github.myersguo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //启动服务
        Intent i = new Intent("io.github.myersguo.uiautoservice");
        i.setPackage("io.github.myersguo.uiautoservice");
        Bundle bundle = new Bundle();
        bundle.putString("key", "value");
        i.putExtras(bundle);
        startService(i);

    }
}
