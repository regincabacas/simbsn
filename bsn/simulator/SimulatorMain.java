/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bsn.simulator;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import javax.swing.SwingUtilities;

/**
 *
 * @author MAPLE
 */
public class SimulatorMain {


    public static void main (String [] args) throws InterruptedException, InvocationTargetException{

        int numOfNodes = 5;
        int _beaconTime = 0;
        
        Node[]n = new Node[numOfNodes];
        Thread t;
        Vector <Beacon> b;

        System.out.println("Simulator Started!");

        //Instantiate node
        for(int i = 0; i < numOfNodes; i++){
            n[i]= new Node(i);
        }

        //create Thread for each node
        for(int i = 0; i < numOfNodes; i++){
            t = new Thread(n[i]);
            t.start();
        }

        //coordinator Node
        CoordinatorNode c = new CoordinatorNode();
        Thread ct = new Thread(c);
        ct.start();

        //send initial beacon messages
       for(int i = 0; i < n.length; i++)
       {
           c.sendBeaconMessage(n[i],0);
       }

       //simulation period
       for(int i=0; i< 3600; i++){
           
           System.out.println("Time" + i + ": " );
           for(int j = 0; j < n.length; j++)
           {
           //send beacon messsage if its next beacon time 
           //calculated in beacon class
               
           if( i == _beaconTime){
               for(int k = 0; k < n.length; k++)
               {c.sendBeaconMessage(n[k],i);}
                _beaconTime = n[j].getNodeSendTime()[1];
           }
           else if(i == n[j].getNodeSleepTime()[0] && i != n[j].getNodeSleepTime()[1]){
               System.out.println("Node sleeps!");
           }
           else if(i == n[j].getNodeActiveTime()[0] && i != n[j].getNodeActiveTime()[1]){
               System.out.println("Node sense data!");
           }
           else if(i == n[j].getNodeSendTime()[0] && i != n[j].getNodeSendTime()[1]){
               System.out.println("Send to Coordinator");
           }
           }
       }
    }
}
