package com.cabin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;

public class ReservationManager {

    private long gap;
    private String filePath;

    public ReservationManager(long gap, String filePath) {
        this.gap = gap;
        this.filePath = filePath;
    }

    /**
     * Main reservation method that performs the logic to get back a list of cabins.
     * Uses the filepath and specified gap (in days) to determine cabin availability for specified timeframes
     * @return campsite/cabin list
     */
    public String getAvailableCampsites() throws ParseException {
        ReservationUtils reservationUtils = new ReservationUtils();
        JSONObject jsonObject = reservationUtils.parseFileToJson(filePath);
        if (jsonObject != null) {

            //get booking start and end date and store to variables
            JSONObject search = (JSONObject) jsonObject.get(JsonEnum.SEARCH.jsonNodeName);
            String startDate = (String) search.get(JsonEnum.STARTDATE.jsonNodeName);
            String endDate = (String) search.get(JsonEnum.ENDDATE.jsonNodeName);

            //grab existing reservations array
            JSONArray reservations = (JSONArray) jsonObject.get(JsonEnum.RESERVATIONS.jsonNodeName);

            HashSet campsiteIds = new HashSet<String>();

            /**
             * loop through existing reservations array and do gap analysis on the start and end dates vs start and end dates on reservations
             */
            //run gap function on start date and return an array of campsiteIds
            DateUtils dateUtils = new DateUtils();
            for (int i = 0; i < reservations.size(); i++) {
                try {
                    JSONObject reservation = (JSONObject) reservations.get(i);

                    Date startDateQuery = dateUtils.parseDate(startDate);
                    Date endDateQuery = dateUtils.parseDate(endDate);

                    Date reservationStartDate = dateUtils.parseDate((String) reservation.get("startDate"));
                    Date reservationEndDate = dateUtils.parseDate((String) reservation.get("endDate"));

                    if (reservationUtils.isValidGap(reservationStartDate, startDateQuery, gap)) {
                        if (reservationUtils.isValidGap(reservationEndDate, endDateQuery, gap)) {
                            campsiteIds.add(reservation.get(JsonEnum.CAMPSITEID.jsonNodeName));
                        }
                    }
                } catch (ParseException pe) {
                    throw pe;
                }
            }

            JSONArray campsites = (JSONArray) jsonObject.get(JsonEnum.CAMPSITES.jsonNodeName);
            return reservationUtils.getCabinList(campsites, campsiteIds);

        } else {
            //json was null either by error or there was nothing there
            return "There was an error with the file you provided or the file was not found";
    }
    }
}
