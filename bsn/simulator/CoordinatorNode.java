/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bsn.simulator;

import java.util.Vector;

/**
 *
 * @author MAPLE
 */
public class CoordinatorNode implements Runnable{
    
     
     Vector <Beacon>beacon = new Vector();
    
    public void sendBeaconMessage(Node n, int currTime){
        
        System.out.println("Sending beacon to " + n.getId());
        Beacon b = new Beacon(n, currTime);
    }


    @Override
    public void run() {
        
    }
    
}
