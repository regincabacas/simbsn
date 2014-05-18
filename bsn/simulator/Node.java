/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bsn.simulator;

import java.util.Vector;
import javax.swing.SwingUtilities;

/**
 *
 * @author MAPLE
 */
public class Node implements Runnable{
    
    private int _id;
    private int _nextID;
    public Vector _messages = new Vector();
    public Vector _beacon = new Vector();
    
    private int [] _sleepTime;
    private int [] _activeTime;
    private int [] _sendTime;
    
    public Node(int id){
        _id = id;
       _nextID = id;
       
       System.out.println("Node: " + _id + " created!");
    }
    
    @Override
    synchronized public void run() {
        
        try
        {
            System.out.println("Running Node " + this._id);
            Thread.sleep(100);
            
            SwingUtilities.invokeAndWait(this);
        }
        catch(Exception e){
            
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
        System.out.println( "Node: " + this._id + "---- Sleep Time:" + b.getNodeSleepTime()[0] +"," +  b.getNodeSleepTime()[1] + "---- Send Time:" + b.getNodeActiveTime()[0] +"," + b.getNodeActiveTime()[1]  + "---- Active Time:" + b.getNodeSendTime()[0] + "," + b.getNodeSendTime()[1]);
        
        _sleepTime =  b.getNodeSleepTime();
        //_sleepTime[1] =  b.getNodeSleepTime()[1];
        
        _activeTime= b.getNodeActiveTime();
        //_activeTime[1] = b.getNodeActiveTime()[1];
        
        _sendTime = b.getNodeSendTime();
        //_sendTime[1] = b.getNodeSendTime()[1];
        
    }
    public Vector getBeacon(){
        
        return this._beacon;
    }
    
 public int []getNodeSleepTime(){
        
        return _sleepTime;
        
    }
    
    public int [] getNodeActiveTime(){
        
        return _activeTime;
        
    }
    public int []getNodeSendTime(){
        
        return _sendTime;
        
    }
}
