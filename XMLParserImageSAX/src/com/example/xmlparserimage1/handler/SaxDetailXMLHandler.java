package com.example.xmlparserimage1.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.xmlparserimage1.entity.Detail;

public class SaxDetailXMLHandler extends DefaultHandler {
	private ArrayList<Detail> arrDetail;
	Detail mDetail;
	String mTempleString;

	public ArrayList<Detail> getArrDetail() {
		return arrDetail;
	}

	public SaxDetailXMLHandler() {
		arrDetail = new ArrayList<Detail>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (localName.equalsIgnoreCase("item")) {
			mDetail = new Detail();

		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		mTempleString = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName.equalsIgnoreCase("item")) {
			arrDetail.add(mDetail);
		} else if (localName.equalsIgnoreCase("URLImage")) {
			mDetail.setImage(mTempleString);
		}
	}
}
