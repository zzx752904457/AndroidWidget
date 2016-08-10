package githubzzx752904457.com.automoveimageview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.StackView;

import githubzzx752904457.com.automoveimageview.R;
import githubzzx752904457.com.automoveimageview.adapters.ImageAdapter;

public class StackViewActivity extends AppCompatActivity {
    private ImageAdapter mAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stackview);

        mAdpater = new ImageAdapter(this);

        initStackView(mAdpater);
    }

    private void initStackView(Adapter adapter) {
        StackView mStackView = (StackView) findViewById(R.id.mStackView);
        mStackView.setAdapter(adapter);
    }
}
