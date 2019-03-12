package test.schuraytz.dictionary;

import org.junit.jupiter.api.Test;
import schuraytz.dictionary.Bananagrams;
import schuraytz.dictionary.Dictionary;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class BananagramsTest {

    @Test
    public void tryToMakeWord() {
        //given
        Dictionary dictionary = mock(Dictionary.class);     //fake dictionary; nothing in here
        Bananagrams bananagrams = new Bananagrams();
        String letters = "apalbcdeghiknm";
        List<String> wordList =
                Arrays.asList("aa", "mA", "Ab", "APPLE", "AD", "YELLOW", "cake", "MEN", "ELEMENTARY");
        doReturn(wordList).when(dictionary).getList();

        //when
        List<String> list = bananagrams.tryToMakeWord(dictionary, letters);

        //then
        assertEquals("[AA, MA, AB, AD, CAKE, MEN]", list.toString());
    }
}
