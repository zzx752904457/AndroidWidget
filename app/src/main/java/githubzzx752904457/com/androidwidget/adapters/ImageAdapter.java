package githubzzx752904457.com.androidwidget.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import githubzzx752904457.com.androidwidget.R;


/**
 * Created by admin on 2016/8/9.
 */
public class ImageAdapter extends BaseAdapter {
    private final int[] arr = new int[]{R.mipmap.welcome_1, R.mipmap.welcome_2, R.mipmap.welcome_3, R.mipmap.welcome_4, R.mipmap.welcome_5};
    private Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(arr[position]);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }
}
