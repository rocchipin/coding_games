package fr.roi.isograd.battledev2021;

import java.util.Scanner;

public class Tetris {
    public static void main(String[] argv) throws Exception {

        Scanner sc = new Scanner(System.in);

        char[][] tab = new char[20][10];
        for (int i = 0; i < 20; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 10; j++) {
                tab[i][j] = line.charAt(j);
            }
        }

        System.out.println(tetris(tab));


    }

    public static String tetris(char[][] tab) {
        // parcours des lignes
        char point = '.';
        char diese = '#';

        for (int colonne = 0; colonne < 10; colonne++) {
            // parcours de ligne
            for (int ligne = 0; ligne < 20; ligne++) {
                // cherche dans les lignes le #

                if (tab[ligne][colonne] == point) {
                    // est ce que toute la ligne contient des dieses
                    if (checkLine(tab, ligne, colonne)
                            && checkLine(tab, ligne+1, colonne)
                            && checkLine(tab, ligne+2, colonne)
                            && checkLine(tab, ligne+3, colonne)
                            && checkfin(tab,ligne,colonne)) {
                        return "BOOM " + (colonne + 1);
                    }
                } else {
                    break;
                }

            }

        }
        return "NOPE";

    }

    private static boolean checkfin(char[][] tab, int ligne, int colonne) {
        if ((ligne+3) == 19 ) {
            return true;
        }

        if (ligne+4>20) {
            return false;
        }
        if (tab[ligne+4][colonne] == '#') {
            return true;
        }

        return false;
    }

    private static boolean checkLine(char[][] tab, int ligne, int colonne) {

        if (ligne>=20) {
            return false;
        }
        for (int col = 0; col < 10; col++) {
            if (tab[ligne][col] == '.' && col != colonne) {
                return false;
            }

        }
        return true;
    }
}
