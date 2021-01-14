  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifikationservice;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *This class implements the interface "Runnable" in order to get multithreading funktionality. 
 * It contains the code which should be executed in a parallel thread.
 */
public class NotifikationService implements Runnable
{
    /**
     * If set to false code execution stops.
     */
    protected static boolean exit = true;
    /**
     * Contains the Date information of the last minute.
     */
    private static Date last;
    
    /**
     * The constructor initiates the class veriables.
     * exit has to be true in order to run the code.
     * last has to contain the date information of one minute befor the programm start.
     */
    NotifikationService()
    {
        exit = true;
        last = Email.getNow();
        last.setMinutes(last.getMinutes()-1);
    }
   /**
    * This methode executes the code which runs in a parallel thread.
    * It checks the current time and compares it to the time of the
    * scheduled notification.
    * If the current time equals the time of an notification,
    * an email with the notification text is send to the 
    * corresponding email address(es).
    */
    @Override public void run()
    {
        while(exit)
        {
            Date now = Email.getNow();
            if(now.compareTo(last)>0)
            {
                Notification[] all = Datenbank.loadNotification();
                Email.compareAndSend(all, now);
                last = now;
                
            }
        }
    }
}
