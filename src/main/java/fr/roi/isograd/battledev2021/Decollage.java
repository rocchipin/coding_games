package fr.roi.isograd.battledev2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Decollage {
    public static void main(String[] argv) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> str = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            str.add(sc.next());
        }

        HashMap<String, Integer> map = new HashMap<>();

        String resultat="";
        for (String s : str) {

            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        resultat = getString(str, map);
        System.out.println(resultat);


    }

    private static String getString(List<String> str, HashMap<String, Integer> map) {
        for (String s: str) {
            if (map.get(s) == 2) {
                return s;

            }
        }
        return "";
    }
}
