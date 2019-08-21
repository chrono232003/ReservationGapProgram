package com.cabin;

public class Main {

    private final static long GAP = 3;
    private final static String filePath = "src/com/cabin/test-case.json";

    public static void main(String[] args) {

        //ask user for path to json file
//        Scanner myObj = new Scanner(System.in);
//        System.out.println("Insert path to json file:");
//
//        String filePath = myObj.nextLine();

        ReservationManager manager = new ReservationManager(GAP, filePath);
        String availableCampsites = manager.getAvailableCampsites();

        System.out.println("These are the available campsites:\n" + availableCampsites);
        //System.out.println(System.getProperty("user.dir"));
    }
}
