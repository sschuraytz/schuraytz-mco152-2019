package schuraytz.dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

   private ArrayList<String> list = new ArrayList();

    public Dictionary(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()) {
            String word = scanner.next();
            list.add(word);
            scanner.nextLine();
        }
        scanner.close();
    }

    public Dictionary() throws FileNotFoundException {
            this("dictionary.txt");
    }

    public boolean contains (String word){
        return list.contains(word.toUpperCase());
    }

    public boolean isPalindrome (String word) {

        String reverse = new StringBuilder(word).reverse().toString();

        if (word.compareTo(reverse) == 0) {
            return true;
        } else {
            return false;
        }
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