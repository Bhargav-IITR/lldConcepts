package org.example.factoryDesignPattern.NotificationCreator;

import org.example.factoryDesignPattern.notification.Notification;
import org.example.factoryDesignPattern.notification.SMSNotification;

public class SMSNotificationCreator extends NotificationCreator{
    @Override
    public Notification createNotification(){
        return new SMSNotification();
    }
}
