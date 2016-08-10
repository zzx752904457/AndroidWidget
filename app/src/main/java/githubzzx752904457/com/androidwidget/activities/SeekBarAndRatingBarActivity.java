package githubzzx752904457.com.androidwidget.activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;

import githubzzx752904457.com.androidwidget.R;


public class SeekBarAndRatingBarActivity extends AppCompatActivity {
    private ImageView iv;
    private AppCompatRatingBar mRatingBar;
    private AppCompatSeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_and_ratingbar);

        iv = (ImageView) findViewById(R.id.iv);

        initSeekBar();

        initRatingBar();
    }

    private void initRatingBar() {
        mRatingBar = (AppCompatRatingBar) findViewById(R.id.mRatingBar);
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    iv.setImageAlpha((int) rating * 255 / mRatingBar.getNumStars());
                } else {
                    iv.setAlpha((int) rating * 255 / mRatingBar.getNumStars());
                }
            }
        });
    }

    private void initSeekBar() {
        mSeekBar = (AppCompatSeekBar) findViewById(R.id.mSeekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    iv.setImageAlpha(progress);
                } else {
                    iv.setAlpha(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
