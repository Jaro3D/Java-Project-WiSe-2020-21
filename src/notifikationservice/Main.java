/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifikationservice;

import java.util.Date;

/**
 *Only to demonstrate the execution of the parallel processing.
 * 
 * 
 */
public class Main 
{
    
    public static void main(String[] args)
    {
        Thread notifikationService = new Thread(new NotifikationService());
        notifikationService.start();
        new UI().setVisible(true);
        
        
        

        
    }
    
    
}
