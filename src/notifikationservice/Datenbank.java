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
    /*Diese 4 Attribute müssen so wie sie sind in die Datenbank.
    außerdem muss man sie einzeln laden können 
    für den Constuctor der E-mail Klasse.
    */
    public static String AddressSender = "onTime.notification@gmail.com";
    public static String Password = "2Szz59bGHXBK3Lw";
    public static String Host = "smtp.gmail.com";
    public static String Port = "465";
    
    
    
    /*Diese 2 Attribute sind nur für die ausführung der fake Datenbank Klasse relevant*/
    public static boolean createNew = true;
    public static Notification[] aktive;
    
    
    /*Diese methode simmulert das laden eines notification arrays aus der Datenbank.
    Hier kann man zu test zwecken die empfänger email adressen anpassen.*/
    public static Notification[] loadNotification()
    {
        Notification[] notifications;
        if(createNew)
        {
            Date now = NotifikationService.getNow();
            Date end = NotifikationService.getNow();
            end.setDate(end.getDate()+15);
            
            Date[] dates = new Date[3];
            
            
            /*Hier kann man das sende datum der notification festlegen.
            Satndartmäßig wird das aktuelle datum geladen. Es werden drei notifications erstellt,
            die erste wird sofort versendet, die zweite eine Minute nach programm aufruf, 
            die letzte nach dem programm aufruf.*/
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
            
            /*Hier(Da wo "give-me-cookies@web.de" steht) kann man die emfänger email adresse festlegen. Dies muss für jede notification eintzeln gemacht werden.
            An stelle des Strings "none" können CC adressen angeben werden. Sind es mehrere müssen diese durch ein komma getrennt werden.*/            
            notifications[0] = new Notification("User1", "give-me-cookies@web.de", "none", "Email-Service test 1", members, address,0,dates[0],end,0);
            notifications[1] = new Notification("User2", "give-me-cookies@web.de", "none", "Email-Service test 2", members, address,0,dates[1],end,1);
            notifications[2] = new Notification("User3", "give-me-cookies@web.de", "none", "Email-Service test 3", members, address,0,dates[2],end,2);
            
            
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
