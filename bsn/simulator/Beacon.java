/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bsn.simulator;

/**
 *
 * @author MAPLE
 */
public class Beacon {
    
    private int _id;
    private int  _beaconTime;
    private int  _sendTime [] = new int [2];
    private int  _sleepTime [] = new int [2];
    private int  _activeTime [] = new int [2];
    private int _currTime;
    Node _n;
    
    public Beacon(Node n, int currTime){
        _n = n;
        _currTime = currTime;
        
        createBeaconMessage();
    }
    
    public Beacon(Node n){
        _n = n;
        createBeaconMessage();
    }
    
    
    public void createBeaconMessage(){
        
        _beaconTime = _currTime + _sendTime[1]; 
        System.out.println("Beacon created for: " + _n.getId());
        
        this.setNodeSleepTime();
        this.setNodeActiveTime();
        this.setNodeSendTime();
        
       _n.receiveBeacon(this);
    }
    
    /*
    time node will put to sleep to save energy
    */
    public void setNodeSleepTime(){
        //values 2000 to change dynamically
        int  start = this._currTime + 200 , end = start + 200;
        _sleepTime[0] = start;
        _sleepTime[1] = end;
   
    }
    
   /*
    time node will be active to sense data
    */
        public void setNodeActiveTime(){
        int  start = this._sleepTime[1], end = start + 300;
        _activeTime[0] = start;
        _activeTime[1] = end;
  
    }

    /*
        node's time to send data
    */
        
    public void setNodeSendTime(){
        int  start = this._activeTime[1], end = start + 400;
        _sendTime[0] = start;
        _sendTime[1] = end;
      
    }
    
    public int []getNodeSleepTime(){
        
        return this._sleepTime;
        
    }
    
    public int []getNodeActiveTime(){
        
        return this._activeTime;
        
    }
    public int  []getNodeSendTime(){
        
        return this._sendTime;
        
    }
    
    public int getNextBeaconTime(){
        
        return this._beaconTime;
        
    }
    
}
