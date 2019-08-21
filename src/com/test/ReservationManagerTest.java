package com.test;


import com.cabin.DateUtils;
import com.cabin.ReservationManager;
import com.cabin.ReservationUtils;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class ReservationManagerTest {
    private String filePath = "src/com/test/test-case.json";

    @Test
    public void getAvailableCampsitesSuccessTestGap4() {
            String availableCabins = getAvailableCampsitesSuccessAbstract(4);
            System.out.println(availableCabins);
            assert availableCabins.trim().equals("\"Cozy Cabin\"");
    }

    @Test
    public void getAvailableCampsitesSuccessTestGap3() {
        String availableCabins = getAvailableCampsitesSuccessAbstract(3);
        System.out.println(availableCabins);
        assert availableCabins.trim().equals("\"Cozy Cabin\"\n\"Comfy Cabin\"\n\"Rustic Cabin\"\n\"Rickety Cabin\"");
    }

    @Test
    public void getAvailableCampsitesFileError() {
        try {
            ReservationManager manager = new ReservationManager(4, "bad/file/path");
            String response = manager.getAvailableCampsites();
            assert response.equals("There was an error with the file you provided or the file was not found");
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    private String getAvailableCampsitesSuccessAbstract(long gap) {
        try {
            ReservationManager manager = new ReservationManager(gap, filePath);
            return manager.getAvailableCampsites();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return null;
    }
}
