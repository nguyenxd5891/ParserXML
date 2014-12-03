package com.example.xmlparserimage1.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.xmlparserimage1.R;
import com.example.xmlparserimage1.entity.Album;

public class AlbumAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<Album> mGirls;
	private AQuery mAQuery;

	public AlbumAdapter(Context context, ArrayList<Album> arrGirl) {

		this.mContext = context;
		this.mGirls = arrGirl;
		this.mInflater = LayoutInflater.from(mContext);

	}

	@Override
	public int getCount() {
		return mGirls.size();
	}

	@Override
	public Object getItem(int position) {
		return mGirls.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		Album girl = mGirls.get(position);
		mAQuery = new AQuery(mContext);

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_gridview, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		mAQuery.id(holder.imgGirl).image(girl.getImage());
		holder.tvName.setText(girl.getName());
		return convertView;
	}

	public class ViewHolder {

		ImageView imgGirl;
		TextView tvName;

		public ViewHolder(View v) {

			imgGirl = (ImageView) v.findViewById(R.id.ivGirl);
			tvName = (TextView) v.findViewById(R.id.tvName);
		}

	}
}
