package com.example.xmlparserimage1.activity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.example.xmlparserimage1.R;
import com.example.xmlparserimage1.adapter.DetailAdapter;
import com.example.xmlparserimage1.entity.Detail;
import com.example.xmlparserimage1.handler.SaxDetailXMLHandler;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class DetailActivity extends Activity {
	private ArrayList<Detail> arrDetail = null;
	private GridView gvDetail;
	private DetailAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity);
		gvDetail = (GridView) findViewById(R.id.gvDetail);
		SAXParser();
	}

	private void SAXParser() {
		InputStream inputStream;
		try {
			inputStream = getAssets().open("Image.xml");
			InputSource inputSource = new InputSource(inputStream);

			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			javax.xml.parsers.SAXParser saxParser = parserFactory
					.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			SaxDetailXMLHandler handler = new SaxDetailXMLHandler();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(inputSource);
			arrDetail = handler.getArrDetail();
			mAdapter = new DetailAdapter(getApplicationContext(), arrDetail);
			gvDetail.setAdapter(mAdapter);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
