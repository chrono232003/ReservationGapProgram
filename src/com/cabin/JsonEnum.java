package com.cabin;

enum JsonEnum {
    SEARCH("search"),
    STARTDATE("startDate"),
    ENDDATE("endDate"),
    CAMPSITES("campsites"),
    RESERVATIONS("reservations"),
    CAMPSITEID("campsiteId");

    final String jsonNodeName;

    JsonEnum(String jsonNodeName) {
        this.jsonNodeName = jsonNodeName;
    }
}
