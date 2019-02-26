package schuraytz.dictionary;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class dictionaryTest {

    @Test
    /* this test works b/c I created a small file with only 3 words (2 palindromes) & tested that to be sure
    the functionality works before applying it to the large dictionary file
    */
    public void get_dict_palindromes() throws FileNotFoundException {
        //given
        Dictionary dictionary = new Dictionary();

        //when
        ArrayList palindromes = new ArrayList();
        palindromes.add("anna");
        palindromes.add("mom");

        //then
        assertEquals(palindromes, dictionary.getPalindromes());
    }

    @Test
    public void get_size() throws FileNotFoundException {

        //given
        Dictionary dictionary = new Dictionary();
        //when

        //then
        assertEquals(167964, dictionary.size());
    }

    @Test
    public void is_palindrome() throws FileNotFoundException {

        //given
        Dictionary dictionary = new Dictionary();

        //when

        //then
        assertTrue(dictionary.isPalindrome("kayak"));
    }

    @Test
    public void is_not_palindrome() throws FileNotFoundException {

        //given
        Dictionary dictionary = new Dictionary();

        //when

        //then
        assertFalse(dictionary.isPalindrome("hello"));
    }

    @Test
    public void contains_true() throws FileNotFoundException {

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
    public void contains_true_mixed_case() throws FileNotFoundException {

        // given
        Dictionary dictionary = new Dictionary();

        // when

        // then
        assertTrue(dictionary.contains("WONDERful"));
    }
}