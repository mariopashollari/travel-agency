package com.sda.travel_agency_project.static_data;


public enum ContinentsData {
    EUROPE("Europe"),
    ASIA("Asia"),
    AFRICA("Africa"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    AUSTRALIA("Australia"),
    ANTARCTICA("Antarctica"),;

    private final String continentName;

    ContinentsData(String name) {
        this.continentName = name;
    }

    public String getContinentName() {
        return this.continentName;
    }
}
