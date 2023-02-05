package utils;

import java.util.logging.Logger;

/**
 * Class provide some utils for get today, get md5, ...
 *
 * @author Group 3
 */

public class Utils {

    public static Logger getLogger(String className) {
        return Logger.getLogger(className);
    }

    public static String formatTime(int seconds) {
        int hour = seconds / 3600;
        int minute = (seconds - hour * 3600) / 60;
        int second = seconds - hour * 3600 - minute * 60;
        return hour + "h " + minute + "m " + second + "s";
    }

}
