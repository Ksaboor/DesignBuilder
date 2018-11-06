package io.zipcoder.zcw_licensebuilder.utils;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


/**
 * @author
 */ // TODO - Replace with mocking framework like Mockito
public final class MockDataGenerator {
    private MockDataGenerator() {
    }

    private static volatile Random random = new Random();

    /**
     * @return true with the likelihood of specified percentage
     */
    public static boolean createBoolean(float likelihood) {
        return likelihood > createFloat(0, 100);
    }

    /**
     * @return a random character between the specified minimum and maximum character range
     */
    public static Character createCharacter(char min, char max) {
        return (char) createInteger((int) min, (int) max).intValue();
    }

    /**
     * @return a random double between the specified minimum and maximum numeric range
     */
    public static Double createDouble(Double min, Double max) {
        return createFloat(min.floatValue(), max.floatValue()).doubleValue();
    }

    /**
     * @return a random float between the specified minimum and maximum numeric range
     */
    public static synchronized Float createFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    /**
     * @return a random integer between the specified minimum and maximum numeric range
     */
    public static Integer createInteger(Integer min, Integer max) {
        return createFloat(min, max).intValue();
    }

    /**
     * @return a random long between the specified minimum and maximum numeric range
     */
    public static Long createLong(Long min, Long max) {
        return createFloat(min, max).longValue();
    }

    /**
     * @return a random string of the specified length containing characters in the specified range
     */
    public static String createString(char min, char max, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(createCharacter(min, max));
        }
        return sb.toString();
    }


    public static Date createMonthDayYear(int minYear, int maxYear) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, createInteger(minYear, maxYear));
        gc.set(Calendar.DAY_OF_YEAR, createInteger(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR)));
        String date = "%s-%s-%s";
        String year = "" + gc.get(Calendar.YEAR);
        String month = "" + (gc.get(Calendar.MONTH) + 1);
        String day = "" + gc.get(Calendar.DAY_OF_MONTH);

        month = month.length() < 2 ? "0" + month : month;
        day = day.length() < 2 ? "0" + day : day;

        return Date.valueOf(String.format(date, year, month, day));
    }

    /**
     * @return a random element from the specified array
     */
    public static <E> E selectElement(E[] array) {
        return array[createInteger(0, array.length - 1)];
    }

}
