package by.zhigarev.entity;

import by.zhigarev.dao.ElementBuilder;
import junit.framework.TestCase;

public class ElementBuilderTest extends TestCase {
    ElementBuilder elementBuilder = new ElementBuilder();

    public void testCreateElement() {
        Element element = elementBuilder.createElement("food id=\"1\" id2=\"2\"");
        System.out.println(element);
    }
}