/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsnsimulator;

/**
 *
 * @author MAPLE
 */
public class Beacon {
    
    //Node _n;
    int _id;
    int _sendTime;
    int _sleepTime;
    int _activeTime;
    
    public Beacon(Node n){
        //_n = n;
        _id = n.getId();
    }
    
    public void createBeaconMessage(){
 
    }
    
}
