package com.t3h.buoi9;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLParse extends DefaultHandler {
    private ArrayList<News> arr = new ArrayList<>();
    private News item;
    private StringBuilder value;

    public XMLParse(String url) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(url, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        value = new StringBuilder();
        if (qName.equals(Const.ITEM)) {
            item = new News();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (item == null) return;
        switch (qName) {
            case Const.TITLE:
                item.setTitle(value.toString());
                break;
            case Const.DESC:
                String str = "/>";
                int index = value.lastIndexOf(str) + str.length();
                String desc = value.substring(index);

                str = "src='";
                index = value.indexOf(str) +str.length();
                int lastIndex = value.indexOf("'",index+1);
                String img = value.substring(index,lastIndex);

                item.setDesc(desc);
                item.setImg(img);
                break;
            case Const.PUB_DATE:
                item.setPubdate(value.toString());
                break;
            case Const.LINK:
                item.setLink(value.toString());
                break;
            case Const.ITEM:
                arr.add(item);
                break;
        }
    }

    public ArrayList<News> getArr() {
        return arr;
    }

}
