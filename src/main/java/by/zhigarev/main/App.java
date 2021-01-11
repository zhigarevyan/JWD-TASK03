package by.zhigarev.main;


import by.zhigarev.entity.Element;
import by.zhigarev.service.ElementService;
import by.zhigarev.service.impl.ElementServiceImpl;

import java.io.IOException;

public class App
{
    public static void main( String[] args )
    {
        ElementService elementService = new ElementServiceImpl();
        try {
            Element rootElement = elementService.getRootElement("src/main/java/by/zhigarev/resources/document.xml");
            OutputStringBuilder outputStringBuilder = new OutputStringBuilder();
            System.out.println(outputStringBuilder.getOutputString(rootElement));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
