package test.schuraytz.dictionary;

import org.junit.jupiter.api.Test;
import schuraytz.dictionary.Dictionary;
import schuraytz.dictionary.Palindromes;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {

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