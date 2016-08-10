package githubzzx752904457.com.androidwidget.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterViewFlipper;

import githubzzx752904457.com.androidwidget.R;
import githubzzx752904457.com.androidwidget.adapters.ImageAdapter;

public class AdapterViewFlipperActivity extends AppCompatActivity {
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapterviewflipper);

        mAdapter = new ImageAdapter(this);

        initAdapterViewFlipper(mAdapter);
    }

    private void initAdapterViewFlipper(Adapter adapter) {
        AdapterViewFlipper mViewFlipper = (AdapterViewFlipper) findViewById(R.id.mViewFlipper);
        mViewFlipper.setAdapter(adapter);
    }
}
