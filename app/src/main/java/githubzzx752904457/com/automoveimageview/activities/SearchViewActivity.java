package githubzzx752904457.com.automoveimageview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import githubzzx752904457.com.automoveimageview.R;

public class SearchViewActivity extends AppCompatActivity {
    private SearchView searchView;
    private ListView listView;

    //提示列表
    private final String[] str = {"aaaaaa", "bbbbbb", "cccccc", "dddddd", "eeeeee", "ffffff", "gggggg", "hhhhhh", "iiiiii"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);

        initListView();

        initSearchView();
    }

    private void initSearchView() {
        searchView = (SearchView) findViewById(R.id.sv);
        //设置默认是否自动缩小为图标
        searchView.setIconifiedByDefault(false);
        //设置是否显示搜索按钮
        searchView.setSubmitButtonEnabled(true);
        //设置默认显示的文字
        searchView.setQueryHint("请输入你要搜索的内容");
        //设置输入监听器
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SearchViewActivity.this, "你要搜索的内容是：" + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ListAdapter adapter = listView.getAdapter();
                if (adapter instanceof Filterable){
                    Filter filter = ((Filterable) adapter).getFilter();
                    //以下方法不会有弹窗提示
                    if (TextUtils.isEmpty(newText)) {
                        filter.filter(null);
                    } else {
                        filter.filter(newText);
                    }
                    //以下方法会有弹窗提示
//                    if (TextUtils.isEmpty(newText)) {
//                        listView.clearTextFilter();
//                    } else {
//                        listView.setFilterText(newText);
//                    }
                }
                return false;
            }
        });
    }

    private void initListView() {
        listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str));
        //设置listview启用过滤
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                searchView.setQuery(str[position], true);
            }
        });
    }
}
