package Problems.Logger;

public enum LogLevel {
    // priority level - > DEBUG < INFO < ERROR
    DEBUG(1),
    INFO(2),
    ERROR(3);

    private final int level;
    // constructor should either be private or package private
    LogLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return this.level;
    }
}
