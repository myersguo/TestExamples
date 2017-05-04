package io.github.myersguo.uiautoservice.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;
import android.os.Handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.github.myersguo.uiautoservice.R;
import io.github.myersguo.uiautoservice.constants.*;


public class MyIntentService extends IntentService {
    private static final String TAG = MyIntentService.class.getName();
    private Handler handler;

    Intent localIntent = new Intent(Constants.SERVICE_BROADCAST_ACTION);

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "start service");
        JSONArray  cmdJson = null;
        //获取数据
        //org.json.JSONException: Value {{'type':'shell', 'shell':'monkey 50'}} of type java.lang.String cannot be converted to JSONArray
        try {
            String cmds = intent.getStringExtra("case");
            cmdJson = new JSONArray(cmds);
            for(int i=0; i<cmdJson.length(); i++) {
                JSONObject row = cmdJson.getJSONObject(i);
                String type = row.getString("type");
                Log.i(TAG, "case type" + type);
                if(type.equals("shell")){
                    //执行shell
                    String shell=row.getString("shell");
                    try {
                        Log.i(TAG, "exe shell " + shell);
                        Process process = Runtime.getRuntime().exec(shell);
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                process.getInputStream()));
                        String line="";
                        StringBuilder sb = new StringBuilder();
                        while(((line = br.readLine())!=null)){
                            line = line.trim();
                            if(line.equals(""))continue;
                            sb.append(line);
                            sb.append("\r\n");
                        }
                        try {
                            process.waitFor();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(sb.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        //如果命令是exec,则执行之
        //执行自动化测试
//        synchronized (this) {
//            try {
//                wait(1000*2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        localIntent.putExtra(Constants.SERVICE_DATA_RESULT_KEY, "ok");
        localIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        //LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
        sendBroadcast(localIntent);
        this.makeToast("auto service stopping");
        this.makeNotification("auto service","hi");

        Log.d(TAG, "end service");
    }
    public class MyRunable implements Runnable {
        public String msg;
        public String title;
        public MyRunable(String msg) {
            this.msg = msg;
        }
        public MyRunable(String title, String msg) {
            this.title = title;
            this.msg = msg;
        }
        @Override
        public void run() {
            //
        }
    }
    private void makeToast(String msg) {
        handler.post(new MyRunable(msg) {
            @Override
            public void run() {
                Toast.makeText(MyIntentService.this, this.msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void makeNotification(String title, String msg) {
        //android.os.Debug.waitForDebugger();
        handler.post(new MyRunable(title, msg) {
            @Override
            public void run() {
                NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(MyIntentService.this);
                mBuilder.setContentTitle(this.title);
                mBuilder.setContentText(this.msg);
                mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(this.msg));
                mBuilder.setSmallIcon(R.drawable.ic_launcher);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1, mBuilder.build());
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Received start id " + startId + ": " + intent);
        Toast.makeText(this, "auto service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

}
