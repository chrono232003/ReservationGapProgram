package com.cabin;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

//    private final static long GAP = 3;
//    private final static String filePath = "src/com/cabin/test-case.json";

    public static void main(String[] args) {

        //ask user for path to json file
        Scanner scannerPath = new Scanner(System.in);
        System.out.println("Insert path to json file:");
        String filePath = scannerPath.nextLine();

        //ask user to specify for minimum gap in days between bookings
        Scanner scannerGap = new Scanner(System.in);
        System.out.println("Enter minimum day gap between bookings:");
        long gap = scannerGap.nextInt();

        try {
            ReservationManager manager = new ReservationManager(gap, filePath);
            String availableCampsites = manager.getAvailableCampsites();

            System.out.println(availableCampsites.trim());
            //System.out.println(System.getProperty("user.dir"));
        } catch (ParseException pe) {
            System.out.println("There are issues with the dates in the json and the program is not able to parse one or more of them.");
        }
    }
}
