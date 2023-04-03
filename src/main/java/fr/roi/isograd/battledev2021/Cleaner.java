package fr.roi.isograd.battledev2021;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Cleaner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orbitSize = sc.nextInt();
        String orbit = sc.next();

        int halfOrbit = orbitSize / 2;
        int count = 0;
        if (orbitSize % 2 == 1) {
            System.out.print("0");
            return;
        }

        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (Character c : orbit.toCharArray()) {
            treeMap.put(c, treeMap.getOrDefault(c, 0) + 1);
        }

        if (!treeMap.values().stream().allMatch(i -> i % 2 == 0)) {
            System.out.print("0");
            return;
        }

        treeMap.replaceAll((k, v) -> v / 2);

        TreeMap<Character, Integer> solution = new TreeMap<>(treeMap);
        TreeMap<Character, Integer> cleaner = new TreeMap<>();


        for (int i = 0; i < halfOrbit; i++) {
            Character c = orbit.charAt(i);
            cleaner.put(c, cleaner.getOrDefault(c, 0) + 1);
        }

        //parcours de la moitié de l'orbit
        // et mis a jour de la map
        // puis compare avec solution

        for (int i = 1; i <= halfOrbit; i++) {
            Character entrant = orbit.charAt(halfOrbit + i - 1);
            Character sortant = orbit.charAt(i - 1);

            cleaner.put(entrant, cleaner.getOrDefault(entrant, 1) + 1);
            cleaner.put(sortant, cleaner.getOrDefault(sortant, 0) - 1);

            if (equals(cleaner, solution)) {
                count++;
            }

        }
        System.out.print(count * 2);
    }

    public static boolean equals(Map<Character, Integer> c1, Map<Character, Integer> c2) {
        Map<Character, Integer> cc1 = c1.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return cc1.equals(c2);
    }
}
