package by.zhigarev.util;

import by.zhigarev.dao.XmlFileReader;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;

public class XmlFileReaderTest extends TestCase {

    public void testRead() {
        XmlFileReader xmlFileReader = new XmlFileReader("resources/document.xml");
        String expectedResult ="<breakfast-menu>\n" +
                "    <food id=\"1\">\n" +
                "        <name>Belgian Waffles</name>\n" +
                "        <price>$5.95</price>\n" +
                "    </food>\n" +
                "    <food id=\"2\">\n" +
                "        <name>Strawberry Belgian Waffles</name>\n" +
                "        <price>$7.95</price>\n" +
                "    </food>\n" +
                "</breakfast-menu>\n";
        String actualResult ="";
        try {
            actualResult = xmlFileReader.readAllFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectedResult,actualResult);




    }
}