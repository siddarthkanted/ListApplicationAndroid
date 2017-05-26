package in.bestpoint.listapplication;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

import in.bestpoint.commonlibrary.ActivityUtils;
import in.bestpoint.commonlibrary.AdsUtil;
import in.bestpoint.commonlibrary.AlphabetSideSelector.IndexableListView;
import in.bestpoint.commonlibrary.Constants;
import in.bestpoint.commonlibrary.FileUtil;
import in.bestpoint.commonlibrary.StringUtils;

public class MainActivity extends AppCompatActivity {

    private List<Data> dataList;
    private IndexableListViewBaseAdapter indexableListViewBaseAdapter;
    private ListView indexableListView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityUtils.setActionBarColor(this, R.color.green_00c1c1);
        dataList = FileUtil.jsonListDeserializeFromFile(getApplicationContext(), "data.json", Data[].class);
        indexableListView = (ListView) findViewById(R.id.indexableListView);
        indexableListView.setFastScrollEnabled(true);
        setIndexableListViewItemClick();
    }

    private void setIndexableListViewItemClick(){
        indexableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Data data = (Data)indexableListViewBaseAdapter.getItem(i);
                ActivityUtils.callActivity(MainActivity.this, HtmlDisplayActivity.class, Constants.pass_Data, data, Data.class, false, false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.xml.action_bar_menu_items, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem searchViewMenuItem = menu.findItem(R.id.action_bar_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchViewMenuItem);
        if (null != searchView) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    if(StringUtils.isNullOrEmpty(s)){
                        indexableListView.setVerticalScrollBarEnabled(false);
                    }else{
                        indexableListView.setVerticalScrollBarEnabled(true);
                    }
                    setSearchFilter();
                    return false;
                }
            });
            searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    indexableListView.setVerticalScrollBarEnabled(true);
                    return false;
                }
            });
        }
        return true;
    }

    private void setSearchFilter() {
        if (null != searchView && null != searchView.getQuery())
            indexableListViewBaseAdapter.getFilter().filter(searchView.getQuery());
    }

    @Override
    public void onResume() {
        super.onResume();
        setIndexableListViewBaseAdapter();
    }

    private void setIndexableListViewBaseAdapter() {
        if (null == indexableListViewBaseAdapter) {
            indexableListViewBaseAdapter = new IndexableListViewBaseAdapter(this);
        }
        indexableListViewBaseAdapter.setDataList(dataList);
        if (null == indexableListView.getAdapter()) {
            indexableListView.setAdapter(indexableListViewBaseAdapter);
        }
        indexableListViewBaseAdapter.notifyDataSetChanged();
    }
}
