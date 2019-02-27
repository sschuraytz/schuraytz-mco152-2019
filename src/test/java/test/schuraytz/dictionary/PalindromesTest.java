package test.schuraytz.dictionary;

import org.junit.jupiter.api.Test;
import schuraytz.dictionary.Dictionary;
import schuraytz.dictionary.Palindromes;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class PalindromesTest {

    @Test
    public void getPalindromes() {

        // given
        Dictionary dictionary = mock(Dictionary.class);     //fake dictionary; nothing in here
        Palindromes palindromes = new Palindromes();
        List<String> wordList =
                Arrays.asList("Kaila", "Esther", "Dad", "Hannah", "Helen", "Ayelet", "Sarah Bracha");
        doReturn(wordList).when(dictionary).getList();

        // when
        List<String> list = palindromes.getPalindromes(dictionary);

        // then
        assertEquals(2, list.size());
    }

    @Test
    public void isPalindrome() {

        //given
        Palindromes palindromes = new Palindromes();

        //when

        //then
        assertTrue(palindromes.isPalindrome("kayak"));
    }

    @Test
    public void isPalindrome_false() {

        //given
        Palindromes palindromes = new Palindromes();

        //when

        //then
        assertFalse(palindromes.isPalindrome("hello"));
    }
}
