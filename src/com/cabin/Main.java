package com.cabin;

import java.text.ParseException;

public class Main {

    private final static long GAP = 3;
    private final static String filePath = "src/com/cabin/test-case.json";

    public static void main(String[] args) {

        //ask user for path to json file
//        Scanner myObj = new Scanner(System.in);
//        System.out.println("Insert path to json file:");
//
//        String filePath = myObj.nextLine();

        try {
            ReservationManager manager = new ReservationManager(GAP, filePath);
            String availableCampsites = manager.getAvailableCampsites();

            System.out.println(availableCampsites);
            //System.out.println(System.getProperty("user.dir"));
        } catch (ParseException pe) {
            System.out.println("There are issues with the dates in the json and the program is not able to parse one or more of them.");
        }
    }
}
