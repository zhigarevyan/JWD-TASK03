package by.zhigarev.dao;

import by.zhigarev.entity.Attribute;
import by.zhigarev.entity.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElementBuilder {
    private static final String SIGN_EQUAL="=";
    private static final String TAG_NAME="(?<=<)(\\/)*(\\w+)";
    private static final String ATTRIBUTE = "(\\w+)(\\s*)=(\\s*)\"\\s*(\\w+|\\d+)\\s*\"";
    private static final String SIGN_BRACKETS="\"";
    private static final String REPLACEMENT = "";
    private final Pattern tagNamePattern;
    private final Pattern attributePattern;
    private int pointer = 0;

    public ElementBuilder() {
        tagNamePattern = Pattern.compile(TAG_NAME);
        attributePattern = Pattern.compile(ATTRIBUTE);
    }



    public Element createElement(String rawString){
        Element createdElement = new Element();
        Matcher tagNameMatcher = tagNamePattern.matcher(rawString);
        Matcher attributeMatcher = attributePattern.matcher(rawString);
        createdElement.setName(getMatchValue(rawString,tagNameMatcher));
        while (attributeMatcher.find(pointer)){
            createdElement.addAttribute(createAttribute(getMatchValue(rawString,attributeMatcher)));
        }
        return createdElement;
    }

    private String getMatchValue(String rawString,Matcher matcher){
        matcher.find(pointer);
        int start = matcher.start();
        pointer = matcher.end();
        return rawString.substring(start,pointer);
    }

    public Attribute createAttribute(String rawString){
        int nameIndex = 0,
            valueIndex = 1;
        Attribute createdAttribute = new Attribute();
        String[] splittedToNameAndValue = rawString.split(SIGN_EQUAL);

        createdAttribute.setName(splittedToNameAndValue[nameIndex].trim());
        createdAttribute.setValue(splittedToNameAndValue[valueIndex].trim().replaceAll(SIGN_BRACKETS,REPLACEMENT).trim());
        return createdAttribute;
    }







}
