package githubzzx752904457.com.androidwidget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;

import githubzzx752904457.com.androidwidget.activities.AdapterViewFlipperActivity;
import githubzzx752904457.com.androidwidget.activities.AnalogAndTextClockActivity;
import githubzzx752904457.com.androidwidget.activities.CalendarViewActivity;
import githubzzx752904457.com.androidwidget.activities.DatePickerActivity;
import githubzzx752904457.com.androidwidget.activities.NotificationActivity;
import githubzzx752904457.com.androidwidget.activities.NumberPickerActivity;
import githubzzx752904457.com.androidwidget.activities.SearchViewActivity;
import githubzzx752904457.com.androidwidget.activities.SeekBarAndRatingBarActivity;
import githubzzx752904457.com.androidwidget.activities.StackViewActivity;
import githubzzx752904457.com.androidwidget.activities.TextViewActivity;
import githubzzx752904457.com.androidwidget.activities.TimePickerActivity;
import githubzzx752904457.com.androidwidget.activities.ViewSwitcherActivity;
import githubzzx752904457.com.androidwidget.adapters.MainAdapter;

public class MainActivity extends AppCompatActivity {

    private List<String> resList;
    private MainAdapter mAdapter;
    private GridView mGridView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initResList();

        initGridView();

    }

    private void initGridView() {
        mGridView = (GridView) findViewById(R.id.gv);

        mAdapter = new MainAdapter(this , resList);
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(getContext(), TextViewActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getContext(), AnalogAndTextClockActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getContext(), AdapterViewFlipperActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getContext(), StackViewActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getContext(), SeekBarAndRatingBarActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getContext(), ViewSwitcherActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getContext(), CalendarViewActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getContext(), DatePickerActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getContext(), TimePickerActivity.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(getContext(), NumberPickerActivity.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(getContext(), SearchViewActivity.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(getContext(), NotificationActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private void initResList() {
        resList = new ArrayList<>();
        resList.add("TextView");
        resList.add("AnalogAndTextClock");
        resList.add("AdapterViewFlipper");
        resList.add("StackView");
        resList.add("SeekBarAndRatingBar");
        resList.add("ViewSwitcher");
        resList.add("CalendarView");
        resList.add("DatePicker");
        resList.add("TimePicker");
        resList.add("NumberPicker");
        resList.add("SearchView");
        resList.add("Notification");
    }

    private Context getContext(){
        return this;
    }
}
