package githubzzx752904457.com.automoveimageview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import githubzzx752904457.com.automoveimageview.R;

public class TextViewActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

        Object[] obj = new Object[]{"752904457@qq.com", "021-42348564", "www.baidu.com"};

        tv = (TextView) findViewById(R.id.tv);

        tv.setText(String.format("邮箱:%s,电话:%s,网站:%s", obj));
    }
}
