package githubzzx752904457.com.androidwidget.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import githubzzx752904457.com.androidwidget.R;


public class CalendarViewActivity extends AppCompatActivity {
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendarview);

        initCalendarView();
    }

    private void initCalendarView() {
        calendarView = (CalendarView) findViewById(R.id.cv);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(CalendarViewActivity.this, year + "年" + month + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
