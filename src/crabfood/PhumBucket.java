package crabfood;

import static crabfood.CrabFood.map;
import java.util.ArrayList;
import java.util.Scanner;

public class PhumBucket {

    String name = "";

    public PhumBucket(String name) {
        this.name = name;
    }

    public void bacaje(Scanner scanner) {
        System.out.println("");
        System.out.println("Restaurant name: Phum Bucket");
        String first_xy = scanner.nextLine();
        ArrayList<String> xy = new ArrayList<>();
        while (first_xy.length() <= 3)//selagi the string length is 3 or below, masuk loop
        {
            String[] split = first_xy.split(" ");
            int x1 = Integer.valueOf(split[0]);
            int y1 = Integer.valueOf(split[1]);
            xy.add(split[0]);
            xy.add(split[1]);
            System.out.println("X1: " + x1); //check
            System.out.println("Y1: " + y1); //check
            first_xy = scanner.nextLine();
            System.out.println(xy.toString()); //check

            for (int i = 0; i < 3; i++) {
                map[x1][y1] = 2;
            }
        }
        
                ArrayList<String> dishes = new ArrayList<>();
        ArrayList<String> prepTime = new ArrayList<>();
        while (first_xy.length() > 3)
        {
            dishes.add(first_xy);
            System.out.println(first_xy);
            first_xy = scanner.nextLine();
            prepTime.add(first_xy);
            System.out.println(first_xy);
            first_xy = scanner.nextLine();
        }

    }
}