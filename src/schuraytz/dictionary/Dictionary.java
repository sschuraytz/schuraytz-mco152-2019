package schuraytz.dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

   private ArrayList<String> list = new ArrayList();


    public Dictionary() throws FileNotFoundException {
            String path = "C://Users//SB//Documents//LCW//Semester 4 (Spring 2019)//Methodology//simpleDictionary.txt";
            // String path = "dictionary.txt";
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String word = scanner.next();
                list.add(word);
                scanner.nextLine();
            }
            scanner.close();
    }

    public boolean contains (String word){
        return list.contains(word.toUpperCase());
    }

    public boolean isPalindrome (String word) {

        String reverse = new StringBuilder(word).reverse().toString();

        char[] letters = word.toCharArray();
        char[] reverseLetters = reverse.toCharArray();

        for (char i = 0; i < letters.length; i++) {
            if (letters[i] != reverseLetters[i]) {
                return false;
            }
        }
        return true;
    }

    // return all the palindromes in the dictionary
    public List<String> getPalindromes () {
        ArrayList palindromeList = new ArrayList();
        for (String word : list) {
            if (isPalindrome(word)) {
                palindromeList.add(word);
            }
        }
        return palindromeList;
    }

    public int size() {
        return  list.size();
    }
}