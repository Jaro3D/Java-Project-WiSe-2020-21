/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifikationservice;

import java.util.Date;

/**
 *
 * This class is only to summulate an database for testing purposes.
 */
public class Datenbank {
    public static String AddressSender = "onTime.notification@gmail.com";
    public static String Password = "2Szz59bGHXBK3Lw";
    public static String Host = "smtp.gmail.com";
    public static String Port = "465";
    public static String NameSender = "onTime notification";
    public static String subject = "Youre Appointment is now";
    public static String emailText = "You recived an Email on Time\nCongrats";
    public static String AddressReceiver = "marlon.ringel@gmx.de";
    public static boolean createNew = true;
    public static Notification[] aktive;
    
    public static Notification[] loadNotification()
    {
        Notification[] notifications;
        if(createNew)
        {
            Date now = Email.getNow();
            Date end = Email.getNow();
            end.setDate(end.getDate()+15);
            
            Date[] dates = new Date[3];
            dates[0] = new Date(now.getYear(),now.getMonth(),now.getDate(),now.getHours(),now.getMinutes());
            dates[1] = new Date(now.getYear(),now.getMonth(),now.getDate(),now.getHours(),now.getMinutes()+1);
            dates[2] = new Date(now.getYear(),now.getMonth(),now.getDate(),now.getHours(),now.getMinutes()+2);
            
            
            String[] members = new String[0];
            String[] address = new String[4];
            address[0] = "Hauptstraße 23";
            address[1] = "60437";
            address[2] = "Frankfurt am Main";
            address[3] = "Deutschland";
            
            notifications = new Notification[3];
            
            notifications[0] = new Notification("User1", "marlon.ringel@stud.fra-uas.de", "none", "Email-Service test 1", members, address,0,dates[0],end,0);
            notifications[1] = new Notification("User2", "marlon.ringel@stud.fra-uas.de", "none", "Email-Service test 2", members, address,0,dates[1],end,1);
            notifications[2] = new Notification("User3", "marlon.ringel@stud.fra-uas.de", "none", "Email-Service test 3", members, address,0,dates[2],end,2);
            
            
            createNew = false;
            aktive = notifications;
        }
        else
        {
           notifications = aktive;
        }
        return notifications;
    }
}
