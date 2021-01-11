package by.zhigarev.service;

import by.zhigarev.entity.Element;

import java.util.Stack;

public class ElementStack {
    private Stack<Element> elements = new Stack<>();

    public ElementStack(){}

    public Element peek(){
        return elements.peek();
    }

    public Element push(Element item){
        return elements.push(item);
    }

    public Element pop(){
        return elements.pop();
    }

    public int size(){
        return elements.size();
    }

    public boolean isClosedTag(Element element){
        Element topElement = elements.peek();
        return ("/"+topElement.getName()).equals(element.getName());
    }

}
