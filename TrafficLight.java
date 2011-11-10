/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersect;

/**
 *
 * @author RAMDA YANURZHA
 */
public class TrafficLight {
    boolean NS;
    boolean Red;
    
    public void TrafficLight(){
    NS = true;
    Red = true;      
}
    
    public void Switch(TrafficLight L1, TrafficLight L2){
        if (L1.Red){
            L1.Red = false;
            L2.Red = true;
        } else {
            L1.Red = true;
            L2.Red = false;
        }
    }
}
