package fr.roi.isograd.battledev2021;

import java.util.Scanner;

public class Preparation {

    public static void main(String[] argv) throws Exception {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int l = sc.nextInt();
        int total = d + 5 * l;

        System.out.println(total);
    }

}
