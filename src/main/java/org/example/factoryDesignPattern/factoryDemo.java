package org.example.factoryDesignPattern;

import org.example.factoryDesignPattern.NotificationCreator.EmailNotificationCreator;
import org.example.factoryDesignPattern.NotificationCreator.NotificationCreator;
import org.example.factoryDesignPattern.NotificationCreator.SMSNotificationCreator;

public class factoryDemo {
    public static void main(String [] args){
        System.out.println("======= Factory Method Design Pattern ======");

        NotificationCreator creator;

        creator = new EmailNotificationCreator();
        creator.send("Email notification");
        creator = new SMSNotificationCreator();
        creator.send("SMS notification");
    }
}
