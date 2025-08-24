package Problems.BookMyShow.observer;

/**
 * Concrete Observer implementation for handling notifications
 */
public class NotificationObserver implements Observer {
    private String observerName;
    
    public NotificationObserver(String observerName) {
        this.observerName = observerName;
    }
    
    @Override
    public void update(String message) {
        System.out.println("📢 [" + observerName + "] Notification: " + message);
    }
}
