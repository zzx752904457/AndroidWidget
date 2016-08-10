package githubzzx752904457.com.androidwidget.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;

import githubzzx752904457.com.androidwidget.R;


public class NumberPickerActivity extends AppCompatActivity {
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numberpicker);

        initNumberPicker();
    }

    private void initNumberPicker() {
        numberPicker = (NumberPicker) findViewById(R.id.np);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(100);
        numberPicker.setValue(50);
        //设置NumberPicker不能循环滚动
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.e("value", newVal+"");
            }
        });
    }
}
