package com.softserve.edu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */

enum SymbolPattern{
//	ALL_DIGITS("\\d+"),
//    FIRST_DIGITS("^\\d+"),
//    LAST_DOUBLE("\\d+\\.\\d+$"),
//    NUMBER_DOUBLE("\\d+\\.\\d+");
//	FIRST_SYMBOL("^\\W+");
	FIRST_SYMBOL("[€\\£\\$]");
    //
    private String field;

    private SymbolPattern(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field;
    }
}
public class App 
{
    
    public static String str = "400.24£ spdfhnsdo 4000";
    private final static String EXTRACT_NUMBER_MESSAGE = "NumberFormatException for pattern =  %s text =  %s";

	private App() {
	}

	public static String extractString(String pattern, String text) {
		String result = new String();
		Matcher matcher = Pattern.compile(pattern).matcher(text);
		if (matcher.find()) {
			result = text.substring(matcher.start(), matcher.end());
		}
		return result;
	}

	public static String extractSymbol(String pattern,  String text) {
		String result = null;
		String extractText = extractString(pattern, text);
		if(!text.isEmpty()) {
			result = extractText;
		}
		return result;
	}
	public static void main( String[] args )
    {
		String s = extractSymbol(SymbolPattern.FIRST_SYMBOL.toString(), str);
		System.out.println(s);
    }
}
