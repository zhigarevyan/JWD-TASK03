package by.zhigarev.service.impl;

import by.zhigarev.dao.ElementDAO;
import by.zhigarev.dao.impl.ElementDAOImpl;
import by.zhigarev.entity.Element;
import by.zhigarev.service.ElementService;
import by.zhigarev.service.ElementStack;

import java.io.IOException;

public class ElementServiceImpl implements ElementService {
    public Element getRootElement(String filePath) throws IOException {
        ElementDAO elementDAOImpl = new ElementDAOImpl(filePath);
        ElementStack elementStack = new ElementStack();
        Element firstElement = elementDAOImpl.getNextElement();
        elementStack.push(firstElement);
        while(elementStack.size()>0){
            Element element = elementDAOImpl.getNextElement();
            if(elementStack.isClosedTag(element)){
                if(elementStack.size()>1) {
                    Element childElement = elementStack.pop();
                    Element parentElement = elementStack.peek();
                    parentElement.addChild(childElement);
                }
                else{
                    elementStack.pop();
                }
            }
            else {
                elementStack.push(element);
            }
        }
        return firstElement;
    }
}
