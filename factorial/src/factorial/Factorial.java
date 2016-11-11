
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;


/**
 *
 * @author shcherbakov
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Bigdata factor = new Bigdata();
     int j;
     j=30;
        for(int i=1;i<=j;i++){
          factor.data=factor.multiply(i);
           }
     System.out.println("Факториал  "+j +"!="+factor.data);
    }
}

