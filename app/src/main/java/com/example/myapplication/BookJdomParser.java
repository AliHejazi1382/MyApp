package com.example.myapplication;

import android.content.Context;

import org.jdom2.Element;

import java.io.InputStream;

public class BookJdomParser extends XmlGJDOMParser<Books>{
    private Context context;
    public BookJdomParser(Context context) {
        this.context = context;
    }

    @Override
    public InputStream getInput() {
        return context.getResources().openRawResource(R.raw.bookstore);
    }

    @Override
    public String getChildrenName() {
        return "book";
    }

    @Override
    public Books getObject(Element e) {
        Books book = new Books();
        book.setaCategory(e.getAttributeValue("category"));
        book.setTitle(e.getChildText("title"));
        book.setaLang(e.getAttributeValue("lang"));
        book.setAuthor(e.getChildText("author"));
        book.setYear(Integer.valueOf(e.getChildText("year")));
        book.setPhoto(e.getChildText("photo"));
        book.setPrice(Double.valueOf(e.getChildText("price")));
        return book;
    }

}
