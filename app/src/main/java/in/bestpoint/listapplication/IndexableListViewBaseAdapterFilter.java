package in.bestpoint.listapplication;

import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sikanted on 5/25/2017.
 */
public class IndexableListViewBaseAdapterFilter extends Filter {

    private List<Data> originalDataList;
    private IndexableListViewBaseAdapter indexableListViewBaseAdapter;

    public IndexableListViewBaseAdapterFilter(List<Data> originalDataList, IndexableListViewBaseAdapter indexableListViewBaseAdapter) {
        this.originalDataList = originalDataList;
        this.indexableListViewBaseAdapter = indexableListViewBaseAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        charSequence = charSequence.toString().toLowerCase();
        FilterResults result = new FilterResults();
        if(charSequence != null && charSequence.toString().length() > 0)
        {
            List<Data> filteredDataList = new ArrayList<Data>();

            for(int i = 0; i < originalDataList.size();  i++)
            {
                Data data = originalDataList.get(i);
                if(data.getTitle().toString().toLowerCase().contains(charSequence))
                    filteredDataList.add(data);
            }
            result.count = filteredDataList.size();
            result.values = filteredDataList;
        }
        else
        {
            synchronized(this)
            {
                result.values = originalDataList;
                result.count = originalDataList.size();
            }
        }
        return result;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        indexableListViewBaseAdapter.setFilteredDataList((List<Data>)filterResults.values);
        indexableListViewBaseAdapter.notifyDataSetChanged();
    }
}
