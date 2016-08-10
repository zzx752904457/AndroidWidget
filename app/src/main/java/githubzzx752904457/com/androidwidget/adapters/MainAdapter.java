package githubzzx752904457.com.androidwidget.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import githubzzx752904457.com.androidwidget.R;


/**
 * Created by admin on 2016/8/9.
 */
public class MainAdapter extends BaseAdapter {
    private List<String> resList;
    private Context context;
    private LayoutInflater inflater;

    public MainAdapter(Context context, List<String> resList) {
        this.context = context;
        this.resList = resList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (resList != null) {
            return resList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return resList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.main_item, null);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.main_item_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv.setText(resList.get(position));

        return convertView;
    }

    private class ViewHolder{
        private TextView tv;
    }
}
