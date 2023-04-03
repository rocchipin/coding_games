package fr.roi.isograd.laposte2021;

import java.util.*;

public class DecodageTemporel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chiffre1_code = sc.nextLine();
        String chiffre2_code = sc.nextLine();
        String chiffre3 = sc.nextLine();

        String[] c1 = chiffre1_code.split(" ");
        String[] c2 = chiffre2_code.split(" ");

        String code1 = c1[1];
        String chiffre1 = c1[0];

        int size = code1.length();
        List<String> li = new ArrayList<>();
        switch (size) {
            case 30: {
                li.add("3");
                break;
            }
            case 40: {
                li.add("4");
                break;
            }
            default: {
                li.add("3");
                li.add("4");
            }
        }

        int nb4 = size - 30;
        int nb3 = 10 - nb4;

        for (int i = 0; i < 9; i++) {
            li = addElement(li, nb3, nb4);
        }

        List<Map<Integer, String>> possibles = new ArrayList<>();
        for (String elt : li) {
            String[] tab = decodeD(elt, code1);
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                map.put(Integer.valueOf("" + chiffre1.charAt(i)), tab[i]);
            }
            possibles.add(map);
        }

        //test des solutions :
        Map<Integer, String> laSolution = null;
        for (Map<Integer, String> solution : possibles) {
            String chiffre = c2[0];
            //encodage
            String encode = "";
            for (int i = 0; i < 10; i++) {
                Integer ch = Integer.valueOf("" + chiffre.charAt(i));
                encode = encode + solution.get(ch);
            }

            if (encode.equals(c2[1])) {
                //trouvé
                laSolution = solution;
                break;
            }
        }

        //System.out.print(laSolution);

        String res = "";

        for (int i = 0; i < chiffre3.length(); i++) {
            Integer ch = Integer.valueOf("" + chiffre3.charAt(i));
            res = res + laSolution.get(ch);
        }

        System.out.print(res);
    }

    private static String[] decodeD(String reparition, String code) {

        String[] tab = new String[10];
        char[] repart = reparition.toCharArray();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            int longueur = Integer.valueOf("" + repart[i]);
            tab[i] = code.substring(index, index + longueur);
            index = index + longueur;
        }
        return tab;

    }

    private static List<String> addElement(List<String> liste, int nb3, int nb4) {
        List<String> retour = new ArrayList<>();
        for (String s : liste) {
            if (nb3 > 0) {
                long count = s.chars().filter(ch -> ch == '3').count();
                if (count < nb3) {
                    retour.add(s + "3");
                }
            }
            if (nb4 > 0) {
                long count = s.chars().filter(ch -> ch == '4').count();
                if (count < nb4) {
                    retour.add(s + "4");
                }
            }

        }

        return retour;
    }
}
