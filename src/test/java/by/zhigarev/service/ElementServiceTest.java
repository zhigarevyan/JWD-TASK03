package by.zhigarev.service;

import by.zhigarev.entity.Element;
import junit.framework.TestCase;

import java.io.IOException;

public class ElementServiceTest extends TestCase {
    ElementService elementService = new ElementService();
    public void testReadXml() {
        try {
            Element element = elementService.getRootElement("src/main/java/by/zhigarev/resources/document.xml");
            System.out.println(element);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}