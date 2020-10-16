package com.example.myapplication;

import android.content.Context;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BookXmlPullParser extends XmlPullParserV2<Books>{
    private Context context;
    private List<Books> books;
    private Books currentBook;
    private String currentTag;
    public BookXmlPullParser(Context context) {
        this.context = context;
        books = new ArrayList<>();
    }

    @Override
    public InputStream getInput() {
        return context.getResources().openRawResource(R.raw.bookstore);
    }

    @Override
    public List<Books> getList() {
        return books;
    }

    @Override
    public void handleStartTag(String name) {
        if (name.equals("book")){
            currentBook = new Books();
            books.add(currentBook);
        } else {
            currentTag = name;
        }
    }

    @Override
    public void handleText(String text) {
        if (currentTag == null || currentBook == null) return;
        switch (currentTag){
            case "title" :
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

    @Override
    public void handleEndTag() {
        currentTag = null;
    }
}
