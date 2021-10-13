package hr.dream.factory.learning.models;

import hr.dream.factory.learning.MySqlDao;
import junit.framework.TestCase;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RuneMapperTest extends TestCase {

    public void testMapRunewords() {
        String query = "Select * from runes";
        MySqlDao dao = new MySqlDao();
        List<Rune> results = dao.select(query);
        RuneMapper rmp = new RuneMapper(results);

        String query2 = "Select * from runewords";
        MySqlDao dao2 = new MySqlDao();
        List<Runeword> results2 = dao2.select2(query2);

        Map<Runeword, List<Rune>> testmap = rmp.mapRunewords(results2);
        //System.out.println(Collections.singletonList(testmap));
        //for (Map.Entry<Runeword, List<Rune>> entry : testmap.entrySet()) {
        //    System.out.println(entry.getKey() +" : "+entry.getValue());
        //}
        testmap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey().name + ":" + printList(entry.getValue()));
        });
    }

    private String printList(List<Rune> input) {
        String xyz = "";
        for (Rune y : input){
            //System.out.print(y + " ");
             xyz += y.name+"("+ y.runeRank+")" + " " ;
        }
        return xyz;
    }
}