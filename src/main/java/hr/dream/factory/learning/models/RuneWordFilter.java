package hr.dream.factory.learning.models;

import hr.dream.factory.learning.MySqlDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RuneWordFilter {
    List<Runeword> pomRWList;

    public RuneWordFilter(List<Runeword> pomRWList) {
        this.pomRWList = pomRWList;
    }

    List<Runeword> filterByRuneRanks(List<Integer> runeRanks){

        List<Runeword> results = new ArrayList<>();

        String query = "Select * from runes";
        MySqlDao dao = new MySqlDao();
        List<Rune> runeResults = dao.select(query);
        RuneMapper rmp = new RuneMapper(runeResults);

        String query2 = "Select * from runewords";
        MySqlDao dao2 = new MySqlDao();
        List<Runeword> results2 = dao2.select2(query2);

        Map<Runeword, List<Rune>> testMap = rmp.mapRunewords(results2);

        for (Map.Entry<Runeword, List<Rune>> entry : testMap.entrySet()) {
            List<Integer> pomRuneRanks = new ArrayList<>(runeRanks);
            boolean pomB = true;

            List<Rune> allRunesNeededForRuneword = entry.getValue();

            for (Rune pomRune : allRunesNeededForRuneword){
                if (pomRuneRanks.contains(pomRune.runeRank)){
                    pomRuneRanks.remove((Integer) pomRune.runeRank);
                } else {
                    pomB = false;
                }
            }
            if (pomB) results.add(entry.getKey());
        }
        return results;
    }

    List<Runeword> filterByLevel(int characterLevel){
        //List<Runeword> results = new ArrayList<>();

        String query2 = "Select * from runewords";
        MySqlDao dao2 = new MySqlDao();
        List<Runeword> runewordList = dao2.select2(query2);
        //for (Runeword pomRW : runewordList){
        //    if (pomRW.reqLevel <= characterLevel) results.add(pomRW);
        //}
        List<Runeword> results = runewordList.stream()
                .filter(t -> t.reqLevel <= characterLevel)
                .collect(Collectors.toList());
        return results;
    }

}
