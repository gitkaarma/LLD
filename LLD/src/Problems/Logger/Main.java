package Problems.Logger;

public class Main {

    public static void main(String[] args) {
        // Get the logger chain from the manager.
        Logger loggerChain = LogManager.buildChain(); // Return the head of the chain i.e. the console logger

        /**
         * Now from here I just have to call loggerChain.logMessage(---, ---);
         */

        System.out.println("\n--- Logging a DEBUG message ---");
        // Handled only by CONSOLE LOGGER
        loggerChain.logMessage(LogLevel.DEBUG, "This is a debug message.");

        System.out.println("--- Logging an INFO message ---");
        // Handled by ConsoleLogger (INFO), FileLogger (DEBUG), but not DBLogger (ERROR)
        loggerChain.logMessage(LogLevel.INFO, "This is an informational message.");

        System.out.println("\n--- Logging an ERROR message ---");
        // Handled by all loggers: Console, File, and DB
        loggerChain.logMessage(LogLevel.ERROR, "This is an error message.");

    }
}
