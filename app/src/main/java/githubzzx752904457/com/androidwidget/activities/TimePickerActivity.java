package githubzzx752904457.com.androidwidget.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import githubzzx752904457.com.androidwidget.R;


public class TimePickerActivity extends AppCompatActivity {
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        initTimePicker();
    }

    private void initTimePicker() {
        timePicker = (TimePicker) findViewById(R.id.tp);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(TimePickerActivity.this, hourOfDay+"时"+minute+"分", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
