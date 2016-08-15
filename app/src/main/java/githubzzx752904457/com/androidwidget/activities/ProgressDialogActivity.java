package githubzzx752904457.com.androidwidget.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import githubzzx752904457.com.androidwidget.R;

public class ProgressDialogActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressdialog);

        initProgressDialog();
    }

    /**
     * 用静态方法创建普通环形进度条
     * @param view
     */
    public void showNormalDialog(View view){
        ProgressDialog.show(this, "环形进度条", "任务执行中", false, true);
    }

    public void showHorizontalDialog(View view){
        progressDialog.show();
        handler.sendEmptyMessageDelayed(0, 500);
    }

    private void initProgressDialog(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        /**
         * 自定义显示格式：
         * 当前进度填入%1d位置，总数填入%2d。
         * 这个方法是自动填充的,只要在初始化时，加上这一句，
         * 调用progressDialog.setMax(int )后会自动将总数填入%2d.
         * 同理,调用progressDialog.setProgress(int )后会自动将当前进度填入%1d.
         */
        progressDialog.setProgressNumberFormat("%1d M/%2d M");
        progressDialog.setMax(1024);
        progressDialog.setTitle("任务执行中");
        progressDialog.setMessage("任务完成进度");
        progressDialog.setCancelable(true);
        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                progress = 0 ;
                progressDialog.setProgress(progress);
            }
        });
        //设置ProgressDialog显示进度
        progressDialog.setIndeterminate(false);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0){
                progress++;
                if (progress > 1024){
                    progressDialog.dismiss();
                }else {
                    progressDialog.setProgress(progress);
                    if (progressDialog.isShowing()){
                        handler.sendEmptyMessageDelayed(0, 500);
                    }
                }
            }
        }
    };

}
