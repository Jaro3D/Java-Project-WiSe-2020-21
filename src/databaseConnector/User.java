/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnector;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;


public class User {
    
    private int id;
    private String username;
    private String email;
    private String password;
    private int[] contactIDs;
    private boolean isAdmin;

    public User() 
    {}
    
    public User(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = false;
        int[] temp = new int[1];
        temp[0] = 0;
        this.contactIDs = temp;
    }

    public User(int id, String username, String email, String password, String friendIDs, int isadmin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        
        String[] temp1 = friendIDs.split(",");
        int[] temp2 = new int[temp1.length];
        for(int i = 0;i<temp1.length;i++)
        {
            temp2[i] = Integer.parseInt(temp1[i]);
        }
        this.contactIDs = temp2;
        
        switch(isadmin)
        {
            case 0: this.isAdmin = false; break;
            case 1: this.isAdmin = true; break;
            default: this.isAdmin = false; break;
        }
    }

    public void print()
    {
        System.out.println(this.id+" "+this.username+" "+this.email+" "+this.password+" "+this.contactIDs[0]+" "+this.isAdmin);
    }
    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int[] getContactIDs() {
        return contactIDs;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContactIDs(int[] contactIDs) {
        this.contactIDs = contactIDs;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
    
    /*
    
     public static void storeUsers(User[] allUsers)
    {
        try
        {
            File file = new File("Users.txt");
            if(!file.exists())
            {
                file.createNewFile();
                FileWriter createAdmin = new FileWriter("Users.txt");
                createAdmin.write("1\n"+"root~1234~root@email.com~admin");
                createAdmin.close();
            }
            FileWriter writeUsers = new FileWriter("Users.txt");
            writeUsers.write(allUsers.length+"\n");
                                             
            for(int i = 0;i<allUsers.length;++i)
            {
            writeUsers.write(allUsers[i].getUsername()+"~"+
                    allUsers[i].getPassword()+"~"+
                    allUsers[i].getEmail()+"~"+
                    allUsers[i].getStatus()+"\n");
            }
            writeUsers.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }   
     
    public static User[] loadUsers()
    {
        try
        {
            File data = new File("Users.txt");
            if(!data.exists())
            {
                data.createNewFile();
                FileWriter createAdmin = new FileWriter("Users.txt");
                createAdmin.write("1\n"+"root~1234~root@email.com~admin");
                createAdmin.close();
            }
            Scanner load = new Scanner(data);
            User[] allUsers = new User[Integer.parseInt(load.nextLine())];
            for(int i = 0;i<allUsers.length;i++)
            {
                String [] split = load.nextLine().split("~");
                allUsers[i] = new User(split[0],split[1],split[2],split[3]);
            }
            load.close();
            return allUsers;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        User[] output = new User[1];
        return output;
    } 
        
    public static void addUser(User newUser)
    {
        User[] allUsers = loadUsers();
        User[] allUsersPlus = new User[allUsers.length+1];
        for(int i = 0;i<allUsers.length;i++)
        {
            allUsersPlus[i] = allUsers[i];
        }
        allUsersPlus[allUsers.length] = newUser;
        storeUsers(allUsersPlus);
    }    
     /*Achtung, Wenn User deleteUser nicht Funktioniert 
    gibt es eine Exception Array out of bounce*/
    /*
    public static void deleteUser(User deleteUser)
    {
        User[] allUsers = loadUsers(); 
        User[] allUsersMinus = new User[allUsers.length-1];
        for(int i = 0, j = 0;i<allUsers.length;i++,j++)
        {
            if(allUsers[i].getUsername().equals(deleteUser.getUsername()))
            {
                j--;
            }
            else
            {
                allUsersMinus[j] = allUsers[i];
            }
        }
        storeUsers(allUsersMinus);
    }
    
    public static boolean login(String username, String password)
    {
        User[] allUsers = loadUsers();
        for(int i = 0;i<allUsers.length;i++)
        {
            if(allUsers[i].getUsername().equals(username))
            {
                if(allUsers[i].getPassword().equals(password))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static int createNewUser(String username, String email, String password1, String password2)
    {
        if(username.equals("")||email.equals("")||password1.equals(""))
        {
            return -1;
        }
        if(!password1.equals(password2))
        {
            return 0;
        }
        User[] allUsers = loadUsers();
        for(int i = 0;i<allUsers.length;i++)
        {
            if(allUsers[i].getUsername().equals(username))
            {
                return 1;
            }
        }
        User newUser = new User(username, password1, email, "user");
        addUser(newUser);
        return 2;
    }
    */
}




