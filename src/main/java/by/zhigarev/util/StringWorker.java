package by.zhigarev.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringWorker {
    private static final String EMPTY_SPACE_BETWEEN_TAGS = "(?<=\\>)([\\s]+?)(?=\\<)";
    private static final String TEXT_BETWEEN_TAGS = "([\\s\\S]+?)(?=\\<)";
    private static final String LINE_BREAK = "\n";
    //private static final String EMPTY_SPACE_AFTER_QUOTATION = "(?<=\")(\\s+)";
    private static final String TAG = "(<.[^(><.)]+>)";
    private static final String EMPTY_SPACE_AFTER_OPEN = "(?<=<)(\\s+)";
    private static final String EMPTY_SPACE_BEFORE_CLOSE = "(\\s+)(?=>)";
    private static final String REPLACEMENT = "";
    private static final String TAG_OPEN_BRACKET = "<";
    private static final String TAG_CLOSE_BRACKET = ">";
    private String formattedString;
    private final Matcher tagMatcher;
    private final Matcher textMatcher;
    private int pointer = 0;



    public StringWorker(String string) {

        formattedString = format(string);

        Pattern tagPattern = Pattern.compile(TAG);
        tagMatcher = tagPattern.matcher(formattedString);
        Pattern textPattern = Pattern.compile(TEXT_BETWEEN_TAGS);
        textMatcher = textPattern.matcher(formattedString);
    }

    public String format(String string) {
        return string.replaceAll(LINE_BREAK, REPLACEMENT)
                                .replaceAll(EMPTY_SPACE_BETWEEN_TAGS, REPLACEMENT)
                                .replaceAll(EMPTY_SPACE_AFTER_OPEN,REPLACEMENT)
                                .replaceAll(EMPTY_SPACE_BEFORE_CLOSE,REPLACEMENT);
    }

    public String getNextTag() {
        String returnString = "";

        if(tagMatcher.find(pointer)){
            int start = tagMatcher.start();
            pointer = tagMatcher.end();
            returnString = formattedString.substring(start,pointer);
                    //.replace(TAG_OPEN_BRACKET,REPLACEMENT)
                    //.replace(TAG_CLOSE_BRACKET,REPLACEMENT);
            //formattedString = formattedString.replaceFirst(TAG,REPLACEMENT);
        }
        return returnString;
    }

    public String findNextText() {
        String returnString = "";

        if(textMatcher.find(pointer)){
            int start = textMatcher.start();
            pointer = textMatcher.end();
            returnString = formattedString.substring(start,pointer);
            //formattedString = formattedString.replaceFirst(TEXT_BETWEEN_TAGS,REPLACEMENT);
            return returnString.trim();
        }
        return returnString.trim();
    }

    public boolean hasNext(){
        return tagMatcher.find(pointer) || textMatcher.find(pointer);
    }

    public boolean isNextTag(){
        return formattedString.length()>pointer && formattedString.charAt(pointer) == '<';
    }

}
