/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersect;

/**
 *
 * @author RAMDA YANURZHA 12644700
 */
public class Car {
    int xpos;
    int ypos;
    Direction Cardir;
    
    public Car(Direction D, Lane L){
        Cardir = D;
        if (D.EW = true){
            xpos = 0;
            ypos = L.getInitPosV(L);
        } else {
            ypos = 0;
            xpos = L.getInitPosH(L);
        }
    }
    
    public String DrawCar (Car C){
        return "c";
    }
    
    public boolean IsOnBorder (Car C, Intersect I){
        return ((C.xpos == I.EWborder) || (C.xpos == I.NSborder));
    }
}
