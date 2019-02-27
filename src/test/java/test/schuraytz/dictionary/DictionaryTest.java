package test.schuraytz.dictionary;

import org.junit.jupiter.api.Test;
import schuraytz.dictionary.Dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {

    @Test
    /* this test works b/c I created a small file with only 3 words (2 palindromes) & tested that to be sure
    the functionality works before applying it to the large dictionary file
    */
    public void getPalindromes() throws FileNotFoundException {
        //given
        Dictionary dictionary = new Dictionary("C://Users//SB//Documents//LCW//Semester 4 (Spring 2019)//Methodology//simpleDictionary.txt");

        //when
        ArrayList palindromes = new ArrayList();
        palindromes.add("anna");
        palindromes.add("mom");

        //then
        assertEquals(palindromes, dictionary.getPalindromes());
    }

    @Test
    public void isPalindrome() throws FileNotFoundException {

        //given
        Dictionary dictionary = new Dictionary();

        //when

        //then
        assertTrue(dictionary.isPalindrome("kayak"));
    }

    @Test
    public void isPalindrome_false() throws FileNotFoundException {

        //given
        Dictionary dictionary = new Dictionary();

        //when

        //then
        assertFalse(dictionary.isPalindrome("hello"));
    }

    @Test
    public void contains() throws FileNotFoundException {

        // given
        Dictionary dictionary = new Dictionary();

        // when

        // then
        assertTrue(dictionary.contains("WONDERFUL"));
    }

    @Test
    public void contains_false() throws FileNotFoundException {

        // given
        Dictionary dictionary = new Dictionary();

        // when

        // then
        assertFalse(dictionary.contains("WONDERF"));
    }

    @Test
    public void contains_mixedCase() throws FileNotFoundException {

        // given
        Dictionary dictionary = new Dictionary();

        // when

        // then
        assertTrue(dictionary.contains("WONDERful"));
    }

    @Test
    public void size() throws FileNotFoundException {

        //given
        Dictionary dictionary = new Dictionary();
        //when

        //then
        assertEquals(167964, dictionary.size());
    }
}