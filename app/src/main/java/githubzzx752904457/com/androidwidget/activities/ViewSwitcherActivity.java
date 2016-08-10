package githubzzx752904457.com.androidwidget.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

import githubzzx752904457.com.androidwidget.R;
import githubzzx752904457.com.androidwidget.bean.DataBean;

public class ViewSwitcherActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,View.OnTouchListener{
    //显示每屏的应用程序数
    public final int NUMBER_PER_SCREEN = 40;

    //数据源
    private List<DataBean> resList = new ArrayList<>();

    //记录当前正在显示第几屏
    private int curScreenNo;

    //程序所占的总屏数
    private int totalScreenCount;

    //item的总数
    private final int TOTAL_ITEM_COUNT = 267;

    private ViewSwitcher viewSwitcher;
    private LayoutInflater inflater;
    private GestureDetector gestureDetector;
    private PullToRefreshGridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewswitcher);

        inflater = LayoutInflater.from(this);

        initViewSwitcher();
    }

    private void initViewSwitcher() {
        viewSwitcher = (ViewSwitcher) findViewById(R.id.mViewSwitcher);

        for (int i = 0; i < TOTAL_ITEM_COUNT; i++) {
            DataBean dataBean = new DataBean();
            dataBean.setImg(R.mipmap.ic_launcher);
            dataBean.setName("app--" + i + 1);
            resList.add(dataBean);
        }

        totalScreenCount = TOTAL_ITEM_COUNT % NUMBER_PER_SCREEN == 0 ?
                TOTAL_ITEM_COUNT / NUMBER_PER_SCREEN :
                TOTAL_ITEM_COUNT / NUMBER_PER_SCREEN + 1;

        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                gridView = (PullToRefreshGridView) inflater.inflate(R.layout.slidelistview, null);

                return gridView;
            }
        });

        gestureDetector = new GestureDetector(this, this);
        viewSwitcher.setOnTouchListener(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ViewSwitcherActivity.this, "" + (curScreenNo * NUMBER_PER_SCREEN + position), Toast.LENGTH_SHORT).show();
            }
        });

        viewSwitcher.setLongClickable(true);
        gestureDetector.setIsLongpressEnabled(true);

        next(null);
    }

    public void next(View view) {
        if (curScreenNo < totalScreenCount - 1) {
            curScreenNo++;

            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            viewSwitcher.setOutAnimation(this, R.anim.slide_out_left);

            ((PullToRefreshGridView) viewSwitcher.getNextView()).setAdapter(adapter);

            viewSwitcher.showNext();
        }
    }

    public void prev(View view) {
        if (curScreenNo > 0) {
            curScreenNo--;
            viewSwitcher.setInAnimation(this, R.anim.slide_in_left);
            viewSwitcher.setOutAnimation(this, R.anim.slide_out_right);

            ((PullToRefreshGridView) viewSwitcher.getNextView()).setAdapter(adapter);

            viewSwitcher.showPrevious();
        }
    }

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if (curScreenNo == totalScreenCount - 1 && resList.size() % NUMBER_PER_SCREEN != 0) {
                return resList.size() % NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public Object getItem(int position) {
            return resList.get(curScreenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_layout, null);
            }
            ImageView imageView = (ImageView) convertView.findViewById(R.id.item_iv);
            TextView textView = (TextView) convertView.findViewById(R.id.item_tv);
            imageView.setImageResource(resList.get(curScreenNo * NUMBER_PER_SCREEN + position).getImg());
            textView.setText(resList.get(curScreenNo * NUMBER_PER_SCREEN + position).getName());
            return convertView;
        }
    };

    /**
     * 长按（onLongPress）动作前一定会执行一次按住（onShowPress）动作。
     * 按住（onShowPress）动作和按下（onDown）动作之后都会执行一次抬起（onSingleTapUp）动作。
     * 长按（onLongPress）、滚动（onScroll）和抛掷（onFling）动作之后都不会执行抬起（onSingleTapUp）动作。
     */

    //刚刚手指接触到触摸屏的那一刹那，就是触的那一下。
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    //手指按在触摸屏上，它的时间范围在按下到长按生效之前。
    @Override
    public void onShowPress(MotionEvent e) {

    }

    //手指离开触摸屏的那一刹那。
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    //手指在触摸屏上滑动。
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    //手指按下持续一段时间，并且没有松开。
    @Override
    public void onLongPress(MotionEvent e) {

    }

    //手指在触摸屏上迅速移动，并松开的动作。
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() - e2.getX() > 40 && Math.abs(velocityX) > 20 && e2.getY() - e1.getY() < 40) {
            next(null);
        } else if (e1.getX() - e2.getX() < -40 && Math.abs(velocityX) > 20 && e2.getY() - e1.getY() < 40) {
            prev(null);
        }

        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    /**
     * 当最外层是scrollview或relativelayout时，需要重写该方法,让手势控制器自己处理
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }
}
