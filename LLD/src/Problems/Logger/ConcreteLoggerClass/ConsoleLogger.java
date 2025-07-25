package Problems.Logger.ConcreteLoggerClass;

import Problems.Logger.LogLevel;
import Problems.Logger.Logger;

public class ConsoleLogger extends Logger {
    public ConsoleLogger(LogLevel logLevel){
        this.level = logLevel;
    }
    @Override
    protected void write(String message) {
        System.out.println("CONSOLE LOGGER: " + message);
    }
}
