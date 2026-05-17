package org.example.factoryDesignPattern.NotificationCreator;

import org.example.factoryDesignPattern.notification.Notification;
import org.example.factoryDesignPattern.notification.PushNotification;

public class PushNotificationCreator extends NotificationCreator{
    @Override
    public Notification createNotification(){
        return new PushNotification();
    }
}
