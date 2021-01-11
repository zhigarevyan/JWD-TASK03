package by.zhigarev.dao.impl;

import by.zhigarev.dao.ElementBuilder;
import by.zhigarev.dao.ElementDAO;
import by.zhigarev.dao.XmlFileReader;
import by.zhigarev.entity.Element;
import by.zhigarev.util.StringWorker;

import java.io.IOException;

public class ElementDAOImpl implements ElementDAO {
    private XmlFileReader reader;
    private StringWorker worker;

    public ElementDAOImpl(String filePath) throws IOException {
        reader = new XmlFileReader(filePath);
        worker = new StringWorker(reader.readAllFile());
    }

    public Element getNextElement() {
        Element element = new Element();
        ElementBuilder elementBuilder =new ElementBuilder();
        if(worker.hasNext() ){
            if(worker.isNextTag()) {
                String tag = worker.getNextTag();
                element = elementBuilder.createElement(tag);
            }
            if(!worker.isNextTag() && worker.hasNext()){
                String text = worker.findNextText();
                element.setContent(text);
            }
        }
        return element;
    }
}
