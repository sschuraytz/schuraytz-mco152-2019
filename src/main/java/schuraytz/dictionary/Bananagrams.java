package schuraytz.dictionary;

import java.util.*;

public class Bananagrams {

    final int NUM_OF_LETTERS = 14;

    public ArrayList<String> tryToMakeWord(Dictionary dictionary, String letters) {

        HashMap<String, Integer> myLetters = submitLetters(letters);
        ArrayList<String> wordsFound = new ArrayList<>();

        for (String word : dictionary.getList()) {
            if (word.length() <= NUM_OF_LETTERS) {
                word = word.toUpperCase();
                LinkedHashMap<String, Integer> theWord = submitLetters(word);
                Iterator<String> iterator = theWord.keySet().iterator();
                String letter;

                while(iterator.hasNext()) {
                    letter = iterator.next();
                    if(myLetters.containsKey(letter) && myLetters.get(letter) >= theWord.get(letter)) {
                        iterator.remove();
                        if(theWord.isEmpty()) {
                            wordsFound.add(word);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return wordsFound;
    }

    public LinkedHashMap<String, Integer> submitLetters(String letters) {
        String[] letterSplit = letters.toUpperCase().split("");

        LinkedHashMap<String, Integer> myLetters = new LinkedHashMap<>();
        for (String letter : letterSplit) {
            myLetters.merge(letter, 1, Integer::sum);
        }
        return myLetters;
    }
}