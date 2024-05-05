package com.api.kkn.app.util;

import java.time.LocalDate;

public class GenerateKode {
    private static int counter = 1;
    private static int lastYear = LocalDate.now().getYear();
    private static final String BASE_FORMAT = "%04d%02d%02d%04d";
    private static LocalDate lastDate = LocalDate.now();
    private static final int MAX_COUNTER = 9999;

    public static synchronized String generateID() {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();

        if (year != lastYear || !currentDate.isEqual(lastDate)) {
            counter = 1; // Reset counter if the year changes or the date changes
            lastYear = year;
            lastDate = currentDate;
        } else {
            if (counter >= MAX_COUNTER) {
                // Handle counter reaching its maximum value
                throw new RuntimeException("Counter has reached its maximum value for the day.");
            }
            counter++;
        }

        return String.format(BASE_FORMAT, year, currentDate.getMonthValue(),
                currentDate.getDayOfMonth(), counter);
    }

    public static void main(String[] args) {
        System.out.println(generateID());
        System.out.println(generateID());
        System.out.println(generateID());
        // Output depends on when you run the program and will change on new year's day
    }
}
