package com.sda.travel_agency_project.exceptions;

public class AgencyExceptions extends RuntimeException {
    private AgencyExceptions(String message) {
        super(message);
    }

    public static AgencyExceptions notFound(String className, Object id) {
        String message = String.format("%s with id %s not found!", className, id.toString());
        return new AgencyExceptions(message);
    }

    public static AgencyExceptions userNotFound(String className, String username) {
        String message = String.format("User with username '%s' not found!", username);
        return new AgencyExceptions(message);

    }
}