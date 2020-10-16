package com.example.myapplication;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class XmlGJDOMParser<T> {

    public abstract InputStream getInput();

    public abstract String getChildrenName();

    public abstract T getObject();

    public List<T> parseXml() {
        List<T> t = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(getInput());
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.getChildren(getChildrenName());
            for (Element e : elements){
                T item = getObject();
                t.add(item);
            }
            getInput().close();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }
}
