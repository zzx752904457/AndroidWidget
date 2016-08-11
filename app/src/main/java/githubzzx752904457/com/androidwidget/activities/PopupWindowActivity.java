package githubzzx752904457.com.androidwidget.activities;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import githubzzx752904457.com.androidwidget.R;
import githubzzx752904457.com.androidwidget.utils.DensityUtil;

public class PopupWindowActivity extends AppCompatActivity {
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);

        initPopupWindow();
    }

    private void initPopupWindow() {
        popupWindow = new PopupWindow(createContentView(), DensityUtil.dip2px(200), DensityUtil.dip2px(200), true);
        ColorDrawable colorDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.white));
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setOutsideTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                changeBackgroundAlpha(1.0f);
            }
        });
    }

    private View createContentView() {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.make);
        return imageView;
    }

    public void show(View view) {
        changeBackgroundAlpha(0.3f);
        popupWindow.showAsDropDown(view, DensityUtil.dip2px(0), DensityUtil.dip2px(60));
//        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }

    public void dismiss(View view) {
        popupWindow.dismiss();
    }

    /**
     * alpha = 0.0～1.0，值越小背景越暗
     * @param alpha
     */
    private void changeBackgroundAlpha(float alpha){
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha;
        getWindow().setAttributes(lp);
    }
}
