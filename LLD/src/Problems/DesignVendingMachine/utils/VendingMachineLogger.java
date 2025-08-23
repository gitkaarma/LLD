package Problems.DesignVendingMachine.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple logging utility for vending machine operations
 */
public class VendingMachineLogger {
    
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static boolean debugEnabled = true;
    
    public static void info(String message) {
        log("INFO", message);
    }
    
    public static void debug(String message) {
        if (debugEnabled) {
            log("DEBUG", message);
        }
    }
    
    public static void error(String message) {
        log("ERROR", message);
    }
    
    public static void warn(String message) {
        log("WARN", message);
    }
    
    private static void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        System.out.println(String.format("[%s] %s - %s", timestamp, level, message));
    }
    
    public static void setDebugEnabled(boolean enabled) {
        debugEnabled = enabled;
    }
}
