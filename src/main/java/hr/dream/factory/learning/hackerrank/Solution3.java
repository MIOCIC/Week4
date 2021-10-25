package hr.dream.factory.learning.hackerrank;

import java.util.Scanner;

public class Solution3 {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int n = game.length;
        int pom = 0;
        int pom2 = 0;
        while (true){
            if (pom+leap >= n) return true;
            else {
                if (game[leap] == 1 && game[1] == 1 && pom == 0 ) return false;


                if (game[pom+leap] == 0) {
                    pom= pom+leap;
                    pom2 = pom;
                    //game[pom] = 1;
                } else if (game[pom+1] == 0) {

                    pom++;
                    //game[pom] = 1;
                } else if (pom>0 && game[pom-1] == 0) {
                    game[pom] = 1;
                    pom--;
                }

                else if (pom2-leap >= 0 && game[pom2-leap] == 0) {
                    game[pom2] = 1;
                    pom = pom2 - leap;
                    pom2 = 0;
                } else return false;

            }

        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
