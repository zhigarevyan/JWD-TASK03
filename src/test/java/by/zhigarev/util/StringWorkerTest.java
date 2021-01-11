package by.zhigarev.util;

import junit.framework.TestCase;
import org.junit.Assert;

public class StringWorkerTest extends TestCase {
    String input ="<     breakfast-menu>\n" +
                "    <food id=\"1\"      >\n" +
            "        <   name    >Belgian Waffles</name>\n" +
            "        <price>$5.95</price>\n" +
            "    </food>\n" +
            "    <food id=\"2\">\n" +
            "        <name>Strawberry Belgian Waffles</name>\n" +
            "        <price>$7.95</price>\n" +
            "    </food>\n" +
            "</breakfast-menu>\n";
    StringWorker stringWorker = new StringWorker(input);


    public void testFormat() {
        String expectedResult = "<breakfast-menu><food id=\"1\"><name>Belgian Waffles</name><price>$5.95</price></food><food id=\"2\"><name>Strawberry Belgian Waffles</name><price>$7.95</price></food></breakfast-menu>";


        String actualResult = stringWorker.format(input);
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult,actualResult);


    }

    public void testFindNextTag() {
        String actualResult = stringWorker.getNextTag();
        String expectedResult = "breakfast-menu";

        Assert.assertEquals(expectedResult,actualResult);

    }


}