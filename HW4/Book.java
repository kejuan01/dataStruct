//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;

/*Header
/HW4
/Names:
*/
import java.util.*;
public class Book {
    public static void main(String[] args){

    }
    public static String punctuation(String s){
        StringBuilder newString = new StringBuilder();
        //String newString = "";
        //String Punctuation = "?!.'\",";
        for ( int i = 0; i<= s.length(); i++){
            if
            ("?!.'\",".contains(String.valueOf(s.charAt(i)))) continue;
            newString.append(String.valueOf(s.charAt(i)).toLowerCase());


        }
        return newString.toString();
    }
    public static TreeMap<String, Integer> words(String s){
        TreeMap
    }
    public static void statistics(TreeMap<String, Integer> m){
        int numberofwords =0;
        int totalwords = 0;
        String commonword ="";
        String longestword ="";
        int iscount =0;
        System.out.println("Number of different words in book: "+numberofwords);
        System.out.println("Total number of in book: "+totalwords);
        System.out.println("Most common word in book: "+commonword);
        System.out.println("Longest word in book: "+longestword);
        System.out.println("Is occurs in book: "+iscount+" times");
    }

}
