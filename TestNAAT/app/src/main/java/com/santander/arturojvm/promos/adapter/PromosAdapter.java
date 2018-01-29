package com.santander.arturojvm.promos.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.santander.arturojvm.R;
import com.santander.arturojvm.promos.fragment.entity.PromosInformationView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by arturo on 15/02/17.
 */

public class PromosAdapter extends BaseAdapter implements Filterable {

    private final ItemFilter mFilter = new ItemFilter();
    private ArrayList<PromosInformationView> promos;
    private ArrayList<PromosInformationView> promosFilter;
    private ViewHolder viewHolder;
    private Context context;

    public PromosAdapter(Context context, ArrayList<PromosInformationView> promosList) {
        this.context = context;
        promos = promosList;
        promosFilter = promosList;
    }

    @Override
    public int getCount() {
        return promosFilter.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_promos_grid, viewGroup, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (promosFilter.size() > 0) {
            viewHolder.ivPromosImage.setImageDrawable(promosFilter.get(position).getImagePromo());
            viewHolder.tvPromosInformation.setText(promosFilter.get(position).getInformationPromo());
        }

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    public static class ViewHolder {

        @BindView(R.id.container_promos)
        CardView containerPromos;

        @BindView(R.id.iv_promos_image)
        ImageView ivPromosImage;

        @BindView(R.id.tv_promos_information)
        TextView tvPromosInformation;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.container_promos)
        protected void onContainerPromosClicked() {

        }

    }

    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Log.e("filter", constraint.toString());
            final String filterSeq = constraint.toString().toLowerCase();
            final FilterResults result = new FilterResults();

            final List<PromosInformationView> list = promos;
            final int count = list.size();
            final List<PromosInformationView> nlist = new ArrayList<>(count);

            PromosInformationView filterableString;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i);
                if (filterableString.getInformationPromo().toLowerCase().contains(filterSeq)) {
                    nlist.add(filterableString);
                }
            }
            if (nlist.isEmpty()) {
                result.values = nlist;
                result.count = nlist.size();
            } else {
                result.values = nlist;
                result.count = nlist.size();
            }

            if (TextUtils.isEmpty(constraint)) {
                result.values = promos;
                result.count = promos.size();
            }

            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            promosFilter = (ArrayList<PromosInformationView>) results.values;
            notifyDataSetChanged();
        }
    }
}
