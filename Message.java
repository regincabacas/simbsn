/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsnsimulator;

/**
 *
 * @author MAPLE
 */
public class Message {
    
    static int _id;
    static int _priority;
    static int _data;
    static int _time;
    
    public Message(int id, int time, int pn, int data){
        
        _id = id;
        _time = time;
        _priority = pn;
        _data = data;
        
    }
    
}
