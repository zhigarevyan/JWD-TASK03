package by.zhigarev.main;

import by.zhigarev.entity.Attribute;
import by.zhigarev.entity.Element;

public class OutputStringBuilder {
    public String getOutputString(Element element){
        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(elementToString(element));
        if(element.hasChild()){
            for(Element e : element.getChildElements()){
                resultStringBuilder.append(getOutputString(e));
            }
        }
        return resultStringBuilder.toString();
    }

    private String elementToString(Element element){
        StringBuilder resultString = new StringBuilder();
        for(Attribute a: element.getAttributes()){
            resultString.append("\n").append(a.getValue()).append("\n");
        }
        if(element.getContent()!=null)
        resultString.append(element.getContent()).append("  ");
        return resultString.toString();
    }
}
