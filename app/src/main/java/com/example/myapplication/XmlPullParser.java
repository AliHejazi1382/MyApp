package com.example.myapplication;

import android.content.Context;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlPullParser {
    private Context context;
    private List<Books> books;
    private Books currentBook;
    private String currentTag;
    public XmlPullParser(Context context) {
        this.context = context;
    }

    public List<Books> parseXml() {
        books = new ArrayList<>();
        try (InputStream inputStream = context.getResources().openRawResource(R.raw.bookstore)){
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            org.xmlpull.v1.XmlPullParser parser = factory.newPullParser();
            parser.setInput(inputStream, null);
            int eventType = parser.getEventType();
            while (eventType != org.xmlpull.v1.XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case org.xmlpull.v1.XmlPullParser.START_TAG :
                        handleStartTag(parser.getName());
                        break;
                    case org.xmlpull.v1.XmlPullParser.TEXT :
                        handleText(parser.getText());
                        break;
                    case org.xmlpull.v1.XmlPullParser.END_TAG :
                        currentTag = null;
                        break;
                }
                eventType = parser.next();
            }
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        return books;
    }

    private void handleStartTag(String name) {
        if (name.equals("book")){
            currentBook = new Books();
            books.add(currentBook);
        } else {
            currentTag = name;
        }
    }

    private void handleText(String text) {
        if (currentBook == null || currentTag == null) return;
        switch (currentTag){
            case "tilte" :
                currentBook.setTitle(text);
                break;
            case "author" :
                currentBook.setAuthor(text);
                break;
            case "year" :
                currentBook.setYear(Integer.valueOf(text));
                break;
            case "photo" :
                currentBook.setPhoto(text);
                break;
            case "price" :
                currentBook.setPrice(Double.valueOf(text));
                break;
            default: break;
        }
    }
}
