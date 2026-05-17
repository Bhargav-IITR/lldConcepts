package org.example.factoryDesignPattern.NotificationCreator;
import org.example.factoryDesignPattern.notification.EmailNotification;
import org.example.factoryDesignPattern.notification.Notification;

public class EmailNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification(){
        return new EmailNotification();
    }
}
