package oozie.mr.test;

import java.util.StringTokenizer;

/**
 * Created by qls on 16-3-29.
 */
public class test {
    public static void main(String[] args) {
        String line = "hello world";
        StringTokenizer tokenizer = new StringTokenizer(line);
        while(tokenizer.hasMoreTokens())
        {
            System.out.println(tokenizer.nextToken());
        }
    }
}
