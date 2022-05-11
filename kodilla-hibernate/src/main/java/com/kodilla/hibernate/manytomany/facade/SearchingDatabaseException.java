package com.kodilla.hibernate.manytomany.facade;

public class SearchingDatabaseException extends Exception {

    public static String ERR_CANNOT_FIND_COMPANY = "Cannot find company in database";
    public static String ERR_CANNOT_FIND_LASTNAME = "Cannot find employee in database";
    public static String ERR_FRAGMENT_NOT_LONG_ENOUGH = "Cannot use empty query";

    public SearchingDatabaseException(String message) {
        super(message);
    }
}
