/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsnsimulator;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

/**
 *
 * @author MAPLE
 */
public class SimulatorMain {
    
    static Node n;
    static Thread t;
    
    public static void main (String [] args) throws InterruptedException, InvocationTargetException{
        
        System.out.println("Simulator Started!");
        
        //Instantiate node and create Threads for each
        for(int i = 1; i <= 5; i++){
            n = new Node(i);
            t = new Thread(n);
            t.start();
        }
       
        //coordinator Node
        CoordinatorNode c = new CoordinatorNode();
        Thread ct = new Thread(c);
        ct.start();
        
        //send beacon messages
       for(int i = 1; i < n.nodeCount(); i++)
       {
           c.sendBeaconMessage(n);
       }
       
       //simulation period
       for(int i=0; i< 3600; i++){
           
           if()
           
       }

        
    }
    
    
}
