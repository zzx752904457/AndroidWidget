package githubzzx752904457.com.automoveimageview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

import githubzzx752904457.com.automoveimageview.R;

public class DatePickerActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        initDatePicker();

    }

    private void initDatePicker() {
        datePicker = (DatePicker) findViewById(R.id.dp);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(DatePickerActivity.this, year + "年" + monthOfYear + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
