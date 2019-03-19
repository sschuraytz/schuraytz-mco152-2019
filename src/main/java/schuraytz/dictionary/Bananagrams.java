package schuraytz.dictionary;

import java.util.ArrayList;
import java.util.HashMap;

public class Bananagrams {

    private Dictionary dictionary;
    private final int NUM_OF_LETTERS = 14;
    private ArrayList<String> wordsFound = new ArrayList<>();

    public Bananagrams(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     *
     * @param tiles
     * @return a list of the words in the dictionary that can be created using the given tiles
     */
    public ArrayList<String> tryToMakeWord(String tiles) {

        HashMap<String, Integer> myLetters = submitLetters(tiles);

        for (String word : dictionary.getList()) {
            if (word.length() <= tiles.length()) {
                word = word.toUpperCase();
                HashMap<String, Integer> theWord = submitLetters(word);

                boolean contains = true;
                for (String letter : theWord.keySet()) {
                    if (!myLetters.containsKey(letter) || myLetters.get(letter) < theWord.get(letter)) {
                        contains = false;
                        break;
                    }
                }
                if (contains) {
                    wordsFound.add(word);
                }
            }
        }
        return wordsFound;
    }

    /**
     *
     * @param letters
     * @return a HashMap where each key is a String with a letter and the mapped value is the number of times that letter
     * appears in the String
     */
    public HashMap<String, Integer> submitLetters(String letters) {
        String[] letterSplit = letters.toUpperCase().split("");

        HashMap<String, Integer> myLetters = new HashMap<>();
        for (String letter : letterSplit) {
            myLetters.merge(letter, 1, Integer::sum);
        }
        return myLetters;
    }
}