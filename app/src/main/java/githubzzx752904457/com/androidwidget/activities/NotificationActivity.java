package githubzzx752904457.com.androidwidget.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import githubzzx752904457.com.androidwidget.R;


public class NotificationActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 0x0717;
    private NotificationManager notificationManager;
    private PendingIntent pendingIntent;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this, AnalogAndTextClockActivity.class);
        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        notification = new Notification.Builder(this)
                //设置点击该通知，通知自动消失
                .setAutoCancel(true)
                //设置显示在状态栏的通知提示消息
                .setTicker("您有新短消息")
                //设置通知的图标
                .setSmallIcon(R.mipmap.make)
                //LargeIcon要手机android版本23以上才能使用
//                .setLargeIcon(Icon.createWithResource(this, R.mipmap.make))
                //设置通知的标题
                .setContentTitle("一条通知提醒")
                //设置通知的内容
                .setContentText("请注意时间，不要迟到")
                //设置使用系统默认的设置
                .setDefaults(Notification.DEFAULT_ALL)
                //设置自定义声音
//                .setSound(Uri.parse(""))
                //设置自定义震动
//                .setVibrate(new long[]{0, 50, 100, 150})
                //设置通知显示的时间
                .setWhen(System.currentTimeMillis())
                //设置点击通知要启动的activity
                .setContentIntent(pendingIntent)
                .build();
    }

    /**
     * 发送通知
     * @param v
     */
    public void send(View v) {
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    /**
     * 取消通知
     * @param v
     */
    public void cancel(View v) {
        notificationManager.cancel(NOTIFICATION_ID);
    }
}
