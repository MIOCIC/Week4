package hr.dream.factory.learning;

import hr.dream.factory.learning.models.Rune;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MySqlDaoTest {

    @Test
    public void insert() {
        String query = "INSERT INTO runes (rune_rank, name, high_rune) " +
                " VALUES (1, 'El', false)";
        MySqlDao dao = new MySqlDao();
        dao.insert(query);
        Assert.assertTrue(true);
    }
    @Test
    public void testSelect() {
        String query = "Select * from runes";
        MySqlDao dao = new MySqlDao();
        List<Rune> results = dao.select(query);
        Assert.assertFalse(results.isEmpty());
        results.stream()
                .filter(t -> t.getHighRune())
                .forEach(t -> print(t));
    }

    private void print (Rune rune){
        System.out.println(rune.getRuneRank() +
                ", " + rune.getName() + ", " + rune.getHighRune());
    }
}