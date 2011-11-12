/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersect;
/**
 *
 * @author RAMDA YANURZHA 12644700
 */
public class Intersect {
    static int counter; //global cycle counter
    int EWborder; //holds the x-axis value of the EW intersection border
    int NSborder; //holds the y-axis value of the NS intersection border
    int turns = 20;                                  //total turns : 20
    
    public Intersect(int x, int y){
        counter = 0;
        EWborder = x;
        NSborder = y;
    }
    
    public static void InitTest(){
        int vlane = Lane.InputVLane();                   //enter number of vertical lane
        int hlane = Lane.InputHLane();                   //enter number of horizontal lane
        Lane L1 = new Lane(vlane,hlane);                //create new Lane L1
        L1.FillMatrix(L1);                              //populate L1 lane matrix
        Intersect I1 = new Intersect(L1.vb1,L1.h1);      //create new Intersection
        
        /*trying new test routine*/
        /*for this test, the light will turn red for 10 turn after the car has moved west to east for 5 turn*/
        Car C1 = new Car(0,L1.getInitPosV(L1));         //create a new car with valid initial position
        Direction D = new Direction();
        D.EW = true;
        C1.Cardir = D;
        TrafficLight T2 = new TrafficLight(D,false,0);
        T2.TLDir = D;
        while (counter <= I1.turns) {
            //red light duration: turn 5 thru 15
            //if ((counter > delay) && (counter < (T2.duration+delay))){
            if (counter > 2){
                T2.Red = true;
            }
            if (counter > 13) { //this is just a temporary value
                T2.Red = false;
            }
            if (C1.IsOnBorder(C1, I1)){
                if (T2.Red) {
                    Move(L1,C1,0, D);
                } else {
                    Move(L1,C1,1, D);
                }
            } else {
                Move(L1,C1,1, D);
            }
            //PrintStats(counter,T2.duration,delay);
            //System.out.print(C1.IsOnBorder(C1, I1));
            //System.out.print(T2.Red);
            counter++;

        }
    }
    
    
    public static void PrintStats(int x, int y, int z){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
    
    public static void Move(Lane L, Car C, int steps, Direction movedir){
        int xprevpos;
        int yprevpos;
        L.lanematrix[C.xpos][C.ypos] = C.DrawCar(C);
        L.DrawMatrix(L);
        xprevpos = C.xpos;
        yprevpos = C.ypos;
        if (movedir.EW) {
            C.xpos = C.xpos + steps;
        } else {
            C.ypos = C.ypos + steps;
        }
        L.lanematrix[xprevpos][yprevpos] = " ";
    }
    
    public static void main(String[] args) {
        
        InitTest(); //run test routine
                
                // TODO code application logic here
    }
}
