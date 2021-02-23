/**
 * Create by Iaroslav Goncharuk, 1302419
 * Java WiSe 2020/21 Project
 * 
 */

package timescheduler;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Frame;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 * 
 * This is the main of the application
 * 
 * @author Jaro
 */
public class scheduler_ui extends javax.swing.JFrame {
    User currentUser;
    User editedUser;
    Event currentEvent;
    String filePath = "";
    int mousePosX;
    int mousePosY;
    int buttonIndex = 0;
    int[] participantIDs = new int[0];
    boolean passNotVisible = false;
    boolean searchActive = false;
    boolean appEdited = false;
    boolean partEdited = false;
    boolean isAdmin = false;
    boolean adminEdit = false;
    
    public scheduler_ui() {
        Thread notifikationService = new Thread(new NotifikationService());
        notifikationService.start();
        initComponents();
        initBasics();
    }
    
    public void initBasics()
    {
        nameInput.setBackground(new java.awt.Color(0,0,0,0));
        emailInput.setBackground(new java.awt.Color(0,0,0,0));
        passwordInput.setBackground(new java.awt.Color(0,0,0,0));
        passwordConfInput.setBackground(new java.awt.Color(0,0,0,0));
        upperPanel.setBackground(new java.awt.Color(0,0,0,0));
        exitButton.setBackground(new java.awt.Color(0,0,0,0));
        caccButton.setBackground(new java.awt.Color(0,0,0,0));
        goBackButton.setBackground(new java.awt.Color(0,0,0,0));
        signupButton.setBackground(new java.awt.Color(0,0,0,0));
        passVisButton.setBackground(new java.awt.Color(0,0,0,0));
        mainTab.setBackground(new java.awt.Color(0,0,0,0));
        mainMenu.setBackground(new java.awt.Color(0,0,0,0));
        homeButton.setBackground(new java.awt.Color(0,0,0,0));
        calenderButton.setBackground(new java.awt.Color(0,0,0,0));
        profilesButton.setBackground(new java.awt.Color(0,0,0,0));
        logoutButton.setBackground(new java.awt.Color(0,0,0,0));
        editButton.setBackground(new java.awt.Color(0,0,0,0));
        saveButton.setBackground(new java.awt.Color(0,0,0,0));
        cancelDataEdit.setBackground(new java.awt.Color(0,0,0,0));
        adminEditButton.setBackground(new java.awt.Color(0,0,0,0));
        usernameEdit.setBackground(new java.awt.Color(0,0,0,0));
        mailEdit.setBackground(new java.awt.Color(0,0,0,0));
        passwordEdit.setBackground(new java.awt.Color(0,0,0,0));
        appAddButton.setBackground(new java.awt.Color(0,0,0,0));
        appEditButton.setBackground(new java.awt.Color(0,0,0,0));
        appRemoveButton.setBackground(new java.awt.Color(0,0,0,0));
        appSaveButton.setBackground(new java.awt.Color(0,0,0,0));
        cancelAppEditButton.setBackground(new java.awt.Color(0,0,0,0));
        passwordInput.setEchoChar((char)0);
        passwordConfInput.setEchoChar((char)0);
        passwordConfInput.setEchoChar((char)0);
        LoginMenu();
        AppEdit();
    }
    
    /**
     * Checks if the addplication is beeing managed
     */
    public void AppEdit()
    {
        if (appEdited) //Appointment editing screen
        {
            appSaveButton.setVisible(true);
            cancelAppEditButton.setVisible(true);
            appAddButton.setVisible(false);
            addLabel.setText("Modify appointment");
            partEditButton.setVisible(true);
            openFileButton.setVisible(true);
            if (partEdited) //Participants list opened
            {
                appPartPanel.setVisible(true);
                appDisplayPanel.setVisible(false);
                addLabel.setText("Edit participants");
            }
            else //Participants list closed
            {
                appPartPanel.setVisible(false);
                appDisplayPanel.setVisible(true);
                addLabel.setText("Modify appointment");
            }
        }
        else // Appointment displaying screen
        {
            partEditButton.setVisible(true);
            appSaveButton.setVisible(false);
            cancelAppEditButton.setVisible(false);
            appAddButton.setVisible(true);
            addLabel.setText("Add new appointment");
            appPartPanel.setVisible(false);
            appDisplayPanel.setVisible(true);
            openFileButton.setVisible(false);
            if (partEdited) //Participants list opened
            {
                appPartPanel.setVisible(true);
                appDisplayPanel.setVisible(false);
                addLabel.setText("Edit participants");
            }
            else //Participants list closed
            {
                appPartPanel.setVisible(false);
                appDisplayPanel.setVisible(true);
                addLabel.setText("Modify appointment");
            }
        }
            
    }
    
    /**
     * Switches background initializes displayed information
     */
    private void CheckButtonIndex()
    {
        switch(buttonIndex) 
        {
        case 0: //Login screen
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG.png")));
            break;
        case 1: //Dashboard
            RecentEvents();
            DataOverviewMenu();
            currentEvent = null;
            mainMenu.setSelectedIndex(0);
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG_Home.png")));
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton_over.png")));
            calenderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton.png")));
            profilesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton.png")));
            break;
        case 2: //Appontment screen
            mainMenu.setSelectedIndex(1);
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG_Calender.png")));
            calenderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton_over.png")));
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton.png")));
            profilesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton.png")));
            LoadEventsToList();
            break;
        case 3: //Contacts and profile screen
            LoadUserDetails();
            currentEvent = null;
            mainMenu.setSelectedIndex(2);
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG_Profiles.png")));
            profilesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton_over.png")));
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton.png")));
            calenderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton.png")));
            friendsList.setModel(UsersToList(Database.loadAllUsers(), false));
            break;
        default:
          // code block
            break;
        }
    }
    
    /**
     * Loading all events from database to a DafaultListModel on the appointment screen
     */
    private void LoadEventsToList()
    {
        int listLength = 0;
        int i = 0;
        String listElement = "";
        Event[] events = {};
        events = GetAllSortedEvents();
        listLength = events.length;
        
        DefaultListModel AppointmentList = new DefaultListModel();
        
        while(i <= (listLength - 1))
        {
            if (events[i].getDate().getDate() < 10) 
            {
                listElement = "0" + events[i].getDate().getDate() + ".";
            }
            else
            {
                listElement = events[i].getDate().getDate() + ".";
            }
            
            if ((events[i].getDate().getMonth() + 1) < 10) 
            {
                listElement = listElement + "0" + (events[i].getDate().getMonth() + 1) + ".";
            }
            else
            {
                listElement = listElement + (events[i].getDate().getMonth() + 1) + ".";
            }
            
            listElement = listElement + (events[i].getDate().getYear() + 1900) + " ";
            
            if (events[i].getDate().getHours() < 10) 
            {
                listElement = listElement + "0" + events[i].getDate().getHours() + ":";
            }
            else
            {
                listElement = listElement + events[i].getDate().getHours() + ":";
            }
            
            if (events[i].getDate().getMinutes() < 10) 
            {
                listElement = listElement + "0" + events[i].getDate().getMinutes() + " ";
            }
            else
            {
                listElement = listElement + events[i].getDate().getMinutes() + " ";
            }
            
            listElement = listElement + events[i].getTitle();
            
            AppointmentList.addElement(listElement);
            i++;
        }
        
        appList.setModel(AppointmentList);
    }
    
    /**
     * Loading all events from database and sorting it
     * @return a sorted event list
     */
    private Event[] GetAllSortedEvents()
    {
        Event[] events = {};
        events = Database.loadUserEvents(currentUser.getId());
        events = Database.sortEvents(events, true);
        
        return events;
    }
    
    /**
     * Converts a user array to a list
     * 
     * @param users Users array you want to  convert
     * @param withSelf With or without the own username
     * @return List model for a list
     */
    private DefaultListModel UsersToList(User[] users, boolean withSelf)
    {
        int listLength = 0;
        int i = 0;
        String listElement = "";
        users = Database.loadAllUsers();
        listLength = users.length;
        
        DefaultListModel UsersList = new DefaultListModel();
        
        while(i <= (listLength - 1))
        {
            listElement = users[i].getUsername();
            
            if (withSelf) 
            {
                UsersList.addElement(listElement);
            }
            else
            {
                if (!currentUser.getUsername().equals(users[i].getUsername())) 
                {
                    UsersList.addElement(listElement);
                }
            }
            
            i++;
        }
        
        return UsersList;
    }
    
    /**
     * Converts ID array to a DafaultListModel
     * @param IDs The IDs you want to convert
     * @return A DafaultListModel for a list.
     */
    private DefaultListModel IDsToList(int[] IDs)
    {
        DefaultListModel UsersList = new DefaultListModel();
        String listElement = "";
        
        for (int i = 0; i < IDs.length; i++) 
        {
            User tempUser = Database.loadUser(IDs[i]);
            listElement = tempUser.getUsername();
            UsersList.addElement(listElement);
        }
        
        return UsersList;
    }
    
    /**
     * Loads the first three recent events on the dashboard
     */
    private void RecentEvents()
    {
        Event[] events = {};
        events = Database.loadUserEvents(currentUser.getId());
        events = Database.sortEvents(events, true);
        int eventLength = events.length;
        
        switch(eventLength)
        {
            case 0:
                HideAllEvents();
                break;
            case 1:
                LoadFirstEvent(events[0]);
                tilePanel_1.setVisible(true);
                tilePanel_2.setVisible(false);
                tilePanel_3.setVisible(false);
                break;
            case 2:
                LoadFirstEvent(events[0]);
                LoadSecondEvent(events[1]);
                tilePanel_1.setVisible(true);
                tilePanel_2.setVisible(true);
                tilePanel_3.setVisible(false);
                break;
            default:
                LoadFirstEvent(events[0]);
                LoadSecondEvent(events[1]);
                LoadThridEvent(events[2]);
                tilePanel_1.setVisible(true);
                tilePanel_2.setVisible(true);
                tilePanel_3.setVisible(true);
                break;
        }
    }
    
    /**
     * Needed for RecentEvents(), hides all events
     */
    private void HideAllEvents()
    {
        tilePanel_1.setVisible(false);
        tilePanel_2.setVisible(false);
        tilePanel_3.setVisible(false);
    }
    
    /**
     * Needed for RecentEvents(), loads first event tile
     * @param event The event you want to load
     */
    private void LoadFirstEvent(Event event)
    {
        tile_1_name.setText(event.getTitle());
        tile_1_duration.setText(TimeConverter(event));
        tile_1_location_street.setText(event.getAddress()[0]);
        tile_1_location_city.setText(event.getAddress()[1]);
        tile_1_participants_amount.setText(String.valueOf(event.getParticipantIDs().length));
        tile_1_date.setText(String.valueOf(event.getDate().getDate()));
        tile_1_month.setText(MonthConverter(event));
        SetPriority(event, tile_1);
    }
    
    /**
     * Needed for RecentEvents(), loads second event tile
     * @param event The event you want to load
     */
    private void LoadSecondEvent(Event event)
    {
        tile_2_name.setText(event.getTitle());
        tile_2_duration.setText(TimeConverter(event));
        tile_2_location_street.setText(event.getAddress()[0]);
        tile_2_location_city.setText(event.getAddress()[1]);
        tile_2_participants_amount.setText(String.valueOf(event.getParticipantIDs().length));
        tile_2_date.setText(String.valueOf(event.getDate().getDate()));
        tile_2_month.setText(MonthConverter(event));
        SetPriority(event, tile_2);
    }
    
    /**
     * Needed for RecentEvents(), loads third event tile
     * @param event The event you want to load
     */
    private void LoadThridEvent(Event event)
    {
        tile_3_name.setText(event.getTitle());
        tile_3_duration.setText(TimeConverter(event));
        tile_3_location_street.setText(event.getAddress()[0]);
        tile_3_location_city.setText(event.getAddress()[1]);
        tile_3_participants_amount.setText(String.valueOf(event.getParticipantIDs().length));
        tile_3_date.setText(String.valueOf(event.getDate().getDate()));
        tile_3_month.setText(MonthConverter(event));
        SetPriority(event, tile_3);
    }
    
    //DISPLAYS FULL EVENT DATA IN EDIT MODE
    /**
     * Displays the selected event in the event input
     */
    private void CurrentEditedEvent()
    {   
        if (appEdited == true) 
        {
            Event[] events = {};
            events = GetAllSortedEvents();
            int index;
            index = appList.getSelectedIndex();
            currentEvent = events[index];

            nameEventInput.setText(currentEvent.getTitle());
            dateEventInput.setDate(LocalDate.of(currentEvent.getDate().getYear() + 1900, 
                                                currentEvent.getDate().getMonth() + 1, 
                                                currentEvent.getDate().getDate()));
            btimeEventInput.setTime(LocalTime.of(currentEvent.getDate().getHours(), 
                                                 currentEvent.getDate().getMinutes()));
            durationEventInput.setText(currentEvent.getDuration());
            cityEventInput.setText(currentEvent.getAddress()[1]);
            streetEventInput.setText(currentEvent.getAddress()[0]);
            notifEventInput.setSelectedIndex(currentEvent.getNotification() - 1);
            priorityEventInput.setSelectedIndex(currentEvent.getPriority() - 1);
            participantIDs = currentEvent.getParticipantIDs();
            partAddContactsList.setModel(IDsToList(participantIDs));
        }
        else
        {
            ClearEventInputData();
        }
    }
    
    /**
     * Clears all event input text
     */
    private void ClearEventInputData()
    {
        nameEventInput.setText("");
        dateEventInput.setText("");
        btimeEventInput.setText("");
        durationEventInput.setText("");
        cityEventInput.setText("");
        streetEventInput.setText("");
        notifEventInput.setSelectedIndex(0);
        priorityEventInput.setSelectedIndex(0);
        currentEvent = null;
        participantIDs = null;
    }
    
    /**
     * Sets the right background for every priority
     * 1 = Low
     * 2 = Medium
     * 3 = High
     * 
     * @param event Gets priority of this event
     * @param label Sets the background of that label
     */
    private void SetPriority(Event event, JLabel label)
    {
        switch(event.getPriority())
        {
            case 1:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/greenTile.png")));
                break;
            case 2:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/orangeTile.png")));
                break;
            case 3:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/redTile.png")));
                break;
        }
    }
    
    /**
     * Converts month data from event to a short version of month
     * 0 = Jan, 1 = Feb ...
     * 
     * @param event Uses that event data
     * @return A string which contains the short month name
     */
    private String MonthConverter(Event event)
    {
        String month = "";
        
        switch(event.getDate().getMonth())
        {
            case 0:
                month = "Jan";
                break;
            case 1:
                month = "Feb";
                break;
            case 2:
                month = "Mar";
                break;
            case 3:
                month = "Apr";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "Jun";
                break;
            case 6:
                month = "Jul";
                break;
            case 7:
                month = "Aug";
                break;
            case 8:
                month = "Sep";
                break;
            case 9:
                month = "Oct";
                break;
            case 10:
                month = "Nov";
                break;
            case 11:
                month = "Dec";
                break;
        }
        
        return month;
    }
    
    /**
     * Converts time data from event to a right time format
     * 00:00
     * 
     * @param event
     * @return 
     */
    private String TimeConverter(Event event)
    {
        String time = "";
        
        if (event.getDate().getHours() < 10) 
        {
            time = "0" + String.valueOf(event.getDate().getHours()) + ":";
        }
        else
        {
            time = String.valueOf(event.getDate().getHours()) + ":";
        }
        
        if (event.getDate().getMinutes() < 10) 
        {
            time += "0" + String.valueOf(event.getDate().getMinutes());
        }
        else
        {
            time += String.valueOf(event.getDate().getMinutes());
        }
        
        return time;
    }
    
    /**
     * Loads user details on profile screen
     */
    private void LoadUserDetails()
    {
        usernameView.setText(currentUser.getUsername());
        maiView.setText(currentUser.getEmail());
    }
    
    /**
     * Loads users data into input to be edited
     */
    private void LoadEditedUserData()
    {
        usernameEdit.setText(editedUser.getUsername());
        mailEdit.setText(editedUser.getEmail());
        passwordEdit.setText(editedUser.getPassword());
    }
    
    /**
     * Shows the user data edit screen, if user is admin, then he has more options
     * Hides the user data display screen
     */
    private void DataEditMenu()
    {
        dataOverview.setVisible(false);
        dataEdit.setVisible(true);
        
        if (!adminEdit) 
        {
            usernameEdit.setText("Edit username");
            mailEdit.setText("Edit E-Mail address");
            passwordEdit.setText("Edit password");
            usernameEdit.setForeground(new Color(204,204,204));
            mailEdit.setForeground(new Color(204,204,204));
            passwordEdit.setForeground(new Color(204,204,204));
        }
    }
    
    /**
     * Shows user data display screen
     * Hides the user data edit screen
     */
    private void DataOverviewMenu()
    {
        dataEdit.setVisible(false);
        dataOverview.setVisible(true);
    }
    
    /**
     * Enables the loginmenu, hides the sign up menu
     */
    private void LoginMenu()
    {
        buttonIndex = 0;
        signupButton.setVisible(true);
        loginButton.setVisible(true);
        caccButton.setVisible(false);
        passwordConfInput.setVisible(false);
        passwordConfUnderline.setVisible(false);
        goBackButton.setVisible(false);
        emailInput.setVisible(false);
        emailUnderline.setVisible(false);
        userIcon.setLocation(590, 280);
        nameInput.setLocation(650, 280);
        nameUnderline.setLocation(640, 320);
        passwordInput.setLocation(650, 360);
        passwordUnderline.setLocation(640, 400);
        nameInput.setText("Username");
        passwordInput.setText("Password");
    }
    
    /**
     * Enables the sign up menu, hides the login menu
     */
    private void SignUpMenu()
    {
        signupButton.setVisible(false);
        loginButton.setVisible(false);
        emailInput.setVisible(true);
        emailUnderline.setVisible(true);
        caccButton.setVisible(true);
        passwordConfInput.setVisible(true);
        passwordConfUnderline.setVisible(true);
        goBackButton.setVisible(true);
        userIcon.setLocation(590, 240);
        nameInput.setLocation(650, 240);
        nameUnderline.setLocation(640, 280);
        passwordInput.setLocation(650, 360);
        passwordUnderline.setLocation(640, 400);
        nameInput.setText("Username");
        emailInput.setText("E-Mail");
        passwordInput.setText("Password");
        passwordConfInput.setText("Confirm Password");
    }
    
    /**
     * Hides the passwort if wanted
     */
    private void CheckVisibility()
    {
        if (passNotVisible) 
        {
            passwordInput.setEchoChar((char)0);
            passwordConfInput.setEchoChar((char)0);
            passVisButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Password_hidden.png")));
            if (passwordInput.getText().equals("Password")) 
            {
                passwordInput.setForeground(new Color(51,51,51));
            }
            else
            {
                passwordInput.setForeground(new Color(0,0,0));
            }
            
            if (passwordConfInput.getText().equals("Confirm Password")) 
            {
                passwordConfInput.setForeground(new Color(51,51,51));
            }
            else
            {
                passwordConfInput.setForeground(new Color(0,0,0));
            }
        }
        else
        {
            if (passwordInput.getText().equals("Password")) 
            {
                passwordInput.setEchoChar((char)0);
                passwordInput.setForeground(new Color(51,51,51));
            }
            else
            {
                passwordInput.setEchoChar('*');
                passwordInput.setForeground(new Color(0,0,0));
            }
            
            if (passwordConfInput.getText().equals("Confirm Password")) 
            {
                passwordConfInput.setEchoChar((char)0);
                passwordConfInput.setForeground(new Color(51,51,51));
            }
            else
            {
                passwordConfInput.setEchoChar('*');
                passwordConfInput.setForeground(new Color(0,0,0));
            }
            passVisButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Password_visible.png")));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        upperPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        minButton = new javax.swing.JButton();
        mainTab = new javax.swing.JTabbedPane();
        loginPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        outputLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        nameUnderline = new javax.swing.JPanel();
        emailInput = new javax.swing.JTextField();
        emailUnderline = new javax.swing.JPanel();
        passwordInput = new javax.swing.JPasswordField();
        passwordUnderline = new javax.swing.JPanel();
        passwordConfInput = new javax.swing.JPasswordField();
        passwordConfUnderline = new javax.swing.JPanel();
        passVisButton = new javax.swing.JButton();
        userIcon = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        signupButton = new javax.swing.JButton();
        caccButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        miniLogo = new javax.swing.JLabel();
        adminLogo = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        calenderButton = new javax.swing.JButton();
        profilesButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        mainMenu = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        upcomingLabels = new javax.swing.JLabel();
        tilePanel_3 = new javax.swing.JPanel();
        tile_3_name = new javax.swing.JLabel();
        tile_3_duration = new javax.swing.JLabel();
        tile_3_location_street = new javax.swing.JLabel();
        tile_3_participants_amount = new javax.swing.JLabel();
        tile_3_participants_label = new javax.swing.JLabel();
        tile_3_location_city = new javax.swing.JLabel();
        tile_3_month = new javax.swing.JLabel();
        tile_3_date = new javax.swing.JLabel();
        tile_3 = new javax.swing.JLabel();
        tilePanel_2 = new javax.swing.JPanel();
        tile_2_name = new javax.swing.JLabel();
        tile_2_duration = new javax.swing.JLabel();
        tile_2_location_street = new javax.swing.JLabel();
        tile_2_participants_amount = new javax.swing.JLabel();
        tile_2_participants_label = new javax.swing.JLabel();
        tile_2_location_city = new javax.swing.JLabel();
        tile_2_month = new javax.swing.JLabel();
        tile_2_date = new javax.swing.JLabel();
        tile_2 = new javax.swing.JLabel();
        tilePanel_1 = new javax.swing.JPanel();
        tile_1_name = new javax.swing.JLabel();
        tile_1_duration = new javax.swing.JLabel();
        tile_1_location_street = new javax.swing.JLabel();
        tile_1_participants_label = new javax.swing.JLabel();
        tile_1_participants_amount = new javax.swing.JLabel();
        tile_1_location_city = new javax.swing.JLabel();
        tile_1_month = new javax.swing.JLabel();
        tile_1_date = new javax.swing.JLabel();
        tile_1 = new javax.swing.JLabel();
        calenderPanel = new javax.swing.JPanel();
        appLabel = new javax.swing.JLabel();
        addLabel = new javax.swing.JLabel();
        listDisplay = new javax.swing.JScrollPane();
        appList = new javax.swing.JList<>();
        appDisplayPanel = new javax.swing.JPanel();
        nameEventLabel = new javax.swing.JLabel();
        nameEventInput = new javax.swing.JTextField();
        dateEventLabel = new javax.swing.JLabel();
        dateEventInput = new com.github.lgooddatepicker.components.DatePicker();
        btimeEventLabel = new javax.swing.JLabel();
        btimeEventInput = new com.github.lgooddatepicker.components.TimePicker();
        durationEventLabel = new javax.swing.JLabel();
        durationEventInput = new javax.swing.JTextField();
        cityEventLabel = new javax.swing.JLabel();
        cityEventInput = new javax.swing.JTextField();
        streetEventLabel = new javax.swing.JLabel();
        streetEventInput = new javax.swing.JTextField();
        priorityEventLabel = new javax.swing.JLabel();
        priorityEventInput = new javax.swing.JComboBox<>();
        nitifEventLabel = new javax.swing.JLabel();
        notifEventInput = new javax.swing.JComboBox<>();
        partEditButton = new javax.swing.JButton();
        attachmentButton = new javax.swing.JButton();
        openFileButton = new javax.swing.JButton();
        appPartPanel = new javax.swing.JPanel();
        yourContLabel = new javax.swing.JLabel();
        partContacts = new javax.swing.JScrollPane();
        partContactsList = new javax.swing.JList<>();
        eventPartLabel = new javax.swing.JLabel();
        partAddContacts = new javax.swing.JScrollPane();
        partAddContactsList = new javax.swing.JList<>();
        partSaveButton = new javax.swing.JButton();
        partAddButton = new javax.swing.JButton();
        appEditButton = new javax.swing.JButton();
        appExportButton = new javax.swing.JButton();
        appRemoveButton = new javax.swing.JButton();
        appSaveButton = new javax.swing.JButton();
        appAddButton = new javax.swing.JButton();
        cancelAppEditButton = new javax.swing.JButton();
        appAppTile = new javax.swing.JLabel();
        appDisplayTile = new javax.swing.JLabel();
        profilesPanel = new javax.swing.JPanel();
        userProfilePanel = new javax.swing.JPanel();
        dataEdit = new javax.swing.JPanel();
        editLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelDataEdit = new javax.swing.JButton();
        usernameEdit = new javax.swing.JTextField();
        usernameUnderline = new javax.swing.JPanel();
        mailEdit = new javax.swing.JTextField();
        mailUnderline = new javax.swing.JPanel();
        passwordEdit = new javax.swing.JTextField();
        passUnderline = new javax.swing.JPanel();
        dataOverview = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        userLogo = new javax.swing.JLabel();
        adminView = new javax.swing.JLabel();
        usernameView = new javax.swing.JLabel();
        maiView = new javax.swing.JLabel();
        userTile = new javax.swing.JLabel();
        friendsPanel = new javax.swing.JPanel();
        friednsLabel = new javax.swing.JLabel();
        friendsView = new javax.swing.JScrollPane();
        friendsList = new javax.swing.JList<>();
        adminEditButton = new javax.swing.JButton();
        friendsTile = new javax.swing.JLabel();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setName("main_frame"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        bgPanel.setMaximumSize(new java.awt.Dimension(1000, 600));
        bgPanel.setMinimumSize(new java.awt.Dimension(1000, 600));
        bgPanel.setLayout(null);

        upperPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                upperPanelMouseDragged(evt);
            }
        });
        upperPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                upperPanelMousePressed(evt);
            }
        });
        upperPanel.setLayout(null);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Button.png"))); // NOI18N
        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setBorder(null);
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setOpaque(false);
        exitButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Button_pressed.png"))); // NOI18N
        exitButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Button_over.png"))); // NOI18N
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        upperPanel.add(exitButton);
        exitButton.setBounds(970, 10, 20, 20);

        minButton.setBackground(new java.awt.Color(255, 255, 255));
        minButton.setForeground(new java.awt.Color(255, 255, 255));
        minButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/MinButton.png"))); // NOI18N
        minButton.setBorder(null);
        minButton.setOpaque(false);
        minButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/MinButton_pressed.png"))); // NOI18N
        minButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/MinButton_over.png"))); // NOI18N
        minButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minButtonMouseExited(evt);
            }
        });
        minButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minButtonActionPerformed(evt);
            }
        });
        upperPanel.add(minButton);
        minButton.setBounds(940, 10, 20, 20);

        bgPanel.add(upperPanel);
        upperPanel.setBounds(0, 0, 1000, 50);

        mainTab.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        loginPanel.setOpaque(false);
        loginPanel.setLayout(null);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Logo.png"))); // NOI18N
        loginPanel.add(logoLabel);
        logoLabel.setBounds(660, 70, 250, 110);

        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputLabel.setText("Welcome!");
        outputLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        outputLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginPanel.add(outputLabel);
        outputLabel.setBounds(640, 170, 300, 40);

        nameInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nameInput.setText("Username");
        nameInput.setBorder(null);
        nameInput.setForeground(new java.awt.Color(51, 51, 51));
        nameInput.setOpaque(false);
        nameInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameInputFocusLost(evt);
            }
        });
        loginPanel.add(nameInput);
        nameInput.setBounds(650, 280, 280, 40);

        nameUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout nameUnderlineLayout = new javax.swing.GroupLayout(nameUnderline);
        nameUnderline.setLayout(nameUnderlineLayout);
        nameUnderlineLayout.setHorizontalGroup(
            nameUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        nameUnderlineLayout.setVerticalGroup(
            nameUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        loginPanel.add(nameUnderline);
        nameUnderline.setBounds(640, 320, 300, 2);

        emailInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        emailInput.setText("E-Mail");
        emailInput.setBorder(null);
        emailInput.setForeground(new java.awt.Color(51, 51, 51));
        emailInput.setOpaque(false);
        emailInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailInputFocusLost(evt);
            }
        });
        loginPanel.add(emailInput);
        emailInput.setBounds(650, 300, 280, 40);

        emailUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout emailUnderlineLayout = new javax.swing.GroupLayout(emailUnderline);
        emailUnderline.setLayout(emailUnderlineLayout);
        emailUnderlineLayout.setHorizontalGroup(
            emailUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        emailUnderlineLayout.setVerticalGroup(
            emailUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        loginPanel.add(emailUnderline);
        emailUnderline.setBounds(640, 340, 300, 2);

        passwordInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        passwordInput.setText("Password");
        passwordInput.setBorder(null);
        passwordInput.setEchoChar('*');
        passwordInput.setForeground(new java.awt.Color(51, 51, 51));
        passwordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordInputFocusLost(evt);
            }
        });
        loginPanel.add(passwordInput);
        passwordInput.setBounds(650, 360, 280, 40);

        passwordUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout passwordUnderlineLayout = new javax.swing.GroupLayout(passwordUnderline);
        passwordUnderline.setLayout(passwordUnderlineLayout);
        passwordUnderlineLayout.setHorizontalGroup(
            passwordUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        passwordUnderlineLayout.setVerticalGroup(
            passwordUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        loginPanel.add(passwordUnderline);
        passwordUnderline.setBounds(640, 400, 300, 2);

        passwordConfInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        passwordConfInput.setText("Confirm Password");
        passwordConfInput.setBorder(null);
        passwordConfInput.setEchoChar('*');
        passwordConfInput.setForeground(new java.awt.Color(51, 51, 51));
        passwordConfInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordConfInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordConfInputFocusLost(evt);
            }
        });
        loginPanel.add(passwordConfInput);
        passwordConfInput.setBounds(650, 420, 280, 40);

        passwordConfUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout passwordConfUnderlineLayout = new javax.swing.GroupLayout(passwordConfUnderline);
        passwordConfUnderline.setLayout(passwordConfUnderlineLayout);
        passwordConfUnderlineLayout.setHorizontalGroup(
            passwordConfUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        passwordConfUnderlineLayout.setVerticalGroup(
            passwordConfUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        loginPanel.add(passwordConfUnderline);
        passwordConfUnderline.setBounds(640, 460, 300, 2);

        passVisButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Password_visible.png"))); // NOI18N
        passVisButton.setBorder(null);
        passVisButton.setOpaque(false);
        passVisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passVisButtonActionPerformed(evt);
            }
        });
        loginPanel.add(passVisButton);
        passVisButton.setBounds(590, 360, 40, 40);

        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/user.png"))); // NOI18N
        loginPanel.add(userIcon);
        userIcon.setBounds(590, 280, 40, 40);

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/LoginButton.png"))); // NOI18N
        loginButton.setBorder(null);
        loginButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        loginButton.setOpaque(false);
        loginButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/LoginButton_pressed.png"))); // NOI18N
        loginButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/LoginButton_over.png"))); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginPanel.add(loginButton);
        loginButton.setBounds(730, 450, 110, 40);

        goBackButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        goBackButton.setForeground(new java.awt.Color(255, 255, 255));
        goBackButton.setText("Go Back");
        goBackButton.setActionCommand("");
        goBackButton.setBorder(null);
        goBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goBackButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goBackButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                goBackButtonMousePressed(evt);
            }
        });
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });
        loginPanel.add(goBackButton);
        goBackButton.setBounds(750, 560, 60, 15);

        signupButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        signupButton.setForeground(new java.awt.Color(255, 255, 255));
        signupButton.setText("Don't have an Account? Sign Up");
        signupButton.setActionCommand("");
        signupButton.setBorder(null);
        signupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signupButtonMousePressed(evt);
            }
        });
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        loginPanel.add(signupButton);
        signupButton.setBounds(690, 520, 190, 15);

        caccButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SignUpButton.png"))); // NOI18N
        caccButton.setBorder(null);
        caccButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        caccButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        caccButton.setOpaque(false);
        caccButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SignUpButton_pressed.png"))); // NOI18N
        caccButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SignUpButton_over.png"))); // NOI18N
        caccButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caccButtonActionPerformed(evt);
            }
        });
        loginPanel.add(caccButton);
        caccButton.setBounds(690, 510, 180, 40);

        mainTab.addTab("", loginPanel);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(null);

        miniLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Logo_small.png"))); // NOI18N
        mainPanel.add(miniLogo);
        miniLogo.setBounds(10, 10, 150, 50);

        adminLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Admin.png"))); // NOI18N
        mainPanel.add(adminLogo);
        adminLogo.setBounds(10, 50, 90, 25);

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton.png"))); // NOI18N
        homeButton.setBorder(null);
        homeButton.setOpaque(false);
        homeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton_pressed.png"))); // NOI18N
        homeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton_over.png"))); // NOI18N
        homeButton.setToolTipText("");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        mainPanel.add(homeButton);
        homeButton.setBounds(30, 100, 73, 70);

        calenderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton.png"))); // NOI18N
        calenderButton.setBorder(null);
        calenderButton.setOpaque(false);
        calenderButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton_pressed.png"))); // NOI18N
        calenderButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton_over.png"))); // NOI18N
        calenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calenderButtonActionPerformed(evt);
            }
        });
        mainPanel.add(calenderButton);
        calenderButton.setBounds(30, 210, 70, 70);

        profilesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton.png"))); // NOI18N
        profilesButton.setBorder(null);
        profilesButton.setOpaque(false);
        profilesButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton_pressed.png"))); // NOI18N
        profilesButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton_over.png"))); // NOI18N
        profilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilesButtonActionPerformed(evt);
            }
        });
        mainPanel.add(profilesButton);
        profilesButton.setBounds(30, 310, 70, 70);

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/LogOutButton.png"))); // NOI18N
        logoutButton.setBorder(null);
        logoutButton.setOpaque(false);
        logoutButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/LogOutButton_over.png"))); // NOI18N
        logoutButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/LogOutButton_over.png"))); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        mainPanel.add(logoutButton);
        logoutButton.setBounds(50, 530, 30, 30);

        mainMenu.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        homePanel.setOpaque(false);
        homePanel.setLayout(null);

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("Welcome back User!");
        homePanel.add(welcomeLabel);
        welcomeLabel.setBounds(110, 60, 290, 40);

        upcomingLabels.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        upcomingLabels.setForeground(new java.awt.Color(255, 255, 255));
        upcomingLabels.setText("Upcomming appointments");
        homePanel.add(upcomingLabels);
        upcomingLabels.setBounds(110, 130, 340, 40);

        tilePanel_3.setOpaque(false);
        tilePanel_3.setLayout(null);

        tile_3_name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tile_3_name.setForeground(new java.awt.Color(255, 255, 255));
        tile_3_name.setText("Appointment 3");
        tilePanel_3.add(tile_3_name);
        tile_3_name.setBounds(20, 20, 160, 20);

        tile_3_duration.setText("10:00 - 12:00");
        tile_3_duration.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_3_duration.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_3.add(tile_3_duration);
        tile_3_duration.setBounds(20, 50, 160, 20);

        tile_3_location_street.setText("Jenaer Strasse 11");
        tile_3_location_street.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_3_location_street.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_3.add(tile_3_location_street);
        tile_3_location_street.setBounds(20, 70, 160, 20);

        tile_3_participants_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_3_participants_amount.setForeground(new java.awt.Color(255, 255, 255));
        tile_3_participants_amount.setText("56");
        tilePanel_3.add(tile_3_participants_amount);
        tile_3_participants_amount.setBounds(100, 110, 50, 20);

        tile_3_participants_label.setText("Participants:");
        tile_3_participants_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_3_participants_label.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_3.add(tile_3_participants_label);
        tile_3_participants_label.setBounds(20, 110, 80, 20);

        tile_3_location_city.setText("Berlin");
        tile_3_location_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_3_location_city.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_3.add(tile_3_location_city);
        tile_3_location_city.setBounds(20, 90, 160, 20);

        tile_3_month.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tile_3_month.setForeground(new java.awt.Color(153, 153, 153));
        tile_3_month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tile_3_month.setText("Oct");
        tilePanel_3.add(tile_3_month);
        tile_3_month.setBounds(40, 202, 50, 20);

        tile_3_date.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tile_3_date.setForeground(new java.awt.Color(153, 153, 153));
        tile_3_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tile_3_date.setText("29");
        tilePanel_3.add(tile_3_date);
        tile_3_date.setBounds(40, 175, 50, 20);

        tile_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/greenTile.png"))); // NOI18N
        tilePanel_3.add(tile_3);
        tile_3.setBounds(0, 0, 200, 235);

        homePanel.add(tilePanel_3);
        tilePanel_3.setBounds(610, 190, 200, 235);

        tilePanel_2.setOpaque(false);
        tilePanel_2.setLayout(null);

        tile_2_name.setText("Appointment 2");
        tile_2_name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tile_2_name.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_2.add(tile_2_name);
        tile_2_name.setBounds(20, 20, 160, 20);

        tile_2_duration.setText("18:30 - 19:00");
        tile_2_duration.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_2_duration.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_2.add(tile_2_duration);
        tile_2_duration.setBounds(20, 50, 160, 20);

        tile_2_location_street.setText("Potsdamer Platz 40");
        tile_2_location_street.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_2_location_street.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_2.add(tile_2_location_street);
        tile_2_location_street.setBounds(20, 70, 160, 20);

        tile_2_participants_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_2_participants_amount.setForeground(new java.awt.Color(255, 255, 255));
        tile_2_participants_amount.setText("7");
        tilePanel_2.add(tile_2_participants_amount);
        tile_2_participants_amount.setBounds(100, 110, 50, 20);

        tile_2_participants_label.setText("Participants:");
        tile_2_participants_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_2_participants_label.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_2.add(tile_2_participants_label);
        tile_2_participants_label.setBounds(20, 110, 80, 20);

        tile_2_location_city.setText("Frankfurt am Main");
        tile_2_location_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_2_location_city.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_2.add(tile_2_location_city);
        tile_2_location_city.setBounds(20, 90, 160, 20);

        tile_2_month.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tile_2_month.setForeground(new java.awt.Color(153, 153, 153));
        tile_2_month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tile_2_month.setText("Oct");
        tilePanel_2.add(tile_2_month);
        tile_2_month.setBounds(40, 202, 50, 20);

        tile_2_date.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tile_2_date.setForeground(new java.awt.Color(153, 153, 153));
        tile_2_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tile_2_date.setText("28");
        tilePanel_2.add(tile_2_date);
        tile_2_date.setBounds(40, 175, 50, 20);

        tile_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/orangeTile.png"))); // NOI18N
        tilePanel_2.add(tile_2);
        tile_2.setBounds(0, 0, 200, 235);

        homePanel.add(tilePanel_2);
        tilePanel_2.setBounds(360, 190, 200, 235);

        tilePanel_1.setOpaque(false);
        tilePanel_1.setLayout(null);

        tile_1_name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tile_1_name.setForeground(new java.awt.Color(255, 255, 255));
        tile_1_name.setText("Appointment 1");
        tilePanel_1.add(tile_1_name);
        tile_1_name.setBounds(20, 20, 160, 20);

        tile_1_duration.setText("13:00 - 14:00");
        tile_1_duration.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_1_duration.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_1.add(tile_1_duration);
        tile_1_duration.setBounds(20, 50, 160, 20);

        tile_1_location_street.setText("Kurfürstendamm 51");
        tile_1_location_street.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_1_location_street.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_1.add(tile_1_location_street);
        tile_1_location_street.setBounds(20, 70, 160, 20);

        tile_1_participants_label.setText("Participants:");
        tile_1_participants_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_1_participants_label.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_1.add(tile_1_participants_label);
        tile_1_participants_label.setBounds(20, 110, 80, 20);

        tile_1_participants_amount.setText("3");
        tile_1_participants_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_1_participants_amount.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_1.add(tile_1_participants_amount);
        tile_1_participants_amount.setBounds(100, 110, 50, 20);

        tile_1_location_city.setText("Frankfurt am Main");
        tile_1_location_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_1_location_city.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_1.add(tile_1_location_city);
        tile_1_location_city.setBounds(20, 90, 160, 20);

        tile_1_month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tile_1_month.setText("Oct");
        tile_1_month.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tile_1_month.setForeground(new java.awt.Color(153, 153, 153));
        tilePanel_1.add(tile_1_month);
        tile_1_month.setBounds(40, 202, 50, 20);

        tile_1_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tile_1_date.setText("28");
        tile_1_date.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tile_1_date.setForeground(new java.awt.Color(153, 153, 153));
        tilePanel_1.add(tile_1_date);
        tile_1_date.setBounds(40, 175, 50, 20);

        tile_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/redTile.png"))); // NOI18N
        tilePanel_1.add(tile_1);
        tile_1.setBounds(0, 0, 200, 235);

        homePanel.add(tilePanel_1);
        tilePanel_1.setBounds(110, 190, 200, 235);

        mainMenu.addTab("", homePanel);

        calenderPanel.setBackground(new java.awt.Color(163, 64, 76));
        calenderPanel.setOpaque(false);
        calenderPanel.setLayout(null);

        appLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        appLabel.setForeground(new java.awt.Color(255, 255, 255));
        appLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appLabel.setText("Your appointments");
        calenderPanel.add(appLabel);
        appLabel.setBounds(190, 30, 180, 40);

        addLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addLabel.setText("Add new appointment");
        addLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addLabel.setForeground(new java.awt.Color(255, 255, 255));
        calenderPanel.add(addLabel);
        addLabel.setBounds(500, 20, 260, 30);

        listDisplay.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        listDisplay.setBackground(new java.awt.Color(251, 101, 120));
        listDisplay.setBorder(null);
        listDisplay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listDisplay.setForeground(new java.awt.Color(163, 64, 76));

        appList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "28.12.2020 12:30 Java Lecture", "29.12.2020 08:15 SWE Lecture", "29.12.2020 17:45 Database Lecture", "30.12.2020 13:15 Statistic Lacture", "01.01.2021 00:00 New Year", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        appList.setBackground(new java.awt.Color(224, 92, 109));
        appList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appList.setForeground(new java.awt.Color(255, 255, 255));
        appList.setSelectionBackground(new java.awt.Color(209, 80, 97));
        appList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                appListValueChanged(evt);
            }
        });
        listDisplay.setViewportView(appList);

        calenderPanel.add(listDisplay);
        listDisplay.setBounds(150, 80, 270, 290);

        appDisplayPanel.setOpaque(false);
        appDisplayPanel.setLayout(null);

        nameEventLabel.setText("Name");
        nameEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        appDisplayPanel.add(nameEventLabel);
        nameEventLabel.setBounds(0, 0, 235, 20);

        nameEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(nameEventInput);
        nameEventInput.setBounds(0, 20, 235, 30);

        dateEventLabel.setText("Date");
        dateEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        appDisplayPanel.add(dateEventLabel);
        dateEventLabel.setBounds(0, 50, 120, 20);

        dateEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(dateEventInput);
        dateEventInput.setBounds(0, 70, 230, 30);

        btimeEventLabel.setText("Start time");
        btimeEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btimeEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        appDisplayPanel.add(btimeEventLabel);
        btimeEventLabel.setBounds(0, 100, 95, 20);

        btimeEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(btimeEventInput);
        btimeEventInput.setBounds(0, 120, 110, 30);

        durationEventLabel.setText("Duration");
        durationEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        durationEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        appDisplayPanel.add(durationEventLabel);
        durationEventLabel.setBounds(120, 100, 95, 20);

        durationEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(durationEventInput);
        durationEventInput.setBounds(120, 120, 115, 30);

        cityEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cityEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        cityEventLabel.setText("City");
        appDisplayPanel.add(cityEventLabel);
        cityEventLabel.setBounds(0, 152, 235, 17);

        cityEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(cityEventInput);
        cityEventInput.setBounds(0, 170, 235, 30);

        streetEventLabel.setText("Street");
        streetEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        streetEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        appDisplayPanel.add(streetEventLabel);
        streetEventLabel.setBounds(0, 203, 235, 17);

        streetEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(streetEventInput);
        streetEventInput.setBounds(0, 220, 235, 30);

        priorityEventLabel.setText("Priority");
        priorityEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        priorityEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        appDisplayPanel.add(priorityEventLabel);
        priorityEventLabel.setBounds(155, 253, 80, 17);

        priorityEventInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High" }));
        priorityEventInput.setBackground(new java.awt.Color(204, 0, 0));
        priorityEventInput.setBorder(null);
        priorityEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(priorityEventInput);
        priorityEventInput.setBounds(155, 270, 80, 30);

        nitifEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nitifEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        nitifEventLabel.setText("Notification");
        appDisplayPanel.add(nitifEventLabel);
        nitifEventLabel.setBounds(0, 253, 80, 17);

        notifEventInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 week", "3 days", "1 hour", "10 minutes" }));
        notifEventInput.setBackground(new java.awt.Color(204, 0, 0));
        notifEventInput.setBorder(null);
        notifEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(notifEventInput);
        notifEventInput.setBounds(0, 270, 110, 30);

        partEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartButton.png"))); // NOI18N
        partEditButton.setBorder(null);
        partEditButton.setOpaque(false);
        partEditButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartButton_pressed.png"))); // NOI18N
        partEditButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartButton_over.png"))); // NOI18N
        partEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partEditButtonActionPerformed(evt);
            }
        });
        appDisplayPanel.add(partEditButton);
        partEditButton.setBounds(0, 315, 145, 30);

        attachmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Attachment.png"))); // NOI18N
        attachmentButton.setBorder(null);
        attachmentButton.setOpaque(false);
        attachmentButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Attachment_pressed.png"))); // NOI18N
        attachmentButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Attachment_over.png"))); // NOI18N
        attachmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachmentButtonActionPerformed(evt);
            }
        });
        appDisplayPanel.add(attachmentButton);
        attachmentButton.setBounds(205, 315, 30, 30);

        openFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OpenFile.png"))); // NOI18N
        openFileButton.setBorder(null);
        openFileButton.setOpaque(false);
        openFileButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OpenFile_pressed.png"))); // NOI18N
        openFileButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OpenFile_over.png"))); // NOI18N
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });
        appDisplayPanel.add(openFileButton);
        openFileButton.setBounds(165, 315, 30, 30);

        calenderPanel.add(appDisplayPanel);
        appDisplayPanel.setBounds(510, 50, 235, 350);

        appPartPanel.setOpaque(false);
        appPartPanel.setLayout(null);

        yourContLabel.setText("Your contacts:");
        yourContLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yourContLabel.setForeground(new java.awt.Color(255, 255, 255));
        appPartPanel.add(yourContLabel);
        yourContLabel.setBounds(0, 0, 240, 20);

        partContactsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Aidan Alcock", "Maddie Koch", "Ayman Jenkins", "Keir Livingston", "Beck Whitney", "Mathias Vance" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        partContactsList.setBackground(new java.awt.Color(224, 92, 109));
        partContactsList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        partContactsList.setForeground(new java.awt.Color(255, 255, 255));
        partContactsList.setSelectionBackground(new java.awt.Color(209, 80, 97));
        partContacts.setViewportView(partContactsList);

        appPartPanel.add(partContacts);
        partContacts.setBounds(0, 20, 235, 100);

        eventPartLabel.setText("Event participants:");
        eventPartLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eventPartLabel.setForeground(new java.awt.Color(255, 255, 255));
        appPartPanel.add(eventPartLabel);
        eventPartLabel.setBounds(0, 160, 240, 20);

        partAddContactsList.setBackground(new java.awt.Color(224, 92, 109));
        partAddContactsList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        partAddContactsList.setForeground(new java.awt.Color(255, 255, 255));
        partAddContactsList.setSelectionBackground(new java.awt.Color(209, 80, 97));
        partAddContacts.setViewportView(partAddContactsList);

        appPartPanel.add(partAddContacts);
        partAddContacts.setBounds(0, 180, 235, 100);

        partSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartSaveButton.png"))); // NOI18N
        partSaveButton.setBorder(null);
        partSaveButton.setOpaque(false);
        partSaveButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartSaveButton_pressed.png"))); // NOI18N
        partSaveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartSaveButton_over.png"))); // NOI18N
        partSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partSaveButtonActionPerformed(evt);
            }
        });
        appPartPanel.add(partSaveButton);
        partSaveButton.setBounds(80, 290, 70, 30);

        partAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartAddButton.png"))); // NOI18N
        partAddButton.setBorder(null);
        partAddButton.setOpaque(false);
        partAddButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartAddButton_pressed.png"))); // NOI18N
        partAddButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PartAddButton_over.png"))); // NOI18N
        partAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partAddButtonActionPerformed(evt);
            }
        });
        appPartPanel.add(partAddButton);
        partAddButton.setBounds(0, 120, 40, 40);

        calenderPanel.add(appPartPanel);
        appPartPanel.setBounds(510, 70, 235, 330);

        appEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton.png"))); // NOI18N
        appEditButton.setBorder(null);
        appEditButton.setOpaque(false);
        appEditButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton_pressed.png"))); // NOI18N
        appEditButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton_over.png"))); // NOI18N
        appEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appEditButtonActionPerformed(evt);
            }
        });
        calenderPanel.add(appEditButton);
        appEditButton.setBounds(142, 400, 90, 40);

        appExportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ExportButton.png"))); // NOI18N
        appExportButton.setBorder(null);
        appExportButton.setOpaque(false);
        appExportButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ExportButton_pressed.png"))); // NOI18N
        appExportButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ExportButton_over.png"))); // NOI18N
        appExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appExportButtonActionPerformed(evt);
            }
        });
        calenderPanel.add(appExportButton);
        appExportButton.setBounds(240, 400, 90, 40);

        appRemoveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton.png"))); // NOI18N
        appRemoveButton.setBorder(null);
        appRemoveButton.setOpaque(false);
        appRemoveButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton_pressed.png"))); // NOI18N
        appRemoveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton_over.png"))); // NOI18N
        appRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appRemoveButtonActionPerformed(evt);
            }
        });
        calenderPanel.add(appRemoveButton);
        appRemoveButton.setBounds(338, 400, 90, 40);

        appSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SaveButton.png"))); // NOI18N
        appSaveButton.setBorder(null);
        appSaveButton.setOpaque(false);
        appSaveButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SaveButton_pressed.png"))); // NOI18N
        appSaveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SaveButton_over.png"))); // NOI18N
        appSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appSaveButtonActionPerformed(evt);
            }
        });
        calenderPanel.add(appSaveButton);
        appSaveButton.setBounds(630, 410, 90, 40);

        appAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton.png"))); // NOI18N
        appAddButton.setBorder(null);
        appAddButton.setOpaque(false);
        appAddButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton_pressed.png"))); // NOI18N
        appAddButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton_over.png"))); // NOI18N
        appAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appAddButtonActionPerformed(evt);
            }
        });
        calenderPanel.add(appAddButton);
        appAddButton.setBounds(590, 410, 90, 40);

        cancelAppEditButton.setText("Cancel");
        cancelAppEditButton.setBorder(null);
        cancelAppEditButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelAppEditButton.setOpaque(false);
        cancelAppEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelAppEditButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelAppEditButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelAppEditButtonMousePressed(evt);
            }
        });
        cancelAppEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAppEditButtonActionPerformed(evt);
            }
        });
        calenderPanel.add(cancelAppEditButton);
        cancelAppEditButton.setBounds(510, 410, 100, 40);

        appAppTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PanelTile.png"))); // NOI18N
        calenderPanel.add(appAppTile);
        appAppTile.setBounds(117, 0, 340, 480);

        appDisplayTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PanelTile.png"))); // NOI18N
        calenderPanel.add(appDisplayTile);
        appDisplayTile.setBounds(460, 0, 340, 480);

        mainMenu.addTab("", calenderPanel);

        profilesPanel.setOpaque(false);
        profilesPanel.setLayout(null);

        userProfilePanel.setBackground(new java.awt.Color(0, 0, 0));
        userProfilePanel.setOpaque(false);
        userProfilePanel.setLayout(null);

        dataEdit.setOpaque(false);
        dataEdit.setLayout(null);

        editLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editLabel.setText("Edit your profile");
        editLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editLabel.setForeground(new java.awt.Color(255, 255, 255));
        dataEdit.add(editLabel);
        editLabel.setBounds(95, 100, 150, 30);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SaveButton.png"))); // NOI18N
        saveButton.setBorder(null);
        saveButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SaveButton_pressed.png"))); // NOI18N
        saveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SaveButton_over.png"))); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        dataEdit.add(saveButton);
        saveButton.setBounds(135, 370, 90, 40);

        cancelDataEdit.setText("Cancel");
        cancelDataEdit.setBorder(null);
        cancelDataEdit.setForeground(new java.awt.Color(255, 255, 255));
        cancelDataEdit.setOpaque(false);
        cancelDataEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelDataEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelDataEditMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelDataEditMousePressed(evt);
            }
        });
        cancelDataEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDataEditActionPerformed(evt);
            }
        });
        dataEdit.add(cancelDataEdit);
        cancelDataEdit.setBounds(125, 420, 110, 40);

        usernameEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameEdit.setForeground(new java.awt.Color(204, 204, 204));
        usernameEdit.setText("Edit username");
        usernameEdit.setBorder(null);
        usernameEdit.setOpaque(false);
        usernameEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameEditFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameEditFocusLost(evt);
            }
        });
        dataEdit.add(usernameEdit);
        usernameEdit.setBounds(100, 220, 160, 30);

        usernameUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout usernameUnderlineLayout = new javax.swing.GroupLayout(usernameUnderline);
        usernameUnderline.setLayout(usernameUnderlineLayout);
        usernameUnderlineLayout.setHorizontalGroup(
            usernameUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        usernameUnderlineLayout.setVerticalGroup(
            usernameUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        dataEdit.add(usernameUnderline);
        usernameUnderline.setBounds(100, 250, 160, 2);

        mailEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mailEdit.setText("Edit E-Mail address");
        mailEdit.setBorder(null);
        mailEdit.setForeground(new java.awt.Color(204, 204, 204));
        mailEdit.setOpaque(false);
        mailEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mailEditFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mailEditFocusLost(evt);
            }
        });
        dataEdit.add(mailEdit);
        mailEdit.setBounds(100, 260, 160, 30);

        mailUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mailUnderlineLayout = new javax.swing.GroupLayout(mailUnderline);
        mailUnderline.setLayout(mailUnderlineLayout);
        mailUnderlineLayout.setHorizontalGroup(
            mailUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        mailUnderlineLayout.setVerticalGroup(
            mailUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        dataEdit.add(mailUnderline);
        mailUnderline.setBounds(100, 290, 160, 2);

        passwordEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordEdit.setForeground(new java.awt.Color(204, 204, 204));
        passwordEdit.setText("Edit password");
        passwordEdit.setBorder(null);
        passwordEdit.setOpaque(false);
        passwordEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordEditFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordEditFocusLost(evt);
            }
        });
        dataEdit.add(passwordEdit);
        passwordEdit.setBounds(100, 300, 160, 30);

        passUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout passUnderlineLayout = new javax.swing.GroupLayout(passUnderline);
        passUnderline.setLayout(passUnderlineLayout);
        passUnderlineLayout.setHorizontalGroup(
            passUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        passUnderlineLayout.setVerticalGroup(
            passUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        dataEdit.add(passUnderline);
        passUnderline.setBounds(100, 330, 160, 2);

        userProfilePanel.add(dataEdit);
        dataEdit.setBounds(0, 0, 400, 500);

        dataOverview.setOpaque(false);
        dataOverview.setLayout(null);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton.png"))); // NOI18N
        editButton.setBorder(null);
        editButton.setOpaque(false);
        editButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton_pressed.png"))); // NOI18N
        editButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton_over.png"))); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        dataOverview.add(editButton);
        editButton.setBounds(135, 370, 90, 40);

        userLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/User Logo.png"))); // NOI18N
        dataOverview.add(userLogo);
        userLogo.setBounds(115, 60, 130, 128);

        adminView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adminView.setForeground(new java.awt.Color(255, 255, 255));
        adminView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminView.setText("Admin");
        dataOverview.add(adminView);
        adminView.setBounds(50, 200, 260, 30);

        usernameView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameView.setText("Username");
        usernameView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameView.setForeground(new java.awt.Color(255, 255, 255));
        dataOverview.add(usernameView);
        usernameView.setBounds(50, 230, 260, 30);

        maiView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maiView.setText("namesurname@gmail.com");
        maiView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maiView.setForeground(new java.awt.Color(255, 255, 255));
        dataOverview.add(maiView);
        maiView.setBounds(50, 260, 260, 30);

        userProfilePanel.add(dataOverview);
        dataOverview.setBounds(0, 0, 400, 500);

        userTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PanelTile.png"))); // NOI18N
        userProfilePanel.add(userTile);
        userTile.setBounds(10, 0, 340, 480);

        profilesPanel.add(userProfilePanel);
        userProfilePanel.setBounds(450, 0, 410, 530);

        friendsPanel.setOpaque(false);
        friendsPanel.setLayout(null);

        friednsLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        friednsLabel.setText("Available users:");
        friednsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        friednsLabel.setForeground(new java.awt.Color(255, 255, 255));
        friendsPanel.add(friednsLabel);
        friednsLabel.setBounds(160, 30, 240, 30);

        friendsView.setBorder(null);

        friendsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Charis Lundblad", "Mark Peeler", "Melina Monreal", "Herb Deshotel", "Charita Salmon", "Juliann Esch", "Jonah Kampa", "Ta Bachand" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        friendsList.setBackground(new java.awt.Color(224, 92, 109));
        friendsList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friendsList.setForeground(new java.awt.Color(255, 255, 255));
        friendsList.setSelectionBackground(new java.awt.Color(209, 80, 97));
        friendsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                friendsListValueChanged(evt);
            }
        });
        friendsView.setViewportView(friendsList);

        friendsPanel.add(friendsView);
        friendsView.setBounds(155, 70, 150, 280);

        adminEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton.png"))); // NOI18N
        adminEditButton.setBorder(null);
        adminEditButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton_pressed.png"))); // NOI18N
        adminEditButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/EditButton_over.png"))); // NOI18N
        adminEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminEditButtonActionPerformed(evt);
            }
        });
        friendsPanel.add(adminEditButton);
        adminEditButton.setBounds(240, 370, 90, 40);

        friendsTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PanelTile.png"))); // NOI18N
        friendsPanel.add(friendsTile);
        friendsTile.setBounds(117, 0, 340, 480);

        profilesPanel.add(friendsPanel);
        friendsPanel.setBounds(0, 0, 450, 530);

        mainMenu.addTab("", profilesPanel);

        mainPanel.add(mainMenu);
        mainMenu.setBounds(130, 60, 870, 560);

        mainTab.addTab("", mainPanel);

        bgPanel.add(mainTab);
        mainTab.setBounds(0, 0, 1020, 600);

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG.png"))); // NOI18N
        bgPanel.add(bgLabel);
        bgLabel.setBounds(0, 0, 1000, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void caccButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caccButtonActionPerformed
        String password = String.valueOf(passwordInput.getPassword());
        String passwordConf = String.valueOf(passwordConfInput.getPassword());
        
        if (password.equals(passwordConf)) 
        {
            User newUser = new User(nameInput.getText(), emailInput.getText(), password);
            Database.storeNewAccount(newUser);
            LoginMenu();
        }
        else
        {
            outputLabel.setText("Passwords do not match");
        }
    }//GEN-LAST:event_caccButtonActionPerformed

    private void upperPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upperPanelMouseDragged
        int xAxis = evt.getXOnScreen();
        int yAxis = evt.getYOnScreen();
        
        this.setLocation(xAxis - mousePosX, yAxis - mousePosY);
    }//GEN-LAST:event_upperPanelMouseDragged

    private void upperPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upperPanelMousePressed
        mousePosX = evt.getX();
        mousePosY = evt.getY();
    }//GEN-LAST:event_upperPanelMousePressed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        NotifikationService.exit = false;
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered

    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited

    }//GEN-LAST:event_exitButtonMouseExited

    private void nameInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameInputFocusGained
        if (nameInput.getText().equals("Username")) 
        {
            nameInput.setText("");
            nameInput.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_nameInputFocusGained

    private void nameInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameInputFocusLost
        if (nameInput.getText().equals("")) 
        {
            nameInput.setText("Username");
            nameInput.setForeground(new Color(51, 51, 51));
        }
    }//GEN-LAST:event_nameInputFocusLost

    private void passwordInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordInputFocusLost
        if (passwordInput.getText().equals("")) 
        {
            passwordInput.setEchoChar((char)0);
            passwordInput.setText("Password");
            CheckVisibility();
        }
        else
        {
            CheckVisibility();
        }
    }//GEN-LAST:event_passwordInputFocusLost

    private void passwordInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordInputFocusGained
        if (passwordInput.getText().equals("Password")) 
        {
            passwordInput.setText("");
            CheckVisibility();
        }
        else
        {
            CheckVisibility();
        }
    }//GEN-LAST:event_passwordInputFocusGained

    private void passVisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passVisButtonActionPerformed
        passNotVisible = !passNotVisible;
        CheckVisibility();
    }//GEN-LAST:event_passVisButtonActionPerformed

    private void signupButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupButtonMouseEntered
        signupButton.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_signupButtonMouseEntered

    private void signupButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupButtonMouseExited
        signupButton.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_signupButtonMouseExited

    private void signupButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupButtonMousePressed
        signupButton.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_signupButtonMousePressed

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        SignUpMenu();
    }//GEN-LAST:event_signupButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String password = String.valueOf(passwordInput.getPassword());
        if (Database.verifyLogin(nameInput.getText(), password)) 
        {
            System.out.print(nameInput.getText() + " " + password + " verified\n");
            currentUser = Database.loadUser(nameInput.getText());
            
            if (currentUser.getIsAdmin()) 
            {
                isAdmin = true;
            }
            else
            {
                isAdmin = false;
            }
            
            //If user is a Admin
            adminLogo.setVisible(isAdmin);
            adminEditButton.setVisible(isAdmin);
            adminView.setVisible(isAdmin);
            usernameEdit.setVisible(isAdmin);
            usernameUnderline.setVisible(isAdmin);
            passwordEdit.setVisible(isAdmin);
            passUnderline.setVisible(isAdmin);
            
            buttonIndex = 1;
            CheckButtonIndex();
            mainTab.setSelectedIndex(1);
        }
        else
        {
            System.out.print(nameInput.getText() + " " + password + " access denied\n");
            outputLabel.setText("Login failed, please try again.");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordConfInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordConfInputFocusGained
        if (passwordConfInput.getText().equals("Confirm Password")) 
        {
            passwordConfInput.setText("");
            CheckVisibility();
        }
        else
        {
            CheckVisibility();
        }
    }//GEN-LAST:event_passwordConfInputFocusGained

    private void passwordConfInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordConfInputFocusLost
        if (passwordConfInput.getText().equals("")) 
        {
            passwordConfInput.setEchoChar((char)0);
            passwordConfInput.setText("Confirm Password");
            CheckVisibility();
        }
        else
        {
            CheckVisibility();
        }
    }//GEN-LAST:event_passwordConfInputFocusLost

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        buttonIndex = 1;
        CheckButtonIndex();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void calenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calenderButtonActionPerformed
        buttonIndex = 2;
        CheckButtonIndex();
    }//GEN-LAST:event_calenderButtonActionPerformed

    private void profilesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilesButtonActionPerformed
        buttonIndex = 3;
        CheckButtonIndex();
    }//GEN-LAST:event_profilesButtonActionPerformed

    private void minButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_minButtonMouseEntered

    private void minButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_minButtonMouseExited

    private void minButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minButtonActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minButtonActionPerformed

    private void goBackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackButtonMouseEntered
        goBackButton.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_goBackButtonMouseEntered

    private void goBackButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackButtonMouseExited
        goBackButton.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_goBackButtonMouseExited

    private void goBackButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackButtonMousePressed
        goBackButton.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_goBackButtonMousePressed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        LoginMenu();
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        currentUser = null;
        currentEvent = null;
        mainTab.setSelectedIndex(0);
        LoginMenu();
        CheckButtonIndex();
        CheckVisibility();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void cancelDataEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDataEditActionPerformed
        DataOverviewMenu();
    }//GEN-LAST:event_cancelDataEditActionPerformed

    private void cancelDataEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelDataEditMouseEntered
        cancelDataEdit.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_cancelDataEditMouseEntered

    private void cancelDataEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelDataEditMouseExited
        cancelDataEdit.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_cancelDataEditMouseExited

    private void cancelDataEditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelDataEditMousePressed
        cancelDataEdit.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_cancelDataEditMousePressed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (adminEdit) 
        {
            editedUser.setUsername(usernameEdit.getText());
            editedUser.setEmail(mailEdit.getText());
            editedUser.setPassword(passwordEdit.getText());
            Database.updateUser(editedUser);
        }
        else
        {
            if (isAdmin) 
            {
                currentUser.setUsername(usernameEdit.getText());
                currentUser.setPassword(passwordEdit.getText());
            }
            currentUser.setEmail(mailEdit.getText());
            Database.updateUser(currentUser);
        }
        
        friendsList.setModel(UsersToList(Database.loadAllUsers(), true));
        LoadUserDetails();
        DataOverviewMenu();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        adminEdit = false;
        editLabel.setText("Edit your profile");
        DataEditMenu();
    }//GEN-LAST:event_editButtonActionPerformed

    private void mailEditFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailEditFocusGained
        if (mailEdit.getText().equals("Edit E-Mail address")) 
        {
            mailEdit.setText("");
            mailEdit.setForeground(new Color(255,255,255));
        }
    }//GEN-LAST:event_mailEditFocusGained

    private void mailEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailEditFocusLost
        if (mailEdit.getText().equals("")) 
        {
            mailEdit.setText("Edit E-Mail address");
            mailEdit.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_mailEditFocusLost

    private void cancelAppEditButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelAppEditButtonMouseEntered
        cancelAppEditButton.setForeground(new Color(204, 204, 204));  
    }//GEN-LAST:event_cancelAppEditButtonMouseEntered

    private void cancelAppEditButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelAppEditButtonMouseExited
        cancelAppEditButton.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_cancelAppEditButtonMouseExited

    private void cancelAppEditButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelAppEditButtonMousePressed
        cancelAppEditButton.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_cancelAppEditButtonMousePressed

    private void cancelAppEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAppEditButtonActionPerformed
        appEdited = false;
        partEdited = false;
        AppEdit();
        ClearEventInputData();
        participantIDs = null;
        filePath = "";
    }//GEN-LAST:event_cancelAppEditButtonActionPerformed

    private void appEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appEditButtonActionPerformed
        if (appList.getSelectedIndex() != -1) 
        {
            appEdited = true;
            partEdited = false;
            AppEdit();
            CurrentEditedEvent();
            filePath = "";
        }
    }//GEN-LAST:event_appEditButtonActionPerformed

    private void appSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appSaveButtonActionPerformed
        String[] address = {"", ""};
        address[0] = streetEventInput.getText();
        address[1] = cityEventInput.getText();
        String[] date = dateEventInput.getDate().toString().split("-");
        String[] time = btimeEventInput.getTime().toString().split(":");
        
        if (participantIDs.length == 0) 
        {
            participantIDs = new int[1];
        }
        
        Date newDate = new Date(Integer.parseInt(date[0]) - 1900, 
                                Integer.parseInt(date[1]) - 1, 
                                Integer.parseInt(date[2]), 
                                Integer.parseInt(time[0]), 
                                Integer.parseInt(time[1]), 
                                0);
        
        currentEvent.setTitle(nameEventInput.getText());
        currentEvent.setAddress(address);
        currentEvent.setDate(newDate);
        currentEvent.setDuration(durationEventInput.getText());
        currentEvent.setParticipantIDs(participantIDs);
        currentEvent.setNotification(notifEventInput.getSelectedIndex()+1);
        currentEvent.setPriority(priorityEventInput.getSelectedIndex()+1);
        
        Database.UpdateEvent(currentEvent);
        
        appEdited = false;
        AppEdit();
        ClearEventInputData();
        LoadEventsToList();
        participantIDs = new int[0];
    }//GEN-LAST:event_appSaveButtonActionPerformed

    private void partEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partEditButtonActionPerformed
        partEdited = true;
        AppEdit();
        
        partContactsList.setModel(UsersToList(Database.loadAllUsers(), true));
    }//GEN-LAST:event_partEditButtonActionPerformed

    private void partSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partSaveButtonActionPerformed
        partEdited = false;
        AppEdit();
    }//GEN-LAST:event_partSaveButtonActionPerformed

    private void emailInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailInputFocusGained
        if (emailInput.getText().equals("E-Mail")) 
        {
            emailInput.setText("");
            emailInput.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_emailInputFocusGained

    private void emailInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailInputFocusLost
        if (emailInput.getText().equals("")) 
        {
            emailInput.setText("E-Mail");
            emailInput.setForeground(new Color(51, 51, 51));
        }
    }//GEN-LAST:event_emailInputFocusLost

    private void appRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appRemoveButtonActionPerformed
        Event[] events = {};
        events = GetAllSortedEvents();
        int index;
        index = appList.getSelectedIndex();
        
        Database.deleteEvent(events[index]);
        
        LoadEventsToList();
    }//GEN-LAST:event_appRemoveButtonActionPerformed

    private void appListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_appListValueChanged
        CurrentEditedEvent();
    }//GEN-LAST:event_appListValueChanged

    private void partAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partAddButtonActionPerformed
        int index = partContactsList.getSelectedIndex();
        int length = participantIDs.length;
        boolean isSaved = false;
        
        if (index != -1) 
        {
            String username = partContactsList.getSelectedValue();
            User tempUser = Database.loadUser(username);
            
            //Checking if the array is empty
            if (length == 0)
            {
                participantIDs = new int[length +1];
                participantIDs[length] = tempUser.getId();
            }
            else
            {
                //Checking if user ID is already saved
                for (int i = 0; i < participantIDs.length; i++) 
                {
                    if (participantIDs[i] == tempUser.getId()) 
                    {
                        isSaved = true;
                    }
                }
                
                if (!isSaved) 
                {
                    //Creating new array with one more space and copying from the original array
                    int[] tempIDs = new int[length +1];
                    for (int i = 0; i < length; i++) 
                    {
                        tempIDs[i] = participantIDs[i];
                    }
                    tempIDs[length] = tempUser.getId();
                    participantIDs = tempIDs;
                }
                isSaved = false;
            }
            
            partAddContactsList.setModel(IDsToList(participantIDs));
        }
    }//GEN-LAST:event_partAddButtonActionPerformed

    private void appAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appAddButtonActionPerformed
        String[] address = {"", ""};
        address[0] = streetEventInput.getText();
        address[1] = cityEventInput.getText();
        String[] date = dateEventInput.getDate().toString().split("-");
        String[] time = btimeEventInput.getTime().toString().split(":");
        Date newDate = new Date(Integer.parseInt(date[0]) - 1900, 
                                Integer.parseInt(date[1]) - 1, 
                                Integer.parseInt(date[2]), 
                                Integer.parseInt(time[0]), 
                                Integer.parseInt(time[1]), 
                                0);
        
        if (participantIDs.length == 0) 
        {
            participantIDs = new int[1];
        }
        
        Event newEvent = new Event(nameEventInput.getText(), 
                                   address, 
                                   newDate, 
                                   durationEventInput.getText(), 
                                   participantIDs, 
                                   notifEventInput.getSelectedIndex()+1,
                                   priorityEventInput.getSelectedIndex()+1,
                                   currentUser.getId());
        
        if (!filePath.equals("")) 
        {
            newEvent.addAttachmentToEvent(filePath);
        }
        
        Database.storeNewEvent(newEvent);
        LoadEventsToList();
        ClearEventInputData();
        participantIDs = null;
        filePath = "";
        participantIDs = new int[0];
    }//GEN-LAST:event_appAddButtonActionPerformed

    private void usernameEditFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameEditFocusGained
        if (usernameEdit.getText().equals("Edit username")) 
        {
            usernameEdit.setText("");
            usernameEdit.setForeground(new Color(255,255,255));
        }
    }//GEN-LAST:event_usernameEditFocusGained

    private void usernameEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameEditFocusLost
        if (usernameEdit.getText().equals("")) 
        {
            usernameEdit.setText("Edit username");
            usernameEdit.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_usernameEditFocusLost

    private void passwordEditFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordEditFocusGained
        if (passwordEdit.getText().equals("Edit password")) 
        {
            passwordEdit.setText("");
            passwordEdit.setForeground(new Color(255,255,255));
        }
    }//GEN-LAST:event_passwordEditFocusGained

    private void passwordEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordEditFocusLost
        if (passwordEdit.getText().equals("")) 
        {
            passwordEdit.setText("Edit password");
            passwordEdit.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_passwordEditFocusLost

    private void friendsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_friendsListValueChanged
        editedUser = Database.loadUser(friendsList.getSelectedValue());
        LoadEditedUserData();
    }//GEN-LAST:event_friendsListValueChanged

    private void adminEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminEditButtonActionPerformed
        if (friendsList.getSelectedIndex() != -1) 
        {
            adminEdit = true;
            editLabel.setText("Edit user profile");
            editedUser = Database.loadUser(friendsList.getSelectedValue());
            LoadEditedUserData();
            DataEditMenu();
        }
    }//GEN-LAST:event_adminEditButtonActionPerformed

    private void attachmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachmentButtonActionPerformed
        if (currentEvent != null) 
        {
            currentEvent.addAttachmentToEvent(currentEvent.addNewAttachment());
        }
        else
        {
            filePath = Event.addNewAttachment();
            System.out.println(filePath);
        }
    }//GEN-LAST:event_attachmentButtonActionPerformed

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed
        String[] path = currentEvent.getAttachments();
        
        
        for (int i = 0; i < path.length; i++) 
        {
            File file = new File(path[i]);
            try
            {
                if (currentEvent != null) 
                {
                    if (file.exists()) 
                    {
                        if (Desktop.isDesktopSupported()) 
                        {
                            Desktop.getDesktop().open(file);
                        }
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        
        
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void appExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appExportButtonActionPerformed
        Saveschedule schedule = new Saveschedule();
        try 
        {
            schedule.saveschedule(currentUser.getId());
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(scheduler_ui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_appExportButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(scheduler_ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scheduler_ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scheduler_ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scheduler_ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scheduler_ui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLabel;
    private javax.swing.JButton adminEditButton;
    private javax.swing.JLabel adminLogo;
    private javax.swing.JLabel adminView;
    private javax.swing.JButton appAddButton;
    private javax.swing.JLabel appAppTile;
    private javax.swing.JPanel appDisplayPanel;
    private javax.swing.JLabel appDisplayTile;
    private javax.swing.JButton appEditButton;
    private javax.swing.JButton appExportButton;
    private javax.swing.JLabel appLabel;
    private javax.swing.JList<String> appList;
    private javax.swing.JPanel appPartPanel;
    private javax.swing.JButton appRemoveButton;
    private javax.swing.JButton appSaveButton;
    private javax.swing.JButton attachmentButton;
    private javax.swing.JLabel bgLabel;
    private javax.swing.JPanel bgPanel;
    private com.github.lgooddatepicker.components.TimePicker btimeEventInput;
    private javax.swing.JLabel btimeEventLabel;
    private javax.swing.JButton caccButton;
    private javax.swing.JButton calenderButton;
    private javax.swing.JPanel calenderPanel;
    private javax.swing.JButton cancelAppEditButton;
    private javax.swing.JButton cancelDataEdit;
    private javax.swing.JTextField cityEventInput;
    private javax.swing.JLabel cityEventLabel;
    private javax.swing.JPanel dataEdit;
    private javax.swing.JPanel dataOverview;
    private com.github.lgooddatepicker.components.DatePicker dateEventInput;
    private javax.swing.JLabel dateEventLabel;
    private javax.swing.JTextField durationEventInput;
    private javax.swing.JLabel durationEventLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editLabel;
    private javax.swing.JTextField emailInput;
    private javax.swing.JPanel emailUnderline;
    private javax.swing.JLabel eventPartLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel friednsLabel;
    private javax.swing.JList<String> friendsList;
    private javax.swing.JPanel friendsPanel;
    private javax.swing.JLabel friendsTile;
    private javax.swing.JScrollPane friendsView;
    private javax.swing.JButton goBackButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel homePanel;
    private javax.swing.JScrollPane listDisplay;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel maiView;
    private javax.swing.JTextField mailEdit;
    private javax.swing.JPanel mailUnderline;
    private javax.swing.JTabbedPane mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JButton minButton;
    private javax.swing.JLabel miniLogo;
    private javax.swing.JTextField nameEventInput;
    private javax.swing.JLabel nameEventLabel;
    private javax.swing.JTextField nameInput;
    private javax.swing.JPanel nameUnderline;
    private javax.swing.JLabel nitifEventLabel;
    private javax.swing.JComboBox<String> notifEventInput;
    private javax.swing.JButton openFileButton;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JButton partAddButton;
    private javax.swing.JScrollPane partAddContacts;
    private javax.swing.JList<String> partAddContactsList;
    private javax.swing.JScrollPane partContacts;
    private javax.swing.JList<String> partContactsList;
    private javax.swing.JButton partEditButton;
    private javax.swing.JButton partSaveButton;
    private javax.swing.JPanel passUnderline;
    private javax.swing.JButton passVisButton;
    private javax.swing.JPasswordField passwordConfInput;
    private javax.swing.JPanel passwordConfUnderline;
    private javax.swing.JTextField passwordEdit;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JPanel passwordUnderline;
    private javax.swing.JComboBox<String> priorityEventInput;
    private javax.swing.JLabel priorityEventLabel;
    private javax.swing.JButton profilesButton;
    private javax.swing.JPanel profilesPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton signupButton;
    private javax.swing.JTextField streetEventInput;
    private javax.swing.JLabel streetEventLabel;
    private javax.swing.JPanel tilePanel_1;
    private javax.swing.JPanel tilePanel_2;
    private javax.swing.JPanel tilePanel_3;
    private javax.swing.JLabel tile_1;
    private javax.swing.JLabel tile_1_date;
    private javax.swing.JLabel tile_1_duration;
    private javax.swing.JLabel tile_1_location_city;
    private javax.swing.JLabel tile_1_location_street;
    private javax.swing.JLabel tile_1_month;
    private javax.swing.JLabel tile_1_name;
    private javax.swing.JLabel tile_1_participants_amount;
    private javax.swing.JLabel tile_1_participants_label;
    private javax.swing.JLabel tile_2;
    private javax.swing.JLabel tile_2_date;
    private javax.swing.JLabel tile_2_duration;
    private javax.swing.JLabel tile_2_location_city;
    private javax.swing.JLabel tile_2_location_street;
    private javax.swing.JLabel tile_2_month;
    private javax.swing.JLabel tile_2_name;
    private javax.swing.JLabel tile_2_participants_amount;
    private javax.swing.JLabel tile_2_participants_label;
    private javax.swing.JLabel tile_3;
    private javax.swing.JLabel tile_3_date;
    private javax.swing.JLabel tile_3_duration;
    private javax.swing.JLabel tile_3_location_city;
    private javax.swing.JLabel tile_3_location_street;
    private javax.swing.JLabel tile_3_month;
    private javax.swing.JLabel tile_3_name;
    private javax.swing.JLabel tile_3_participants_amount;
    private javax.swing.JLabel tile_3_participants_label;
    private javax.swing.JLabel upcomingLabels;
    private javax.swing.JPanel upperPanel;
    private javax.swing.JLabel userIcon;
    private javax.swing.JLabel userLogo;
    private javax.swing.JPanel userProfilePanel;
    private javax.swing.JLabel userTile;
    private javax.swing.JTextField usernameEdit;
    private javax.swing.JPanel usernameUnderline;
    private javax.swing.JLabel usernameView;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel yourContLabel;
    // End of variables declaration//GEN-END:variables
}
