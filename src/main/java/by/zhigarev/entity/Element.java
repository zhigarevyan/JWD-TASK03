package by.zhigarev.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Element {
    private String name;
    private List<Attribute> attributes = new ArrayList<>();
    private List<Element> childElements = new ArrayList<>();
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<Element> getChildElements() {
        return childElements;
    }
    public void addChild(Element element){
        childElements.add(element);
    }
    public void addAttribute(Attribute attribute){
        attributes.add(attribute);
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean hasChild(){
        return childElements.size()>0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return getName().equals(element.getName()) &&
                Objects.equals(getAttributes(), element.getAttributes()) &&
                Objects.equals(getChildElements(), element.getChildElements()) &&
                Objects.equals(getContent(), element.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAttributes(), getChildElements(), getContent());
    }
}
