package in.bestpoint.listapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import java.util.List;

import in.bestpoint.commonlibrary.ColorUtils;
import in.bestpoint.commonlibrary.HtmlUtil;
import in.bestpoint.commonlibrary.StringUtils;
import in.bestpoint.commonlibrary.TextViewUtils;

/**
 * Created by sikanted on 5/25/2017.
 */
public class IndexableListViewBaseAdapter extends BaseAdapter implements Filterable {

    private List<Data> originalDataList, filteredDataList;
    private Activity activity;
    private IndexableListViewBaseAdapterFilter indexableListViewBaseAdapterFilter;

    public IndexableListViewBaseAdapter(Activity activity){
        this.activity = activity;
    }

    public void setDataList(List<Data> dataList) {
        this.originalDataList = dataList;
        this.filteredDataList = dataList;
    }

    public void setFilteredDataList(List<Data> dataList){
        this.filteredDataList = dataList;
    }

    @Override
    public int getCount() {
        return filteredDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return filteredDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(activity);
                view = layoutInflater.inflate(R.layout.item_indexable_list_view, viewGroup, false);
        }
        Data data = filteredDataList.get(i);
        setImage(data, view, i);
        TextViewUtils.setTextInTextViewIfNotNull(view, R.id.title, data.getTitle());
        TextViewUtils.setTextInTextViewIfNotNull(view, R.id.summary, StringUtils.getLimitedString(HtmlUtil.GetFirstElementText(data.getText()), 70));
        return view;
    }

    private void setImage(Data data, View view, int position){
        ImageView imageView = (ImageView) view.findViewById(R.id.circularImage);
        ColorUtils.setCharacterAsImage(data.getTitle(), imageView, position);
    }

    @Override
    public Filter getFilter() {
        if (indexableListViewBaseAdapterFilter == null){
            indexableListViewBaseAdapterFilter = new IndexableListViewBaseAdapterFilter(originalDataList, this);
        }
        return indexableListViewBaseAdapterFilter;
    }


}
