package com.example.myapplication;

import android.content.Context;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlJdomParser {
    private Context context;
    public XmlJdomParser(Context context) {
        this.context = context;
    }

    public List<Books> parseXml() {
        List<Books> books = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        try (InputStream inputStream = context.getResources().openRawResource(R.raw.bookstore)){
            Document document = builder.build(inputStream);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.getChildren("book");
            for (Element e : elements){
                Books book = new Books();
                book.setaCategory(e.getAttributeValue("category"));
                book.setTitle(e.getChildText("title"));
                book.setaLang(e.getAttributeValue("lang"));
                book.setAuthor(e.getChildText("author"));
                book.setYear(Integer.valueOf(e.getChildText("year")));
                book.setPhoto(e.getChildText("photo"));
                book.setPrice(Double.valueOf(e.getChildText("price")));
                books.add(book);
            }
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
        return books;
    }
}
