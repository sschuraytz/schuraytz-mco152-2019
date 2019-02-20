package schuraytz.dictionary;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class dictionaryTest {

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