package hr.dream.factory.learning.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> inputListList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> pomList = new ArrayList<>();
            int listSize = sc.nextInt();
            for (int j = 0; j < listSize; j++) {
                pomList.add(sc.nextInt());
            }
            inputListList.add(pomList);
        }

        n = sc.nextInt();
        List<List<Integer>> integerList2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> pomList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                pomList.add(sc.nextInt());
            }
            integerList2.add(pomList);
        }
        for (int listIndex = 0; listIndex<integerList2.size(); listIndex++) {
            List<Integer> coordinateList = integerList2.get(listIndex);
            Integer firstCoordinate = coordinateList.get(0);
            int coordinateAdjustedToIndex = firstCoordinate - 1;
            List<Integer> targetInputList = inputListList.get(coordinateAdjustedToIndex);
            Integer elementIndex = coordinateList.get(1);
            if (inputListList.size() > firstCoordinate
                    &&
                    targetInputList.size() >= elementIndex)
                System.out.println(targetInputList.get(elementIndex -1));
            else System.out.println("ERROR!");
        }

    }
}
