 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifikationservice;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *This class provieds funktionality to send emails and/or send time scheduled emails.
 * 
 */
public class Email 
{   
    /**
     * Contains the email address from the sender email account.
     * Will be loaded from the database
     */
    private String senderAddress;
    /**
     * Contains the password from the sender email account.
     * Will be loaded from the database
     */
    private String password;
    /**
     * Contains the host address from the email service provider.
     * Will be loaded from the database
     */
    private String host;
    /**
     * Contains the port used to send the email to the service provider.
     * Will be loaded from the database
     */
    private String port;
    /**
     * Contains the subject text for the email.
     */
    private String subject;
    /**
     * Contains the text for the email.
     */
    private String emailText;
    /**
     * Contains the email address of the receiver of the email.
     */
    private String receiverAdresse;
    
    /**
     * Contains the email addresses from the CC receivers.
     * This has to contain 1 or more email addresses seperated by commas or the string "none".
     */
    private String memberAdresses;
    
    /**
     * Constructor takes email login data from database.
     */
    Email()
    {
        this.senderAddress = Datenbank.AddressSender;
        this.password = Datenbank.Password;
        this.host = Datenbank.Host;
        this.port = Datenbank.Port;
    }
    
    /**
     * This allows to create an email object by giving the following attributes. 
     * 
     * @param senderAddress
     * @param password
     * @param host
     * @param port
     * @param subject
     * @param emailText
     * @param receiverAdresse
     * @param memberAdresses 
     */
    Email(String subject, String emailText, String receiverAdresse, String memberAdresses)
    {
        this.senderAddress = Datenbank.AddressSender;
        this.password = Datenbank.Password;
        this.host = Datenbank.Host;
        this.port = Datenbank.Port;
        this.subject = subject;
        this.emailText = emailText;
        this.receiverAdresse = receiverAdresse;
        this.memberAdresses = memberAdresses;
    }
    
    /**
     * This is used to change the "senderAddress" attribute.
     * @param senderAddress 
     */
    public void setSenderAddress(String senderAddress)
    {
        this.senderAddress = senderAddress;
    }
    /**
     * This returns the value of the "senderAddress" attribute.
     * @return 
     */
    public String getSenderAddress()
    {
        return senderAddress;
    }
    /**
     * This is used to change the "password" attribute.
     * @param password 
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * This returns the value of the "password" attribute.
     * @return 
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * This is used to change the "host" attribute.
     * @param host 
     */
    public void setHost(String host)
    {
        this.host = host;
    }
    /**
     * This returns the value of the "host" attribute.
     * @return 
     */
    public String getHost()
    {
        return host;
    }
    /**
     * This is used to change the "port" attribute.
     * @param port 
     */
    public void setPort(String port)
    {
        this.port = port;
    }
    /**
     * This returns the value of the "port" attribute.
     * @return 
     */
    public String getPort()
    {
        return port;
    }
    /**
     * This is used to change the "subject" attribute.
     * @param subject 
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    /**
     * This returns the value of the "subject" attribute.
     * @return 
     */
    public String getSubject()
    {
        return subject;
    }
    /**
     * This is used to change the "emailText" attribute.
     * @param emailText 
     */
    public void setEmailText(String emailText)
    {
        this.emailText = emailText;
    }
    /**
     * This returns the value of the "emailText" attribute.
     * @return 
     */
    public String getEmailText()
    {
        return emailText;
    }
    /**
     * This is used to change the "receiverAdresse" attribute.
     * @param receiverAdresse 
     */
    public void setReceiverAdresse(String receiverAdresse)
    {
        this.receiverAdresse = receiverAdresse;
    }
    /**
     * This returns the value of the "receiverAdresse" attribute.
     * @return 
     */
    public String getReceiverAdresse()
    {
        return receiverAdresse;
    }
    /**
     * This is used to change the "memberAdresses" attribute.
     * @param memberAdresses 
     */
    public void setMemberAdresses(String memberAdresses)
    {
        this.memberAdresses = memberAdresses;
    }
    /**
     * This returns the value of the "memberAdresses" attribute.
     * @return 
     */
    public String getMemberAdresses()
    {
        return memberAdresses;
    }
    
    
    protected Session aktiveSession;
    /**
     * This method is used to login to an email account in order to send emails.
     * The login data is provided to this method by the calling email object.
     */
    public void login()
    {
        Properties props = new Properties();
        props.put("mail.smtp.host", this.getHost());
        props.put("mail.smtp.socketFactory.port", this.getPort());
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", this.getPort());
        
        Authenticator login = new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderAddress, password);
            }
        };
        this.aktiveSession = Session.getDefaultInstance(props, login);
        System.out.println("Eingeloggt.");
    }
    
    /**
     * This method is used to send an email. The needed data to send 
     * the email is provided by the calling email object.
     * @throws MessagingException
     * @throws UnsupportedEncodingException 
     */
    public void sendMail() throws MessagingException, UnsupportedEncodingException
    {
        MimeMessage email = new MimeMessage(aktiveSession);
        email.addHeader("Content-type", "text/HTML; charset=UTF-8");
        email.addHeader("format", "flowed");
        email.addHeader("Content-Transfer-Encoding", "8bit");
        
        email.setFrom(new InternetAddress(this.getSenderAddress(), "onTime"));
        email.setReplyTo(InternetAddress.parse(this.getSenderAddress(), false));
        email.setSubject(this.getSubject(), "UTF-8");
        email.setText(this.getEmailText(), "UTF-8");
        email.setSentDate(new Date());
        
        email.setRecipients(Message.RecipientType.TO, this.getReceiverAdresse());
        if(!this.getMemberAdresses().equals("none"))
        {
            email.setRecipients(Message.RecipientType.CC, this.getMemberAdresses());
        }
        
        System.out.println("Versende E-Mail...");
        Transport.send(email);
        System.out.println("E-Mail versendet.");
    }
    
    /**
     * Returns a date object containing the current date and time. 
     * The precision of the date object is reduced to only be precise to the minute. 
     * Secounds an microseconds are allways stored as zero. 
     * @return 
     */
    public static Date getNow()
    {
        Date temp = new Date();
        Date now = new Date(temp.getYear(), temp.getMonth(), temp.getDate(), temp.getHours(), temp.getMinutes());
        return now;
    }
    
    /**
     * Creates an email subject string from an given notification object and returns it.
     * @param notification
     * @return 
     */
    public static String createSubject(Notification notification)
    {
        String subject;
        switch(notification.getDelay())
        {
            case 1:
            {
                subject = "You're appointment \"" +  notification.getEventName() + "\" is in one week";
                break;
            }
            case 2:
            {
                subject = "You're appointment \"" +  notification.getEventName() + "\" is in tree days";
                break;
            }
            case 3:
            {
                subject = "You're appointment \"" +  notification.getEventName() + "\" is in one hour";
                break;
            }
            case 4:
            {
                subject = "You're appointment \"" +  notification.getEventName() + "\" is in ten minutes";
                break;
            }
            default:
            {
                subject = "You're appointment \"" +  notification.getEventName() + "\" is now";
                break;
            }
        }
        return subject;
    }
    
    /**
     * Creates an email text string from an given notification object and returns it.
     * @param notification
     * @return 
     */
    public static String createText(Notification notification)
    {
        String address = "";
        for(int i = 0;i<notification.getEventAddress().length;i++)
        {
            address = address + notification.getEventAddress()[i] + "\n";
        }
        String members = notification.getUsername() + "\n";
        for(int i = 0;i<notification.getEventMembers().length;i++)
        {
            members = members + notification.getEventMembers()[i] + "\n";
        }
        String priority;
        switch(notification.getPriority())
        {
            case 1:
            {
                priority = "Low\n";
                break;
            }
            case 2:
            {
                priority = "Medium\n";
                break;
            }
            case 3:
            {
                priority = "High\n";
                break;
            }
            default:
            {
                priority = "none\n";
                break;
            }
        }
        String delay;
        switch(notification.getDelay())
        {
            case 1:
            {
                delay = " is in one week.\n";
                break;
            }
            case 2:
            {
                delay = " is in tree days.\n";
                break;
            }
            case 3:
            {
                delay = " is in one hour.\n";
                break;
            }
            case 4:
            {
               delay = " is in ten minutes.\n";
                break;
            }
            default:
            {
                delay = " is now.\n";
                break;
            }
        }
        String text = "Dear User,\nYou're appointment \"" + notification.getEventName() + "\"" + delay + "See details below:\n\n"
                + "The appointment beginns at:\n" + notification.getEventDateStart().toString() 
                + "\n\nThe appointmemt ends at:\n" + notification.getEventDateEnd().toString() 
                + "\n\nThe appointment takes place at:\n"+ address 
                + "\nParticipants of the appointment are:\n"+ members
                + "\nThe priority of the Appointment is:\n" + priority
                + "\n\nKind regards\nYou're onTime Team\n";
        return text;
    }

    /**
     * Compares the dates in the notification objekt array to the the date in "now", 
     * which its receives upon funktion call.
     * If they equal, an email is created from the notification object. Then this email gets send.
     * The reqired data will be provieded by the notification object and the database.
     * @param notifications
     * @param now 
     */
    public static void compareAndSend(Notification[] notifications, Date now)
    {
        for(int i = 0;i<notifications.length;i++)
        {
            if(notifications[i].getSendDate().equals(now))
            {
                Email mail = new Email(createSubject(notifications[i]), createText(notifications[i]), notifications[i].getReceiverAddresse(), notifications[i].getMemberAdresses());
                mail.login();
                try 
                {
                    mail.sendMail();
                } 
                catch (MessagingException ex) 
                {
                    Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (UnsupportedEncodingException ex) 
                {
                    Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Now = " + new Date());
                System.out.println("-----------------------------------------\n");
                System.out.println(mail.getSubject()+"\n\n\n"+mail.getEmailText());
                System.out.println("-----------------------------------------\n");
            }
        }
    }
    /**
     * Creates an email containing an welcome text for a specific user and sends it to the given email address.
     * @param username
     * @param userAddress 
     */
    public static void sendWelcome(String username, String userAddress)
    {
        String subject = "Welcome " + username + " to onTime.";
        String text = "Dear " + username + ",\n" 
                +"you're account has been registered.\n"
                +"\n\n You're onTime Team";
        Email mail = new Email(subject, text, userAddress, "none");
        mail.login();
        try 
        {
            mail.sendMail();
        } 
        catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This sends an email which informs about the change of an event. 
     * The email contains all details given by the notification about the event.
     * @param notification 
     */
    public static void sendEventEdit(Notification notification)
    {
        String subject = "You're appointment \"" + notification.getEventName() + "\" has changed.";
        String address = "";
        for(int i = 0;i<notification.getEventAddress().length;i++)
        {
            address = address + notification.getEventAddress()[i] + "\n";
        }
        String members = notification.getUsername() + "\n";
        for(int i = 0;i<notification.getEventMembers().length;i++)
        {
            members = members + notification.getEventMembers()[i] + "\n";
        }
        String priority;
        switch(notification.getPriority())
        {
            case 1:
            {
                priority = "Low\n";
                break;
            }
            case 2:
            {
                priority = "Medium\n";
                break;
            }
            case 3:
            {
                priority = "High\n";
                break;
            }
            default:
            {
                priority = "none\n";
                break;
            }
        }
        String text = "Dear User,\nYou're appointment \"" + notification.getEventName() + "\"" + " has changed.\nSee details below:\n\n"
                + "The appointment beginns at:\n" + notification.getEventDateStart().toString() 
                + "\n\nThe appointmemt ends at:\n" + notification.getEventDateEnd().toString() 
                + "\n\nThe appointment takes place at:\n"+ address 
                + "\nParticipants of the appointment are:\n"+ members
                + "\nThe priority of the Appointment is:\n" + priority
                + "\n\nKind regards\nYou're onTime Team\n";
        
        Email mail = new Email(subject, text, notification.getReceiverAddresse(), notification.getMemberAdresses());
        mail.login();
        try 
        {
            mail.sendMail();
        }
        catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
