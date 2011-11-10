/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersect;
import java.util.Scanner;
/**
 *
 * @author skarta
 */
public class Lane {
    String[][] lanematrix;
    int hlane;
    int vlane;
    int v1,vb1,vb2,h1,hb1, hb2 = 0;
    static final int XSIZE = 20;
    static final int YSIZE = 20; 
    
    public Lane(int vl, int hl){
        lanematrix = new String[XSIZE][YSIZE];
        hlane = hl;
        vlane = vl;
        v1 = (XSIZE-vlane) / 2;
        vb1 = v1;
        vb2 = v1+vlane+1;
        h1 = (YSIZE-hlane) / 2;
        hb1 = h1;
        hb2 = h1+hlane+1;
    }
    
    public static int InputVLane(){
        Scanner S = new Scanner(System.in);
        System.out.println("Enter value of vertical lane: ");
        return S.nextInt();
    }
    
    public static int InputHLane(){
        Scanner S = new Scanner(System.in);
        System.out.println("Enter value of horizontal lane: ");
        return S.nextInt();
    }
    
    public int getInitPosH(Lane L){
        return L.hb1+1;
    }
    
    public int getInitPosV(Lane L){
        return L.vb1+1;
    }
    
    public void FillMatrix(Lane L){
        //int v1,vb1,vb2,h1,hb1, hb2;
        /*L.v1 = (Lane.XSIZE-L.vlane) / 2;
        L.vb1 = L.v1;
        L.vb2 = L.v1+L.vlane+1;
        L.h1 = (Lane.YSIZE-L.hlane) / 2;
        L.hb1 = L.h1;
        L.hb2 = L.h1+L.hlane+1;
         */
        for (int i = 0;i<Lane.XSIZE;i++)
            for (int j = 0;j<Lane.YSIZE;j++) {
                if ((L.vb1 < i ) && (i < L.vb2)) {
                    L.lanematrix[i][j] = " ";
                } else if ((L.hb1 < j ) && (j < L.hb2)) {
                    L.lanematrix[i][j] = " ";
                } else if ((i == L.v1) || (i == (L.v1+L.vlane+1))) {
                    L.lanematrix[i][j] = "|";
                } else if ((j == L.h1) || (j == (L.h1+L.hlane+1))) {
                    L.lanematrix[i][j] = "-";
                }else {
                    L.lanematrix[i][j] = " ";
                }
                
            }        
        
    }
    
    public void DrawMatrix(Lane L){
        for (int n = 0;n<Lane.YSIZE;n++)
            for (int m = 0;m<Lane.XSIZE;m++){
                if (m == 0){
                    System.out.println("");
                    System.out.print(L.lanematrix[m][n]);
                } else {
                    System.out.print(L.lanematrix[m][n]);
                }
            }
    }
    
    
    public static void main(String [] args){
        int vlane = InputVLane();
        int hlane = InputHLane();
        Lane L1 = new Lane(vlane,hlane);
        L1.FillMatrix(L1);
        L1.DrawMatrix(L1);
        System.out.println("end");
    }
}
