package com.example.xmlparserimage1.activity;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.example.xmlparserimage1.R;
import com.example.xmlparserimage1.adapter.AlbumAdapter;
import com.example.xmlparserimage1.entity.Album;
import com.example.xmlparserimage1.handler.SaxAlbumXMLHandler;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	private GridView gvGirl;
	private ArrayList<Album> arrGirl;
	private AlbumAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gvGirl = (GridView) findViewById(R.id.gvImage);

		try {
			InputStream inputStream = getAssets().open("Album.xml");
			InputSource inputSource = new InputSource(inputStream);

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();

			SaxAlbumXMLHandler handler = new SaxAlbumXMLHandler();
			reader.setContentHandler(handler);
			reader.parse(inputSource);

			arrGirl = handler.getmGirls();
			Log.d("abc", "" + arrGirl);
			mAdapter = new AlbumAdapter(getApplicationContext(), arrGirl);
			gvGirl.setAdapter(mAdapter);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
