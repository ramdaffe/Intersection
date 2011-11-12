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
    
    public Car(int x, int y){
        xpos = x;
        ypos = y;
    }
    
    public String DrawCar (Car C){
        return "c";
    }
    
    public boolean IsOnBorder (Car C, Intersect I){
        return (C.xpos == I.EWborder);
    }
}
