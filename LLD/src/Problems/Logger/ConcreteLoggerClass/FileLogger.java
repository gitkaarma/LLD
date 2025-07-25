package Problems.Logger.ConcreteLoggerClass;

import Problems.Logger.LogLevel;
import Problems.Logger.Logger;

public class FileLogger extends Logger {

    public FileLogger(LogLevel logLevel){
        this.level = logLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("FILE LOGGER: " + message);
    }
}
