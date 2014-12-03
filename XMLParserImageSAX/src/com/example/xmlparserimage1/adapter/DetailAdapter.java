package com.example.xmlparserimage1.adapter;

import java.util.ArrayList;

import com.androidquery.AQuery;
import com.example.xmlparserimage1.R;
import com.example.xmlparserimage1.entity.Detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class DetailAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<Detail> arrDetail;
	private AQuery mAquery;

	public DetailAdapter(Context context, ArrayList<Detail> arrDetail) {
		super();
		this.mContext = context;
		this.arrDetail = arrDetail;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return arrDetail.size();
	}

	@Override
	public Object getItem(int position) {
		return arrDetail.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		mAquery = new AQuery(mContext);
		Detail detail = (Detail) getItem(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_detail, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		mAquery.id(holder.ivDetail).image(detail.getImage());
		return convertView;
	}

	class ViewHolder {
		ImageView ivDetail;

		public ViewHolder(View v) {
			ivDetail = (ImageView) v.findViewById(R.id.ivDetail);
		}
	}
}
