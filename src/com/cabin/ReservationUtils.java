package com.cabin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

public class ReservationUtils {

    /**
     * Reads the json file that a user passes in and attempts to parse it.
     * This method will return null on the case of the file not being found from the path or the file cannot be parsed as json
     * @param filePath
     * @return JsonObject
     */
    public JSONObject parseFileToJson(String filePath) {
        try {
            //parse the json file
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            return (JSONObject) obj;
        } catch (FileNotFoundException e) {
            //just returning null here as we do not want the command line user to see a stack trace.
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Checks to see if the gap between the reservation and input date are valid (Not too small)
     * @param reservationDate
     * @param inputDate
     * @param gap
     * @return boolean true or false whether the gap is valid
     */
    public boolean isValidGap(Date reservationDate, Date inputDate, long gap) {
            DateUtils dateUtils = new DateUtils();
            long daysBetweenDates = dateUtils.daysBetween(reservationDate, inputDate);
            return (daysBetweenDates == 0) || (daysBetweenDates >= gap);
    }

    /**
     * Get a formatted list of available cabins based on the campsiteids that were returned as valid.
     * @param campsites
     * @param campsiteIds
     * @return List of cabin names
     */
    public String getCabinList(JSONArray campsites, HashSet<String> campsiteIds) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < campsites.size(); i++) {
            JSONObject campsite = (JSONObject) campsites.get(i);
            if (campsiteIds.contains(campsite.get("id"))) {
                builder.append("\"" + campsite.get("name") + "\"\n");
            }
        }
        return builder.toString();
    }
}
