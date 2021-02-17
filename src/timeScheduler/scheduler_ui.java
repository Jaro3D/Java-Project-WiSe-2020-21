package timescheduler;

import java.awt.Color;
import java.awt.Frame;

/**
 *
 * @author Jaro
 */
public class scheduler_ui extends javax.swing.JFrame {
    int mousePosX;
    int mousePosY;
    boolean passNotVisible = false;
    boolean searchActive = false;
    boolean appEdited = false;
    boolean partEdited = false;
    int buttonIndex = 0;
    
    public scheduler_ui() {
        initComponents();
        initBasics();
    }
    
    public void initBasics()
    {
        nameInput.setBackground(new java.awt.Color(0,0,0,0));
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
        searchField.setBackground(new java.awt.Color(0,0,0,0));
        searchButton.setBackground(new java.awt.Color(0,0,0,0));
        addButton.setBackground(new java.awt.Color(0,0,0,0));
        removeButton.setBackground(new java.awt.Color(0,0,0,0));
        firstNameEdit.setBackground(new java.awt.Color(0,0,0,0));
        lastNameEdit.setBackground(new java.awt.Color(0,0,0,0));
        occupationEdit.setBackground(new java.awt.Color(0,0,0,0));
        mailEdit.setBackground(new java.awt.Color(0,0,0,0));
        appAddButton.setBackground(new java.awt.Color(0,0,0,0));
        appEditButton.setBackground(new java.awt.Color(0,0,0,0));
        appRemoveButton.setBackground(new java.awt.Color(0,0,0,0));
        appSaveButton.setBackground(new java.awt.Color(0,0,0,0));
        cancelAppEditButton.setBackground(new java.awt.Color(0,0,0,0));
        passwordInput.setEchoChar((char)0);
        passwordConfInput.setEchoChar((char)0);
        passwordConfInput.setEchoChar((char)0);
        LoginMenu();
        SearchActive();
        AppEdit();
    }
    
    //EDITING APPOINTMENTS ON CALENDER SCREEN
    private void AppEdit()
    {
        if (appEdited) //Appointment editing screen
        {
            appSaveButton.setVisible(true);
            cancelAppEditButton.setVisible(true);
            appAddButton.setVisible(false);
            addLabel.setText("Modify appointment");
            partEditButton.setVisible(true);
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
    
    //SWITCHING BACKGROUNDS
    private void CheckButtonIndex()
    {
        switch(buttonIndex) 
        {
        case 0: //Login screen
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG.png")));
            break;
        case 1: //Dashboard
            DataOverviewMenu();
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
            break;
        case 3: //Contacts and profile screen
            mainMenu.setSelectedIndex(2);
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG_Profiles.png")));
            profilesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton_over.png")));
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton.png")));
            calenderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton.png")));
            break;
        default:
          // code block
            break;
        }
    }
    
    //CONTACTS SCREEN SEARCH BAR
    private void SearchActive()
    {
        if (searchActive) //Search bar enabled
        {
            serachBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SearchField.png")));
            searchField.setVisible(true);
            addButton.setVisible(true);
            removeButton.setVisible(false);
            friednsLabel.setText("Users found:");
        }
        else //Searchbar disabled
        {
            serachBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SearchField_closed.png")));
            searchField.setVisible(false);
            addButton.setVisible(false);
            removeButton.setVisible(true);
            friednsLabel.setText("Your contacts:");
        }
    }
    
    //ENABLE PROFILE DATA EDIT
    private void DataEditMenu()
    {
        dataOverview.setVisible(false);
        dataEdit.setVisible(true);
    }
    
    //ENABLE PROFILE DATA DISPLAY
    private void DataOverviewMenu()
    {
        dataEdit.setVisible(false);
        dataOverview.setVisible(true);
    }
    
    //ENABLE LOGIN MENU
    private void LoginMenu()
    {
        buttonIndex = 0;
        signupButton.setVisible(true);
        loginButton.setVisible(true);
        caccButton.setVisible(false);
        passwordConfInput.setVisible(false);
        passwordConfUnderline.setVisible(false);
        goBackButton.setVisible(false);
    }
    
    //ENABLE REGISTRATION MENU
    private void SignUpMenu()
    {
        signupButton.setVisible(false);
        loginButton.setVisible(false);
        caccButton.setVisible(true);
        passwordConfInput.setVisible(true);
        passwordConfUnderline.setVisible(true);
        goBackButton.setVisible(true);
    }
    
    //LOGIN AND REGISTRATION PASSWORT DISPLAY SETTINGS
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
        duratonEventInput = new com.github.lgooddatepicker.components.TimePicker();
        cityEventLabel = new javax.swing.JLabel();
        cityEventInput = new javax.swing.JTextField();
        streetEventLabel = new javax.swing.JLabel();
        streetEventInput = new javax.swing.JTextField();
        priorityEventLabel = new javax.swing.JLabel();
        priorityEventInput = new javax.swing.JComboBox<>();
        nitifEventLabel = new javax.swing.JLabel();
        notifEventInput = new javax.swing.JComboBox<>();
        partEditButton = new javax.swing.JButton();
        appPartPanel = new javax.swing.JPanel();
        yourContLabel = new javax.swing.JLabel();
        partContacts = new javax.swing.JScrollPane();
        partContactsList = new javax.swing.JList<>();
        eventPartLabel = new javax.swing.JLabel();
        partAddContacts = new javax.swing.JScrollPane();
        partAddContactsList = new javax.swing.JList<>();
        partSaveButton = new javax.swing.JButton();
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
        firstNameEdit = new javax.swing.JTextField();
        fistNameUnderline = new javax.swing.JPanel();
        lastNameEdit = new javax.swing.JTextField();
        lastNameUnderline = new javax.swing.JPanel();
        occupationEdit = new javax.swing.JTextField();
        occupationUnderline = new javax.swing.JPanel();
        mailEdit = new javax.swing.JTextField();
        mailUnderline = new javax.swing.JPanel();
        dataOverview = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        userLogo = new javax.swing.JLabel();
        nameView = new javax.swing.JLabel();
        maiView = new javax.swing.JLabel();
        occView = new javax.swing.JLabel();
        usernameView = new javax.swing.JLabel();
        userTile = new javax.swing.JLabel();
        friendsPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        serachBG = new javax.swing.JLabel();
        friednsLabel = new javax.swing.JLabel();
        friendsView = new javax.swing.JScrollPane();
        friendsList = new javax.swing.JList<>();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
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

        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/Button.png"))); // NOI18N
        exitButton.setBorder(null);
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

        outputLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        outputLabel.setForeground(new java.awt.Color(255, 255, 255));
        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputLabel.setText("Welcome!");
        loginPanel.add(outputLabel);
        outputLabel.setBounds(640, 200, 300, 40);

        nameInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nameInput.setForeground(new java.awt.Color(51, 51, 51));
        nameInput.setText("Username");
        nameInput.setBorder(null);
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
        loginPanel.add(nameUnderline);
        nameUnderline.setBounds(640, 320, 300, 2);

        passwordInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        passwordInput.setForeground(new java.awt.Color(51, 51, 51));
        passwordInput.setText("Password");
        passwordInput.setBorder(null);
        passwordInput.setEchoChar('*');
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
        loginPanel.add(passwordUnderline);
        passwordUnderline.setBounds(640, 400, 300, 2);

        passwordConfInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        passwordConfInput.setForeground(new java.awt.Color(51, 51, 51));
        passwordConfInput.setText("Confirm Password");
        passwordConfInput.setBorder(null);
        passwordConfInput.setEchoChar('*');
        passwordConfInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordConfInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordConfInputFocusLost(evt);
            }
        });
        loginPanel.add(passwordConfInput);
        passwordConfInput.setBounds(650, 430, 280, 40);

        passwordConfUnderline.setBackground(new java.awt.Color(255, 255, 255));
        loginPanel.add(passwordConfUnderline);
        passwordConfUnderline.setBounds(640, 470, 300, 2);

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
        userIcon.setBounds(590, 290, 40, 40);

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/LoginButton.png"))); // NOI18N
        loginButton.setBorder(null);
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

        caccButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        caccButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SignUpButton.png"))); // NOI18N
        caccButton.setBorder(null);
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

        tile_2_name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tile_2_name.setForeground(new java.awt.Color(255, 255, 255));
        tile_2_name.setText("Appointment 2");
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

        tile_1_participants_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_1_participants_amount.setForeground(new java.awt.Color(255, 255, 255));
        tile_1_participants_amount.setText("3");
        tilePanel_1.add(tile_1_participants_amount);
        tile_1_participants_amount.setBounds(100, 110, 50, 20);

        tile_1_location_city.setText("Frankfurt am Main");
        tile_1_location_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tile_1_location_city.setForeground(new java.awt.Color(255, 255, 255));
        tilePanel_1.add(tile_1_location_city);
        tile_1_location_city.setBounds(20, 90, 160, 20);

        tile_1_month.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tile_1_month.setForeground(new java.awt.Color(153, 153, 153));
        tile_1_month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tile_1_month.setText("Oct");
        tilePanel_1.add(tile_1_month);
        tile_1_month.setBounds(40, 202, 50, 20);

        tile_1_date.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tile_1_date.setForeground(new java.awt.Color(153, 153, 153));
        tile_1_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tile_1_date.setText("28");
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
        appList.setOpaque(false);
        appList.setSelectionBackground(new java.awt.Color(209, 80, 97));
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

        duratonEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appDisplayPanel.add(duratonEventInput);
        duratonEventInput.setBounds(120, 120, 110, 30);

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

        notifEventInput.setBackground(new java.awt.Color(204, 0, 0));
        notifEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notifEventInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 week", "3 days", "1 hour", "10 minutes" }));
        notifEventInput.setBorder(null);
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
        partEditButton.setBounds(50, 315, 145, 30);

        calenderPanel.add(appDisplayPanel);
        appDisplayPanel.setBounds(510, 50, 235, 350);

        appPartPanel.setOpaque(false);
        appPartPanel.setLayout(null);

        yourContLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yourContLabel.setForeground(new java.awt.Color(255, 255, 255));
        yourContLabel.setText("Your contacts:");
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

        eventPartLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eventPartLabel.setForeground(new java.awt.Color(255, 255, 255));
        eventPartLabel.setText("Event participants:");
        appPartPanel.add(eventPartLabel);
        eventPartLabel.setBounds(0, 135, 240, 20);

        partAddContactsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Sullivan Hulme", "Halima Ellwood", "Koby Sinclair", "Milena Tierney", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        partAddContactsList.setBackground(new java.awt.Color(224, 92, 109));
        partAddContactsList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        partAddContactsList.setForeground(new java.awt.Color(255, 255, 255));
        partAddContactsList.setSelectionBackground(new java.awt.Color(209, 80, 97));
        partAddContacts.setViewportView(partAddContactsList);

        appPartPanel.add(partAddContacts);
        partAddContacts.setBounds(0, 160, 235, 100);

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
        calenderPanel.add(appExportButton);
        appExportButton.setBounds(240, 400, 90, 40);

        appRemoveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton.png"))); // NOI18N
        appRemoveButton.setBorder(null);
        appRemoveButton.setOpaque(false);
        appRemoveButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton_pressed.png"))); // NOI18N
        appRemoveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton_over.png"))); // NOI18N
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

        editLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editLabel.setForeground(new java.awt.Color(255, 255, 255));
        editLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editLabel.setText("Edit your profile");
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

        cancelDataEdit.setForeground(new java.awt.Color(255, 255, 255));
        cancelDataEdit.setText("Cancel");
        cancelDataEdit.setBorder(null);
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

        firstNameEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameEdit.setForeground(new java.awt.Color(204, 204, 204));
        firstNameEdit.setText("Edit first name");
        firstNameEdit.setBorder(null);
        firstNameEdit.setOpaque(false);
        firstNameEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameEditFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameEditFocusLost(evt);
            }
        });
        dataEdit.add(firstNameEdit);
        firstNameEdit.setBounds(100, 170, 160, 30);

        fistNameUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout fistNameUnderlineLayout = new javax.swing.GroupLayout(fistNameUnderline);
        fistNameUnderline.setLayout(fistNameUnderlineLayout);
        fistNameUnderlineLayout.setHorizontalGroup(
            fistNameUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        fistNameUnderlineLayout.setVerticalGroup(
            fistNameUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        dataEdit.add(fistNameUnderline);
        fistNameUnderline.setBounds(100, 197, 160, 2);

        lastNameEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameEdit.setForeground(new java.awt.Color(204, 204, 204));
        lastNameEdit.setText("Edit last name");
        lastNameEdit.setBorder(null);
        lastNameEdit.setOpaque(false);
        lastNameEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameEditFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameEditFocusLost(evt);
            }
        });
        dataEdit.add(lastNameEdit);
        lastNameEdit.setBounds(100, 210, 160, 30);

        lastNameUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout lastNameUnderlineLayout = new javax.swing.GroupLayout(lastNameUnderline);
        lastNameUnderline.setLayout(lastNameUnderlineLayout);
        lastNameUnderlineLayout.setHorizontalGroup(
            lastNameUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        lastNameUnderlineLayout.setVerticalGroup(
            lastNameUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        dataEdit.add(lastNameUnderline);
        lastNameUnderline.setBounds(100, 237, 160, 2);

        occupationEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        occupationEdit.setForeground(new java.awt.Color(204, 204, 204));
        occupationEdit.setText("Edit occupation");
        occupationEdit.setBorder(null);
        occupationEdit.setOpaque(false);
        occupationEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                occupationEditFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                occupationEditFocusLost(evt);
            }
        });
        dataEdit.add(occupationEdit);
        occupationEdit.setBounds(100, 250, 160, 30);

        occupationUnderline.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout occupationUnderlineLayout = new javax.swing.GroupLayout(occupationUnderline);
        occupationUnderline.setLayout(occupationUnderlineLayout);
        occupationUnderlineLayout.setHorizontalGroup(
            occupationUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        occupationUnderlineLayout.setVerticalGroup(
            occupationUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        dataEdit.add(occupationUnderline);
        occupationUnderline.setBounds(100, 277, 160, 2);

        mailEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mailEdit.setForeground(new java.awt.Color(204, 204, 204));
        mailEdit.setText("Edit E-Mail address");
        mailEdit.setBorder(null);
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
        mailEdit.setBounds(100, 290, 160, 30);

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
        mailUnderline.setBounds(100, 317, 160, 2);

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

        nameView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameView.setForeground(new java.awt.Color(255, 255, 255));
        nameView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameView.setText("Name Surname");
        dataOverview.add(nameView);
        nameView.setBounds(48, 230, 260, 30);

        maiView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maiView.setForeground(new java.awt.Color(255, 255, 255));
        maiView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maiView.setText("namesurname@gmail.com");
        dataOverview.add(maiView);
        maiView.setBounds(48, 290, 260, 30);

        occView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        occView.setForeground(new java.awt.Color(255, 255, 255));
        occView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        occView.setText("Occupation");
        dataOverview.add(occView);
        occView.setBounds(48, 260, 260, 30);

        usernameView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameView.setForeground(new java.awt.Color(255, 255, 255));
        usernameView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameView.setText("Username");
        dataOverview.add(usernameView);
        usernameView.setBounds(48, 200, 260, 30);

        userProfilePanel.add(dataOverview);
        dataOverview.setBounds(0, 0, 400, 500);

        userTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PanelTile.png"))); // NOI18N
        userProfilePanel.add(userTile);
        userTile.setBounds(10, 0, 340, 480);

        profilesPanel.add(userProfilePanel);
        userProfilePanel.setBounds(450, 0, 410, 530);

        friendsPanel.setOpaque(false);
        friendsPanel.setLayout(null);

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SearchLogo.png"))); // NOI18N
        searchButton.setBorder(null);
        searchButton.setOpaque(false);
        searchButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SearchLogo_over.png"))); // NOI18N
        searchButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SearchLogo_over.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        friendsPanel.add(searchButton);
        searchButton.setBounds(160, 40, 30, 30);

        searchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(51, 51, 51));
        searchField.setText("Search for Users");
        searchField.setBorder(null);
        searchField.setOpaque(false);
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });
        friendsPanel.add(searchField);
        searchField.setBounds(202, 40, 200, 30);

        serachBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SearchField_closed.png"))); // NOI18N
        friendsPanel.add(serachBG);
        serachBG.setBounds(155, 35, 260, 40);

        friednsLabel.setText("Your Friends:");
        friednsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        friednsLabel.setForeground(new java.awt.Color(255, 255, 255));
        friendsPanel.add(friednsLabel);
        friednsLabel.setBounds(160, 100, 240, 30);

        friendsView.setBorder(null);

        friendsList.setBackground(new java.awt.Color(224, 92, 109));
        friendsList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friendsList.setForeground(new java.awt.Color(255, 255, 255));
        friendsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Charis Lundblad", "Mark Peeler", "Melina Monreal", "Herb Deshotel", "Charita Salmon", "Juliann Esch", "Jonah Kampa", "Ta Bachand" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        friendsList.setSelectionBackground(new java.awt.Color(209, 80, 97));
        friendsView.setViewportView(friendsList);

        friendsPanel.add(friendsView);
        friendsView.setBounds(155, 130, 150, 190);

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton.png"))); // NOI18N
        removeButton.setBorder(null);
        removeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton_pressed.png"))); // NOI18N
        removeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton_over.png"))); // NOI18N
        friendsPanel.add(removeButton);
        removeButton.setBounds(225, 370, 120, 40);

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton.png"))); // NOI18N
        addButton.setBorder(null);
        addButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton_pressed.png"))); // NOI18N
        addButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton_over.png"))); // NOI18N
        friendsPanel.add(addButton);
        addButton.setBounds(240, 370, 90, 40);

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
        buttonIndex = 1;
        CheckButtonIndex();
        mainTab.setSelectedIndex(1);
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
        if (nameInput.getText().equals("Jaro") && passwordInput.getText().equals("pass123")) 
        {
            buttonIndex = 1;
            CheckButtonIndex();
            mainTab.setSelectedIndex(1);
        }
        else
        {
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
        mainTab.setSelectedIndex(0);
        LoginMenu();
        CheckButtonIndex();
        CheckVisibility();
        nameInput.setText("Username");
        passwordInput.setText("Password");
        passwordConfInput.setText("Confirm Password");
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
        DataOverviewMenu();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        DataEditMenu();
        firstNameEdit.setText("Edit first name");
        lastNameEdit.setText("Edit last name");
        occupationEdit.setText("Edit occupation");
        mailEdit.setText("Edit E-Mail address");
        firstNameEdit.setForeground(new Color(204,204,204));
        lastNameEdit.setForeground(new Color(204,204,204));
        occupationEdit.setForeground(new Color(204,204,204));
        mailEdit.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_editButtonActionPerformed

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        if (searchField.getText().equals("Search for Users")) 
        {
            searchField.setText("");
            searchField.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        if (searchField.getText().equals("")) 
        {
            searchField.setText("Search for Users");
            searchField.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchFieldFocusLost

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchActive = !searchActive;
        SearchActive();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void firstNameEditFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameEditFocusGained
        if (firstNameEdit.getText().equals("Edit first name")) 
        {
            firstNameEdit.setText("");
            firstNameEdit.setForeground(new Color(255,255,255));
        }
    }//GEN-LAST:event_firstNameEditFocusGained

    private void lastNameEditFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameEditFocusGained
        if (lastNameEdit.getText().equals("Edit last name")) 
        {
            lastNameEdit.setText("");
            lastNameEdit.setForeground(new Color(255,255,255));
        }
    }//GEN-LAST:event_lastNameEditFocusGained

    private void occupationEditFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_occupationEditFocusGained
        if (occupationEdit.getText().equals("Edit occupation")) 
        {
            occupationEdit.setText("");
            occupationEdit.setForeground(new Color(255,255,255));
        }
    }//GEN-LAST:event_occupationEditFocusGained

    private void mailEditFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailEditFocusGained
        if (mailEdit.getText().equals("Edit E-Mail address")) 
        {
            mailEdit.setText("");
            mailEdit.setForeground(new Color(255,255,255));
        }
    }//GEN-LAST:event_mailEditFocusGained

    private void firstNameEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameEditFocusLost
        if (firstNameEdit.getText().equals("")) 
        {
            firstNameEdit.setText("Edit first name");
            firstNameEdit.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_firstNameEditFocusLost

    private void lastNameEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameEditFocusLost
        if (lastNameEdit.getText().equals("")) 
        {
            lastNameEdit.setText("Edit last name");
            lastNameEdit.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_lastNameEditFocusLost

    private void occupationEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_occupationEditFocusLost
        if (occupationEdit.getText().equals("")) 
        {
            occupationEdit.setText("Edit occupation");
            occupationEdit.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_occupationEditFocusLost

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
        AppEdit();
    }//GEN-LAST:event_cancelAppEditButtonActionPerformed

    private void appEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appEditButtonActionPerformed
        appEdited = true;
        partEdited = false;
        AppEdit();
    }//GEN-LAST:event_appEditButtonActionPerformed

    private void appSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appSaveButtonActionPerformed
        appEdited = false;
        AppEdit();
    }//GEN-LAST:event_appSaveButtonActionPerformed

    private void partEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partEditButtonActionPerformed
        partEdited = true;
        AppEdit();
    }//GEN-LAST:event_partEditButtonActionPerformed

    private void partSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partSaveButtonActionPerformed
        partEdited = false;
        AppEdit();
    }//GEN-LAST:event_partSaveButtonActionPerformed

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
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addLabel;
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
    private javax.swing.JLabel durationEventLabel;
    private com.github.lgooddatepicker.components.TimePicker duratonEventInput;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editLabel;
    private javax.swing.JLabel eventPartLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField firstNameEdit;
    private javax.swing.JPanel fistNameUnderline;
    private javax.swing.JLabel friednsLabel;
    private javax.swing.JList<String> friendsList;
    private javax.swing.JPanel friendsPanel;
    private javax.swing.JLabel friendsTile;
    private javax.swing.JScrollPane friendsView;
    private javax.swing.JButton goBackButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel homePanel;
    private javax.swing.JTextField lastNameEdit;
    private javax.swing.JPanel lastNameUnderline;
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
    private javax.swing.JLabel nameView;
    private javax.swing.JLabel nitifEventLabel;
    private javax.swing.JComboBox<String> notifEventInput;
    private javax.swing.JLabel occView;
    private javax.swing.JTextField occupationEdit;
    private javax.swing.JPanel occupationUnderline;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JScrollPane partAddContacts;
    private javax.swing.JList<String> partAddContactsList;
    private javax.swing.JScrollPane partContacts;
    private javax.swing.JList<String> partContactsList;
    private javax.swing.JButton partEditButton;
    private javax.swing.JButton partSaveButton;
    private javax.swing.JButton passVisButton;
    private javax.swing.JPasswordField passwordConfInput;
    private javax.swing.JPanel passwordConfUnderline;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JPanel passwordUnderline;
    private javax.swing.JComboBox<String> priorityEventInput;
    private javax.swing.JLabel priorityEventLabel;
    private javax.swing.JButton profilesButton;
    private javax.swing.JPanel profilesPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel serachBG;
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
    private javax.swing.JLabel usernameView;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel yourContLabel;
    // End of variables declaration//GEN-END:variables
}
