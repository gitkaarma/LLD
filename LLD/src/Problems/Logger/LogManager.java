package Problems.Logger;

import Problems.Logger.ConcreteLoggerClass.*;


public class LogManager {
    public static Logger buildChain() {
        // Build the chain: Console -> File -> Database
        Logger consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
        Logger fileLogger = new FileLogger(LogLevel.INFO);
        Logger dbLogger = new DatabaseLogger(LogLevel.ERROR);

        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(dbLogger);

        return consoleLogger; // Return the head of the chain
    }
}
