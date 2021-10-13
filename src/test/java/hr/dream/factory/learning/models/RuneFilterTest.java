package hr.dream.factory.learning.models;

import hr.dream.factory.learning.MySqlDao;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class RuneFilterTest extends TestCase {

    public void testFilterByRuneRanks() {
        List<Integer> pomTest = Arrays.asList(31, 6, 30, 8, 9, 7);
        String query2 = "Select * from runewords";
        MySqlDao dao2 = new MySqlDao();
        List<Runeword> results2 = dao2.select2(query2);
        RuneWordFilter rWF = new RuneWordFilter(results2);
        List<Runeword> pomRWL = rWF.filterByRuneRanks(pomTest);
        for (Runeword pomRWD : pomRWL) {
            System.out.println(pomRWD.name);
        }

        assertEquals(2, pomRWL.size());
        List<Integer> pomTest2 = Arrays.asList(6, 30, 9, 7);
        List<Runeword> runewordList = rWF.filterByRuneRanks(pomTest2);
        assertTrue(runewordList.isEmpty());
    }

    public void testFilterByLevel() {
        int i = 50;
        String query2 = "Select * from runewords";
        MySqlDao dao2 = new MySqlDao();
        List<Runeword> results2 = dao2.select2(query2);
        RuneWordFilter rWF = new RuneWordFilter(results2);
        List<Runeword> pomRWL = rWF.filterByLevel(i);
        for (Runeword pomRWD : pomRWL) {
            System.out.println(pomRWD.name + " " +pomRWD.reqLevel);
        }
        assertEquals(1, pomRWL.size());
    }
}