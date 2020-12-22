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
        appListTile.setBackground(new java.awt.Color(0,0,0,0));
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
    
    private void AppEdit()
    {
        if (appEdited) 
        {
            appSaveButton.setVisible(true);
            cancelAppEditButton.setVisible(true);
            appAddButton.setVisible(false);
            addLabel.setText("Modify appointment");
        }
        else
        {
            appSaveButton.setVisible(false);
            cancelAppEditButton.setVisible(false);
            appAddButton.setVisible(true);
            addLabel.setText("Add new appointment");
        }
            
    }
    
    private void CheckButtonIndex()
    {
        switch(buttonIndex) 
        {
        case 0:
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG.png")));
            break;
        case 1:
            DataOverviewMenu();
            mainMenu.setSelectedIndex(0);
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG_Home.png")));
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton_over.png")));
            calenderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton.png")));
            profilesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton.png")));
            break;
        case 2:
            mainMenu.setSelectedIndex(1);
            bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/OnTime_BG_Calender.png")));
            calenderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/CalenderButton_over.png")));
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton.png")));
            profilesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/ProfilesButton.png")));
            break;
        case 3:
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
    
    private void SearchActive()
    {
        if (searchActive) 
        {
            serachBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SearchField.png")));
            searchField.setVisible(true);
            addButton.setVisible(true);
            removeButton.setVisible(false);
            friednsLabel.setText("Users found:");
        }
        else
        {
            serachBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/SearchField_closed.png")));
            searchField.setVisible(false);
            addButton.setVisible(false);
            removeButton.setVisible(true);
            friednsLabel.setText("Your Friends:");
        }
    }
    
    private void DataEditMenu()
    {
        dataOverview.setVisible(false);
        dataEdit.setVisible(true);
    }
    
    private void DataOverviewMenu()
    {
        dataEdit.setVisible(false);
        dataOverview.setVisible(true);
    }
    
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
    
    private void SignUpMenu()
    {
        signupButton.setVisible(false);
        loginButton.setVisible(false);
        caccButton.setVisible(true);
        passwordConfInput.setVisible(true);
        passwordConfUnderline.setVisible(true);
        goBackButton.setVisible(true);
    }
    
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
        listView = new javax.swing.JScrollPane();
        appointmentList = new javax.swing.JList<>();
        appointmentDetails = new javax.swing.JPanel();
        nameEvent = new javax.swing.JLabel();
        dateEvent = new javax.swing.JLabel();
        timeEvent = new javax.swing.JLabel();
        durationEvent = new javax.swing.JLabel();
        locationEvent = new javax.swing.JLabel();
        participantsLabel = new javax.swing.JLabel();
        participantsList = new javax.swing.JComboBox<>();
        partListTile = new javax.swing.JLabel();
        appListTile = new javax.swing.JLabel();
        calenderPanel = new javax.swing.JPanel();
        appLabel = new javax.swing.JLabel();
        addLabel = new javax.swing.JLabel();
        listDisplay = new javax.swing.JScrollPane();
        appList = new javax.swing.JList<>();
        nameEventLabel = new javax.swing.JLabel();
        nameEventInput = new javax.swing.JTextField();
        dateEventLabel = new javax.swing.JLabel();
        dateEventInput = new com.github.lgooddatepicker.components.DatePicker();
        btimeEventLabel = new javax.swing.JLabel();
        btimeEventInput = new com.github.lgooddatepicker.components.TimePicker();
        etimeEventLabel = new javax.swing.JLabel();
        etimeEventInput = new com.github.lgooddatepicker.components.TimePicker();
        locationEventLabel = new javax.swing.JLabel();
        locationEventInput = new javax.swing.JTextField();
        participantsEventLabel = new javax.swing.JLabel();
        participantsEventInput = new javax.swing.JComboBox<>();
        priorityEventLabel = new javax.swing.JLabel();
        priorityEventInput = new javax.swing.JComboBox<>();
        appEditButton = new javax.swing.JButton();
        appRemoveButton = new javax.swing.JButton();
        appAddButton = new javax.swing.JButton();
        appSaveButton = new javax.swing.JButton();
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
        homeButton.setToolTipText("");
        homeButton.setBorder(null);
        homeButton.setOpaque(false);
        homeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton_pressed.png"))); // NOI18N
        homeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/HomeButton_over.png"))); // NOI18N
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

        listView.setBackground(new java.awt.Color(251, 101, 120));
        listView.setBorder(null);
        listView.setForeground(new java.awt.Color(163, 64, 76));
        listView.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        listView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        appointmentList.setBackground(new java.awt.Color(224, 92, 109));
        appointmentList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appointmentList.setForeground(new java.awt.Color(255, 255, 255));
        appointmentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "28.12.2020 12:30 Java Lecture", "29.12.2020 08:15 SWE Lecture", "29.12.2020 17:45 Database Lecture", "30.12.2020 13:15 Statistic Lacture", "01.01.2021 00:00 New Year", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        appointmentList.setOpaque(false);
        appointmentList.setSelectionBackground(new java.awt.Color(209, 80, 97));
        listView.setViewportView(appointmentList);

        homePanel.add(listView);
        listView.setBounds(150, 80, 270, 350);

        appointmentDetails.setOpaque(false);
        appointmentDetails.setLayout(null);

        nameEvent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameEvent.setForeground(new java.awt.Color(255, 255, 255));
        nameEvent.setText("Java Lecture");
        appointmentDetails.add(nameEvent);
        nameEvent.setBounds(70, 40, 120, 20);

        dateEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateEvent.setForeground(new java.awt.Color(255, 255, 255));
        dateEvent.setText("28.12.2020");
        dateEvent.setMaximumSize(new java.awt.Dimension(87, 17));
        dateEvent.setMinimumSize(new java.awt.Dimension(87, 17));
        dateEvent.setPreferredSize(new java.awt.Dimension(87, 17));
        appointmentDetails.add(dateEvent);
        dateEvent.setBounds(70, 60, 120, 20);

        timeEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timeEvent.setForeground(new java.awt.Color(255, 255, 255));
        timeEvent.setText("12:30");
        timeEvent.setMaximumSize(new java.awt.Dimension(87, 17));
        timeEvent.setMinimumSize(new java.awt.Dimension(87, 17));
        timeEvent.setPreferredSize(new java.awt.Dimension(87, 17));
        appointmentDetails.add(timeEvent);
        timeEvent.setBounds(70, 80, 120, 20);

        durationEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        durationEvent.setForeground(new java.awt.Color(255, 255, 255));
        durationEvent.setText("90 min.");
        durationEvent.setMaximumSize(new java.awt.Dimension(87, 17));
        durationEvent.setMinimumSize(new java.awt.Dimension(87, 17));
        durationEvent.setPreferredSize(new java.awt.Dimension(87, 17));
        appointmentDetails.add(durationEvent);
        durationEvent.setBounds(70, 100, 120, 20);

        locationEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationEvent.setForeground(new java.awt.Color(255, 255, 255));
        locationEvent.setText("Homeoffice");
        appointmentDetails.add(locationEvent);
        locationEvent.setBounds(70, 120, 120, 20);

        participantsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        participantsLabel.setForeground(new java.awt.Color(255, 255, 255));
        participantsLabel.setText("Participants:");
        appointmentDetails.add(participantsLabel);
        participantsLabel.setBounds(70, 150, 120, 30);

        participantsList.setBackground(new java.awt.Color(204, 0, 0));
        participantsList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        participantsList.setForeground(new java.awt.Color(255, 255, 255));
        participantsList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yousuf Dunne", "Rebekah Avalos", "Siyana Espinosa", "Zain Sumner", "Madelaine Norton", "Scarlette Daniels", "Jaden Ferreira", "Kynan Bate", "Noor Cope", "Zachary Finnegan" }));
        participantsList.setBorder(null);
        appointmentDetails.add(participantsList);
        participantsList.setBounds(70, 180, 140, 30);

        partListTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PanelTile.png"))); // NOI18N
        appointmentDetails.add(partListTile);
        partListTile.setBounds(0, 0, 340, 480);

        homePanel.add(appointmentDetails);
        appointmentDetails.setBounds(460, 0, 400, 530);

        appListTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/PanelTile.png"))); // NOI18N
        homePanel.add(appListTile);
        appListTile.setBounds(117, 0, 340, 480);

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

        addLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addLabel.setForeground(new java.awt.Color(255, 255, 255));
        addLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addLabel.setText("Add new appointment");
        calenderPanel.add(addLabel);
        addLabel.setBounds(500, 30, 260, 40);

        listDisplay.setBackground(new java.awt.Color(251, 101, 120));
        listDisplay.setBorder(null);
        listDisplay.setForeground(new java.awt.Color(163, 64, 76));
        listDisplay.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        listDisplay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        appList.setBackground(new java.awt.Color(224, 92, 109));
        appList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appList.setForeground(new java.awt.Color(255, 255, 255));
        appList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "28.12.2020 12:30 Java Lecture", "29.12.2020 08:15 SWE Lecture", "29.12.2020 17:45 Database Lecture", "30.12.2020 13:15 Statistic Lacture", "01.01.2021 00:00 New Year", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        appList.setOpaque(false);
        appList.setSelectionBackground(new java.awt.Color(209, 80, 97));
        listDisplay.setViewportView(appList);

        calenderPanel.add(listDisplay);
        listDisplay.setBounds(150, 80, 270, 290);

        nameEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameEventLabel.setText("Name");
        calenderPanel.add(nameEventLabel);
        nameEventLabel.setBounds(510, 75, 235, 30);

        nameEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        calenderPanel.add(nameEventInput);
        nameEventInput.setBounds(510, 100, 235, 30);

        dateEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateEventLabel.setText("Date");
        calenderPanel.add(dateEventLabel);
        dateEventLabel.setBounds(510, 135, 120, 30);

        dateEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        calenderPanel.add(dateEventInput);
        dateEventInput.setBounds(510, 160, 230, 30);

        btimeEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btimeEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        btimeEventLabel.setText("Start time");
        calenderPanel.add(btimeEventLabel);
        btimeEventLabel.setBounds(510, 195, 95, 30);

        btimeEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        calenderPanel.add(btimeEventInput);
        btimeEventInput.setBounds(630, 220, 110, 30);

        etimeEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etimeEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        etimeEventLabel.setText("End time");
        calenderPanel.add(etimeEventLabel);
        etimeEventLabel.setBounds(630, 195, 95, 30);

        etimeEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        calenderPanel.add(etimeEventInput);
        etimeEventInput.setBounds(510, 220, 110, 30);

        locationEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        locationEventLabel.setText("Location");
        calenderPanel.add(locationEventLabel);
        locationEventLabel.setBounds(510, 255, 235, 30);

        locationEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        calenderPanel.add(locationEventInput);
        locationEventInput.setBounds(510, 280, 235, 30);

        participantsEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        participantsEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        participantsEventLabel.setText("Participants");
        calenderPanel.add(participantsEventLabel);
        participantsEventLabel.setBounds(510, 315, 120, 30);

        participantsEventInput.setBackground(new java.awt.Color(204, 0, 0));
        participantsEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        participantsEventInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yousuf Dunne", "Rebekah Avalos", "Siyana Espinosa", "Zain Sumner", "Madelaine Norton", "Scarlette Daniels", "Jaden Ferreira", "Kynan Bate", "Noor Cope", "Zachary Finnegan" }));
        participantsEventInput.setBorder(null);
        calenderPanel.add(participantsEventInput);
        participantsEventInput.setBounds(510, 340, 145, 30);

        priorityEventLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        priorityEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        priorityEventLabel.setText("Priority");
        calenderPanel.add(priorityEventLabel);
        priorityEventLabel.setBounds(665, 315, 80, 30);

        priorityEventInput.setBackground(new java.awt.Color(204, 0, 0));
        priorityEventInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        priorityEventInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High" }));
        priorityEventInput.setBorder(null);
        calenderPanel.add(priorityEventInput);
        priorityEventInput.setBounds(665, 340, 80, 30);

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
        appEditButton.setBounds(160, 400, 90, 40);

        appRemoveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton.png"))); // NOI18N
        appRemoveButton.setBorder(null);
        appRemoveButton.setOpaque(false);
        appRemoveButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton_pressed.png"))); // NOI18N
        appRemoveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/RemoveButton_over.png"))); // NOI18N
        calenderPanel.add(appRemoveButton);
        appRemoveButton.setBounds(290, 400, 120, 40);

        appAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton.png"))); // NOI18N
        appAddButton.setBorder(null);
        appAddButton.setOpaque(false);
        appAddButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton_pressed.png"))); // NOI18N
        appAddButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timescheduler/AddButton_over.png"))); // NOI18N
        calenderPanel.add(appAddButton);
        appAddButton.setBounds(585, 400, 90, 40);

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
        appSaveButton.setBounds(585, 390, 90, 40);

        cancelAppEditButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelAppEditButton.setText("Cancel");
        cancelAppEditButton.setBorder(null);
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
        cancelAppEditButton.setBounds(580, 425, 100, 40);

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

        friednsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        friednsLabel.setForeground(new java.awt.Color(255, 255, 255));
        friednsLabel.setText("Your Friends:");
        friendsPanel.add(friednsLabel);
        friednsLabel.setBounds(160, 100, 130, 30);

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
        AppEdit();
    }//GEN-LAST:event_appEditButtonActionPerformed

    private void appSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appSaveButtonActionPerformed
        appEdited = false;
        AppEdit();
    }//GEN-LAST:event_appSaveButtonActionPerformed

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
    private javax.swing.JLabel appDisplayTile;
    private javax.swing.JButton appEditButton;
    private javax.swing.JLabel appLabel;
    private javax.swing.JList<String> appList;
    private javax.swing.JLabel appListTile;
    private javax.swing.JButton appRemoveButton;
    private javax.swing.JButton appSaveButton;
    private javax.swing.JPanel appointmentDetails;
    private javax.swing.JList<String> appointmentList;
    private javax.swing.JLabel bgLabel;
    private javax.swing.JPanel bgPanel;
    private com.github.lgooddatepicker.components.TimePicker btimeEventInput;
    private javax.swing.JLabel btimeEventLabel;
    private javax.swing.JButton caccButton;
    private javax.swing.JButton calenderButton;
    private javax.swing.JPanel calenderPanel;
    private javax.swing.JButton cancelAppEditButton;
    private javax.swing.JButton cancelDataEdit;
    private javax.swing.JPanel dataEdit;
    private javax.swing.JPanel dataOverview;
    private javax.swing.JLabel dateEvent;
    private com.github.lgooddatepicker.components.DatePicker dateEventInput;
    private javax.swing.JLabel dateEventLabel;
    private javax.swing.JLabel durationEvent;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editLabel;
    private com.github.lgooddatepicker.components.TimePicker etimeEventInput;
    private javax.swing.JLabel etimeEventLabel;
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
    private javax.swing.JScrollPane listView;
    private javax.swing.JLabel locationEvent;
    private javax.swing.JTextField locationEventInput;
    private javax.swing.JLabel locationEventLabel;
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
    private javax.swing.JLabel nameEvent;
    private javax.swing.JTextField nameEventInput;
    private javax.swing.JLabel nameEventLabel;
    private javax.swing.JTextField nameInput;
    private javax.swing.JPanel nameUnderline;
    private javax.swing.JLabel nameView;
    private javax.swing.JLabel occView;
    private javax.swing.JTextField occupationEdit;
    private javax.swing.JPanel occupationUnderline;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JLabel partListTile;
    private javax.swing.JComboBox<String> participantsEventInput;
    private javax.swing.JLabel participantsEventLabel;
    private javax.swing.JLabel participantsLabel;
    private javax.swing.JComboBox<String> participantsList;
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
    private javax.swing.JLabel timeEvent;
    private javax.swing.JPanel upperPanel;
    private javax.swing.JLabel userIcon;
    private javax.swing.JLabel userLogo;
    private javax.swing.JPanel userProfilePanel;
    private javax.swing.JLabel userTile;
    private javax.swing.JLabel usernameView;
    // End of variables declaration//GEN-END:variables
}
