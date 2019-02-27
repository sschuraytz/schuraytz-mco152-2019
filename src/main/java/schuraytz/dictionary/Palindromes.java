package schuraytz.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Palindromes {

    public boolean isPalindrome (String word) {

        String reversed = new StringBuilder(word).reverse().toString();

        return word.equalsIgnoreCase(reversed);
    }

    // return all the palindromes in specified dictionary
    public List<String> getPalindromes (Dictionary dictionary) {
        ArrayList palindromeList = new ArrayList();
        for (String word : dictionary.getList()) {
            if (isPalindrome(word)) {
                palindromeList.add(word);
            }
        }
        return palindromeList;
    }
}
