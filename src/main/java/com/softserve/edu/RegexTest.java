package com.softserve.edu;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String args[]) {
        // String pattern = "[ Na-z]+";
        // String pattern = "time";
        //String pattern = "\\bi";
        //String pattern = "^N";
        //String pattern = "e$";
        //String pattern = "\\w+(\\.\\w+)*@\\w+(\\.\\w{2,})+";
        //String pattern = "\\w+(\\.\\w+)*@(\\w+\\.)+\\w{2,}";
        //String pattern = "<.*>";
        //String pattern = "<[^>]+>";
        //String pattern = ">[^<]+<";
        //String pattern = "<([a-z]+)>[^<]+</\\1>";
        //String pattern = "<([a-z]+)>.+</\\1>";
        //String pattern = "<([a-z]+>)((?!\\1).)+</\\1";
        String pattern = "http://[^/]+/";
        System.out.println("pattern = " + pattern);
        //String text = "New time Now is the time";
        //String text = "a.a@iooo.ua a@i.ua a_a@i.com.ua";
        //String text = "<div><b>Beginning with bold text</b> next, text body,<i>italic text</i> end of text.</div>";
        //String text = "http://192.168.103.142:8080/job/lv269/ws/target/surefire-reports/test-output/2017_12_26_10-58-53_CaptureSourceCode.txt";
        String text = "D:/workspace/lv269/target/surefire-reports/test-output";
        //
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        //
        if (m.matches()) {
            System.out.println("Full Matcher");
            //m.reset();
        }
        m.reset();
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(text.substring(m.start(), m.end()));
            //list.add(text.substring(m.start()+1, m.end()-1).trim());
            System.out.print(text.substring(m.start(), m.end()) + "\n");
        }
        System.out.println("\n\tLIST: " + list);
        //
        m.reset();
        if (m.find()) {
            System.out.println("\nSubstring found: " + text.substring(m.start(), m.end()));
            System.out.println("Last String: " + text.substring(m.end()-1));
        }
    }
}
