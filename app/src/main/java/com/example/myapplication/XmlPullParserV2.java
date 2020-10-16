package com.example.myapplication;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class XmlPullParserV2<T> {

    public abstract InputStream getInput();

    public abstract List<T> getList();

    public abstract void handleStartTag(String name);

    public abstract void handleText(String text);

    public abstract void handleEndTag();

    public List<T> parseXml() {
        List<T> t = getList();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(getInput(), null);
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG :
                        handleStartTag(parser.getName());
                        break;
                    case XmlPullParser.TEXT :
                        handleText(parser.getText());
                        break;
                    case XmlPullParser.END_TAG :
                        handleEndTag();
                        break;
                }
                eventType = parser.next();
            }
            getInput().close();
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return t;
    }
}
