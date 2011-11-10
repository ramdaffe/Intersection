/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersect;
/**
 *
 * @author RAMDA YANURZHA
 */
public class Intersect {
    static int counter; //global cycle counter
    int EWborder; //holds the x-axis value of the EW intersection border
    int NSborder; //holds the y-axis value of the NS intersection border
    
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
        Car C1 = new Car(0,L1.getInitPosV(L1));         //create a new car with valid initial position
        Intersect I = new Intersect(L1.vb1,L1.h1);      //create new Intersection
        
        /*trying new test routine*/
        /*for this test, the light will turn red for 10 turn after the car has moved west to east for 5 turn*/
        int turns = 20;                                  //total turns : 20
        int delay = 5;
        TrafficLight T2 = new TrafficLight(false,false,20);
        T2.NS = false;                                   //T2 is for East-West traffic
        while (counter <= turns) {
            if (counter == delay){
                T2.Red = true;
                T2.duration --;
                Move(L1,C1,0);
                PrintStats(counter,delay,T2.duration);
                counter ++;
            } else if (T2.duration == 0) {
                Move(L1,C1,1);
                PrintStats(counter,delay,T2.duration);
                counter ++;
            } else {
                Move (L1,C1,1);
                PrintStats(counter,delay,T2.duration);
                counter ++;
            }
        }
    }
    
    public static void PrintStats(int x, int y, int z){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
    
    public static void Move(Lane L, Car C, int steps){
        int xprevpos;
        int yprevpos;
        L.lanematrix[C.xpos][C.ypos] = C.DrawCar(C);
        L.DrawMatrix(L);
        xprevpos = C.xpos;
        yprevpos = C.ypos;
        C.xpos = C.xpos + steps;
        L.lanematrix[xprevpos][yprevpos] = " ";
    }
    
    public static void main(String[] args) {
        
        InitTest(); //run test routine
                
                // TODO code application logic here
    }
}
