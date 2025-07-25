package Problems.Logger;

public abstract class Logger {

    protected LogLevel level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger){
        // Could be a constructor parameter as well in child classes
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogLevel messageLevel, String message){

        // Log if the message's level is more severe or equal to this logger's level.
        // This logic can be anything, decided by the interviewer
        if (messageLevel.getLevel() >= this.level.getLevel()) {
            write(message);
        }
        // Whether the above statement log or not, we will pass the message to next logger in chain
        // Pass the request to the next logger in the chain.
        if (nextLogger != null) {
            nextLogger.logMessage(messageLevel, message);
        }
    }
    // Abstract method to be implemented by concrete logger classes.
    protected abstract void write(String message);
}
