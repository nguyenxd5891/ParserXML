package com.example.xmlparserimage1.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.xmlparserimage1.entity.Album;

public class SaxAlbumXMLHandler extends DefaultHandler {

	private ArrayList<Album> mAlbums;
	private Album mAlbum;
	private String mTempString;

	public SaxAlbumXMLHandler() {
		mAlbums = new ArrayList<Album>();

	}

	public ArrayList<Album> getmGirls() {
		return mAlbums;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (localName.equalsIgnoreCase("item")) {
			mAlbum = new Album();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName.equalsIgnoreCase("item")) {
			mAlbums.add(mAlbum);

		} else if (localName.equalsIgnoreCase("IdAlbum")) {
			mAlbum.setIdAlbum(mTempString);
		} else if (localName.equalsIgnoreCase("NameAlbum")) {
			mAlbum.setName(mTempString);

		} else if (localName.equalsIgnoreCase("URLImage")) {
			mAlbum.setImage(mTempString);

		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		mTempString = new String(ch, start, length);
	}

}
