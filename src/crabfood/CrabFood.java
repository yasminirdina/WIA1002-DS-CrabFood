package crabfood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CrabFood {

    public static int[][] map = new int[5][5];
    public static int[] index = {1, 2, 3};

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Menu suppported by CrabFood: ");
        details("Input.txt", index);

        printMap();
        
        System.out.println("Do you want to start ordering? Press end to quit.");
        Scanner input = new Scanner(System.in);
        String order = input.nextLine();

        PrintWriter p = new PrintWriter(new FileOutputStream("Customer.txt"));
        long start = System.nanoTime();
        int indexCust = 1;

        System.out.println(getTime(start) + ": a new day has started!");
        
        while (!order.equalsIgnoreCase("end")) {
            long current = getTime(start);
            p.println(current);
            
//            //displaying timestamp + dish + restaurant
//            //PROBLEM::::: TAK BOLEH KE TEKAN SPACE UTK PROCEED TO NEXT COMMAND LINE INSTEAD OF
//           // ...TERPAKSA PRESS ENTERRRR BURUKKKK
            System.out.print(current + ": ");
            System.out.print("Customer " + indexCust + " wants to order ");
            order = input.next(); //dish first word
            String order3 = input.next(); //dish 2nd word
            if(!order3.equals(" "))
            {
                p.println(order + " " + order3);
                System.out.print("from ");
            }
            
            order = input.next(); //restaurant first word
            order3 = input.next(); //restaurant 2nd word
            if(!order3.equals(" "))
            {
                p.println(order + " " + order3);
                System.out.println(".");
            }
            order = input.nextLine(); //for enter
            p.println(); //empty line to Customer.txt file
            
//            System.out.println("Your choice of restaurant is?");
//            order = input.nextLine();
//            p.println(order);
//
//            System.out.println("Your choice of dish?");
//            order = input.nextLine(); //update order for dish
//            p.println(order);
//            p.println();
//
            indexCust++;
            System.out.println("Thank you for ordering. Next customer please. Press end to quit.");
            order = input.nextLine();
        }
        p.close();

        OrderQueue<String> queue = new OrderQueue<>();
        Scanner scan = new Scanner(new File("Customer.txt"));
        String read = scan.nextLine();

        while (scan.hasNextLine()) {
            String[] custoQueue = new String[3];
            if (!read.isEmpty()) {
                for (int i = 0; i < 3; i++) {
                    custoQueue[i] = read;
                    read = scan.nextLine();
                }
            } else {
                read = scan.nextLine();
                continue;
            }
            queue.enqueue(Arrays.toString(custoQueue));
//            String custArray[] = queue.toArray(new String[queue.getSize()]);
//            System.out.println(Arrays.toString(custArray));
            
            //System.out.println(Arrays.toString(queue.toArray())); //takleh display
        }
        System.out.println(queue.toString());

        /*
        while (scan.hasNextLine()) {
            String[] custQueue = new String[3];
            for(int i = 0; i < 3; i++)
            {
                custQueue[i] = read;
                read = scan.nextLine();
            }
            queue.enqueue(custQueue);
            System.out.println(queue.toString()); //WHY TAKNAK DISPLAYYYYY
        }
         */
        //time
        //System.out.println(getTime(start));
    }

    public static long getTime(long start) {
        long finish = System.nanoTime();
        long timeElapsed = (finish - start) / 1000000; //millisecond

        return timeElapsed;
    }

    public static void details(String file, int[] index) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));

        //for (int i = 0; i < 3; i++) {
        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();

            for (int i = 0; i < 3; i++) {
                if (next.equalsIgnoreCase("Crusty Crab") && index[i] == 1) {
                    CrustyCrab a = new CrustyCrab("Crusty Crab");
                    a.bacaje(scanner);
                } else if (next.equalsIgnoreCase("Phum Bucket") && index[i] == 2) {
                    PhumBucket b = new PhumBucket("Phum Bucket");
                    b.bacaje(scanner);

                } else if (next.equalsIgnoreCase("Burger Krusty") && index[i] == 3) {
                    BurgerKrusty c = new BurgerKrusty("Burger Krusty");
                    c.bacaje(scanner);
                }

            }
        }

    }

    // to print the Map
    public static void printMap() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 1) {
                    System.out.print("C");
                } else if (map[i][j] == 2) {
                    System.out.print("P");
                } else if (map[i][j] == 3) {
                    System.out.print("B");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println("");
        }
    }

}