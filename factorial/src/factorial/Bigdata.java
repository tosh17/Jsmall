/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

public class Bigdata {
  String data;
    Bigdata() {
  data="1";
}
   Bigdata(int x){
       data=Integer.toString(x);
   }
   Bigdata(String x){
   data=x;
   }
   
   public String multiply(int x)    {
     String rezult=Integer.toString(x);  
     return multiply(rezult) ;
   }
   public String multiply(String x) {
        String rezult="";
 int xlenght=x.length();
 int data_l=data.length();
 int n=0;
 
 for(int i=xlenght-1;i>0;i--){
     if (Character.getNumericValue(x.charAt(i))==0) n++;
     else break;
 }
 
 xlenght-=n;
 String xn=x;
 
 
 int int_rezult[]= new int[xlenght+data_l];
 int tx,ty,temp;
 int xy,xy1,xy2;
 for(int i=0;i<xlenght;i++){
     for(int j=0;j<data_l;j++) {
         tx=xlenght-i-1;
         ty=data_l-j-1;
 //        System.out.println(x.charAt(tx)+"  "+y.charAt(ty)); 
         int xi=Character.getNumericValue(x.charAt(tx)), yj=Character.getNumericValue(data.charAt(ty));
         xy=xi*yj;
  //       System.out.println("Произведение X|"+tx+'|'+'*'+"Y|"+ty+"|=" +xi +"*"+yj+"="+xy); 
         if(xy>9){
         xy2=xy%10; xy1=(xy-xy2)/10;
         }
         else{xy1=0;xy2=xy;}
     int_rezult[tx+ty+1]+=xy2;
     int_rezult[tx+ty]+=xy1;
     }
 
  for(int i2=xlenght+data_l-1;i2>0;i2--){
      if (int_rezult[i2]>9){
         temp=int_rezult[i2]%10;
          int_rezult[i2-1]+=(int_rezult[i2]-temp)/10;
          int_rezult[i2]=temp;
        }
  }
 }

 temp=0;
 for(int i=0;i<xlenght+data_l;i++){
 if (int_rezult[i]>0) temp=1;
 if (temp>0)  rezult+=int_rezult[i];
 }
 if(n>0) for(int i=0;i<n;i++) rezult+=0;
 return rezult; 
   }  

}
