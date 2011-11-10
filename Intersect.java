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
    int counter; //global cycle counter

    public static void InitTest(){
        int vlane = Lane.InputVLane();
        int hlane = Lane.InputHLane();
        Lane L1 = new Lane(vlane,hlane);
        L1.FillMatrix(L1);
        int r = 0; //L1.getInitPosH(L1);
        int z = L1.getInitPosV(L1);
        Car C1 = new Car(r,z);
        for (int i = 0;i<15;i++){
            RunSimulation(L1,C1);
        }
    }
    
    
    public static void RunSimulation(Lane L, Car C){
        int xprevpos;
        int yprevpos;
        L.lanematrix[C.xpos][C.ypos] = C.DrawCar(C);
        L.DrawMatrix(L);
        xprevpos = C.xpos;
        yprevpos = C.ypos;
        C.xpos = C.xpos + 1;
        L.lanematrix[xprevpos][yprevpos] = " ";
    }
    
    public static void main(String[] args) {
        
        InitTest();
                
                // TODO code application logic here
    }
}
