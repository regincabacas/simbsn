/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsnsimulator;

import java.util.Vector;

/**
 *
 * @author MAPLE
 */
public class Node implements Runnable{
    
    private int _id;
    private int _nextID;
    public Vector _messages = new Vector();
    public Vector _beacon = new Vector();
    
    public Node(int id){
        _id = id;
       _nextID = id;
    }
    
    @Override
    synchronized public void run() {
        
        try
        {
            System.out.println("Running Node " + this._id);
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            
            e.printStackTrace();
        }
        
    }
    
    synchronized public int nodeCount(){

        return _nextID;
    }
    
    public void createMessages(){
        
        //Message m = new Message();
         
    }
    
    public int getId()
    {
        return _id;
    }
    
    public void receiveBeacon(Beacon b){
        
        _beacon.addElement(b);
        
    }
}
