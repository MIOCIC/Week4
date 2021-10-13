package hr.dream.factory.learning.models;

import java.util.*;
import java.util.stream.Collectors;

public class RuneMapper {
    List<Rune> pomList;
    public RuneMapper(List<Rune> a) {
        this.pomList = a;
    }
    Map<Runeword, List<Rune>> mapRunewords(List<Runeword> lrw){
        Map<Runeword, List<Rune>> results = new HashMap<>();

        for (Runeword pomRWD: lrw) {
            String[] runesData = pomRWD.runes.split(",");
            List<Integer> convertedToInt = Arrays.stream(runesData)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Rune> runesForRuneword = new ArrayList<>();

            for (Integer runeRank : convertedToInt) {
               // List<Rune> pompom = pomList.stream()
               //         .filter(t -> t.runeRank)
                for (Rune rune : pomList) {
                    if (runeRank.equals(rune.getRuneRank())) {
                        runesForRuneword.add(rune);
                    }
                }


            }
            results.put(pomRWD, runesForRuneword);
        }
        return results;
        }
}
