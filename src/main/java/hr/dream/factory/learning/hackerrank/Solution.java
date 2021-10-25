package hr.dream.factory.learning.hackerrank;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        int total = 0;
        for(int i=1; i<=n; i++){
            for (int j=0; j<n-i+1; j++){
                int sum= 0;
                for (int k = j; k < j+i; k++) {
                    sum = sum + array[k];
                }
                if (sum < 0) total++;
            }
        }
        System.out.println(total);

    }
}