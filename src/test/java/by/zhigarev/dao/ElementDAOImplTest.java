package by.zhigarev.dao;

import by.zhigarev.dao.impl.ElementDAOImpl;
import junit.framework.TestCase;

import java.io.IOException;

public class ElementDAOImplTest extends TestCase {

    public void testFindElement() {
        try {
            ElementDAOImpl elementDAOImpl = new ElementDAOImpl("src/main/java/by/zhigarev/resources/document.xml");

            elementDAOImpl.getNextElement();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}